package br.eti.ns.nssuite;

import br.eti.ns.nssuite.compartilhados.Endpoints;
import br.eti.ns.nssuite.compartilhados.Genericos;
import br.eti.ns.nssuite.compartilhados.Parametros;
import br.eti.ns.nssuite.requisicoes._genericos.*;
import br.eti.ns.nssuite.requisicoes.bpe.ConsStatusProcessamentoReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.DownloadReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.NaoEmbReqBPe;
import br.eti.ns.nssuite.requisicoes.cte.ConsStatusProcessamentoReqCTe;
import br.eti.ns.nssuite.requisicoes.cte.DownloadReqCTe;
import br.eti.ns.nssuite.requisicoes.cte.InfGTVReqCTe;
import br.eti.ns.nssuite.requisicoes.mdfe.ConsStatusProcessamentoReqMDFe;
import br.eti.ns.nssuite.requisicoes.mdfe.DownloadReqMDFe;
import br.eti.ns.nssuite.requisicoes.mdfe.IncluirDFeReqMDFe;
import br.eti.ns.nssuite.requisicoes.nf3e.ConsStatusProcessamentoReqNF3e;
import br.eti.ns.nssuite.requisicoes.nf3e.DownloadReqNF3e;
import br.eti.ns.nssuite.requisicoes.nfce.DownloadReqNFCe;
import br.eti.ns.nssuite.requisicoes.nfce.Impressao;
import br.eti.ns.nssuite.requisicoes.nfe.ConsStatusProcessamentoReqNFe;
import br.eti.ns.nssuite.requisicoes.nfe.DownloadReqNFe;
import br.eti.ns.nssuite.retornos.bpe.EmitirSincronoRetBPe;
import br.eti.ns.nssuite.retornos.cte.EmitirSincronoRetCTe;
import br.eti.ns.nssuite.retornos.mdfe.EmitirSincronoRetMDFe;
import br.eti.ns.nssuite.retornos.nf3e.EmitirSincronoRetNF3e;
import br.eti.ns.nssuite.retornos.nfce.EmitirSincronoRetNFCe;
import br.eti.ns.nssuite.retornos.nfe.EmitirSincronoRetNFe;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NSSuite {
    private static String token = "ADQWREQW561D32AWS1D6";
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static Endpoints endpoints = new Endpoints();
    private static Parametros parametros = new Parametros();

    // Esta função envia um conteúdo para uma URL, em requisições do tipo POST
    private static String enviaConteudoParaAPI(Object conteudo, String url, String tpConteudo) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Response respostaServidor;
        try {
            if (tpConteudo.equals("txt")) {
                respostaServidor = target.request(MediaType.TEXT_PLAIN)
                        .header("X-AUTH-TOKEN", token)
                        .post(Entity.text(conteudo));
            } 
            else if (tpConteudo.equals("xml")) {
                respostaServidor = target.request(MediaType.APPLICATION_XML)

                        // pode ser enviado também no json junto com os dados da nfce
                        .header("X-AUTH-TOKEN", token)
                        .post(Entity.xml(conteudo));

            } 
            else {
                respostaServidor = target.request(MediaType.APPLICATION_JSON)

                        // pode ser enviado também no json junto com os dados da nfce

                        .header("X-AUTH-TOKEN", token)
                        .post(Entity.json(conteudo));

            }
        } 
        catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build().toString();
        }
        return respostaServidor.readEntity(String.class);
    }

    // Métodos específicos de BPe
    public static String emitirBPeSincrono(String conteudo, String tpConteudo, String CNPJ, String tpDown, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        String statusEnvio, statusConsulta, statusDownload, motivo, nsNRec, chBPe, cStat, nProt;
        String modelo = "63";
        ArrayList<String> erros = new ArrayList<>();
        statusEnvio = "";
        statusConsulta = "";
        statusDownload = "";
        motivo = "";
        nsNRec = "";
        chBPe = "";
        cStat = "";
        nProt = "";

        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_INICIO]");
        String resposta = emitirDocumento(modelo, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        if ((statusEnvio.equals("200")) || (statusEnvio.equals("-6"))) {
            nsNRec = respostaJSON.get("nsNRec").asText();
            Thread.sleep(parametros.TEMPO_ESPERA);

            ConsStatusProcessamentoReqBPe consStatusProcessamentoBPeReq = new ConsStatusProcessamentoReqBPe();
            consStatusProcessamentoBPeReq.CNPJ = CNPJ;
            consStatusProcessamentoBPeReq.nsNRec = nsNRec;
            consStatusProcessamentoBPeReq.tpAmb = tpAmb;

            resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoBPeReq);
            respostaJSON = objectMapper.readTree(resposta);
            statusConsulta = respostaJSON.get("status").asText();

            if(statusConsulta.equals("-2")){
                cStat = respostaJSON.get("cStat").asText();
                if(cStat.equals("996")){
                    motivo = respostaJSON.get("erro").get("xMotivo").asText();
                    for (int i=1; i<=3; i++){
                        try {
                            Thread.sleep(6000 - (i*1000));
                        } catch (InterruptedException ignored){}
                        resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoBPeReq);
                        respostaJSON = objectMapper.readTree(resposta);
                        statusConsulta = respostaJSON.get("status").asText();
                        if(!statusConsulta.equals("-2")){ break; }
                    }
                } else {
                    motivo = respostaJSON.get("motivo").asText();
                }
            }

            if(statusConsulta.equals("200")){

                cStat = respostaJSON.get("cStat").asText();

                if(cStat.equals("100")){

                    chBPe = respostaJSON.get("chBPe").asText();
                    nProt = respostaJSON.get("nProt").asText();
                    motivo = respostaJSON.get("xMotivo").asText();

                    DownloadReqBPe downloadReqBPe = new DownloadReqBPe();
                    downloadReqBPe.chBPe = chBPe;
                    downloadReqBPe.tpAmb = tpAmb;
                    downloadReqBPe.tpDown = tpDown;

                    resposta = downloadDocumentoESalvar(modelo, downloadReqBPe, caminho, chBPe + "-BPe", exibeNaTela);

                    respostaJSON = objectMapper.readTree(resposta);
                    statusDownload = respostaJSON.get("status").asText();

                    //Testa se houve problema no download
                    if (!statusDownload.equals("200")) motivo = respostaJSON.get("motivo").asText();
                }else{
                    motivo = respostaJSON.get("xMotivo").asText();
                }

            }else if (statusConsulta.equals("-2")){
                cStat = respostaJSON.get("cStat").asText();
                motivo = respostaJSON.get("erro").get("motivo").asText();

            }else{
                motivo = respostaJSON.get("motivo").asText();
            }

        } else if (statusEnvio.equals("-5")) {
            cStat = respostaJSON.get("erro").get("cStat").asText();
            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        } else if (statusEnvio.equals("-4") || statusEnvio.equals("-2")) {
            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

        } else {
            try {
                motivo = respostaJSON.get("motivo").asText();
            } catch (Exception ex) {
                motivo = respostaJSON.toString();
            }
        }
        EmitirSincronoRetBPe emitirSincronoRetBPe = new EmitirSincronoRetBPe();
        emitirSincronoRetBPe.statusEnvio = statusEnvio;
        emitirSincronoRetBPe.statusConsulta = statusConsulta;
        emitirSincronoRetBPe.statusDownload = statusDownload;
        emitirSincronoRetBPe.cStat = cStat;
        emitirSincronoRetBPe.chBPe = chBPe;
        emitirSincronoRetBPe.nProt = nProt;
        emitirSincronoRetBPe.motivo = motivo;
        emitirSincronoRetBPe.nsNRec = nsNRec;
        emitirSincronoRetBPe.erros = erros;

        String retorno = objectMapper.writeValueAsString(emitirSincronoRetBPe);

        Genericos.gravarLinhaLog(modelo, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(modelo, retorno);
        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    public static String naoEmbarque(String modelo, NaoEmbReqBPe naoEmbReqBPe) throws Exception {
        String urlNaoEmb;
        ObjectMapper objectMapper = new ObjectMapper();

        switch (modelo){
            case "63":{
                urlNaoEmb = endpoints.BPeNaoEmb;
                break;
            }
            default: {
                throw new Exception("Não definido endpoint de não embarque para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(naoEmbReqBPe);

        Genericos.gravarLinhaLog(modelo, "[NAO_EMBARQUE_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlNaoEmb, "json");

        Genericos.gravarLinhaLog(modelo, "[NAO_EMBARQUE_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String naoEmbarqueESalvar(String modelo, NaoEmbReqBPe naoEmbReqBPe, DownloadEventoReq downloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String resposta = naoEmbarque(modelo, naoEmbReqBPe);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200")){
            String cStat = respostaJSON.get("retEvento").get("cStat").asText();
            if (cStat.equals("135")){
                String respostaDownloadEvento = downloadEventoESalvar(modelo, downloadEventoReq, caminho, chave, "", exibeNaTela);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao não embarcar, veja o retorno da API para mais informaçõe");
        }
        return resposta;
    }

    // Métodos específicos de CTe
    public static String emitirCTeSincrono(String conteudo, String mod, String tpConteudo, String CNPJ, String tpDown, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        ArrayList<String> erros = new ArrayList<>();

        String statusEnvio = "";
        String statusConsulta = "";
        String statusDownload = "";
        String motivo = "";
        String nsNRec = "";
        String chCTe = "";
        String cStat = "";
        String nProt = "";

        Genericos.gravarLinhaLog(mod, "[EMISSAO_SINCRONA_INICIO]");

        String resposta = emitirDocumento(mod, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        // Testa se o envio foi feito com sucesso (200) ou se é para reconsultar (-6)
        if (statusEnvio.equals("200") || statusEnvio.equals("-6")){

            nsNRec = respostaJSON.get("nsNRec").asText();

            // É necessário aguardar alguns milisegundos antes de consultar o status de processamento
            Thread.sleep(parametros.TEMPO_ESPERA);
            ConsStatusProcessamentoReqCTe consStatusProcessamentoReqCTe = new ConsStatusProcessamentoReqCTe();
            consStatusProcessamentoReqCTe.CNPJ = CNPJ;
            consStatusProcessamentoReqCTe.nsNRec = nsNRec;
            consStatusProcessamentoReqCTe.tpAmb = tpAmb;

            resposta = consultarStatusProcessamento(mod, consStatusProcessamentoReqCTe);
            respostaJSON = objectMapper.readTree(resposta);
            statusConsulta = respostaJSON.get("status").asText();

            // Testa se a consulta foi feita com sucesso (200)
            if (statusConsulta.equals("200")){

                cStat = respostaJSON.get("cStat").asText();

                if (cStat.equals("100") || cStat.equals("150")){

                    chCTe = respostaJSON.get("chCTe").asText();
                    nProt = respostaJSON.get("nProt").asText();
                    motivo = respostaJSON.get("xMotivo").asText();

                    DownloadReqCTe downloadReqCTe = new DownloadReqCTe();
                    downloadReqCTe.chCTe = chCTe;
                    downloadReqCTe.CNPJ = CNPJ;
                    downloadReqCTe.tpAmb = tpAmb;
                    downloadReqCTe.tpDown = tpDown;

                    resposta = downloadDocumentoESalvar(mod, downloadReqCTe, caminho, chCTe + "-CTe", exibeNaTela);
                    respostaJSON = objectMapper.readTree(resposta);
                    statusDownload = respostaJSON.get("status").asText();

                    if (!statusDownload.equals("200")) motivo = respostaJSON.get("motivo").asText();
                }
                else
                {

                    motivo = respostaJSON.get("xMotivo").asText();
                }
            }
            else {

                motivo = respostaJSON.get("motivo").asText();
                erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});
            }
        }
        else if (statusEnvio.equals("-7")){

            motivo = respostaJSON.get("motivo").asText();
            nsNRec = respostaJSON.get("nsNRec").asText();

        }
        else if (statusEnvio.equals("-4")){

            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});
		
		}
        else if (statusEnvio.equals("-9")){
			
			motivo = respostaJSON.get("erro").get("xMotivo").asText();
			cStat = respostaJSON.get("erro").get("cStat").asText();
			
        }
        else
        {

            try
            {
                motivo = respostaJSON.get("motivo").asText();
            }
            catch (Exception ex)
            {
                motivo = respostaJSON.toString();
            }
        }

        EmitirSincronoRetCTe emitirSincronoRetCTe = new EmitirSincronoRetCTe();
        emitirSincronoRetCTe.statusEnvio = statusEnvio;
        emitirSincronoRetCTe.statusConsulta = statusConsulta;
        emitirSincronoRetCTe.statusDownload = statusDownload;
        emitirSincronoRetCTe.cStat = cStat;
        emitirSincronoRetCTe.chCTe = chCTe;
        emitirSincronoRetCTe.nProt = nProt;
        emitirSincronoRetCTe.motivo = motivo;
        emitirSincronoRetCTe.nsNRec = nsNRec;
        emitirSincronoRetCTe.erros = erros;

       String retorno = objectMapper.writeValueAsString(emitirSincronoRetCTe);

        Genericos.gravarLinhaLog(mod, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(mod, retorno);
        Genericos.gravarLinhaLog(mod, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    public static String informarGTV(String modelo, InfGTVReqCTe infGTVReqCTe) throws Exception {
        String urlInfGTV;
        switch (modelo)
        {
            case "57":
            case "67":{
                urlInfGTV = endpoints.CTeCancelamento;
                break;
            }
            default: {
                throw new Exception("Não definido endpoint de informação de GTV para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(infGTVReqCTe);

        Genericos.gravarLinhaLog(modelo, "[INFORMACOES_GTV_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlInfGTV, "json");

        Genericos.gravarLinhaLog(modelo, "[INFORMACOES_GTV_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String informatGTVESalvar(String modelo, InfGTVReqCTe infGTVReqCTe, DownloadEventoReq downloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        String resposta = informarGTV(modelo, infGTVReqCTe);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200"))
        {
            String respostaDownloadEvento = downloadEventoESalvar(modelo, downloadEventoReq, caminho, chave, "", exibeNaTela);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar, veja o retorno da API para mais informações");
        }

        return resposta;
    }

    // Métodos específicos de MDFe
    public static String emitirMDFeSincrono(String conteudo, String tpConteudo, String CNPJ, String tpDown, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        ArrayList<String> erros = new ArrayList<>();

        String modelo = "58";
        String statusEnvio = "";
        String statusConsulta = "";
        String statusDownload = "";
        String motivo = "";
        String nsNRec = "";
        String chMDFe = "";
        String cStat = "";
        String nProt = "";

        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_INICIO]");

        String resposta = emitirDocumento(modelo, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        // Testa se o envio foi feito com sucesso (200) ou se é para reconsultar (-6)
        if (statusEnvio.equals("200") || statusEnvio.equals("-6")){

            nsNRec = respostaJSON.get("nsNRec").asText();

            // É necessário aguardar alguns milisegundos antes de consultar o status de processamento
            Thread.sleep(parametros.TEMPO_ESPERA);

            ConsStatusProcessamentoReqMDFe consStatusProcessamentoReqMDFe = new ConsStatusProcessamentoReqMDFe();
            consStatusProcessamentoReqMDFe.CNPJ = CNPJ;
            consStatusProcessamentoReqMDFe.nsNRec = nsNRec;
            consStatusProcessamentoReqMDFe.tpAmb = tpAmb;

            resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoReqMDFe);
            respostaJSON = objectMapper.readTree(resposta);
            statusConsulta = respostaJSON.get("status").asText();

            // Testa se a consulta foi feita com sucesso (200)
            if (statusConsulta.equals("200")){

                cStat = respostaJSON.get("cStat").asText();

                // Testa se o cStat é igual a 100, pois significa "Autorizado"
                if (cStat.equals("100")){

                    chMDFe = respostaJSON.get("chMDFe").asText();
                    nProt = respostaJSON.get("nProt").asText();
                    motivo = respostaJSON.get("xMotivo").asText();

                    DownloadReqMDFe downloadReqMDFe = new DownloadReqMDFe();
                    downloadReqMDFe.chMDFe = chMDFe;
                    downloadReqMDFe.tpDown = tpDown;
                    downloadReqMDFe.tpAmb = tpAmb;

                    resposta = downloadDocumentoESalvar(modelo, downloadReqMDFe, caminho, chMDFe + "-MDFe", exibeNaTela);
                    respostaJSON = objectMapper.readTree(resposta);
                    statusDownload = respostaJSON.get("status").asText();

                    // Testa se houve problema no download
                    if (!statusDownload.equals("200")) motivo = respostaJSON.get("motivo").asText();
                }
                else
                {
                    motivo = respostaJSON.get("xMotivo").asText();
                }
            }
            else if (statusConsulta.equals("-2")){

                cStat = respostaJSON.get("erro").get("cStat").asText();
                motivo = respostaJSON.get("erro").get("xMotivo").asText();

            }
            else{

                motivo = respostaJSON.get("motivo").asText();
            }
        }
        else if (statusEnvio.equals("-5")){

            cStat = respostaJSON.get("erro").get("cStat").asText();
            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        }
        else if (statusEnvio.equals("-4") || statusEnvio.equals("-2")){

            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

        }
        else if (statusEnvio.equals("-999")){

            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        }
        else
        {
            try
            {
                motivo = respostaJSON.get("motivo").asText();
            }
            catch (Exception ex)
            {
                motivo = respostaJSON.toString();
            }
        }
        EmitirSincronoRetMDFe emitirSincronoRetMDFe = new EmitirSincronoRetMDFe();
        emitirSincronoRetMDFe.statusEnvio = statusEnvio;
        emitirSincronoRetMDFe.statusConsulta = statusConsulta;
        emitirSincronoRetMDFe.statusDownload = statusDownload;
        emitirSincronoRetMDFe.cStat = cStat;
        emitirSincronoRetMDFe.chMDFe = chMDFe;
        emitirSincronoRetMDFe.nProt = nProt;
        emitirSincronoRetMDFe.motivo = motivo;
        emitirSincronoRetMDFe.nsNRec = nsNRec;
        emitirSincronoRetMDFe.erros = erros;

        String retorno = objectMapper.writeValueAsString(emitirSincronoRetMDFe);

        Genericos.gravarLinhaLog(modelo, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(modelo, retorno);
        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    public static String encerrarDocumento(String modelo, EncerrarReq encerrarReq) throws Exception {
        String urlEncerramento;

        switch (modelo){
            case "58":{
                urlEncerramento = endpoints.MDFeEncerramento;
                break;
            }

            default:{
                throw new Exception("Não definido endpoint de encerramento para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(encerrarReq);

        Genericos.gravarLinhaLog(modelo, "[ENCERRAMENTO_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlEncerramento, "json");

        Genericos.gravarLinhaLog(modelo, "[ENCERRAMENTO_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String encerrarDocumentoESalvar(String modelo, EncerrarReq encerrarReq, DownloadEventoReq downloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        String resposta = encerrarDocumento(modelo, encerrarReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200")){
            String respostaDownloadEvento = downloadEventoESalvar(modelo, downloadEventoReq, caminho, chave, "", exibeNaTela);
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao encerrar, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String incluirCondutor(String modelo, IncCondutorReq incCondutorReq) throws Exception {
        String urlIncCondutor;

        switch (modelo)
        {
            case "58":
            {
                urlIncCondutor = endpoints.MDFeIncCondutor;
                break;
            }

            default:
            {
                throw new Exception("Não definido endpoint de inclusão de condutor para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(incCondutorReq);

        Genericos.gravarLinhaLog(modelo, "[INC_CONDUTOR_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlIncCondutor, "json");

        Genericos.gravarLinhaLog(modelo, "[INC_CONDUTOR_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String incluirCondutorESalvar(String modelo, IncCondutorReq incCondutorReq, DownloadEventoReq DownloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        String resposta = incluirCondutor(modelo, incCondutorReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200"))
        {
            String respostaDownloadEvento = downloadEventoESalvar(modelo, DownloadEventoReq, caminho, chave, "", exibeNaTela);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao incluir condutor, veja o retorno da API para mais informações");
        }

        return resposta;
    }

    public static String consultarNaoEncerrados(String modelo, ConsNaoEncerradosReq consNaoEncerradosReq) throws Exception {
        String urlConsNaoEncerrados;

        switch (modelo){
            case "58":{
                urlConsNaoEncerrados = endpoints.MDFeConsNaoEncerrados;
                break;
            }

            default:{
                throw new Exception("Não definido endpoint de consulta de não encerrados para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(consNaoEncerradosReq);

        Genericos.gravarLinhaLog(modelo, "[CONS_NAO_ENCERRADOS_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlConsNaoEncerrados, "json");

        Genericos.gravarLinhaLog(modelo, "[CONS_NAO_ENCERRADOS_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String incluirDFes(String modelo, IncluirDFeReqMDFe incluirDFeReqMDFe) throws Exception {
        String urlIncluirDFe;

        switch (modelo)
        {
            case "58":
            {
                urlIncluirDFe = endpoints.MDFeIncluirDFe;
                break;
            }

            default:
            {
                throw new Exception("Não definido endpoint de inclusão de DFe para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(incluirDFeReqMDFe);

        Genericos.gravarLinhaLog(modelo, "[INCLUIR_DFE_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlIncluirDFe, "json");

        Genericos.gravarLinhaLog(modelo, "[INCLUIR_DFE_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String incluirDFesESalvar(String modelo, IncluirDFeReqMDFe incluirDFeReqMDFe, DownloadEventoReq DownloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        String resposta = incluirDFes(modelo, incluirDFeReqMDFe);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200"))
        {
            String respostaDownloadEvento = downloadEventoESalvar(modelo, DownloadEventoReq, caminho, chave, "", exibeNaTela);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro ao incluir o(s) DFe(s), veja o retorno da API para mais informações");
        }

        return resposta;
    }

    // Métodos específicos de NFCe
    public static String emitirNFCeSincrono(String conteudo, String tpConteudo, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        ArrayList<String> erros = new ArrayList<>();

        String modelo = "65";
        String statusEnvio = "";
        String statusDownload = "";
        String motivo = "";
        String chNFe = "";
        String cStat = "";
        String nProt = "";

        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_INICIO]");

        String resposta = emitirDocumento(modelo, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        if (statusEnvio.equals("100") || statusEnvio.equals("-100")){

            cStat = respostaJSON.get("nfeProc").get("cStat").asText();
            if (cStat.equals("100") || cStat.equals("150")){
                chNFe = respostaJSON.get("nfeProc").get("chNFe").asText();
                nProt = respostaJSON.get("nfeProc").get("nProt").asText();
                motivo = respostaJSON.get("nfeProc").get("xMotivo").asText();

                Thread.sleep(parametros.TEMPO_ESPERA);

                DownloadReqNFCe downloadReqNFCe = new DownloadReqNFCe();
                downloadReqNFCe.chNFe = chNFe;
                downloadReqNFCe.tpAmb = tpAmb;
                downloadReqNFCe.impressao = new Impressao();

                resposta = downloadDocumentoESalvar(modelo, downloadReqNFCe, caminho, chNFe + "-NFCe", exibeNaTela);
                respostaJSON = objectMapper.readTree(resposta);
                statusDownload = respostaJSON.get("status").asText();

                if (!statusDownload.equals("100")) motivo = respostaJSON.get("motivo").asText();
            }else{
                motivo = respostaJSON.get("nfeProc").get("xMotivo").asText();
            }
        }else if (statusEnvio.equals("-995")){

            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

        }else{
            motivo = respostaJSON.get("motivo").asText();
        }
        EmitirSincronoRetNFCe emitirSincronoRetNFCe= new EmitirSincronoRetNFCe();
        emitirSincronoRetNFCe.statusEnvio = statusEnvio;
        emitirSincronoRetNFCe.statusDownload = statusDownload;
        emitirSincronoRetNFCe.cStat = cStat;
        emitirSincronoRetNFCe.chNFe = chNFe;
        emitirSincronoRetNFCe.nProt = nProt;
        emitirSincronoRetNFCe.motivo = motivo;
        emitirSincronoRetNFCe.erros = erros;

        String retorno = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(emitirSincronoRetNFCe);

        Genericos.gravarLinhaLog(modelo, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(modelo, retorno);
        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    // Métodos específicos de NFe
    public static String emitirNFeSincrono(String conteudo, String tpConteudo, String CNPJ, String tpDown, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        ArrayList<String> erros = new ArrayList<>();

        String modelo = "55";
        String statusEnvio = "";
        String statusConsulta = "";
        String statusDownload = "";
        String motivo = "";
        String nsNRec = "";
        String chNFe = "";
        String cStat = "";
        String nProt = "";

        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_INICIO]");

        String resposta = emitirDocumento(modelo, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        // Testa se o envio foi feito com sucesso (200) ou se é para reconsultar (-6)
        if (statusEnvio.equals("200") || statusEnvio.equals("-6")){

            nsNRec = respostaJSON.get("nsNRec").asText();

            // É necessário aguardar alguns milisegundos antes de consultar o status de processamento
            Thread.sleep(parametros.TEMPO_ESPERA);

            ConsStatusProcessamentoReqNFe consStatusProcessamentoReqNFe = new ConsStatusProcessamentoReqNFe();
            consStatusProcessamentoReqNFe.CNPJ = CNPJ;
            consStatusProcessamentoReqNFe.nsNRec = nsNRec;
            consStatusProcessamentoReqNFe.tpAmb = tpAmb;

            resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoReqNFe);
            respostaJSON = objectMapper.readTree(resposta);
            statusConsulta = respostaJSON.get("status").asText();

            if(statusConsulta.equals("-2")){
                cStat = respostaJSON.get("cStat").asText();
                if(cStat.equals("996")){
                    motivo = respostaJSON.get("erro").get("xMotivo").asText();
                    for (int i=1; i<=3; i++){
                        try {
                            Thread.sleep(6000 - (i*1000));
                        } catch (InterruptedException ignored){}
                        resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoReqNFe);
                        respostaJSON = objectMapper.readTree(resposta);
                        statusConsulta = respostaJSON.get("status").asText();
                        if(!statusConsulta.equals("-2")){ break; }
                    }
                } else {
                    motivo = respostaJSON.get("motivo").asText();
                }
            }
            // Testa se a consulta foi feita com sucesso (200)
            if (statusConsulta.equals("200")){

                cStat = respostaJSON.get("cStat").asText();

                if (cStat.equals("100") || cStat.equals("150")){

                    chNFe = respostaJSON.get("chNFe").asText();
                    nProt = respostaJSON.get("nProt").asText();
                    motivo = respostaJSON.get("xMotivo").asText();

                    DownloadReqNFe downloadReqNFe = new DownloadReqNFe();
                    downloadReqNFe.chNFe = chNFe;
                    downloadReqNFe.tpAmb = tpAmb; //aqui tava downloadReqNfe.tpAmb = tpDown
                    downloadReqNFe.tpDown = tpDown;

                    resposta = downloadDocumentoESalvar(modelo, downloadReqNFe, caminho, chNFe + "-NFe", exibeNaTela);
                    respostaJSON = objectMapper.readTree(resposta);
                    statusDownload = respostaJSON.get("status").asText();

                    if (!statusDownload.equals("200")) motivo = respostaJSON.get("motivo").asText();
                }else{
                    motivo = respostaJSON.get("motivo").asText();
                }
            }else if (statusConsulta.equals("-2")){

                cStat = respostaJSON.get("cStat").asText();
                motivo = respostaJSON.get("erro").get("xMotivo").asText();

            }else{
                motivo = respostaJSON.get("motivo").asText();
            }
        }else if ( statusEnvio.equals("-7")){

            motivo = respostaJSON.get("motivo").asText();
            nsNRec = respostaJSON.get("nsNRec").asText();

        }else if (statusEnvio.equals("-4") || statusEnvio.equals("-2")){

            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

        }else if (statusEnvio.equals("-999") || statusEnvio.equals("-5")){

            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        }else{
            try {
                motivo = respostaJSON.get("motivo").asText();
            }catch (Exception ex){
                motivo = respostaJSON.toString();
            }
        }
        EmitirSincronoRetNFe emitirSincronoRetNFe = new EmitirSincronoRetNFe();
        emitirSincronoRetNFe.statusEnvio = statusEnvio;
        emitirSincronoRetNFe.statusConsulta = statusConsulta;
        emitirSincronoRetNFe.statusDownload = statusDownload;
        emitirSincronoRetNFe.cStat = cStat;
        emitirSincronoRetNFe.chNFe = chNFe;
        emitirSincronoRetNFe.nProt = nProt;
        emitirSincronoRetNFe.motivo = motivo;
        emitirSincronoRetNFe.nsNRec = nsNRec;
        emitirSincronoRetNFe.erros = erros;

        String retorno = objectMapper.writeValueAsString(emitirSincronoRetNFe);

        Genericos.gravarLinhaLog(modelo, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(modelo, retorno);
        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    // Métodos específicos de NF3e
    public static String emitirNF3eSincrono(String conteudo, String tpConteudo, String CNPJ, String tpDown, String tpAmb, String caminho, boolean exibeNaTela) throws Exception {
        ArrayList<String> erros = new ArrayList<>();

        String modelo = "66";
        String statusEnvio = "";
        String statusConsulta = "";
        String statusDownload = "";
        String motivo = "";
        String nsNRec = "";
        String chNF3e = "";
        String cStat = "";
        String nProt = "";

        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_INICIO]");

        String resposta = emitirDocumento(modelo, conteudo, tpConteudo);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        statusEnvio = respostaJSON.get("status").asText();

        // Testa se o envio foi feito com sucesso (200) ou se é para reconsultar (-6)
        if (statusEnvio.equals("200") || statusEnvio.equals("-6")) {

            nsNRec = respostaJSON.get("nsNRec").asText();

            // É necessário aguardar alguns milisegundos antes de consultar o status de
            // processamento
            Thread.sleep(parametros.TEMPO_ESPERA);

            ConsStatusProcessamentoReqNF3e consStatusProcessamentoReqNF3e = new ConsStatusProcessamentoReqNF3e();
            consStatusProcessamentoReqNF3e.CNPJ = CNPJ;
            consStatusProcessamentoReqNF3e.nsNRec = nsNRec;
            consStatusProcessamentoReqNF3e.tpAmb = tpAmb;

            resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoReqNF3e);
            respostaJSON = objectMapper.readTree(resposta);
            statusConsulta = respostaJSON.get("status").asText();

            if (statusConsulta.equals("-2")) {
                cStat = respostaJSON.get("cStat").asText();
                if (cStat.equals("996")) {
                    motivo = respostaJSON.get("erro").get("xMotivo").asText();
                    for (int i = 1; i <= 3; i++) {
                        try {
                            Thread.sleep(6000 - (i * 1000));
                        } catch (InterruptedException ignored) {
                        }
                        resposta = consultarStatusProcessamento(modelo, consStatusProcessamentoReqNF3e);
                        respostaJSON = objectMapper.readTree(resposta);
                        statusConsulta = respostaJSON.get("status").asText();
                        if (!statusConsulta.equals("-2")) {
                            break;
                        }
                    }
                } else {
                    motivo = respostaJSON.get("xMotivo").asText();
                }
            }
            // Testa se a consulta foi feita com sucesso (200)
            if (statusConsulta.equals("200")) {

                cStat = respostaJSON.get("cStat").asText();

                if (cStat.equals("100") || cStat.equals("150")) {

                    chNF3e = respostaJSON.get("chNF3e").asText(); 
                    nProt = respostaJSON.get("nProt").asText();
                    motivo = respostaJSON.get("xMotivo").asText();

                    DownloadReqNF3e downloadReqNF3e = new DownloadReqNF3e();
                    downloadReqNF3e.chNF3e = chNF3e;
                    downloadReqNF3e.tpAmb = tpAmb; 
                    downloadReqNF3e.tpDown = tpDown;

                    resposta = downloadDocumentoESalvar(modelo, downloadReqNF3e, caminho, chNF3e + "-NF3e", exibeNaTela);
                    respostaJSON = objectMapper.readTree(resposta);
                    statusDownload = respostaJSON.get("status").asText();

                    if (!statusDownload.equals("200"))
                        motivo = respostaJSON.get("motivo").asText();
                } else {
                    motivo = respostaJSON.get("motivo").asText();
                }
            } else if (statusConsulta.equals("-2")) {

                cStat = respostaJSON.get("cStat").asText();
                motivo = respostaJSON.get("erro").get("xMotivo").asText();

            } else {
                motivo = respostaJSON.get("motivo").asText();
            }
        } else if (statusEnvio.equals("-7")) {

            motivo = respostaJSON.get("motivo").asText();
            nsNRec = respostaJSON.get("nsNRec").asText();

        } else if (statusEnvio.equals("-4") || statusEnvio.equals("-2")) {

            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(),
                    new TypeReference<ArrayList<String>>() {
                    });

        } else if (statusEnvio.equals("-999") || statusEnvio.equals("-5")) {

            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        } else {
            try {
                motivo = respostaJSON.get("motivo").asText();
            } catch (Exception ex) {
                motivo = respostaJSON.toString();
            }
        }
        EmitirSincronoRetNF3e emitirSincronoRetNF3e = new EmitirSincronoRetNF3e();
        emitirSincronoRetNF3e.statusEnvio = statusEnvio;
        emitirSincronoRetNF3e.statusConsulta = statusConsulta;
        emitirSincronoRetNF3e.statusDownload = statusDownload;
        emitirSincronoRetNF3e.cStat = cStat;
        emitirSincronoRetNF3e.chNF3e = chNF3e;
        emitirSincronoRetNF3e.nProt = nProt;
        emitirSincronoRetNF3e.motivo = motivo;
        emitirSincronoRetNF3e.nsNRec = nsNRec;
        emitirSincronoRetNF3e.erros = erros;

        String retorno = objectMapper.writeValueAsString(emitirSincronoRetNF3e);

        Genericos.gravarLinhaLog(modelo, "[JSON_RETORNO]");
        Genericos.gravarLinhaLog(modelo, retorno);
        Genericos.gravarLinhaLog(modelo, "[EMISSAO_SINCRONA_FIM]");

        return retorno;
    }

    // Métodos genéricos, compartilhados entre diversas funções
    public static String emitirDocumento(String modelo, String conteudo, String tpConteudo) throws Exception {
        String urlEnvio;

        switch (modelo) {
            case "63": {
                urlEnvio = endpoints.BPeEnvio;
                break;
            }
            case "57": {
                urlEnvio = endpoints.CTeEnvio;
                break;
            }
            case "67": {
                urlEnvio = endpoints.CTeOSEnvio;
                break;
            }
            case "58": {
                urlEnvio = endpoints.MDFeEnvio;
                break;
            }
            case "65": {
                urlEnvio = endpoints.NFCeEnvio;
                break;
            }
            case "55": {
                urlEnvio = endpoints.NFeEnvio;
                break;
            }
            case "66": {
                urlEnvio = endpoints.NF3eEnvio;
                break;
            }
            default: {
                throw new Exception("Não definido endpoint de envio para o modelo " + modelo);
            }

        }
        Genericos.gravarLinhaLog(modelo, "[ENVIO_DADOS]");
        Genericos.gravarLinhaLog(modelo, conteudo);

        String resposta = enviaConteudoParaAPI(conteudo, urlEnvio, tpConteudo);

        Genericos.gravarLinhaLog(modelo, "[ENVIO_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String consultarStatusProcessamento(String modelo, ConsStatusProcessamentoReq consStatusProcessamentoReq) throws Exception {
        String urlConsulta;

        switch (modelo) {
            case "63": {
                urlConsulta = endpoints.BPeConsStatusProcessamento;
                break;
            }
            case "57":
            case "67": {
                urlConsulta = endpoints.CTeConsStatusProcessamento;
                break;
            }
            case "58": {
                urlConsulta = endpoints.MDFeConsStatusProcessamento;
                break;
            }
            case "55": {
                urlConsulta = endpoints.NFeConsStatusProcessamento;
                break;
            }
            case "66": {
                urlConsulta = endpoints.NF3eConsStatusProcessamento;
                break;
            }
            default: {
                throw new Exception("Não definido endpoint de consulta para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(consStatusProcessamentoReq);

        Genericos.gravarLinhaLog(modelo, "[CONSULTA_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlConsulta, "json");

        Genericos.gravarLinhaLog(modelo, "[CONSULTA_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);
        return resposta;
    }

    public static String downloadDocumento(String modelo, DownloadReq downloadReq) throws Exception {
        String urlDownload, status;
        ObjectMapper objectMapper = new ObjectMapper();
        switch (modelo) {
            case "63": {
                urlDownload = endpoints.BPeDownload;
                break;
            }
            case "67": {
                urlDownload = endpoints.CTeDownload;
                break;
            }
            case "58": {
                urlDownload = endpoints.MDFeDownload;
                break;
            }
            case "65": {
                urlDownload = endpoints.NFCeDownload;
                break;
            }
            case "55": {
                urlDownload = endpoints.NFeDownload;
                break;
            }
            case "66": {
                urlDownload = endpoints.NF3eDownload;
                break;
            }
            default: {
                throw new Exception("Não definido endpoint de Download para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(downloadReq);

        Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlDownload, "json");

        JsonNode respostaJSON = objectMapper.readTree(resposta);
        status = respostaJSON.get("status").asText();

        // O retorno da API será gravado somente em caso de erro,
        // para não gerar um log extenso com o PDF e XML
        if ((!status.equals("200")) & (!status.equals("100")))
        {
            Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_RESPOSTA]");
            Genericos.gravarLinhaLog(modelo, resposta);
        }
        else
        {
            Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_STATUS]");
            Genericos.gravarLinhaLog(modelo, status);
        }

        return resposta;
    }

    public static String downloadDocumentoESalvar(String modelo, DownloadReq downloadReq, String caminho, String nome, boolean exibeNaTela) throws Exception {
        String resposta = downloadDocumento(modelo, downloadReq);
        String status;

        JsonNode respostaJSON = objectMapper.readTree(resposta);
        status = respostaJSON.get("status").asText();

        if((status.equals("200")) || (status.equals("100"))){
            try{
                File diretorio = new File(caminho);
                if(!diretorio.exists()) diretorio.mkdirs();
                if(!caminho.endsWith("\\")) caminho += "\\";
            }catch (Exception ex){
                Genericos.gravarLinhaLog(modelo, "[CRIAR_DIRETORIO]" + caminho);
                Genericos.gravarLinhaLog(modelo, ex.getMessage());
                throw new Exception("Erro: " + ex.getMessage());
            }

            if(!modelo.equals("65")){
                if (downloadReq.tpDown.toUpperCase().contains("X")){
                    String xml = respostaJSON.get("xml").asText();
                    Genericos.salvarXML(xml, caminho, nome);
                }
                if (downloadReq.tpDown.toUpperCase().contains("P"))
                {
                    String pdf = respostaJSON.get("pdf").asText();
                    Genericos.salvarPDF(pdf, caminho, nome);

                    if (exibeNaTela)
                    {
                        File arq = new File(caminho + nome + ".pdf");
                        Desktop.getDesktop().open(arq);
                    }
                }
            }else{
                String xml = respostaJSON.get("nfeProc").get("xml").asText();
                Genericos.salvarXML(xml, caminho, nome);

                String pdf = respostaJSON.get("pdf").asText();
                Genericos.salvarPDF(pdf, caminho, nome);

                if (exibeNaTela){
                    File arq = new File(caminho + nome + ".pdf");
                    Desktop.getDesktop().open(arq);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Ocorreu um erro, veja o retorno da API para mais informaçõe");
        }
        return resposta;
    }

    public static String downloadEvento(String modelo, DownloadEventoReq downloadEventoReq) throws Exception {
        String urlDownloadEvento;

        switch (modelo){
            case "63":{
                urlDownloadEvento = endpoints.BPeDownloadEvento;
                break;
            }

            case "67":{
                urlDownloadEvento = endpoints.CTeDownloadEvento;
                break;
            }

            case "58":{
                urlDownloadEvento = endpoints.MDFeDownloadEvento;
                break;
            }

            case "65":{
                urlDownloadEvento = endpoints.NFCeDownload;
                break;
            }

            case "55":{
                urlDownloadEvento = endpoints.NFeDownloadEvento;
                break;
            }

            case "66": {
                urlDownloadEvento = endpoints.NF3eDownloadEvento;
                break;
            }

            default:{
                throw new Exception("Não definido endpoint de download de evento para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(downloadEventoReq);

        Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_EVENTO_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlDownloadEvento, "json");

        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        // O retorno da API será gravado somente em caso de erro,
        // para não gerar um log extenso com o PDF e XML
        if ((!status.equals("200")) && (!status.equals("100"))){
            Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_EVENTO_RESPOSTA]");
            Genericos.gravarLinhaLog(modelo, resposta);
        }else{
            Genericos.gravarLinhaLog(modelo, "[DOWNLOAD_EVENTO_STATUS]");
            Genericos.gravarLinhaLog(modelo, status);
        }
        return resposta;
    }

    public static String downloadEventoESalvar(String modelo, DownloadEventoReq downloadEventoReq, String caminho, String chave, String nSeqEvento, boolean exibeNaTela) throws Exception {
        String tpEventoSalvar = "";

        String resposta = downloadEvento(modelo, downloadEventoReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200") || status.equals("100")){
            try{
                File diretorio = new File(caminho);
                if(!diretorio.exists()) diretorio.mkdirs();
                if(!caminho.endsWith("\\")) caminho += "\\";
            }catch (Exception ex){
                Genericos.gravarLinhaLog(modelo, "[CRIAR_DIRETORIO]" + caminho);
                Genericos.gravarLinhaLog(modelo, ex.getMessage());
                throw new Exception("Erro: " + ex.getMessage());
            }
            if (!modelo.equals("65")){

                if (downloadEventoReq.tpEvento.toUpperCase().equals("CANC")){
                    tpEventoSalvar = "110111";
                }else if (downloadEventoReq.tpEvento.toUpperCase().equals("ENC")){
                    tpEventoSalvar = "110110";
                }else{
                    tpEventoSalvar = "110115";
                }

                //Verifica quais arquivos deve salvar
                if (downloadEventoReq.tpDown.toUpperCase().contains("X")){
                    String xml = respostaJSON.get("xml").asText();
                    Genericos.salvarXML(xml, caminho, tpEventoSalvar + chave + nSeqEvento + "-procEven");
                }
                if (downloadEventoReq.tpDown.toUpperCase().contains("P")){
                    String pdf = respostaJSON.get("pdf").asText();
                    if (pdf != null && !pdf.equals("")){
                        Genericos.salvarPDF(pdf, caminho, tpEventoSalvar + chave + nSeqEvento + "-procEven");
                        if (exibeNaTela){
                            File arq = new File(caminho + tpEventoSalvar + chave + nSeqEvento + "procEven.pdf");
                            Desktop.getDesktop().open(arq);
                        }
                    }
                }
            }else{
                String xml = respostaJSON.get("nfeProc").get("xml").asText();
                Genericos.salvarXML(xml, caminho, tpEventoSalvar + chave + nSeqEvento + "-procEven");

                String pdf = respostaJSON.get("pdfCancelamento").asText();
                Genericos.salvarPDF(pdf, caminho, tpEventoSalvar + chave + nSeqEvento + "procEven");

                if (exibeNaTela){
                    File arq = new File(caminho + tpEventoSalvar + chave + nSeqEvento + "procEven.pdf");
                    Desktop.getDesktop().open(arq);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String cancelarDocumento(String modelo, CancelarReq cancelarReq) throws Exception {
        String urlCancelamento;
        switch (modelo){
            case "63":{
                urlCancelamento = endpoints.BPeCancelamento;
                break;
            }

            case "67":{
                urlCancelamento = endpoints.CTeCancelamento;
                break;
            }
            

            case "58":{
                urlCancelamento = endpoints.MDFeCancelamento;
                break;
            }

            case "65":{
                urlCancelamento = endpoints.NFCeCancelamento;
                break;
            }

            case "55":{
                urlCancelamento = endpoints.NFeCancelamento;
                break;
            }

            case "66": {
                urlCancelamento = endpoints.NF3eCancelamento;
                break;
            }

            default:
            {
                throw new Exception("Não definido endpoint de cancelamento para o modelo " + modelo);
            }
        }
        String json = objectMapper.writeValueAsString(cancelarReq);

        Genericos.gravarLinhaLog(modelo, "[CANCELAMENTO_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlCancelamento, "json");

        Genericos.gravarLinhaLog(modelo, "[CANCELAMENTO_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String cancelarDocumentoESalvar(String modelo, CancelarReq cancelarReq, DownloadEventoReq downloadEventoReq, String caminho, String chave, boolean exibeNaTela) throws Exception {
        String resposta = cancelarDocumento(modelo, cancelarReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200") || status.equals("135")){
            String cStat = respostaJSON.get("cStat").asText();
            if (cStat.equals("135")){
                String respostaDownloadEvento = downloadEventoESalvar(modelo, downloadEventoReq, caminho, chave, "1", exibeNaTela);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String corrigirDocumento(String modelo, CorrigirReq corrigirReq) throws Exception {
        String urlCCe;

        switch (modelo){
            case "67":{
                urlCCe = endpoints.CTeCCe;
                break;
            }
            case "55":{
                urlCCe = endpoints.NFeCCe;
                break;
            }
            default:{
                throw new Exception("Não definido endpoint de carta de correção para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(corrigirReq);

        Genericos.gravarLinhaLog(modelo, "[CCE_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlCCe, "json");

        Genericos.gravarLinhaLog(modelo, "[CCE_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String corrigirDocumentoESalvar(String modelo, CorrigirReq corrigirReq, DownloadEventoReq downloadEventoReq, String caminho, String chave, String nSeqEvento, boolean exibeNaTela) throws Exception {
        String resposta = corrigirDocumento(modelo, corrigirReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();

        if (status.equals("200")){
                String respostaDownloadEvento = downloadEventoESalvar(modelo, downloadEventoReq, caminho, chave, nSeqEvento, exibeNaTela);
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao corrigir, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String inutilizarNumeracao(String modelo, InutilizarReq inutilizarReq) throws Exception {
        String urlInutilizacao;

        switch (modelo){
            case "57":
            case "67":{
                urlInutilizacao = endpoints.CTeInutilizacao;
                break;
            }
            case "65":{
                urlInutilizacao = endpoints.NFCeInutilizacao;
                break;
            }
            case "55":{
                urlInutilizacao = endpoints.NFeInutilizacao;
                break;
            }
            default:{
                throw new Exception("Não definido endpoint de inutilização para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(inutilizarReq);

        Genericos.gravarLinhaLog(modelo, "[INUTILIZACAO_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlInutilizacao, "json");

        Genericos.gravarLinhaLog(modelo, "[INUTILIZACAO_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String inutilizarNumeracaoESalvar(String modelo, InutilizarReq inutilizarReq, String caminho) throws Exception {
        String resposta = inutilizarNumeracao(modelo, inutilizarReq);
        JsonNode respostaJSON = objectMapper.readTree(resposta);
        String status = respostaJSON.get("status").asText();
        String xml = null;
        String chave = null;

        if (status.equals("102") || status.equals("200")){
            String cStat = respostaJSON.get("cStat").asText();
            if (cStat.equals("102")){
                switch (modelo){
                    case "57":
                    case "67":{
                        xml = respostaJSON.get("retornoInutCTe").get("xmlInut").asText();
                        chave = respostaJSON.get("retornoInutCTe").get("chave").asText();
                        break;
                    }

                    case "65":{
                        xml = respostaJSON.get("retInutNFe").get("xml").asText();
                        chave = respostaJSON.get("retInutNFe").get("chave").asText();
                        break;
                    }

                    case "55":{
                        xml = respostaJSON.get("retornoInutNFe").get("xmlInut").asText();
                        chave = respostaJSON.get("retornoInutNFe").get("chave").asText();
                        break;
                    }

                    default:
                    {
                        throw new Exception("Nao existe inutilização para este modelo " + modelo);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao inutilizar a numeração, veja o retorno da API para mais informações");
        }

        if (xml != null)
        {
            File diretorio = new File(caminho);
            if(!diretorio.exists()) diretorio.mkdirs();
            if(!caminho.endsWith("\\")) caminho += "\\";
            Genericos.salvarXML(xml, caminho, chave);
        }

        return resposta;
    }

    public static String consultarCadastroContribuinte(String modelo, ConsCadReq consCadReq) throws Exception {
        String urlConsCad;

        switch (modelo){
            case "57":
            case "67":{
                urlConsCad = endpoints.CTeConsCad;
                break;
            }

            case "55":{
                urlConsCad = endpoints.NFeConsCad;
                break;
            }

            default:{
                throw new Exception("Não definido endpoint de consulta de cadastro para o modelo " + modelo);
            }
        }

        String json = objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL).writeValueAsString(consCadReq);

        Genericos.gravarLinhaLog(modelo, "[CONS_CAD_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlConsCad, "json");

        Genericos.gravarLinhaLog(modelo, "[CONS_CAD_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String consultarSituacaoDocumento(String modelo, ConsSitReq consSitReq) throws Exception {
        String urlConsSit;

        switch (modelo){
            case "63":{
                urlConsSit = endpoints.BPeConsSit;
                break;
            }

            case "67":{
                urlConsSit = endpoints.CTeConsSit;
                break;
            }

            case "58":{
                urlConsSit = endpoints.MDFeConsSit;
                break;
            }

            case "65":{
                urlConsSit = endpoints.NFCeConsSit;
                break;
            }

            case "55":{
                urlConsSit = endpoints.NFeConsSit;
                break;
            }

            case "66":{
                urlConsSit = endpoints.NF3eConsSit;
                break;
            }

            default:{
                throw new Exception("Não definido endpoint de consulta de situação para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(consSitReq);

        Genericos.gravarLinhaLog(modelo, "[CONS_SIT_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlConsSit, "json");

        Genericos.gravarLinhaLog(modelo, "[CONS_SIT_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String listarNSNRecs(String modelo, ListarNSNRecReq listarNSNRecReq) throws Exception {
        String urlListarNSNRecs;

        switch (modelo)
        {
            case "67":
            {
                urlListarNSNRecs = endpoints.CTeListarNSNRecs;
                break;
            }

            case "58":
            {
                urlListarNSNRecs = endpoints.MDFeListarNSNRecs;
                break;
            }

            case "55":
            {
                urlListarNSNRecs = endpoints.NFeListarNSNRecs;
                break;
            }

            case "66": {
                urlListarNSNRecs = endpoints.NF3eListarNSNRecs;
                break;
            }

            default:
            {
                throw new Exception("Não definido endpoint de listagem de nsNRec para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(listarNSNRecReq);

        Genericos.gravarLinhaLog(modelo, "[LISTAR_NSNRECS_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlListarNSNRecs, "json");

        Genericos.gravarLinhaLog(modelo, "[LISTAR_NSNRECS_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String enviarEmailDocumento(String modelo, EnviarEmailReq enviarEmailReq) throws Exception {
        String urlEnviarEmail;

        switch (modelo)
        {
            case "65":
            {
                urlEnviarEmail = endpoints.NFCeEnvioEmail;
                break;
            }

            case "55":
            {
                urlEnviarEmail = endpoints.NFeEnvioEmail;
                break;
            }

            default:
            {
                throw new Exception("Não definido endpoint de envio de e-mail para o modelo " + modelo);
            }
        }

        String json = objectMapper.writeValueAsString(enviarEmailReq);

        Genericos.gravarLinhaLog(modelo, "[ENVIAR_EMAIL_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlEnviarEmail, "json");

        Genericos.gravarLinhaLog(modelo, "[ENVIAR_EMAIL_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

}

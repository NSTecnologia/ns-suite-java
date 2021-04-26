package br.eti.ns.nssuite;

import br.eti.ns.nssuite.compartilhados.*;
import br.eti.ns.nssuite.requisicoes._genericos.*;
import br.eti.ns.nssuite.requisicoes.bpe.ConsStatusProcessamentoReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.DownloadReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.NaoEmbReqBPe;
import br.eti.ns.nssuite.retornos.bpe.EmitirSincronoRetBPe;
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

    // BPe methods
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

            if (statusConsulta.equals("-2")) {
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
                } 
                else {
                    motivo = respostaJSON.get("motivo").asText();
                }
            }

            if (statusConsulta.equals("200")) {

                cStat = respostaJSON.get("cStat").asText();

                if (cStat.equals("100")){

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
                }
                else{
                    motivo = respostaJSON.get("xMotivo").asText();
                }

            }
            else if (statusConsulta.equals("-2")){
                cStat = respostaJSON.get("cStat").asText();
                motivo = respostaJSON.get("erro").get("motivo").asText();

            }
            else{
                motivo = respostaJSON.get("motivo").asText();
            }

        } 
        else if (statusEnvio.equals("-5")) {
            cStat = respostaJSON.get("erro").get("cStat").asText();
            motivo = respostaJSON.get("erro").get("xMotivo").asText();

        } 
        else if (statusEnvio.equals("-4") || statusEnvio.equals("-2")) {
            motivo = respostaJSON.get("motivo").asText();
            erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

        } 
        else {
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
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao não embarcar, veja o retorno da API para mais informaçõe");
        }
        return resposta;
    }

    // General use methodos. Public to functions
    public static String emitirDocumento(String modelo, String conteudo, String tpConteudo) throws Exception {
        String urlEnvio;

        urlEnvio = endpoints.BPeEnvio;
        
        Genericos.gravarLinhaLog(modelo, "[ENVIO_DADOS]");
        Genericos.gravarLinhaLog(modelo, conteudo);

        String resposta = enviaConteudoParaAPI(conteudo, urlEnvio, tpConteudo);

        Genericos.gravarLinhaLog(modelo, "[ENVIO_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

    public static String consultarStatusProcessamento(String modelo, ConsStatusProcessamentoReq consStatusProcessamentoReq) throws Exception {
        String urlConsulta;
        urlConsulta = endpoints.BPeConsStatusProcessamento;
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
        urlDownload = endpoints.BPeDownload;
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
            }
            catch (Exception ex){
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
            }
            else {
                String xml = respostaJSON.get("nfeProc").get("xml").asText();
                Genericos.salvarXML(xml, caminho, nome);

                String pdf = respostaJSON.get("pdf").asText();
                Genericos.salvarPDF(pdf, caminho, nome);

                if (exibeNaTela){
                    File arq = new File(caminho + nome + ".pdf");
                    Desktop.getDesktop().open(arq);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String downloadEvento(String modelo, DownloadEventoReq downloadEventoReq) throws Exception {
        String urlDownloadEvento = endpoints.BPeDownloadEvento;

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
        }
        else {
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
            } 
            else {
                String xml = respostaJSON.get("nfeProc").get("xml").asText();
                Genericos.salvarXML(xml, caminho, tpEventoSalvar + chave + nSeqEvento + "-procEven");

                String pdf = respostaJSON.get("pdfCancelamento").asText();
                Genericos.salvarPDF(pdf, caminho, tpEventoSalvar + chave + nSeqEvento + "procEven");

                if (exibeNaTela){
                    File arq = new File(caminho + tpEventoSalvar + chave + nSeqEvento + "procEven.pdf");
                    Desktop.getDesktop().open(arq);
                }
            }
        } 
        else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, veja o retorno da API para mais informações");
        }

        return resposta;
    }

    public static String cancelarDocumento(String modelo, CancelarReq cancelarReq) throws Exception {
        String urlCancelamento = endpoints.BPeCancelamento;
              
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
        } 
        else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cancelar, veja o retorno da API para mais informações");
        }
        return resposta;
    }

    public static String consultarSituacaoDocumento(String modelo, ConsSitReq consSitReq) throws Exception {
        String urlConsSit = endpoints.BPeConsSit;

        String json = objectMapper.writeValueAsString(consSitReq);

        Genericos.gravarLinhaLog(modelo, "[CONS_SIT_DADOS]");
        Genericos.gravarLinhaLog(modelo, json);

        String resposta = enviaConteudoParaAPI(json, urlConsSit, "json");

        Genericos.gravarLinhaLog(modelo, "[CONS_SIT_RESPOSTA]");
        Genericos.gravarLinhaLog(modelo, resposta);

        return resposta;
    }

}

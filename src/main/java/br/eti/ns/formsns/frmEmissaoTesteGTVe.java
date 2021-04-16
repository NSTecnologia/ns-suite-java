package br.eti.ns.formsns;

import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.*;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Dest;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Emit;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.EnderDest;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.EnderEmit;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Ide;
import br.eti.ns.nssuite.requisicoes.nf3e.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmemissaoTesteGTVe {

    private JPanel panelMain;
    private JButton btnEnviarNF3e;
    private JButton btnCancelarNF3e;
    private JButton btnDownEventoNF3e;
    private JButton btnConSituacaoNF3e;
    private JButton btnListarNSNrec;
    private JButton btnDownloadNF3e;

    public frmemissaoTesteGTVe() {

        // NF3e
        btnEnviarNF3e.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Teste de emissão - GTVe");

            // Faz a serializacao do objeto JSON que foi populado

            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            try {
                json = mapper.writeValueAsString(GTVeJSON);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            // Para finalidades de testes, apresenta o json a ser enviado para a API.
            System.out.println(json);

            String retorno = null;

            try {

                // Faz a chamada da funcao para fazer a emissao sincrona da NF3e
                retorno = NSSuite.emitirGTVeSincrono(json, "json", "07364617000135", "X", "2", "C:/Notas/NF3e", false);

                // Le os dados do retorno, fazendo um tratamento para posterior armazenamento dos dados retornados
                JsonNode respostaJSON = mapper.readTree(retorno);
                String statusEnvio = respostaJSON.get("statusEnvio").asText();
                String statusConsulta = respostaJSON.get("statusConsulta").asText();
                String statusDownload = respostaJSON.get("statusDownload").asText();
                String cStat = respostaJSON.get("cStat").asText();
                String chNF3e = respostaJSON.get("chNF3e").asText();
                String nProt = respostaJSON.get("nProt").asText();
                String motivo = respostaJSON.get("motivo").asText();
                String nsNRec = respostaJSON.get("nsNRec").asText();
                ArrayList<String> erros = mapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});
                if (statusEnvio.equals("200") || statusEnvio.equals("-6")){
                    if (statusConsulta.equals("200")) {
                        if (cStat.equals("100")) {
                            JOptionPane.showMessageDialog(null, motivo);
                            if (!statusDownload.equals("200")) {
                                JOptionPane.showMessageDialog(null, "Erro Download");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, motivo);
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, motivo + "\n" + erros.toString());
                }
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }

            // Para fins de teste, apresenta o retorno da API
            //JOptionPane.showMessageDialog(null, retorno);

            // Para fins de teste, apresenta o json retornado pela API
            System.out.println(retorno);

        });

        // Exemplo de como cancelar uma NF3e
        btnCancelarGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Cancelamento - GTVe");

            // Atribuicao dos parametros
            CancelarReqGTVe cancelarReqGTVe = new CancelarReqGTVe();

            cancelarReqGTVe.dhEvento = "2021-04-14T11:23:00-03:00";
            cancelarReqGTVe.nProt = "";
            cancelarReqGTVe.tpAmb = "2";
            cancelarReqGTVe.xJust = "Cancelamento de GTVe para fins de teste em homologação";
            cancelarReqGTVe.chGTVe = "";


            try {
                // Chamada da funcao
                String retorno = NSSuite.cancelarDocumento("66", cancelarReqGTVe);

                // Para fins de teste, apresenta o json retornado pela API
                //JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);

            }

            catch (Exception exception) {
                exception.printStackTrace();

            }


        });

        // Exemplo de como fazer o download do evento da NF3e, neste caso, o cancelamento
        btnDownEventoGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Download de Evento - GTVe");

            // Atribuicao dos parametros
            DownloadEventoReqGTVe downloadEventoReqGTVe = new DownloadEventoReqGTVe();
            downloadEventoReqGTVe.nSeqEvento = "1";
            downloadEventoReqGTVe.chGTVe = "43210407364617000135660000000510021000000016";
            downloadEventoReqGTVe.tpDown = "X";
            downloadEventoReqGTVe.tpAmb = "2";
            downloadEventoReqGTVe.tpEvento = "CANC";


            try {
                // Chamada da funcao
                String retorno = NSSuite.downloadEventoESalvar("64",downloadEventoReqGTVe,"C:/Notas/GTVe",downloadEventoReqGTVe.chGTVe,downloadEventoReqGTVe.nSeqEvento,false);

                // Para fins de teste, apresenta o json retornado pela API
                //JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        // Exemplo de como consultar a situacao da GTVe
        btnConSituacaoGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Consulta Situação - GTVe");

            // Atribuicao dos parametros
            ConsSitReqGTVe consSitReqGTVe = new ConsSitReqGTVe();
            consSitReqGTVe.chGTVe = "43210407364617000135660000000510021000000016";
            consSitReqGTVe.licencaCNPJ = "07364617000135";
            consSitReqGTVe.tpAmb = "2";


            try {
                // Chamada da funcao
                String retorno = NSSuite.consultarSituacaoDocumento("64", consSitReqGTVe);

                // Para fins de teste, apresenta o json retornado pela API
                //JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        // Exemplo de como listar o nsNRec de uma GTVe
        btnListarNSNrec.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Listagem de nsNRec - GTVe");

            // Atribuicao dos parametros
            ListarNSNRecReqGTVe listarNSNRecReqGTVe = new ListarNSNRecReqGTVe();
            listarNSNRecReqGTVe.chGTVe = "43210407364617000135660000000510021000000016";
            listarNSNRecReqGTVe.tpAmb = "2";


            try {
                // Chamada da funcao
                String retorno = NSSuite.listarNSNRecs("64", listarNSNRecReqGTVe);

                // Para fins de teste, apresenta o json retornado pela API
                //JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        // Exemplo de como fazer o Download e Salvar uma GTVe
        btnDownloadGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Download de nsNRec - GTVe");

            // Atribuicao dos parametros
            DownloadReqGTVe downloadReqGTVe = new DownloadReqGTVe();
            downloadReqGTVe.chGTVe = "43210407364617000135660000000510021000000016";
            downloadReqGTVe.tpDown = "X";
            downloadReqGTVe.tpAmb = "2";


            try {
                // Chamada da funcao
                String retorno = NSSuite.downloadDocumentoESalvar("64", downloadReqGTVe,"C:/Notas/GTVe",downloadReqNF3e.chNF3e+"-NF3e",false);

                // Para fins de teste, apresenta o json retornado pela API
                //JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });
    };
    public static void main (String[] args) {
        JFrame frame = new JFrame("frmEmissaoTesteGTVe");
        frame.setContentPane(new frmemissaoTesteGTVe().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

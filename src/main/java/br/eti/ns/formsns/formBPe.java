package br.eti.ns.formsns;

import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.JSON.BPe.*;
import br.eti.ns.nssuite.requisicoes.bpe.DownloadReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.CancelarReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.ConsSitReqBPe;
import br.eti.ns.nssuite.requisicoes.bpe.DownloadEventoReqBPe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.util.ArrayList;

public class formBPe {

    private JPanel panelBPe;
    private JButton btnIssueBPe;
    private JButton btnCancelBPe;
    private JButton btnDownloadEventBPe;
    private JButton btnCheckSituationBPe;
    private JButton btnDownloadBPe;

    public formBPe() {

        btnIssueBPe.addActionListener(e -> {

            BPeJSON bPeJSON = new BPeJSON();
            BPeJSON.BPe bPe = new BPeJSON.BPe();
            BPeJSON.InfBPe infBPe = new BPeJSON.InfBPe();
            BPeJSON.Ide ide = new BPeJSON.Ide();
            BPeJSON.Emit emit = new BPeJSON.Emit();
            BPeJSON.EnderEmit enderEmit = new BPeJSON.EnderEmit();
            BPeJSON.Comp comp = new BPeJSON.Comp();
            BPeJSON.EnderComp enderComp = new BPeJSON.EnderComp();
            BPeJSON.Agencia agencia = new BPeJSON.Agencia();
            BPeJSON.EnderAgencia enderAgencia = new BPeJSON.EnderAgencia();
            BPeJSON.InfPassagem infPassagem = new BPeJSON.InfPassagem();
            BPeJSON.InfPassageiro infPassageiro = new BPeJSON.InfPassageiro();
            BPeJSON.InfViagem infViagem = new BPeJSON.InfViagem();
            BPeJSON.InfValorBPe infValorBPe = new BPeJSON.InfValorBPe();
            BPeJSON.InfValorBPe.Comp listComp = new BPeJSON.InfValorBPe.Comp();
            BPeJSON.Imp imp = new BPeJSON.Imp();
            BPeJSON.ICMS icms = new BPeJSON.ICMS();
            BPeJSON.ICMS00 icms00 = new BPeJSON.ICMS00();
            BPeJSON.ICMSUFFim iCMSUFFim = new BPeJSON.ICMSUFFim();
            BPeJSON.InfBPe.Pag pag = new BPeJSON.InfBPe.Pag();
            BPeJSON.InfRespTec infRespTec = new BPeJSON.InfRespTec();

            // JSON Serialization
            bPeJSON.bPe = bPe;
            bPe.infBPe = infBPe;
            infBPe.versao = "1.00";

            // BPe's Header
            infBPe.ide = ide;
            ide.cUF = "43";
            ide.tpAmb = "2";
            ide.mod = "63";
            ide.serie = "6";
            ide.nBP = "2107";
            ide.cDV = "7";
            ide.modal = "1";
            ide.dhEmi = "2021-04-26T09:39:00-03:00";
            ide.tpEmis = "1";
            ide.verProc = "1.00";
            ide.tpBPe = "0";
            ide.indPres = "1";
            ide.uFIni = "RS";
            ide.cMunIni = "4314902";
            ide.uFFim = "PR";
            ide.cMunFim = "4106902";

            // Issuer's information
            infBPe.emit = emit;
            emit.cNPJ = "07364617000135";
            emit.iE = "0170108708";
            emit.xNome = "EMPRESA TESTE";
            emit.iM = "516830";
            emit.cNAE = "1234567";
            emit.cRT = "1";
            emit.tAR = "113645236";
            emit.enderEmit = enderEmit;
            enderEmit.xLgr = "RUA ANTONIO DURO";
            enderEmit.nro = "87";
            enderEmit.xBairro = "CENTRO";
            enderEmit.cMun = "4303509";
            enderEmit.xMun = "CAMAQUA";
            enderEmit.uF = "RS";

            // Buyer's information
            infBPe.comp = comp;
            comp.xNome = "JHON DOE";
            comp.cPF = "34921624011";
            comp.enderComp = enderComp;
            enderComp.xLgr = "RUA ANDRADAS EM CURITIBANAS";
            enderComp.xLgr = "RUA ANTONIO DURO";
            enderComp.nro = "87";
            enderComp.xBairro = "CENTRO";
            enderComp.cMun = "4303509";
            enderComp.xMun = "CAMAQUA";
            enderComp.uF = "RS";

            // Agency's information
            infBPe.agencia = agencia;
            agencia.xNome = "AGENDA LTDA";
            agencia.cNPJ = "07364617000135";
            agencia.enderAgencia = enderAgencia;
            enderAgencia.xLgr = "Largo Vespasiano Julio Veppo";
            enderAgencia.nro = "87";
            enderAgencia.xBairro = "CENTRO";
            enderAgencia.cMun = "4303509";
            enderAgencia.xMun = "CAMAQUA";
            enderAgencia.uF = "RS";

            // Ticket information
            infBPe.infPassagem = infPassagem;
            infPassagem.cLocOrig = "4314902";
            infPassagem.xLocOrig = "PORTO ALEGRE";
            infPassagem.cLocDest = "4106902";
            infPassagem.xLocDest = "CURITIBA";
            infPassagem.dhEmb = "2021-04-26T18:30:00-03:00";
            infPassagem.dhValidade = "2022-04-26T09:39:00-03:00";
            infPassagem.infPassageiro = infPassageiro;
            infPassageiro.xNome = "JOHN DOE";
            infPassageiro.cPF = "00269925074";
            infPassageiro.tpDoc = "1";
            infPassageiro.nDoc = "3076507718";

            // Trip information
            infBPe.infViagem = infViagem;
            infViagem.cPercurso = "1";
            infViagem.xPercurso = "route description test";
            infViagem.tpViagem = "00";
            infViagem.tpServ = "4";
            infViagem.tpAcomodacao = "1";
            infViagem.tpTrecho = "1";
            infViagem.dhViagem = "2021-04-26T19:00:00-03:00";
            infViagem.poltrona = "5";

            // BPe's payment amounts
            infBPe.infValorBPe = infValorBPe;
            infValorBPe.vBP = "85.00";
            infValorBPe.vDesconto = "0.00";
            infValorBPe.vPgto = "85.00";
            infValorBPe.vTroco = "0.00";
            infValorBPe.comp = listComp;
            listComp.tpComp = "01";
            listComp.vComp = "85.00";

            // BPe's taxes descriprion
            infBPe.imp = imp;
            imp.iCMS = icms;
            icms.iCMS00 = icms00;
            icms00.cST = "00";
            icms00.vBC = "85.00";
            icms00.pICMS = "10";
            icms00.vICMS = "8.50";
            icms.iCMSUFFim = iCMSUFFim;
            iCMSUFFim.vBCUFFim = "10.00";
            iCMSUFFim.pFCPUFFim = "0.85";
            iCMSUFFim.pICMSUFFim = "0.85";
            iCMSUFFim.pICMSInter = "0.85";
            iCMSUFFim.pICMSInterPart = "100";
            iCMSUFFim.vFCPUFFim = "1";
            iCMSUFFim.vICMSUFFim = "1";
            iCMSUFFim.vICMSUFIni = "1";

            // Payment method description
            infBPe.pag = pag;
            pag.tPag = "01";
            pag.vPag = "85.00";

            // Technician responsible information
            infBPe.infRespTec = infRespTec;
            infRespTec.cNPJ = "07364617000135";
            infRespTec.xContato = "Fernando";
            infRespTec.email = "fernando.konflanz@nstecnologia.com";
            infRespTec.fone = "5136921123";

            // object serialization -> to string
            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            try {
                json = mapper.writeValueAsString(bPeJSON);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            String retorno = null;

            try {
                // Function call that makes a synchronous issue
                retorno = NSSuite.emitirBPeSincrono(json, "json", "07364617000135", "X", "2", "C:/NSDOCS/BPe", false);

                // Unpacking the response
                JsonNode responseJSON = mapper.readTree(retorno);
                String statusEnvio = responseJSON.get("statusEnvio").asText();
                String statusConsulta = responseJSON.get("statusConsulta").asText();
                String statusDownload = responseJSON.get("statusDownload").asText();
                String cStat = responseJSON.get("cStat").asText();
                String chBPe = responseJSON.get("chBPe").asText();
                String nProt = responseJSON.get("nProt").asText();
                String motivo = responseJSON.get("motivo").asText();
                String nsNRec = responseJSON.get("nsNRec").asText();
                ArrayList<String> erros = mapper.readValue(responseJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});

                // simple example of error handling
                if (statusEnvio.equals("200") || statusEnvio.equals("-6")){
                    if (statusConsulta.equals("200")) {
                        if (cStat.equals("100")) {
                            JOptionPane.showMessageDialog(null, motivo);
                            if (!statusDownload.equals("200")) {
                                JOptionPane.showMessageDialog(null, "Download Error");
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
        });

        // Cancellation Example
        btnCancelBPe.addActionListener(e -> {

            CancelarReqBPe cancelarReqBPe = new CancelarReqBPe();
            cancelarReqBPe.dhEvento = "2021-04-26T09:42:00-03:00";
            cancelarReqBPe.nProt = "143210000120786";
            cancelarReqBPe.tpAmb = "2";
            cancelarReqBPe.xJust = "BPe cancelled for tests porpouses";
            cancelarReqBPe.chBPe = "43210407364617000135630060000021071463257491";

            try {
                // The cancellation process generates an BPe's Event.
                String retorno = NSSuite.cancelarDocumento("63", cancelarReqBPe);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

        });

        // BPe's Event Download Example
        btnDownloadEventBPe.addActionListener(e -> {

            DownloadEventoReqBPe downloadEventoReqBPe = new DownloadEventoReqBPe();
            downloadEventoReqBPe.nSeqEvento = "1";
            downloadEventoReqBPe.chBPe = "43210407364617000135630060000021071463257491";
            downloadEventoReqBPe.tpDown = "X";
            downloadEventoReqBPe.tpAmb = "2";
            downloadEventoReqBPe.tpEvento = "CANC";

            try {
                String retorno = NSSuite.downloadEventoESalvar("63",downloadEventoReqBPe,"C:/NSDOCS/BPe",downloadEventoReqBPe.chBPe,downloadEventoReqBPe.nSeqEvento,false);
            }
            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        // Example of how to check a BPe's situation after the issue / authorization process
        btnCheckSituationBPe.addActionListener(e -> {

            ConsSitReqBPe consSitReqBPe = new ConsSitReqBPe();
            consSitReqBPe.chBPe = "43210407364617000135630060000021071463257491";
            consSitReqBPe.licencaCNPJ = "07364617000135";
            consSitReqBPe.tpAmb = "2";

            try {
                String retorno = NSSuite.consultarSituacaoDocumento("63", consSitReqBPe);
            }
            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        // Bpe download method ( after authorization process )
        btnDownloadBPe.addActionListener(e -> {
            DownloadReqBPe downloadReqBPe = new DownloadReqBPe();
            downloadReqBPe.chBPe = "43210407364617000135630060000021071463257491";
            downloadReqBPe.tpDown = "X";
            downloadReqBPe.tpAmb = "2";

            try {
                String retorno = NSSuite.downloadDocumentoESalvar("63", downloadReqBPe,"C:/NSDOCS/BPe",downloadReqBPe.chBPe+"-BPe",false);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();
            }

        });
    };

    public static void main (String[] args) {
        JFrame frame = new JFrame("formBPe");
        frame.setContentPane(new formBPe().panelBPe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

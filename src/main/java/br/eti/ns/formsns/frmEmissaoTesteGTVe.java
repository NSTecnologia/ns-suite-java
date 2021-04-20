package br.eti.ns.formsns;

import br.eti.ns.nssuite.JSON.GTVe.GTVeJSON;
import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.requisicoes.gtve.CancelarReqGTVe;
import br.eti.ns.nssuite.requisicoes.gtve.DownloadReqGTVe;
import br.eti.ns.nssuite.requisicoes.gtve.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.util.ArrayList;

public class frmEmissaoTesteGTVe {

    private JPanel panelGTVe;
    private JButton btnEnviarGTVe;
    private JButton btnCancelarGTVe;
    private JButton btnDownEventoGTVe;
    private JButton btnConSituacaoGTVe;
    private JButton btnListarNSNrec;
    private JButton btnDownloadGTVe;

    public frmEmissaoTesteGTVe() {

        btnEnviarGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Teste de emissão - GTVe");

            // Faz a serializacao do objeto JSON que foi populado
            GTVeJSON gtVeJSON = new GTVeJSON();
            GTVeJSON.GTVe gtVe = new GTVeJSON.GTVe();
            GTVeJSON.InfCte infCte = new GTVeJSON.InfCte();
            GTVeJSON.Ide ide = new GTVeJSON.Ide();
            GTVeJSON.Toma toma = new GTVeJSON.Toma();
            GTVeJSON.TomaTerceiro tomaTerceiro = new GTVeJSON.TomaTerceiro();
            GTVeJSON.EnderToma enderToma = new GTVeJSON.EnderToma();
            GTVeJSON.Compl compl = new GTVeJSON.Compl();
            GTVeJSON.OBSCont ObsCont = new GTVeJSON.OBSCont();
            GTVeJSON.OBSFisco ObsFisco = new GTVeJSON.OBSFisco();
            GTVeJSON.Emit emit = new GTVeJSON.Emit();
            GTVeJSON.EnderEmit enderEmit = new GTVeJSON.EnderEmit();
            GTVeJSON.Rem rem = new GTVeJSON.Rem();
            GTVeJSON.EnderReme enderReme = new GTVeJSON.EnderReme();
            GTVeJSON.Dest dest = new GTVeJSON.Dest();
            GTVeJSON.EnderDest enderDest = new GTVeJSON.EnderDest();
            GTVeJSON.Origem origem = new GTVeJSON.Origem();
            GTVeJSON.Destino destino = new GTVeJSON.Destino();
            GTVeJSON.DetGTV detGTV = new GTVeJSON.DetGTV();
            GTVeJSON.InfEspecie infEspecie = new GTVeJSON.InfEspecie();
            GTVeJSON.InfVeiculo infVeiculo = new GTVeJSON.InfVeiculo();
            GTVeJSON.AutXML autXML = new GTVeJSON.AutXML();
            GTVeJSON.InfRespTec infRespTec = new GTVeJSON.InfRespTec();
            GTVeJSON.InfCTeSupl infCTeSupl = new GTVeJSON.InfCTeSupl();
            
            gtVeJSON.gtVe = gtVe;
            gtVe.versao = "3.00";

            gtVe.infCte = infCte;
            infCte.versao = "3.00";

            // Dados do Cabeçalho da GTVe
            infCte.ide = ide;
            ide.cUF = "43";
            ide.cCT = "00001050";
            ide.CFOP = "5353";
            ide.natOp = "PRESTACAO TRANSPORTE A ESTABELECIMENTO COMERCIAL";
            ide.mod = "64";
            ide.serie = "0";
            ide.nCT = "2101";
            ide.dhEmi = "2021-04-20T11:50:00-03:00";
            ide.tpImp = "1";
            ide.tpEmis = "1";
            ide.tpAmb = "2";
            ide.tpCTe = "4";
            ide.verProc = "1.00";
            ide.cMunEnv = "4303509";
            ide.xMunEnv = "CAMAQUA";
            ide.UFEnv = "RS";
            ide.modal = "01";
            ide.tpServ = "9";
            ide.indIEToma = "1";
            ide.dhSaidaOrig = "2021-04-20T08:00:00-03:00";
            ide.dhChegadaDest = "2021-04-20T09:00:00-03:00";

            // Dados do Tomador
            ide.toma = toma;
            toma.toma = "0";

            // Dados do Emitente
            infCte.emit = emit;
            emit.CNPJ = "07364617000135";
            emit.IE = "0170108708";
            emit.xNome = "NEWS SYSTEM LTDA";
            emit.enderEmit = enderEmit;
            enderEmit.xLgr = "RUA TURMALINA";
            enderEmit.nro = "34";
            enderEmit.xBairro = "PRADO";
            enderEmit.cMun = "4303509";
            enderEmit.xMun = "CAMAQUA";
            enderEmit.UF = "RS";

            // Dados do Remetente
            infCte.rem = rem;
            rem.CNPJ = "07364617000135";
            rem.IE = "0170108708";
            rem.xNome = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            rem.enderReme = enderReme;
            enderReme.xLgr = "RUA TURMALINA";
            enderReme.nro = "34";
            enderReme.xBairro = "PRADO";
            enderReme.cMun = "4303509";
            enderReme.xMun = "CAMAQUA";
            enderReme.UF = "RS";

            // Dados do Remetente
            infCte.dest = dest;
            dest.CNPJ = "07364617000135";
            dest.IE = "0170108708";
            dest.xNome = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            dest.enderDest = enderDest;
            enderDest.xLgr = "FAZENDA";
            enderDest.nro = "SN";
            enderDest.xBairro = "ZONA RURAL";
            enderDest.cMun = "4303509";
            enderDest.xMun = "CAMAQUA";
            enderDest.UF = "RS";

            // Dados detalhados da GTVe
            infCte.detGTV = detGTV;
            detGTV.infEspecie = infEspecie;
            infEspecie.tpEspecie = "1";
            infEspecie.vEspecie = "150000.00";
            infEspecie.tpNumerario = "1";
            detGTV.qCarga = "15.0000";

            // Dados do veiculo
            detGTV.infVeiculo = infVeiculo;
            infVeiculo.placa = "ANS9H78";
            infVeiculo.UF = "RS";

            ObjectMapper mapper = new ObjectMapper();
            String json = "";

            try {
                json = mapper.writeValueAsString(gtVeJSON);
            } 
            catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            System.out.println(json);
            String retorno = null;

            try {
                retorno = NSSuite.emitirGTVeSincrono(json, "json", "07364617000135", "X", "2", "C:/Notas/GTVe", false);
                JsonNode respostaJSON = mapper.readTree(retorno);
                String statusEnvio = respostaJSON.get("statusEnvio").asText();
                String statusConsulta = respostaJSON.get("statusConsulta").asText();
                String statusDownload = respostaJSON.get("statusDownload").asText();
                String cStat = respostaJSON.get("cStat").asText();
                String chCTe = respostaJSON.get("chCTe").asText();
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

            JOptionPane.showMessageDialog(null, retorno);
            System.out.println(retorno);

        });

        btnCancelarGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Cancelamento - GTVe");

            CancelarReqGTVe cancelarReqGTVe = new CancelarReqGTVe();
            cancelarReqGTVe.dhEvento = "2021-04-14T11:23:00-03:00";
            cancelarReqGTVe.nProt = "143210000248200";
            cancelarReqGTVe.tpAmb = "2";
            cancelarReqGTVe.xJust = "Cancelamento de GTVe para fins de teste em homologação";
            cancelarReqGTVe.chCTe = "43210407364617000135640000000021011000010507";

            try {
                String retorno = NSSuite.cancelarDocumento("66", cancelarReqGTVe);
                JOptionPane.showMessageDialog(null, retorno);
                System.out.println(retorno);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btnDownEventoGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Download de Evento - GTVe");

            DownloadEventoReqGTVe downloadEventoReqGTVe = new DownloadEventoReqGTVe();
            downloadEventoReqGTVe.nSeqEvento = "1";
            downloadEventoReqGTVe.chCTe = "43210407364617000135640000000021011000010507";
            downloadEventoReqGTVe.tpDown = "X";
            downloadEventoReqGTVe.tpAmb = "2";
            downloadEventoReqGTVe.tpEvento = "CANC";

            try {
                String retorno = NSSuite.downloadEventoESalvar("64",downloadEventoReqGTVe,"C:/Notas/GTVe",downloadEventoReqGTVe.chCTe,downloadEventoReqGTVe.nSeqEvento,false);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        btnConSituacaoGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Consulta Situação - GTVe");
            ConsSitReqGTVe consSitReqGTVe = new ConsSitReqGTVe();
            consSitReqGTVe.chCTe = "43210407364617000135640000000021011000010507";
            consSitReqGTVe.licencaCNPJ = "07364617000135";
            consSitReqGTVe.tpAmb = "2";


            try {
                String retorno = NSSuite.consultarSituacaoDocumento("64", consSitReqGTVe);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        btnListarNSNrec.addActionListener(e -> { 
            
            JOptionPane.showMessageDialog(null, "Listagem de nsNRec - GTVe");

            ListarNSNRecReqGTVe listarNSNRecReqGTVe = new ListarNSNRecReqGTVe();
            listarNSNRecReqGTVe.chCTe = "43210407364617000135640000000021011000010507";
            listarNSNRecReqGTVe.tpAmb = "2";

            try {
                String retorno = NSSuite.listarNSNRecs("64", listarNSNRecReqGTVe);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });

        btnDownloadGTVe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,"Download - GTVe");

            DownloadReqGTVe downloadReqGTVe = new DownloadReqGTVe();
            downloadReqGTVe.chCTe = "43210407364617000135640000000021011000010507";
            downloadReqGTVe.tpDown = "X";
            downloadReqGTVe.tpAmb = "2";

            try {
                String retorno = NSSuite.downloadDocumentoESalvar("64", downloadReqGTVe, "C:/Notas/GTVe", downloadReqGTVe.chCTe + "-GTVe", false);
                System.out.println(retorno);
            }

            catch (Exception exception) {
                exception.printStackTrace();

            }

        });
    };
    public static void main (String[] args) {
        JFrame frame = new JFrame("frmEmissaoTesteGTVe");
        frame.setContentPane(new frmEmissaoTesteGTVe().panelGTVe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

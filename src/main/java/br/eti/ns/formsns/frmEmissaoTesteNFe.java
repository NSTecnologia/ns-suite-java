package br.eti.ns.formsns;

import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON.*;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON.InfNFe;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;
import java.util.ArrayList;

public class frmEmissaoTesteNFe {

    private JPanel panelNFe;
    private JButton btnEnviarNFe;
    private JButton btnCancelarNFe;
    private JButton btnConSituaçãoNFe;
    private JButton btnDownEventoNFe;

    public frmEmissaoTesteNFe() {

        // Métodos específos da NFe
        btnEnviarNFe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Teste de emissão - NFe");

            NFeJSON nFeJSON = new NFeJSON();
            NFe nfe = new NFe();
            InfNFe infNFe = new InfNFe();
            NFeJSON.Ide ide = new NFeJSON.Ide();
            NFeJSON.Emit emit = new NFeJSON.Emit();
            NFeJSON.EnderEmit enderEmit = new NFeJSON.EnderEmit();
            NFeJSON.Dest dest = new NFeJSON.Dest();
            NFeJSON.EnderDest enderDest = new NFeJSON.EnderDest();
            NFeJSON.Det det = new NFeJSON.Det();
            ArrayList<NF3eJSON.Det> listDet = new ArrayList<NF3eJSON.Det>();
            Prod prod = new Prod();
            NFeJSON.Imposto imposto = new NFeJSON.Imposto();
            NFeJSON.ICMS iCMS = new NFeJSON.ICMS();
            ICMSSN102 iCMSSN102 = new ICMSSN102();
            IPI iPI = new IPI();
            IPINT iPINT = new IPINT();
            PIS pIS = new PIS();
            PISAliq pISAliq = new PISAliq();
            COFINS cOFINS = new COFINS();
            COFINSAliq cOFINSAliq = new COFINSAliq();
            NFeJSON.Total total = new NFeJSON.Total();
            NFeJSON.ICMSTot iCMSTot = new NFeJSON.ICMSTot();
            Transp transp = new Transp();
            Transporta transporta = new Transporta();
            Vol vol = new Vol();
            ArrayList<Vol> listVol = new ArrayList<>();
            Pag pag = new Pag();
            NFeJSON.InfIntermed infIntermed = new NFeJSON.InfIntermed();
            DetPag detPag = new DetPag();
            ArrayList<DetPag> listdetPag = new ArrayList<>();
            NFeJSON.InfAdic infAdic = new NFeJSON.InfAdic();

            nFeJSON.nFe = nfe;
            nfe.infNFe = infNFe;
            infNFe.versao = "4.00";
            infNFe.ide = ide;
            ide.cUF = "43";
            ide.natOp = "VENDA A PRAZO - S";
            ide.mod = "55";
            ide.serie = "0";
            ide.nNF = "21252";
            ide.dhEmi = "2021-03-10T09:51:00-03:00";
            ide.tpNF = "1";
            ide.idDest = "1";
            ide.cMunFG = "4305108";
            ide.tpImp = "1";
            ide.tpEmis = "1";
            ide.cDV = "6";
            ide.tpAmb = "2";
            ide.finNFe = "1";
            ide.indFinal = "0";
            ide.indPres = "1";
            ide.indIntermed = "";
            ide.procEmi = "0";
            ide.verProc = "4.00";
            infNFe.emit = emit;
            emit.cNPJ = "11111111111111";
            emit.xNome = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGAÇÃO - SEM VALOR FISCAL";
            emit.iE = "11111111111";
            emit.cRT = "1";
            emit.enderEmit = enderEmit;
            enderEmit.xLgr = "Rua Bento Osvaldo Triisch, 777";
            enderEmit.nro = ".";
            enderEmit.xCpl = "CX POSTAL 91";
            enderEmit.xBairro = "Pendancino";
            enderEmit.xMun = "Caxias do Sul";
            enderEmit.cMun = "4303509";
            enderEmit.uF = "RS";
            enderEmit.cEP = "95046600";
            enderEmit.fone = "005432200200";
            infNFe.dest = dest;
            dest.cNPJ = "11111111111111";
            dest.xNome = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            dest.indIEDest = "1";
            dest.iE = "11111111111";
            dest.email = "email@email.com.br";
            dest.enderDest = enderDest;
            enderDest.xLgr = "AV ANTONIO DURO";
            enderDest.nro = "0";
            enderDest.xBairro = "OLARIA";
            enderDest.cMun = "4303509";
            enderDest.xMun = "CAMAQUA";
            enderDest.uF = "RS";
            enderDest.cEP = "96180000";
            enderDest.cPais = "1058";
            enderDest.xPais = "Brasil";

            infNFe.det = listDet;
            listDet.addAll(listDet);
            det.nItem = "1";
            det.prod = prod;
            prod.cEAN = "SEM GTIN";
            prod.cEANTrib = "SEM GTIN";
            prod.cProd = "1223456789";
            prod.xProd = "COCA-COLA LT 250ML";
            prod.nCM = "22021000";
            prod.cEST = "0301100";
            prod.cFOP = "5101";
            prod.uCom = "UN";
            prod.qCom = "1.0000";
            prod.vUnCom = "3.00";
            prod.vProd = "3.00";
            prod.uTrib = "UN";
            prod.qTrib = "1.0000";
            prod.vUnTrib = "3.00";
            prod.indTot = "1";
            prod.nItemPed = "0";

            det.imposto = imposto;
            imposto.iCMS = iCMS;
            iCMS.iCMSSN102 = iCMSSN102;
            iCMSSN102.orig = "0";
            iCMSSN102.cSOSN = "102";
            imposto.iPI = iPI;
            iPI.cEnq = "999";
            iPI.iPINT = iPINT;
            iPINT.cST = "53";
            imposto.pIS = pIS;
            pIS.pISAliq = pISAliq;
            pISAliq.cST = "01";
            pISAliq.vBC = "3.00";
            pISAliq.pPIS = "1.65";
            pISAliq.vPIS = "0.05";
            imposto.cOFINS = cOFINS;
            cOFINS.cOFINSAliq = cOFINSAliq;
            cOFINSAliq.cST = "01";
            cOFINSAliq.vBC = "3.00";
            cOFINSAliq.pCOFINS = "7.00";
            cOFINSAliq.vCOFINS = "0.21";
            infNFe.total = total;
            total.iCMSTot = iCMSTot;
            iCMSTot.vBC = "0";
            iCMSTot.vICMS = "0";
            iCMSTot.vICMSDeson = "0";
            iCMSTot.vFCPUFDest = "0.00";
            iCMSTot.vICMSUFRemet = "0.00";
            iCMSTot.vFCP = "0";
            iCMSTot.vBCST = "0";
            iCMSTot.vST = "0";
            iCMSTot.vFCPST = "0";
            iCMSTot.vFCPSTRet = "0.00";
            iCMSTot.vProd = "3.00";
            iCMSTot.vFrete = "0.00";
            iCMSTot.vSeg = "0.00";
            iCMSTot.vDesc = "0.00";
            iCMSTot.vII = "0.00";
            iCMSTot.vIPI = "0.00";
            iCMSTot.vIPIDevol = "0.00";
            iCMSTot.vPIS = "0.05";
            iCMSTot.vCOFINS = "0.21";
            iCMSTot.vOutro = "0.00";
            iCMSTot.vNF = "3.00";
            iCMSTot.vTotTrib = "0.00";
            infNFe.transp = transp;
            transp.modFrete = "0";
            transp.transporta = transporta;
            transporta.cNPJ = "11111111111111";
            transporta.xNome = "TRANSPORTADORA TESTE";
            transporta.iE = "0170108708";
            transporta.xEnder = "ESTR BENTO OSVALDO TRISCH 777";
            transporta.xMun = "CAXIAS DO SUL";
            transporta.uF = "RS";
            transp.vol = listVol;
            listVol.add(vol);
            vol.qVol = "0";
            vol.marca = "TESTE";
            vol.nVol = "0";
            vol.pesoL = "0.000";
            vol.pesoB = "0.000";

            infNFe.pag = pag;
            pag.detPag = listdetPag;
            listdetPag.add(detPag);
            detPag.tPag = "01";
            detPag.vPag = "5.00";
            pag.vTroco = "2.00";

            infNFe.infIntermed = infIntermed;
            infIntermed.cNPJ = "11111111111111";
            infIntermed.idCadIntTran = "IDENTIFICACAO DO INTERMEDIADOR";

            infNFe.infAdic = infAdic;
            infAdic.infCpl = "DESCONTO PIS 0,01 COFINS 0,06 LEI 11.196 DE 21/11/2005";

            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            try {
                json = mapper.writeValueAsString(nFeJSON);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            System.out.println(json);
            String retorno = null;
            try {
                retorno = NSSuite.emitirNFeSincrono(json, "json", "07364617000135", "XP", "2", "./Notas", true);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, retorno);
            System.out.println(retorno);

        });
        btnCancelarNFe.addActionListener(e ->{});
        btnDownEventoNFe.addActionListener(e -> {});

    };
    public static void main (String[] args) {
        JFrame frame = new JFrame("frmEmissaoTeste");
        frame.setContentPane(new frmEmissaoTesteNFe().panelNFe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
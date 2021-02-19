package br.eti.ns.formsns;

import br.eti.ns.nssuite.JSON.NFe.NFeJSON;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON.*;
import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.JSON.CTe.CTeJSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;

import java.util.ArrayList;

public class frmemissaoTeste {

    private JButton btnEnviarNFe;
    private JPanel panelMain;
    private JButton btnEnviarCTe;

    public frmemissaoTeste() {

        btnEnviarNFe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Teste de emissão - NFe");

            NFeJSON nFeJSON = new NFeJSON();
            NFe nfe = new NFe();
            InfNFe infNFe = new InfNFe();
            Ide ide = new Ide();
            Emit emit = new Emit();
            EnderEmit enderEmit = new EnderEmit();
            Dest dest = new Dest();
            EnderDest enderDest = new EnderDest();
            Det det = new Det();
            ArrayList<Det> listDet = new ArrayList<>();
            Prod prod = new Prod();
            Imposto imposto = new Imposto();
            ICMS iCMS = new ICMS();
            ICMSSN102 iCMSSN102 = new ICMSSN102();
            IPI iPI = new IPI();
            IPINT iPINT = new IPINT();
            PIS pIS = new PIS();
            PISAliq pISAliq = new PISAliq();
            COFINS cOFINS = new COFINS();
            COFINSAliq cOFINSAliq = new COFINSAliq();
            Total total = new Total();
            ICMSTot iCMSTot = new ICMSTot();
            Transp transp = new Transp();
            Transporta transporta = new Transporta();
            Vol vol = new Vol();
            ArrayList<Vol> listVol = new ArrayList<>();
            Pag pag = new Pag();
            DetPag detPag = new DetPag();
            ArrayList<DetPag> listdetPag = new ArrayList<>();
            InfAdic infAdic = new InfAdic();

            nFeJSON.nFe = nfe;
            nfe.infNFe = infNFe;
            infNFe.versao = "4.00";
            infNFe.ide = ide;
            ide.cUF = "43";
            ide.natOp = "VENDA A PRAZO - S";
            ide.mod = "55";
            ide.serie = "0";
            ide.nNF = "21252";
            ide.dhEmi = "2021-02-19T15:33:00-03:00";
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
            ide.procEmi = "0";
            ide.verProc = "4.00";
            infNFe.emit = emit;
            emit.cNPJ = "07364617000135";
            emit.xNome = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGAÇÃO - SEM VALOR FISCAL";
            emit.iE = "0170108708";
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
            dest.cNPJ = "07364617000135";
            dest.xNome = "NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            dest.indIEDest = "1";
            dest.iE = "0170108708";
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
            listDet.add(det);
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
            transporta.cNPJ = "07364617000135";
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
        btnEnviarCTe.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Teste de emissão - CTe");
            
            CTeJSON cteJSON = new CTeJSON();
            CTeJSON.CTe cte = new CTeJSON.CTe();
            CTeJSON.InfCte infCte = new CTeJSON.InfCte();
            CTeJSON.Ide ide = new CTeJSON.Ide();
            CTeJSON.Toma3 toma3 = new CTeJSON.Toma3();
            CTeJSON.Compl compl = new CTeJSON.Compl();
            CTeJSON.ObsCont obsCont = new CTeJSON.ObsCont();
            CTeJSON.Emit emit = new CTeJSON.Emit();
            CTeJSON.EnderEmit enderEmit = new CTeJSON.EnderEmit();
            CTeJSON.Rem rem = new CTeJSON.Rem();
            CTeJSON.EnderReme enderReme = new CTeJSON.EnderReme();
            CTeJSON.Dest dest = new CTeJSON.Dest();
            CTeJSON.EnderDest enderDest = new CTeJSON.EnderDest();
            CTeJSON.VPrest vPrest = new CTeJSON.VPrest();
            CTeJSON.Comp comp = new CTeJSON.Comp();
            ArrayList<CTeJSON.Comp> listComp = new ArrayList<>();
            CTeJSON.Imp imp = new CTeJSON.Imp();
            CTeJSON.ICMS iCMS = new CTeJSON.ICMS();
            CTeJSON.ICMSSN iCMSSN = new CTeJSON.ICMSSN();
            CTeJSON.InfCTeNorm infCTeNorm = new CTeJSON.InfCTeNorm();
            CTeJSON.InfCarga infCarga = new CTeJSON.InfCarga();
            ArrayList<CTeJSON.InfQ> listInfQ = new ArrayList<>();
            CTeJSON.InfQ infQ = new CTeJSON.InfQ();
            CTeJSON.InfDoc infDoc = new CTeJSON.InfDoc();
            ArrayList<CTeJSON.InfNFe> listInfNFe = new ArrayList<>();
            CTeJSON.InfNFe infNFe = new CTeJSON.InfNFe();
            CTeJSON.InfRespTec infRespTec = new CTeJSON.InfRespTec();
            CTeJSON.InfModal infModal = new CTeJSON.InfModal();
            CTeJSON.Rodo rodo = new CTeJSON.Rodo();
            cteJSON.cTe = cte;
            cte.infCte = infCte;
            infCte.versao = "3.00";
            infCte.ide = ide;
            ide.cUF = "43";
            // Gerar numero randomico
            ide.cCT = "00002111";
            ide.cFOP = "5932";
            ide.natOp = "SERVICO DE TRANSPORTE";
            ide.mod = "57";
            ide.serie = "0";
            ide.nCT = "2113";
            ide.dhEmi = "2021-02-19T09:51:05-03:00";
            ide.tpImp = "1";
            ide.tpEmis = "1";
            ide.cDV = "4";
            // Mudar quando for emitir em producao
            ide.tpAmb = "2";
            ide.tpCTe = "0";
            ide.procEmi = "0";
            // dado padrão
            ide.verProc = "3.00";
            ide.cMunEnv = "4303509";
            ide.xMunEnv = "CAMAQUA";
            ide.uFEnv = "RS";
            ide.modal = "01";
            ide.tpServ = "0";
            ide.cMunIni = "4303509";
            ide.xMunIni = "CAMAQUA";
            ide.uFIni = "RS";
            ide.cMunFim = "4303509";
            ide.xMunFim = "CAMAQUA";
            ide.uFFim = "RS";
            ide.retira = "1";
            ide.indIEToma = "1";
            ide.toma3 = toma3;
            toma3.toma = "3";
            infCte.compl = compl;
            compl.obsCont = compl.obsCont;
            obsCont.xTexto = "luciano.languer@nstecnologia.com.br";
            obsCont.xCampo = "enviaEmail";
            infCte.emit = emit;
            emit.cNPJ = "11111111111111";
            emit.iE = "1111111111";
            emit.xNome = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            emit.xFant = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO";
            emit.enderEmit = enderEmit;
            enderEmit.xLgr = "Rua Bento Osvaldo Triisch, 777";
            enderEmit.nro = ".";
            enderEmit.xCpl = "CX POSTAL 91";
            enderEmit.xBairro = "Pendancino";
            enderEmit.cMun = "4308607";
            enderEmit.xMun = "Caxias do Sul";
            enderEmit.cEP = "95046600";
            enderEmit.uF = "RS";
            enderEmit.fone = "005432200200";
            infCte.rem = rem;
            rem.cPF = "11111111111";
            rem.xNome = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            rem.xFant = "Joaozinho da Silva";
            rem.enderReme = enderReme;
            rem.fone = "5136715390";
            rem.email = "max.ferrazrs@hotmail.com";
            enderReme.xLgr = "Estrada General Motors";
            enderReme.nro = "852";
            enderReme.xCpl = "CX POSTAL 91";
            enderReme.xBairro = "B. Caldeira";
            enderReme.cMun = "3520509";
            enderReme.xMun = "Indaiatuba";
            enderReme.cEP = "13347500";
            enderReme.uF = "SP";
            enderReme.cPais = "1058";
            enderReme.xPais = "Brasil";
            infCte.dest = dest;
            dest.cNPJ = "11111111111111";
            dest.xNome = "CT-E EMITIDO EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL";
            dest.iE = "1111111111";
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
            infCte.vPrest = vPrest;
            vPrest.vTPrest = "440.00";
            vPrest.vRec = "440.00";
            vPrest.comp = listComp;
            listComp.addAll(listComp);
            comp.xNome = "Valor da Viagem";
            comp.vComp = "396.00";
            comp.xNome = "Valor do Seguro";
            comp.vComp = "44.00";
            // Varia conforme o tipo de ICMS
            infCte.imp = imp;
            imp.iCMS = iCMS;
            iCMS.iCMSSN = iCMSSN;
            iCMSSN.cST = "90";
            iCMSSN.indSN = "1";
            infCte.infCTeNorm = infCTeNorm;
            infCTeNorm.infCarga = infCarga;
            infCarga.vCarga = "22000.00";
            infCarga.proPred = "Maquina rebitadeira";
            infCarga.vCargaAverb = "22000.00";
            infCarga.infQ = listInfQ;
            listInfQ.add(infQ);
            infQ.cUnid = "01";
            infQ.tpMed = "Peso Bruto";
            infQ.qCarga = "380.0000";
            infCTeNorm.infDoc = infDoc;
            infDoc.infNFe = listInfNFe;
            listInfNFe.add(infNFe);
            infNFe.chave = "35171108733713000761550010000109471432652222";
            // dados padroes
            infCte.infRespTec = infRespTec;
            infRespTec.cnpj = "11111111111111";
            infRespTec.xContato = "Luciano";
            infRespTec.email = "luciano.languer@nstecnologia.com.br";
            infRespTec.fone = "5136921123";
            // dados padroes
            cteJSON.infModal = infModal;
            infModal.versaoModal = "3.00";
            infModal.rodo = rodo;
            rodo.xmlns = "http://www.portalfiscal.inf.br/cte";
            rodo.rNTRC = "04023389";

            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            try {
                json = mapper.writeValueAsString(cteJSON);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            // System.out.println(json);
            String tpConteudo = "json";
            String modelo = "57";
            String cnpjEmit = "07364617000135";
            String tpDown = "XP";
            String tpAmb = "2";
            String caminho = "./notas";
            Boolean exibeNaTela = true;
            String retorno = null;
            try {
                retorno = NSSuite.emitirCTeSincrono(json, modelo, tpConteudo, cnpjEmit, tpDown, tpAmb, caminho,
                        exibeNaTela);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, retorno);

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmEmissaoTeste");
        frame.setContentPane(new frmemissaoTeste().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public NFeJSON MontarJson() {
        return new NFeJSON() {

        };

    }

}

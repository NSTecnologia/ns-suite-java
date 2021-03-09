package br.eti.ns.formsns;

import br.eti.ns.nssuite.NSSuite;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON.*;
import br.eti.ns.nssuite.JSON.NFe.NFeJSON.InfNFe;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.*;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Dest;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Emit;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.EnderDest;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.EnderEmit;
import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON.Ide;
import br.eti.ns.nssuite.JSON.CTe.CTeJSON;
import br.eti.ns.nssuite.JSON.CTe.CTeJSON.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;

import java.util.ArrayList;

public class frmemissaoTeste {

    private JButton btnEnviarNFe;
    private JPanel panelMain;
    private JButton btnEnviarCTe;
    private JButton btnEnviarNF3e;

    public frmemissaoTeste() {

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
            CTe cte = new CTe();
            InfCte infCte = new InfCte();
            CTeJSON.Ide ide = new CTeJSON.Ide();
            Toma3 toma3 = new Toma3();
            Compl compl = new Compl();
            CTeJSON.ObsCont obsCont = new CTeJSON.ObsCont();
            CTeJSON.Emit emit = new CTeJSON.Emit();
            CTeJSON.EnderEmit enderEmit = new CTeJSON.EnderEmit();
            Rem rem = new Rem();
            EnderReme enderReme = new EnderReme();
            CTeJSON.Dest dest = new CTeJSON.Dest();
            CTeJSON.EnderDest enderDest = new CTeJSON.EnderDest();
            VPrest vPrest = new VPrest();
            Comp comp = new Comp();
            ArrayList<Comp> listComp = new ArrayList<>();
            Imp imp = new Imp();
            CTeJSON.ICMS iCMS = new CTeJSON.ICMS();
            ICMSSN iCMSSN = new ICMSSN();
            InfCTeNorm infCTeNorm = new InfCTeNorm();
            InfCarga infCarga = new InfCarga();
            ArrayList<InfQ> listInfQ = new ArrayList<>();
            InfQ infQ = new InfQ();
            InfDoc infDoc = new InfDoc();
            ArrayList<CTeJSON.InfNFe> listInfNFe = new ArrayList<>();
            CTeJSON.InfNFe infNFe = new CTeJSON.InfNFe();
            InfRespTec infRespTec = new InfRespTec();
            InfModal infModal = new InfModal();
            Rodo rodo = new Rodo();
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
        btnEnviarNF3e.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "Teste de emissão - NF3e");

            NF3eJSON nF3eJSON = new NF3eJSON();
            NF3e nF3e = new NF3e();
            InfNF3e infNF3e = new InfNF3e();
            Ide ide = new Ide();
            Emit emit = new Emit();
            EnderEmit enderEmit = new EnderEmit();
            Dest dest = new Dest();
            EnderDest enderDest = new EnderDest();
            Acessante acessante = new Acessante();
            NFDet NFdet = new NFDet();
            ArrayList<NF3eJSON.Det> listdet = new ArrayList<NF3eJSON.Det>();
            NF3eJSON.Det det = new NF3eJSON.Det();
            DetItem detItem = new DetItem();
            GTarif gTarif = new GTarif();
            GAdBand gAdBand = new GAdBand();
            prod prod = new prod();
            NF3eJSON.Imposto imposto = new NF3eJSON.Imposto();
            NF3eJSON.ICMS90 iCMS90 = new NF3eJSON.ICMS90();
            pIS PIS = new pIS();
            cOFINS COFINS = new cOFINS();
            NF3eJSON.Total total = new NF3eJSON.Total();
            NF3eJSON.ICMSTot ICMSTot = new NF3eJSON.ICMSTot();
            GFat gFat = new GFat();
            EnderCorresp enderCorresp = new EnderCorresp();
            GANEEL gANEEL = new GANEEL();
            NF3eJSON.GHistFat gHistFat = new NF3eJSON.GHistFat();
            NF3eJSON.GGrandFat gGrandFat = new NF3eJSON.GGrandFat();
            ArrayList<GGrandFat> listgGrandFat = new ArrayList<GGrandFat>();
            NF3eJSON.AutXML autXML = new NF3eJSON.AutXML();
            ArrayList<NF3eJSON.AutXML> listautXML = new ArrayList<NF3eJSON.AutXML>();
            NF3eJSON.InfAdic infAdic = new NF3eJSON.InfAdic();
            GRespTec gRespTec = new GRespTec();

            nF3eJSON.nF3e = nF3e;
            nF3e.infNF3e = infNF3e;
            infNF3e.versao = "1.00";

            infNF3e.ide = ide;
            ide.cUF = "43";
            ide.tpAmb = "2";
            ide.mod = "66";
            ide.serie = "0";
            ide.nNF = "21";
            ide.cNF = "00000001";
            ide.cDV = "";
            ide.dhEmi = "2021-03-09T18:29:33-03:00";
            ide.tpEmis = "1";
            ide.cMunFG = "4303509";
            ide.finNF3e = "1";
            ide.verProc = "1.0.0";

            infNF3e.emit = emit;
            emit.cNPJ = "CNPJ DO EMITENTE";
            emit.iE = "IE DO EMITENTE";
            emit.xNome = "News Systems Ltda";
            emit.xFant = "TESTE DE EMISSAO";
            emit.enderEmit = enderEmit;
            enderEmit.xLgr = "Av. Antonio Duro";
            enderEmit.nro = "870";
            enderEmit.xBairro = "Centro";
            enderEmit.cMun = "4303509";
            enderEmit.xMun = "Camaqua";
            enderEmit.cEP = "96785200";
            enderEmit.uF = "RS";
            enderEmit.fone = "5136712053";
            enderEmit.email = "email@email.com.br";

            infNF3e.dest = dest;
            dest.xNome = "Teste de Emissão da Silva";
            dest.cPF = "00269925074";
            dest.indIEDest = "9";
            dest.enderDest = enderDest;
            enderDest.xLgr = "Av. Anthero Salustiano Silveira";
            enderDest.nro = "510";
            enderDest.nro = "510";
            enderDest.xBairro = "Olaria";
            enderDest.cMun = "4303509";
            enderDest.xMun = "Camaqua";
            enderDest.cEP = "96785200";
            enderDest.uF = "RS";
            enderDest.fone = "51999999999";
            enderDest.email = "fernando.konflanz@nstecnologia.com.br";

            infNF3e.acessante = acessante;
            acessante.idAcesso = "43037003";
            acessante.tpAcesso = "0";
            acessante.tpFase = "3";
            acessante.tpGrpTensao = "01";
            acessante.tpModTar = "03";
            acessante.latGPS = "38.736946";
            acessante.longGPS = "9.142685";

            infNF3e.NFdet = NFdet;
            NFdet.det = det;
            det.add(det);
            det.nItem = "1";
            det.detItem = detItem;
            detItem.gTarif = gTarif;
            gTarif.dIniTarif = "2020-07-27";
            gTarif.dFimTarif = "2020-07-28";
            gTarif.tpAto = "1";
            gTarif.nAto = "1234";
            gTarif.anoAto = "1234";
            gTarif.tpTarif = "1";
            gTarif.cPosTarif = "0";
            gTarif.uMed = "1";
            gTarif.vTarifHom = "3.00000000";
            gTarif.vTarifAplic = "3.00000000";
            gTarif.motDifTarif = "03";

            detItem.gAdBand = gAdBand;
            gAdBand.dIniAdBand = "2019-11-27";
            gAdBand.dFimAdBand = "2019-11-27";
            gAdBand.tpBand = "1";
            gAdBand.vAdBand = "3.50";
            gAdBand.vAdBandAplic = "3000.80";
            gAdBand.motDifBand = "03";

            detItem.prod = prod;
            prod.indOrigemQtd = "1";
            prod.cProd = "5555555";
            prod.xProd = "Consumo de Teste";
            prod.cClass = "0601000";
            prod.cFOP = "5258";
            prod.uMed = "2";
            prod.qFaturada = "10";
            prod.vItem = "3.00000000";
            prod.vProd = "30.00000000";

            detItem.imposto = imposto;
            imposto.iCMS90 = iCMS90;
            iCMS90.cST = "90";
            iCMS90.vBC = "30.00";
            iCMS90.pICMS = "18.00";
            iCMS90.vICMS = "5.40";

            imposto.PIS = PIS;
            PIS.cST = "01";
            PIS.vBC = "30.00";
            PIS.pPIS = "1.650";
            PIS.vPIS = "0.49";

            imposto.COFINS = COFINS;
            COFINS.cST = "01";
            COFINS.vBC = "30.00";
            COFINS.pCOFINS = "7.6000";
            COFINS.vCOFINS = "2.28";

            infNF3e.total = total;
            total.vProd = "30.00";
            total.vCOFINS = "2.28";
            total.vPIS = "0.49";
            total.vNF = "30.00";
            total.iCMSTot = ICMSTot;
            ICMSTot.vBC = "30.00";
            ICMSTot.vICMS = "5.40";
            ICMSTot.vICMSDeson = "0.00";
            ICMSTot.vFCP = "0.00";
            ICMSTot.vBCST = "0.00";
            ICMSTot.vST = "0.00";
            ICMSTot.vFCPST = "0.00";

            infNF3e.gFat = gFat;
            gFat.CompetFat = "201911";
            gFat.dVencFat = "2019-11-27";
            gFat.dApresFat = "2019-11-27";
            gFat.dProxLeitura = "2019-12-27";
            gFat.nFat = "123456";
            gFat.codBarras = "12345678";
            gFat.codDebAuto = "12345678";
            gFat.enderCorresp = enderCorresp;
            enderCorresp.xLgr = "Av. Anthero Salustiano Silveira";
            enderCorresp.nro = "510";
            enderCorresp.xBairro = "Olaria";
            enderCorresp.cMun = "4303509";
            enderCorresp.xMun = "Camaqua";
            enderCorresp.cEP = "96785200";
            enderCorresp.uF = "RS";
            enderCorresp.fone = "51999999999";
            enderCorresp.email = "fernando.konflanz@nstecnologia.com.br";

            infNF3e.gANEEL = gANEEL;
            gANEEL.gHistFat = gHistFat;
            gHistFat.xGrandFat = "Consumo Meses Anteriores";
            gHistFat.gGrandFat = gGrandFat;
            gGrandFat.add(gGrandFat);
            gGrandFat.CompetFat = "201911";
            gGrandFat.vFat = "30.00";
            gGrandFat.uMed = "2";
            gGrandFat.qtdDias = "10";

            infNF3e.autXML = autXML;
            autXML.add(autXML);
            autXML.cNPJ = "07364617000135";

            infNF3e.infAdic = infAdic;
            infAdic.infAdFisco = "Dados de interesse do fiscal";
            infAdic.infCpl = "Observacoes, emissao de teste da NS";

            infNF3e.gRespTec = gRespTec;
            gRespTec.cNPJ = "07364617000135";
            gRespTec.xContato = "Fernando Konflanz";
            gRespTec.email = "fernando.konflanz@nstecnologia.com.br";
            gRespTec.fone = "51996359538";

            ObjectMapper mapper = new ObjectMapper();
            String json = "";
            try {
                json = mapper.writeValueAsString(nF3eJSON);
            } catch (JsonProcessingException jsonProcessingException) {
                jsonProcessingException.printStackTrace();
            }

            System.out.println(json);
            String retorno = null;
            try {
                retorno = NSSuite.emitirNF3eSincrono(json, "json", "07364617000135", "XP", "2", "./Notas", false);
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            JOptionPane.showMessageDialog(null, retorno);
            System.out.println(retorno);

        });
    }
    public static void main (String[] args) {
        JFrame frame = new JFrame("frmEmissaoTeste");
        frame.setContentPane(new frmemissaoTeste().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

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
import br.eti.ns.nssuite.requisicoes._genericos.CancelarReq;
import br.eti.ns.nssuite.requisicoes.nf3e.CancelarReqNF3e;
import br.eti.ns.nssuite.requisicoes.nf3e.ConsSitReqNF3e;
import br.eti.ns.nssuite.requisicoes.nf3e.DownloadEventoReqNF3e;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmEmissaoTesteCTe {

    private JPanel panelCTe;
    private JButton btnEnviarCTe;
    private JButton btnCancelarCTe;
    private JButton btnDownEventoCTe;
    private JButton btnConSituaçãoCTe;

    public frmEmissaoTesteCTe() {

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
            String cnpjEmit = "11111111111111";
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
        btnCancelarCTe.addActionListener(e ->{});
        btnDownEventoCTe.addActionListener(e -> {});

    };
    public static void main (String[] args) {
        JFrame frame = new JFrame("frmEmissaoTeste");
        frame.setContentPane(new frmEmissaoTesteCTe().panelCTe);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
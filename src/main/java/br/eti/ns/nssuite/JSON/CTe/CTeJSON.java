package br.eti.ns.nssuite.JSON.CTe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CTeJSON {

    @JsonProperty("CTe")
    public CTe CTe;
    public InfModal infModal;


    public static class Toma3 {
        public String toma;
    }

    public static class EnderToma {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String cEP;
        @JsonProperty("UF")
        public String uF;
        public String cPais;
        public String xPais;
    }

    public static class Toma4 {
        public String toma;
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("IE")
        public String iE;
        public String xNome;
        public String xFant;
        public String fone;
        public EnderToma enderToma;
        public String email;
    }

    public static class Ide {
        public String cUF;
        public String cCT;
        @JsonProperty("CFOP")
        public String CFOP;
        public String natOp;
        public String mod;
        public String serie;
        public String nCT;
        public String dhEmi;
        public String tpImp;
        public String tpEmis;
        public String cDV;
        public String tpAmb;
        public String tpCTe;
        public String procEmi;
        public String verProc;
        public String cMunEnv;
        public String xMunEnv;
        @JsonProperty("UFEnv")
        public String UFEnv;
        public String modal;
        public String tpServ;
        public String cMunIni;
        public String xMunIni;
        @JsonProperty("UFIni")
        public String UFIni;
        public String cMunFim;
        public String xMunFim;
        @JsonProperty("UFFim")
        public String UFFim;
        public String retira;
        public String xDetRetira;
        public String indIEToma;
        public Toma3 toma3;
        public Toma4 toma4;
        public String dhCont;
        public String xJust;
    }

    public static class Pass {
        public String xPass;
    }

    public static class Fluxo {
        public String xOrig;
        public List<Pass> pass;
        public String xDest;
        public String xRota;
    }

    public static class SemData {
        public String tpPer;
    }

    public static class ComData {
        public String tpPer;
        public String dProg;
    }

    public static class NoPeriodo {
        public String tpPer;
        public String dIni;
        public String dFim;
    }

    public static class SemHora {
        public String tpHor;
    }

    public static class ComHora {
        public String tpHor;
        public String hProg;
    }

    public static class NoInter {
        public String tpHor;
        public String hIni;
        public String hFim;
    }

    public static class Entrega {
        public SemData semData;
        public ComData comData;
        public NoPeriodo noPeriodo;
        public SemHora semHora;
        public ComHora comHora;
        public NoInter noInter;
    }

    public static class ObsCont {
        public String xCampo;
        public String xTexto;
    }

    public static class ObsFisco {
        public String xCampo;
        public String xTexto;
    }

    public static class Compl {
        public String xCaracAd;
        public String xCaracSer;
        public String xEmi;
        public Fluxo fluxo;
        @JsonProperty("Entrega")
        public Entrega entrega;
        public String origCalc;
        public String destCalc;
        public String xObs;
        public ObsCont ObsCont;
        @JsonProperty("ObsFisco")
        public List<ObsFisco> obsFisco;
    }

    public static class EnderEmit {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String CEP;
        @JsonProperty("UF")
        public String UF;
        public String fone;
    }

    public static class Emit {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("IE")
        public String IE;
        @JsonProperty("IEST")
        public String iEST;
        public String xNome;
        public String xFant;
        public EnderEmit enderEmit;
        public String CRT;
    }

    public static class EnderReme {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String CEP;
        @JsonProperty("UF")
        public String UF;
        public String cPais;
        public String xPais;
    }

    public static class Rem {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String CPF;
        @JsonProperty("IE")
        public String iE;
        public String xNome;
        public String xFant;
        public String fone;
        public EnderReme enderReme;
        public String email;
    }

    public static class EnderExped {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String cEP;
        @JsonProperty("UF")
        public String uF;
        public String cPais;
        public String xPais;
    }

    public static class Exped {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("IE")
        public String iE;
        public String xNome;
        public String fone;
        public EnderExped enderExped;
        public String email;
    }

    public static class EnderReceb {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String cEP;
        @JsonProperty("UF")
        public String uF;
        public String cPais;
        public String xPais;
    }

    public static class Receb {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("IE")
        public String iE;
        public String xNome;
        public String fone;
        public EnderReceb enderReceb;
        public String email;
    }

    public static class EnderDest {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String cEP;
        @JsonProperty("UF")
        public String UF;
        public String cPais;
        public String xPais;
    }

    public static class Dest {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("IE")
        public String IE;
        public String xNome;
        public String fone;
        @JsonProperty("ISUF")
        public String iSUF;
        public EnderDest enderDest;
        public String email;
    }

    public static class Comp {
        public String xNome;
        public String vComp;
    }

    public static class VPrest {
        public String vTPrest;
        public String vRec;
        @JsonProperty("Comp")
        public List<Comp> comp;
    }

    public static class ICMS00 {
        @JsonProperty("CST")
        public String cST;
        public String vBC;
        public String pICMS;
        public String vICMS;
    }

    public static class ICMS20 {
        @JsonProperty("CST")
        public String cST;
        public String pRedBC;
        public String vBC;
        public String pICMS;
        public String vICMS;
    }

    public static class ICMS45 {
        @JsonProperty("CST")
        public String cST;
    }

    public static class ICMS60 {
        @JsonProperty("CST")
        public String cST;
        public String vBCSTRet;
        public String vICMSSTRet;
        public String pICMSSTRet;
        public String vCred;
    }

    public static class ICMS90 {
        @JsonProperty("CST")
        public String cST;
        public String pRedBC;
        public String vBC;
        public String pICMS;
        public String vICMS;
        public String vCred;
    }

    public static class ICMSOutraUF {
        @JsonProperty("CST")
        public String cST;
        public String pRedBCOutraUF;
        public String vBCOutraUF;
        public String pICMSOutraUF;
        public String vICMSOutraUF;
    }

    public static class ICMSSN {
        @JsonProperty("CST")
        public String CST;
        public String indSN;
    }

    public static class ICMS {
        @JsonProperty("ICMS00")
        public ICMS00 iCMS00;
        @JsonProperty("ICMS20")
        public ICMS20 iCMS20;
        @JsonProperty("ICMS45")
        public ICMS45 iCMS45;
        @JsonProperty("ICMS60")
        public ICMS60 iCMS60;
        @JsonProperty("ICMS90")
        public ICMS90 iCMS90;
        @JsonProperty("ICMSOutraUF")
        public ICMSOutraUF iCMSOutraUF;
        @JsonProperty("ICMSSN")
        public ICMSSN ICMSSN;
    }

    public static class ICMSUFFim {
        public String vBCUFFim;
        public String pFCPUFFim;
        public String pICMSUFFim;
        public String pICMSInter;
        public String pICMSInterPart;
        public String vFCPUFFim;
        public String vICMSUFFim;
        public String vICMSUFIni;
    }

    public static class Imp {
        @JsonProperty("ICMS")
        public ICMS ICMS;
        public String vTotTrib;
        public String infAdFisco;
        @JsonProperty("ICMSUFFim")
        public ICMSUFFim iCMSUFFim;
    }

    public static class InfQ {
        public String cUnid;
        public String tpMed;
        public String qCarga;
    }

    public static class InfCarga {
        public String vCarga;
        public String proPred;
        public List<InfQ> infQ;
        public String vCargaAverb;
    }

    public static class LacUnidCarga {
        public String nLacre;
    }

    public static class InfUnidCarga {
        public String tpUnidCarga;
        public String idUnidCarga;
        public List<LacUnidCarga> lacUnidCarga;
        public String qtdRat;
    }

    public static class LacUnidTransp {
        public String nLacre;
    }

    public static class InfUnidTransp {
        public String tpUnidTransp;
        public String idUnidTransp;
        public List<LacUnidTransp> lacUnidTransp;
        public List<InfUnidCarga> infUnidCarga;
        public String qtdRat;
    }

    public static class InfNF {
        public String nRoma;
        public String nPed;
        public String mod;
        public String serie;
        public String nDoc;
        public String dEmi;
        public String vBC;
        public String vICMS;
        public String vBCST;
        public String vST;
        public String vProd;
        public String vNF;
        public String nCFOP;
        public String nPeso;
        @JsonProperty("PIN")
        public String pIN;
        public String dPrev;
        public List<InfUnidCarga> infUnidCarga;
        public List<InfUnidTransp> infUnidTransp;
        public String unidRat;
    }

    public static class InfNFe {
        public String chave;
        @JsonProperty("PIN")
        public String pIN;
        public String dPrev;
        public List<InfUnidCarga> infUnidCarga;
        public List<InfUnidTransp> infUnidTransp;
        public String unidRat;
    }

    public static class InfOutro {
        public String tpDoc;
        public String descOutros;
        public String nDoc;
        public String dEmi;
        public String vDocFisc;
        public String dPrev;
        public List<InfUnidCarga> infUnidCarga;
        public List<InfUnidTransp> infUnidTransp;
    }

    public static class InfDoc {
        public List<InfNF> infNF;
        public List<InfNFe> infNFe;
        public List<InfOutro> infOutros;
    }

    public static class IdDocAntPap {
        public String tpDoc;
        public String serie;
        public String subser;
        public String nDoc;
        public String dEmi;
    }

    public static class IdDocAntEle {
        public String chCTe;
    }

    public static class IdDocAnt {
        public List<IdDocAntPap> idDocAntPap;
        public List<IdDocAntEle> idDocAntEle;
    }

    public static class EmiDocAnt {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("IE")
        public String iE;
        @JsonProperty("UF")
        public String uF;
        public String xNome;
        public List<IdDocAnt> idDocAnt;
    }

    public static class DocAnt {
        public List<EmiDocAnt> emiDocAnt;
    }

    public static class VeicNovo {
        public String chassi;
        public String cCor;
        public String xCor;
        public String cMod;
        public String vUnit;
        public String vFrete;
    }

    public static class Fat {
        public String nFat;
        public String vOrig;
        public String vDesc;
        public String vLiq;
    }

    public static class Dup {
        public String nDup;
        public String dVenc;
        public String vDup;
    }

    public static class Cobr {
        public Fat fat;
        public List<Dup> dup;
    }

    public static class RefNF {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
        public String mod;
        public String serie;
        public String subserie;
        public String nro;
        public String valor;
        public String dEmi;
    }

    public static class TomaICMS {
        public String refNFe;
        public RefNF refNF;
        public String refCte;
    }

    public static class InfCteSub {
        public String chCte;
        public String refCteAnu;
        public TomaICMS tomaICMS;
        public String indAlteraToma;
    }

    public static class InfGlobalizado {
        public String xObs;
    }

    public static class InfCTeMultimodal {
        public String chCTeMultimodal;
    }

    public static class InfServVinc {
        public List<InfCTeMultimodal> infCTeMultimodal;
    }

    public static class InfCTeNorm {
        public InfCarga infCarga;
        public InfDoc infDoc;
        public DocAnt docAnt;
        public List<VeicNovo> veicNovos;
        public Cobr cobr;
        public InfCteSub infCteSub;
        public InfGlobalizado infGlobalizado;
        public InfServVinc infServVinc;
    }

    public static class InfCteComp {
        public String chCTe;
    }

    public static class InfCteAnu {
        public String chCTe;
        public String dEmi;
    }

    public static class AutXML {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
    }

    public static class InfCte {
        public String versao;
        public Ide ide;
        public Compl compl;
        public Emit emit;
        public Rem rem;
        public Exped exped;
        public Receb receb;
        public Dest dest;
        public VPrest vPrest;
        public Imp imp;
        public InfCTeNorm infCTeNorm;
        public InfCteComp infCteComp;
        public InfCteAnu infCteAnu;
        public List<AutXML> autXML;
    }

    public static class CTe {
        public InfCte infCte;
        public InfRespTec infRespTec;
    }

    public static class EmiOcc {
        @JsonProperty("CNPJ")
        public String cNPJ;
        public String cInt;
        @JsonProperty("IE")
        public String iE;
        @JsonProperty("UF")
        public String uF;
        public String fone;
    }

    public static class Occ {
        public String serie;
        public String nOcc;
        public String dEmi;
        public EmiOcc emiOcc;
    }

    public static class Rodo {
        public String xmlns;
        @JsonProperty("RNTRC")
        public String RNTRC;
        public List<Occ> occ;
    }

    public static class NatCarga {
        public String xDime;
        public String cInfManu;
    }

    public static class Tarifa {
        @JsonProperty("CL")
        public String cL;
        public String cTar;
        public String vTar;
    }

    public static class InfTotAP {
        public String qTotProd;
        public String uniAP;
    }

    public static class Peri {
        public String nONU;
        public String qTotEmb;
        public InfTotAP infTotAP;
    }

    public static class Aereo {
        public String nMinu;
        public String nOCA;
        public String dPrevAereo;
        public NatCarga natCarga;
        public Tarifa tarifa;
        public List<Peri> peri;
    }

    public static class Balsa {
        public String xBalsa;
    }

    public static class Lacre {
        public String nLacre;
    }

    public static class InfRespTec {
        @JsonProperty("CNPJ")
        public String cnpj;
        public String xContato;
        public String email;
        public String fone;
    }

    public static class DetCont {
        public String nCont;
        public List<Lacre> lacre;
        public InfDoc infDoc;
    }

    public static class Aquav {
        public String vPrest;
        public String vAFRMM;
        public String xNavio;
        public List<Balsa> balsa;
        public String nViag;
        public String direc;
        public String irin;
        public List<DetCont> detCont;
    }

    public static class EnderFerro {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String cEP;
        @JsonProperty("UF")
        public String uF;
    }

    public static class FerroEnv {
        @JsonProperty("CNPJ")
        public String cNPJ;
        public String cInt;
        @JsonProperty("IE")
        public String iE;
        public String xNome;
        public EnderFerro enderFerro;
    }

    public static class TrafMut {
        public String respFat;
        public String ferrEmi;
        public String vFrete;
        public String chCTeFerroOrigem;
        public List<FerroEnv> ferroEnv;
    }

    public static class Ferrov {
        public String tpTraf;
        public TrafMut trafMut;
        public String fluxo;
    }

    public static class Duto {
        public String vTar;
        public String dIni;
        public String dFim;
    }

    public static class InfSeg {
        public String xSeg;
        @JsonProperty("CNPJ")
        public String cNPJ;
    }

    public static class Seg {
        public InfSeg infSeg;
        public String nApol;
        public String nAver;
    }

    public static class Multimodal {
        @JsonProperty("COTM")
        public String cOTM;
        public String indNegociavel;
        public Seg seg;
    }

    public static class InfModal {
        public Rodo rodo;
        public Aereo aereo;
        public Aquav aquav;
        public Ferrov ferrov;
        public Duto duto;
        public Multimodal multimodal;
        public String versaoModal;
    }

}
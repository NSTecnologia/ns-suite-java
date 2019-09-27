package br.eti.ns.nssuite.JSON.CTe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class Toma3
{
    public String toma;
}

class EnderToma
{
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

class Toma4
{
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

class Ide
{
    public String cUF;
    public String cCT;
    @JsonProperty("CFOP")
    public String cFOP;
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
    public String uFEnv;
    public String modal;
    public String tpServ;
    public String cMunIni;
    public String xMunIni;
    @JsonProperty("UFIni")
    public String uFIni;
    public String cMunFim;
    public String xMunFim;
    @JsonProperty("UFFim")
    public String uFFim;
    public String retira;
    public String xDetRetira;
    public String indIEToma;
    public Toma3 toma3;
    public Toma4 toma4;
    public String dhCont;
    public String xJust;
}

class Pass
{
    public String xPass;
}

class Fluxo
{
    public String xOrig;
    public List<Pass> pass;
    public String xDest;
    public String xRota;
}

class SemData
{
    public String tpPer;
}

class ComData
{
    public String tpPer;
    public String dProg;
}

class NoPeriodo
{
    public String tpPer;
    public String dIni;
    public String dFim;
}

class SemHora
{
    public String tpHor;
}

class ComHora
{
    public String tpHor;
    public String hProg;
}

class NoInter
{
    public String tpHor;
    public String hIni;
    public String hFim;
}

class Entrega
{
    public SemData semData;
    public ComData comData;
    public NoPeriodo noPeriodo;
    public SemHora semHora;
    public ComHora comHora;
    public NoInter noInter;
}

class ObsCont
{
    public String xCampo;
    public String xTexto;
}

class ObsFisco
{
    public String xCampo;
    public String xTexto;
}

class Compl
{
    public String xCaracAd;
    public String xCaracSer;
    public String xEmi;
    public Fluxo fluxo;
    @JsonProperty("Entrega")
    public Entrega entrega;
    public String origCalc;
    public String destCalc;
    public String xObs;
    @JsonProperty("ObsCont")
    public List<ObsCont> obsCont;
    @JsonProperty("ObsFisco")
    public List<ObsFisco> obsFisco;
}

class EnderEmit
{
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
    public String fone;
}

class Emit
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("IE")
    public String iE;
    @JsonProperty("IEST")
    public String iEST;
    public String xNome;
    public String xFant;
    public EnderEmit enderEmit;
}

class EnderReme
{
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

class Rem
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
    @JsonProperty("IE")
    public String iE;
    public String xNome;
    public String xFant;
    public String fone;
    public EnderReme enderReme;
    public String email;
}

class EnderExped
{
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

class Exped
{
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

class EnderReceb
{
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

class Receb
{
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

class EnderDest
{
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

class Dest
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
    @JsonProperty("IE")
    public String iE;
    public String xNome;
    public String fone;
    @JsonProperty("ISUF")
    public String iSUF;
    public EnderDest enderDest;
    public String email;
}

class Comp
{
    public String xNome;
    public String vComp;
}

class VPrest
{
    public String vTPrest;
    public String vRec;
    @JsonProperty("Comp")
    public List<Comp> comp;
}

class ICMS00
{
    @JsonProperty("CST")
    public String cST;
    public String vBC;
    public String pICMS;
    public String vICMS;
}

class ICMS20
{
    @JsonProperty("CST")
    public String cST;
    public String pRedBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
}

class ICMS45
{
    @JsonProperty("CST")
    public String cST;
}

class ICMS60
{
    @JsonProperty("CST")
    public String cST;
    public String vBCSTRet;
    public String vICMSSTRet;
    public String pICMSSTRet;
    public String vCred;
}

class ICMS90
{
    @JsonProperty("CST")
    public String cST;
    public String pRedBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
    public String vCred;
}

class ICMSOutraUF
{
    @JsonProperty("CST")
    public String cST;
    public String pRedBCOutraUF;
    public String vBCOutraUF;
    public String pICMSOutraUF;
    public String vICMSOutraUF;
}

class ICMSSN
{
    @JsonProperty("CST")
    public String cST;
    public String indSN;
}

class ICMS
{
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
    public ICMSSN iCMSSN;
}

class ICMSUFFim
{
    public String vBCUFFim;
    public String pFCPUFFim;
    public String pICMSUFFim;
    public String pICMSInter;
    public String pICMSInterPart;
    public String vFCPUFFim;
    public String vICMSUFFim;
    public String vICMSUFIni;
}

class Imp
{
    @JsonProperty("ICMS")
    public ICMS iCMS;
    public String vTotTrib;
    public String infAdFisco;
    @JsonProperty("ICMSUFFim")
    public ICMSUFFim iCMSUFFim;
}

class InfQ
{
    public String cUnid;
    public String tpMed;
    public String qCarga;
}

class InfCarga
{
    public String vCarga;
    public String proPred;
    public List<InfQ> infQ;
    public String vCargaAverb;
}

class LacUnidCarga
{
    public String nLacre;
}

class InfUnidCarga
{
    public String tpUnidCarga;
    public String idUnidCarga;
    public List<LacUnidCarga> lacUnidCarga;
    public String qtdRat;
}

class LacUnidTransp
{
    public String nLacre;
}

class InfUnidTransp
{
    public String tpUnidTransp;
    public String idUnidTransp;
    public List<LacUnidTransp> lacUnidTransp;
    public List<InfUnidCarga> infUnidCarga;
    public String qtdRat;
}

class InfNF
{
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

class InfNFe
{
    public String chave;
    @JsonProperty("PIN")
    public String pIN;
    public String dPrev;
    public List<InfUnidCarga> infUnidCarga;
    public List<InfUnidTransp> infUnidTransp;
    public String unidRat;
}

class InfOutro
{
    public String tpDoc;
    public String descOutros;
    public String nDoc;
    public String dEmi;
    public String vDocFisc;
    public String dPrev;
    public List<InfUnidCarga> infUnidCarga;
    public List<InfUnidTransp> infUnidTransp;
}

class InfDoc
{
    public List<InfNF> infNF;
    public List<InfNFe> infNFe;
    public List<InfOutro> infOutros;
}

class IdDocAntPap
{
    public String tpDoc;
    public String serie;
    public String subser;
    public String nDoc;
    public String dEmi;
}

class IdDocAntEle
{
    public String chCTe;
}

class IdDocAnt
{
    public List<IdDocAntPap> idDocAntPap;
    public List<IdDocAntEle> idDocAntEle;
}

class EmiDocAnt
{
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

class DocAnt
{
    public List<EmiDocAnt> emiDocAnt;
}

class VeicNovo
{
    public String chassi;
    public String cCor;
    public String xCor;
    public String cMod;
    public String vUnit;
    public String vFrete;
}

class Fat
{
    public String nFat;
    public String vOrig;
    public String vDesc;
    public String vLiq;
}

class Dup
{
    public String nDup;
    public String dVenc;
    public String vDup;
}

class Cobr
{
    public Fat fat;
    public List<Dup> dup;
}

class RefNF
{
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

class TomaICMS
{
    public String refNFe;
    public RefNF refNF;
    public String refCte;
}

class InfCteSub
{
    public String chCte;
    public String refCteAnu;
    public TomaICMS tomaICMS;
    public String indAlteraToma;
}

class InfGlobalizado
{
    public String xObs;
}

class InfCTeMultimodal
{
    public String chCTeMultimodal;
}

class InfServVinc
{
    public List<InfCTeMultimodal> infCTeMultimodal;
}

class InfCTeNorm
{
    public InfCarga infCarga;
    public InfDoc infDoc;
    public DocAnt docAnt;
    public List<VeicNovo> veicNovos;
    public Cobr cobr;
    public InfCteSub infCteSub;
    public InfGlobalizado infGlobalizado;
    public InfServVinc infServVinc;
}

class InfCteComp
{
    public String chCTe;
}

class InfCteAnu
{
    public String chCTe;
    public String dEmi;
}

class AutXML
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
}

class InfCte
{
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

class CTe
{
    public InfCte infCte;
}

class EmiOcc
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    public String cInt;
    @JsonProperty("IE")
    public String iE;
    @JsonProperty("UF")
    public String uF;
    public String fone;
}

class Occ
{
    public String serie;
    public String nOcc;
    public String dEmi;
    public EmiOcc emiOcc;
}

class Rodo
{
    public String xmlns;
    @JsonProperty("RNTRC")
    public String rNTRC;
    public List<Occ> occ;
}

class NatCarga
{
    public String xDime;
    public String cInfManu;
}

class Tarifa
{
    @JsonProperty("CL")
    public String cL;
    public String cTar;
    public String vTar;
}

class InfTotAP
{
    public String qTotProd;
    public String uniAP;
}

class Peri
{
    public String nONU;
    public String qTotEmb;
    public InfTotAP infTotAP;
}

class Aereo
{
    public String nMinu;
    public String nOCA;
    public String dPrevAereo;
    public NatCarga natCarga;
    public Tarifa tarifa;
    public List<Peri> peri;
}

class Balsa
{
    public String xBalsa;
}

class Lacre
{
    public String nLacre;
}

class DetCont
{
    public String nCont;
    public List<Lacre> lacre;
    public InfDoc infDoc;
}

class Aquav
{
    public String vPrest;
    public String vAFRMM;
    public String xNavio;
    public List<Balsa> balsa;
    public String nViag;
    public String direc;
    public String irin;
    public List<DetCont> detCont;
}

class EnderFerro
{
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

class FerroEnv
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    public String cInt;
    @JsonProperty("IE")
    public String iE;
    public String xNome;
    public EnderFerro enderFerro;
}

class TrafMut
{
    public String respFat;
    public String ferrEmi;
    public String vFrete;
    public String chCTeFerroOrigem;
    public List<FerroEnv> ferroEnv;
}

class Ferrov
{
    public String tpTraf;
    public TrafMut trafMut;
    public String fluxo;
}

class Duto
{
    public String vTar;
    public String dIni;
    public String dFim;
}

class InfSeg
{
    public String xSeg;
    @JsonProperty("CNPJ")
    public String cNPJ;
}

class Seg
{
    public InfSeg infSeg;
    public String nApol;
    public String nAver;
}

class Multimodal
{
    @JsonProperty("COTM")
    public String cOTM;
    public String indNegociavel;
    public Seg seg;
}

class InfModal
{
    public String versaoModal;
    public Rodo rodo;
    public Aereo aereo;
    public Aquav aquav;
    public Ferrov ferrov;
    public Duto duto;
    public Multimodal multimodal;
}

class CTeJSON
{
    @JsonProperty("CTe")
    public CTe cTe;
    public InfModal infModal;
}


package br.eti.ns.nssuite.JSON.NFe;

import br.eti.ns.nssuite.JSON.NF3e.NF3eJSON;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class NFeJSON {
  @JsonProperty("NFe")
  public NFe NFe;

  public static class RefNF {
    public String cUF;
    @JsonProperty("AAMM")
    public String AAMM;
    @JsonProperty("CNPJ")
    public String CNPJ;
    public String mod;
    public String serie;
    public String nNF;
  }

  public static class RefNFP {
    public String cUF;
    @JsonProperty("AAMM")
    public String AAMM;
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    @JsonProperty("IE")
    public String IE;
    public String mod;
    public String serie;
    public String nNF;
    public String refCTe;
  }

  public static class RefECF {
    public String mod;
    public String nECF;
    public String nCOO;
  }

  public static class NFref {
    public String refNFe;
    public RefNF refNF;
    public RefNFP refNFP;
    public RefECF refECF;
  }

  public static class Ide {
    public String cUF;
    public String cNF;
    public String natOp;
    public String mod;
    public String serie;
    public String nNF;
    public String dhEmi;
    public String dhSaiEnt;
    public String tpNF;
    public String idDest;
    public String cMunFG;
    public String tpImp;
    public String tpEmis;
    public String cDV;
    public String tpAmb;
    public String finNFe;
    public String indFinal;
    public String indPres;
    public String indIntermed;
    public String procEmi;
    public String verProc;
    public String dhCont;
    public String xJust;
    @JsonProperty("NFref")
    public List<NFref> NFref;
  }

  public static class EnderEmit {
    public String xLgr;
    public String nro;
    public String xCpl;
    public String xBairro;
    public String cMun;
    public String xMun;
    @JsonProperty("UF")
    public String UF;
    @JsonProperty("CEP")
    public String CEP;
    public String cPais;
    public String xPais;
    public String fone;
  }

  public static class Emit {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    public String xNome;
    public String xFant;
    public EnderEmit enderEmit;
    @JsonProperty("IE")
    public String IE;
    @JsonProperty("IEST")
    public String IEST;
    @JsonProperty("IM")
    public String IM;
    @JsonProperty("CNAE")
    public String CNAE;
    @JsonProperty("CRT")
    public String CRT;
  }

  public static class EnderDest {
    public String xLgr;
    public String nro;
    public String xCpl;
    public String xBairro;
    public String cMun;
    public String xMun;
    @JsonProperty("UF")
    public String UF;
    @JsonProperty("CEP")
    public String CEP;
    public String cPais;
    public String xPais;
    public String fone;
  }

  public static class Dest {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    public String idEstrangeiro;
    public String xNome;
    public EnderDest enderDest;
    public String indIEDest;
    @JsonProperty("IE")
    public String IE;
    @JsonProperty("ISUF")
    public String ISUF;
    @JsonProperty("IM")
    public String IM;
    public String email;
  }

  public static class Retirada {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    public String xLgr;
    public String nro;
    public String xCpl;
    public String xBairro;
    public String cMun;
    public String xMun;
    @JsonProperty("UF")
    public String UF;
  }

  public static class Entrega {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    public String xLgr;
    public String nro;
    public String xCpl;
    public String xBairro;
    public String cMun;
    public String xMun;
    @JsonProperty("UF")
    public String UF;
  }

  public static class AutXML {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
  }

  public static class Rastro {
    public String nLote;
    public String qLote;
    public String dFab;
    public String dVal;
    public String cAgreg;
  }

  public static class Adi {
    public String nAdicao;
    public String nSeqAdic;
    public String cFabricante;
    public String vDescDI;
    public String nDraw;
  }

  public static class DI {
    public String nDI;
    public String dDI;
    public String xLocDesemb;
    @JsonProperty("UFDesemb")
    public String UFDesemb;
    public String dDesemb;
    public String tpViaTransp;
    public String vAFRMM;
    public String tpIntermedio;
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("UFTerceiro")
    public String UFTerceiro;
    public String cExportador;
    public Adi adi;
  }

  public static class ExportInd {
    public String nRE;
    public String chNFe;
    public String qExport;
  }

  public static class DetExport {
    public String nDraw;
    public ExportInd exportInd;
  }

  public static class VeicProd {
    public String tpOp;
    public String chassi;
    public String cCor;
    public String xCor;
    public String pot;
    public String cilin;
    public String pesoL;
    public String pesoB;
    public String nSerie;
    public String tpComb;
    public String nMotor;
    @JsonProperty("CMT")
    public String CMT;
    public String dist;
    public String anoMod;
    public String anoFab;
    public String tpPint;
    public String tpVeic;
    public String espVeic;
    @JsonProperty("VIN")
    public String VIN;
    public String condVeic;
    public String cMod;
    public String cCorDENATRAN;
    public String lota;
    public String tpRest;
  }

  public static class Med {
    public String cProdANVISA;
    public String vPMC;
  }

  public static class Arma {
    public String tpArma;
    public String nSerie;
    public String nCano;
    public String descr;
  }

  public static class CIDE {
    public String qBCProd;
    public String vAliqProd;
    public String vCIDE;
  }

  public static class Encerrante {
    public String nBico;
    public String nBomba;
    public String nTanque;
    public String vEncIni;
    public String vEncFin;
  }

  public static class Comb {
    public String cProdANP;
    public String descANP;
    public String pGLP;
    public String pGNn;
    public String pGNi;
    public String vPart;
    @JsonProperty("CODIF")
    public String CODIF;
    public String qTemp;
    @JsonProperty("UFCons")
    public String UFCons;
    @JsonProperty("CIDE")
    public CIDE CIDE;
    public Encerrante encerrante;
  }

  public static class Prod {
    public String cProd;
    public String cEAN;
    public String xProd;
    @JsonProperty("NCM")
    public String NCM;
    @JsonProperty("NVE")
    public String NVE;
    @JsonProperty("CEST")
    public String CEST;
    public String indEscala;
    @JsonProperty("CNPJFab")
    public String CNPJFab;
    public String cBenef;
    @JsonProperty("EXTIPI")
    public String EXTIPI;
    @JsonProperty("CFOP")
    public String CFOP;
    public String uCom;
    public String qCom;
    public String vUnCom;
    public String vProd;
    public String cEANTrib;
    public String uTrib;
    public String qTrib;
    public String vUnTrib;
    public String vFrete;
    public String vSeg;
    public String vDesc;
    public String vOutro;
    public String indTot;
    public List<Rastro> rastro;
    @JsonProperty("DI")
    public List<DI> DI;
    public List<DetExport> detExport;
    public String xPed;
    public String nItemPed;
    public String nFCI;
    public VeicProd veicProd;
    public Med med;
    public List<Arma> arma;
    public Comb comb;
    public String nRECOPI;
  }

  public static class ICMS00 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
    public String pFCP;
    public String vFCP;
  }

  public static class ICMS10 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
    public String vBCFCP;
    public String pFCP;
    public String vFCP;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
  }

  public static class ICMS20 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String pRedBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
    public String vBCFCP;
    public String pFCP;
    public String vFCP;
    public String vICMSDeson;
    public String motDesICMS;
  }

  public static class ICMS30 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
    public String vICMSDeson;
    public String motDesICMS;
  }

  public static class ICMS40 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String vICMSDeson;
    public String motDesICMS;
  }

  public static class ICMS51 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String pRedBC;
    public String vBC;
    public String pICMS;
    public String vICMSOp;
    public String pDif;
    public String vICMSDif;
    public String vICMS;
    public String vBCFCP;
    public String pFCP;
    public String vFCP;
  }

  public static class ICMS60 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String vBCSTRet;
    public String pST;
    public String vICMSSTRet;
    public String vBCFCPSTRet;
    public String pFCPSTRet;
    public String vFCPSTRet;
  }

  public static class ICMS70 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String pRedBC;
    public String vBC;
    public String pICMS;
    public String vICMS;
    public String vBCFCP;
    public String pFCP;
    public String vFCP;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
    public String vICMSDeson;
    public String motDesICMS;
  }

  public static class ICMS90 {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String vBC;
    public String pRedBC;
    public String pICMS;
    public String vICMS;
    public String vBCFCP;
    public String pFCP;
    public String vFCP;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
    public String vICMSDeson;
    public String motDesICMS;
  }

  public static class ICMSPart {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String modBC;
    public String vBC;
    public String pRedBC;
    public String pICMS;
    public String vICMS;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String pBCOp;
    @JsonProperty("UFST")
    public String UFST;
  }

  public static class ICMSST {
    public String orig;
    @JsonProperty("CST")
    public String CST;
    public String vBCSTRet;
    public String vICMSSTRet;
    public String vBCSTDest;
    public String vICMSSTDest;
  }

  public static class ICMSSN101 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
    public String pCredSN;
    public String vCredICMSSN;
  }

  public static class ICMSSN102 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
  }

  public static class ICMSSN201 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
    public String pCredSN;
    public String vCredICMSSN;
  }

  public static class ICMSSN202 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
  }

  public static class ICMSSN500 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
    public String vBCSTRet;
    public String pST;
    public String vICMSSTRet;
    public String vBCFCPSTRet;
    public String pFCPSTRet;
    public String vFCPSTRet;
  }

  public static class ICMSSN900 {
    public String orig;
    @JsonProperty("CSOSN")
    public String CSOSN;
    public String modBC;
    public String vBC;
    public String pRedBC;
    public String pICMS;
    public String vICMS;
    public String modBCST;
    public String pMVAST;
    public String pRedBCST;
    public String vBCST;
    public String pICMSST;
    public String vICMSST;
    public String vBCFCPST;
    public String pFCPST;
    public String vFCPST;
    public String pCredSN;
    public String vCredICMSSN;
  }

  public static class ICMSUFDest {
    public String vBCUFDest;
    public String vBCFCPUFDest;
    public String pFCPUFDest;
    public String pICMSUFDest;
    public String pICMSInter;
    public String pICMSInterPart;
    public String vFCPUFDest;
    public String vICMSUFDest;
    public String vICMSUFRemet;
  }

  public static class ICMS {
    @JsonProperty("ICMS00")
    public ICMS00 ICMS00;
    @JsonProperty("ICMS10")
    public ICMS10 ICMS10;
    @JsonProperty("ICMS20")
    public ICMS20 ICMS20;
    @JsonProperty("ICMS30")
    public ICMS30 ICMS30;
    @JsonProperty("ICMS40")
    public ICMS40 ICMS40;
    @JsonProperty("ICMS51")
    public ICMS51 ICMS51;
    @JsonProperty("ICMS60")
    public ICMS60 ICMS60;
    @JsonProperty("ICMS70")
    public ICMS70 ICMS70;
    @JsonProperty("ICMS90")
    public ICMS90 ICMS90;
    @JsonProperty("ICMSPart")
    public ICMSPart ICMSPart;
    @JsonProperty("ICMSST")
    public ICMSST ICMSST;
    @JsonProperty("ICMSSN101")
    public ICMSSN101 ICMSSN101;
    @JsonProperty("ICMSSN102")
    public ICMSSN102 ICMSSN102;
    @JsonProperty("ICMSSN201")
    public ICMSSN201 ICMSSN201;
    @JsonProperty("ICMSSN202")
    public ICMSSN202 ICMSSN202;
    @JsonProperty("ICMSSN500")
    public ICMSSN500 ICMSSN500;
    @JsonProperty("ICMSSN900")
    public ICMSSN900 ICMSSN900;
    //@JsonProperty("ICMSUFDest")
    //public ICMSUFDest iCMSUFDest;
  }

  public static class IPITrib {
    @JsonProperty("CST")
    public String CST;
    public String vBC;
    public String pIPI;
    public String qUnid;
    public String vUnid;
    public String vIPI;
  }

  public static class IPINT {
    @JsonProperty("CST")
    public String CST;
  }

  public static class IPI {
    //public String clEnq;
    @JsonProperty("CNPJProd")
    public String CNPJProd;
    public String cSelo;
    public String qSelo;
    public String cEnq;
    @JsonProperty("IPITrib")
    public IPITrib IPITrib;
    @JsonProperty("IPINT")
    public IPINT IPINT;
    //public String vIPIDevol;
  }

  public static class II {
    public String vBC;
    public String vDespAdu;
    public String vII;
    public String vIOF;
  }

  public static class PISAliq {
    @JsonProperty("CST")
    public String CST;
    public String vBC;
    public String pPIS;
    public String vPIS;
  }

  public static class PISQtde {
    @JsonProperty("CST")
    public String CST;
    public String qBCProd;
    public String vAliqProd;
    public String vPIS;
  }

  public static class PISNT {
    @JsonProperty("CST")
    public String CST;
  }

  public static class PISOutr {
    @JsonProperty("CST")
    public String CST;
    public String vBC;
    public String pPIS;
    public String qBCProd;
    public String vAliqProd;
    public String vPIS;
  }

  public static class PIS {
    @JsonProperty("PISAliq")
    public PISAliq PISAliq;
    @JsonProperty("PISQtde")
    public PISQtde PISQtde;
    @JsonProperty("PISNT")
    public PISNT PISNT;
    @JsonProperty("PISOutr")
    public PISOutr PISOutr;
  }

  public static class PISST {
    public String vBC;
    public String pPIS;
    public String qBCProd;
    public String vAliqProd;
    public String vPIS;
  }

  public static class COFINSAliq {
    @JsonProperty("CST")
    public String CST;
    public String vBC;
    public String pCOFINS;
    public String vCOFINS;
  }

  public static class COFINSQtde {
    @JsonProperty("CST")
    public String CST;
    public String qBCProd;
    public String vAliqProd;
    public String vCOFINS;
  }

  public static class COFINSNT {
    @JsonProperty("CST")
    public String CST;
  }

  public static class COFINSOutr {
    @JsonProperty("CST")
    public String CST;
    public String vBC;
    public String pCOFINS;
    public String qBCProd;
    public String vAliqProd;
    public String vCOFINS;
  }

  public static class COFINS {
    @JsonProperty("COFINSAliq")
    public COFINSAliq COFINSAliq;
    @JsonProperty("COFINSQtde")
    public COFINSQtde COFINSQtde;
    @JsonProperty("COFINSNT")
    public COFINSNT COFINSNT;
    @JsonProperty("COFINSOutr")
    public COFINSOutr COFINSOutr;
  }

  public static class COFINSST {
    public String vBC;
    public String pCOFINS;
    public String qBCProd;
    public String vAliqProd;
    public String vCOFINS;
  }

  public static class ISSQN {
    public String vBC;
    public String vAliq;
    public String vISSQN;
    public String cMunFG;
    public String cListServ;
    public String vDeducao;
    public String vOutro;
    public String vDescIncond;
    public String vDescCond;
    public String vISSRet;
    public String indISS;
    public String cServico;
    public String cMun;
    public String cPais;
    public String nProcesso;
    public String indIncentivo;
  }

  public static class Imposto {
    public String vTotTrib;
    @JsonProperty("ICMS")
    public ICMS ICMS;
    @JsonProperty("IPI")
    public IPI IPI;
    @JsonProperty("II")
    public II II;
    @JsonProperty("PIS")
    public PIS PIS;
    @JsonProperty("PISST")
    public PISST PISST;
    @JsonProperty("COFINS")
    public COFINS COFINS;
    @JsonProperty("COFINSST")
    public COFINSST COFINSST;
    @JsonProperty("ISSQN")
    public ISSQN ISSQN;
  }

  public static class ImpostoDevol {
    public String pDevol;
    @JsonProperty("IPI")
    public IPI IPI;
  }

  public static class Det {
    public List<Det> det;
    public Prod prod;
    public Imposto imposto;
    public ImpostoDevol impostoDevol;
    public String infAdProd;
    public String nItem;
  }

  public static class ICMSTot {
    public String vBC;
    public String vICMS;
    public String vICMSDeson;
    public String vFCP;
    public String vFCPUFDest;
    public String vICMSUFDest;
    public String vICMSUFRemet;
    public String vBCST;
    public String vST;
    public String vFCPST;
    public String vFCPSTRet;
    public String vProd;
    public String vFrete;
    public String vSeg;
    public String vDesc;
    public String vII;
    public String vIPI;
    public String vIPIDevol;
    public String vPIS;
    public String vCOFINS;
    public String vOutro;
    public String vNF;
    public String vTotTrib;
  }

  public static class ISSQNtot {
    public String vServ;
    public String vBC;
    public String vISS;
    public String vPIS;
    public String vCOFINS;
    public String dCompet;
    public String vDeducao;
    public String vOutro;
    public String vDescIncond;
    public String vDescCond;
    public String vISSRet;
    public String cRegTrib;
  }

  public static class RetTrib {
    public String vRetPIS;
    public String vRetCOFINS;
    public String vRetCSLL;
    public String vBCIRRF;
    public String vIRRF;
    public String vBCRetPrev;
    public String vRetPrev;
  }

  public static class Total {
    @JsonProperty("ICMSTot")
    public ICMSTot ICMSTot;
    @JsonProperty("ISSQNtot")
    public ISSQNtot ISSQNtot;
    public RetTrib retTrib;
  }

  public static class Transporta {
    @JsonProperty("CNPJ")
    public String CNPJ;
    @JsonProperty("CPF")
    public String CPF;
    public String xNome;
    @JsonProperty("IE")
    public String IE;
    public String xEnder;
    public String xMun;
    @JsonProperty("UF")
    public String UF;
  }

  public static class RetTransp {
    public String vServ;
    public String vBCRet;
    public String pICMSRet;
    public String vICMSRet;
    @JsonProperty("CFOP")
    public String CFOP;
    public String cMunFG;
  }

  public static class VeicTransp {
    public String placa;
    @JsonProperty("UF")
    public String UF;
    @JsonProperty("RNTC")
    public String RNTC;
  }

  public static class Reboque {
    public String placa;
    @JsonProperty("UF")
    public String UF;
    @JsonProperty("RNTC")
    public String RNTC;
  }

  public static class Lacre {
    public String nLacre;
  }

  public static class Vol {
    public String qVol;
    public String esp;
    public String marca;
    public String nVol;
    public String pesoL;
    public String pesoB;
    public List<Lacre> lacres;
  }

  public static class Transp {
    public String modFrete;
    public Transporta transporta;
    public RetTransp retTransp;
    public VeicTransp veicTransp;
    public List<Reboque> reboque;
    public String vagao;
    public String balsa;
    public List<Vol> vol;
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

  public static class Card {
    @JsonProperty("CNPJ")
    public String CNPJ;
    public String tBand;
    public String cAut;
    public String tpIntegra;
  }

  public static class DetPag {
    public String indPag;
    public String tPag;
    public String vPag;
    public Card card;
  }

  public static class Pag {
    public List<DetPag> detPag;
    public String vTroco;
  }

  public static class InfIntermed {
  @JsonProperty("CNPJ")
  public String CNPJ;
  public String idCadIntTran;
}

  public static class ObsCont {
    public String xCampo;
    public String xTexto;
  }

  public static class ObsFisco {
    public String xCampo;
    public String xTexto;
  }

  public static class ProcRef {
    public String nProc;
    public String indProc;
  }

  public static class InfAdic {
    public String infAdFisco;
    public String infCpl;
    public List<ObsCont> obsCont;
    public List<ObsFisco> obsFisco;
    public List<ProcRef> procRef;
  }

  public static class Exporta {
    @JsonProperty("UFSaidaPais")
    public String UFSaidaPais;
    public String xLocExporta;
    public String xLocDespacho;
  }

  public static class Compra {
    public String xNEmp;
    public String xPed;
    public String xCont;
  }

  public static class ForDia {
    public String dia;
    public String qtde;
    public String qTotMes;
    public String qTotAnt;
    public String qTotGer;
  }

  public static class Deduc {
    public String xDed;
    public String vDed;
    public String vFor;
    public String vTotDed;
    public String vLiqFor;
  }

  public static class Cana {
    public String safra;
    public String ref;
    public List<ForDia> forDia;
    public List<Deduc> deduc;
  }

  public static class InfNFe {
    public String versao;
    public Ide ide;
    public Emit emit;
    public Dest dest;
    public Retirada retirada;
    public Entrega entrega;
    public List<AutXML> autXML;
    public List<Det> det;
    public Total total;
    public Transp transp;
    public Cobr cobr;
    public Pag pag;
    public InfIntermed infIntermed;
    public InfAdic infAdic;
    public Exporta exporta;
    public Compra compra;
    public Cana cana;
    public InfRespTec infRespTec;
  }

  public static class InfRespTec {
		public String CNPJ;
		public String xContato;
		public String email;
		public String fone;
	}


  public static class NFe {
    public InfNFe infNFe;
  }


  public String toJsonString() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toJsonString'");
  }

}
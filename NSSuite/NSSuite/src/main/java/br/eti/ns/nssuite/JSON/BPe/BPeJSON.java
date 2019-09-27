package br.eti.ns.nssuite.JSON.BPe;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

class Ide
{
    public String cUF;
    public String tpAmb;
    public String mod;
    public String serie;
    public String nBP;
    public String cBP;
    public String cDV;
    public String modal;
    public String dhEmi;
    public String tpEmis;
    public String verProc;
    public String tpBPe;
    public String indPres;
    @JsonProperty("UFIni")
    public String uFIni;
    public String cMunIni;
    @JsonProperty("UFFim")
    public String uFFim;
    public String cMunFim;
    public String chCont;
    public String xJust;
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
    public String email;
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
    @JsonProperty("IM")
    public String iM;
    @JsonProperty("CNAE")
    public String cNAE;
    @JsonProperty("CRT")
    public String cRT;
    public EnderEmit enderEmit;
    @JsonProperty("TAR")
    public String tAR;
}

class EnderComp
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
    public String fone;
    public String email;
}

class Comp
{
    public String xNome;
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
    public String idEstrangeiro;
    @JsonProperty("IE")
    public String iE;
    public EnderComp enderComp;
    public String tpComp;
    public String vComp;
}

class EnderAgencia
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
    public String email;
}

class Agencia
{
    public String xNome;
    @JsonProperty("CNPJ")
    public String cNPJ;
    public EnderAgencia enderAgencia;
}

class InfBPeSub
{
    public String chBPe;
    public String tpSub;
}

class InfPassageiro
{
    public String xNome;
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
    public String tpDoc;
    public String nDoc;
    public String dNasc;
    public String fone;
    public String email;
}

class InfPassagem
{
    public String cLocOrig;
    public String xLocOrig;
    public String cLocDest;
    public String xLocDest;
    public String dhEmb;
    public String dhValidade;
    public InfPassageiro infPassageiro;
}

class IdfTravessia
{
    public String tpVeiculo;
    public String sitVeiculo;
}

class InfViagem
{
    public String cPercurso;
    public String xPercurso;
    public String tpViagem;
    public String tpServ;
    public String tpAcomodacao;
    public String tpTrecho;
    public String dhViagem;
    public String dhConexao;
    public String prefixo;
    public String poltrona;
    public String plataforma;
    public IdfTravessia idfTravessia;
}

class InfValorBPe
{
    public String vBP;
    public String vDesconto;
    public String vPgto;
    public String vTroco;
    public String tpDesconto;
    public String xDesconto;
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
    public String qRedBCOutraUF;
    public String vBCOutraUF;
    public String pICMSOutraUF;
    public String vICMSOutraUF;
}

class ICMSSN
{
    @JsonProperty("CST")
    public String cST;
    public String indSN;
    public String vTotTrib;
    public String infAdFisco;
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

class ICMS
{
    @JsonProperty("ICMS00")
    public ICMS00 iCMS00;
    @JsonProperty("ICMS20")
    public ICMS20 iCMS20;
    @JsonProperty("ICMS45")
    public ICMS45 iCMS45;
    @JsonProperty("ICMS90")
    public ICMS90 iCMS90;
    @JsonProperty("ICMSOutraUF")
    public ICMSOutraUF iCMSOutraUF;
    @JsonProperty("ICMSSN")
    public ICMSSN iCMSSN;
    @JsonProperty("ICMSUFFim")
    public ICMSUFFim iCMSUFFim;
}

class Imp
{
    @JsonProperty("ICMS")
    public ICMS iCMS;
}

class Card
{
    public String tpIntegra;
    @JsonProperty("CNPJ")
    public String cNPJ;
    public String tBand;
    public String cAut;
}

class Pag
{
    public String tPag;
    public String vPag;
    public Card card;
}

class AutXML
{
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
}

class InfAdic
{
    public String infAdFisco;
    public String infCpl;
}

class InfBPe
{
    public String versao;
    public Ide ide;
    public Emit emit;
    public Comp comp;
    public Agencia agencia;
    public InfBPeSub infBPeSub;
    public InfPassagem infPassagem;
    public List<InfViagem> infViagem;
    public InfValorBPe infValorBPe;
    public Imp imp;
    public List<Pag> pag;
    public List<AutXML> autXML;
    public InfAdic infAdic;
}

class BPe
{
    public InfBPe infBPe;
}

public class BPeJSON
{
    @JsonProperty("BPe")
    public BPe bPe;
}


package br.eti.ns.nssuite.JSON.BPe;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class BPeJSON {
    @JsonProperty("BPe")
    public BPe bPe;

    public static class InfBPe
    {
        public String versao;
        public Ide ide;
        public Emit emit;
        public Comp comp;
        public Agencia agencia;
        public InfBPeSub infBPeSub;
        public InfPassagem infPassagem;
        public InfViagem infViagem;
        public InfValorBPe infValorBPe;
        public Imp imp;
        public Pag pag;
        public List<AutXML> autXML;
        public InfRespTec infRespTec;
        public InfAdic infAdic;

        public static class Pag {
            public String tPag;
            public String vPag;
            public Card card;
        }
    }

    public static class BPe {
        public InfBPe infBPe;
    }

    public static class Ide
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

    public static class EnderEmit
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

    public static class Emit
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

    public static class EnderComp
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

    public static class Comp
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
    }

    public static class EnderAgencia
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

    public static class Agencia
    {
        public String xNome;
        @JsonProperty("CNPJ")
        public String cNPJ;
        public EnderAgencia enderAgencia;
    }

    public static class InfBPeSub
    {
        public String chBPe;
        public String tpSub;
    }

    public static class InfPassageiro
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

    public static class InfPassagem
    {
        public String cLocOrig;
        public String xLocOrig;
        public String cLocDest;
        public String xLocDest;
        public String dhEmb;
        public String dhValidade;
        public InfPassageiro infPassageiro;
    }

    public static class IdfTravessia
    {
        public String tpVeiculo;
        public String sitVeiculo;
    }

    public static class InfViagem
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

    public static class InfValorBPe
    {
        public String vBP;
        public String vDesconto;
        public String vPgto;
        public String vTroco;
        public String tpDesconto;
        public String xDesconto;
        @JsonProperty("Comp")
        public Comp comp;

        public static class Comp {
            public String tpComp;
            public String vComp;
        }
    }

    public static class ICMS00
    {
        @JsonProperty("CST")
        public String cST;
        public String vBC;
        public String pICMS;
        public String vICMS;
    }

    public static class ICMS20
    {
        @JsonProperty("CST")
        public String cST;
        public String pRedBC;
        public String vBC;
        public String pICMS;
        public String vICMS;
    }

    public static class ICMS45
    {
        @JsonProperty("CST")
        public String cST;
    }

    public static class ICMS90
    {
        @JsonProperty("CST")
        public String cST;
        public String pRedBC;
        public String vBC;
        public String pICMS;
        public String vICMS;
        public String vCred;
    }

    public static class ICMSOutraUF
    {
        @JsonProperty("CST")
        public String cST;
        public String qRedBCOutraUF;
        public String vBCOutraUF;
        public String pICMSOutraUF;
        public String vICMSOutraUF;
    }

    public static class ICMSSN
    {
        @JsonProperty("CST")
        public String cST;
        public String indSN;
        public String vTotTrib;
        public String infAdFisco;
    }

    public static class ICMSUFFim
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

    public static class ICMS
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

    public static class Imp
    {
        @JsonProperty("ICMS")
        public ICMS iCMS;
    }

    public static class Card
    {
        public String tpIntegra;
        @JsonProperty("CNPJ")
        public String cNPJ;
        public String tBand;
        public String cAut;
    }

    public static class AutXML
    {
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("CPF")
        public String cPF;
    }

    public static class InfRespTec {
        @JsonProperty("CNPJ")
        public String cNPJ;
        public String xContato;
        public String email;
        public String fone;
        public String idCSRT;
        public String hashCSRT;
    }

    public static class InfAdic
    {
        public String infAdFisco;
        public String infCpl;
    }

}
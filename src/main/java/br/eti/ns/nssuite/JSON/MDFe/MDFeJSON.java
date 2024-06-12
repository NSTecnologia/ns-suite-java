package br.eti.ns.nssuite.JSON.MDFe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MDFeJSON
{
    @JsonProperty("MDFe")
    public MDFe MDFe;

    public static class InfMunCarrega
    {
        public String cMunCarrega;
        public String xMunCarrega;
    }

    public static class InfPercurso
    {
        @JsonProperty("UFPer")
        public String uFPer;
    }

    public static class Ide
    {
        public String cUF;
        public String tpAmb;
        public String tpEmit;
        public String tpTransp;
        public String mod;
        public String serie;
        public String nMDF;
        public String cMDF;
        public String cDV;
        public String modal;
        public String dhEmi;
        public String tpEmis;
        public String procEmi;
        public String verProc;
        @JsonProperty("UFIni")
        public String UFIni;
        @JsonProperty("UFFim")
        public String UFFim;
        public List<InfMunCarrega> infMunCarrega;
        public List<InfPercurso> infPercurso;
        public String dhIniViagem;
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
        public String CEP;
        @JsonProperty("UF")
        public String UF;
        public String fone;
        public String email;
    }

    public static class Emit {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("IE")
        public String IE;
        public String xNome;
        public String xFant;
        public EnderEmit enderEmit;
    }

    public static class LacUnidTransp {
        public String nLacre;
    }

    public static class LacUnidCarga{
        public String nLacre;
    }

    public static class InfUnidCarga {
        public String tpUnidCarga;
        public String idUnidCarga;
        public List<LacUnidCarga> lacUnidCarga;
        public String qtdRat;
    }

    public static class InfUnidTransp {
        public String tpUnidTransp;
        public String idUnidTransp;
        public List<LacUnidTransp> lacUnidTransp;
        public List<InfUnidCarga> infUnidCarga;
        public String qtdRat;
    }

    public static class Peri {
        public String nONU;
        public String xNomeAE;
        public String xClaRisco;
        public String grEmb;
        public String qTotProd;
        public String qVolTipo;
    }

    public static class InfCTe {
        public String chCTe;
        @JsonProperty("SegCodBarra")
        public String segCodBarra;
        public String indReentrega;
        public List<InfUnidTransp> infUnidTransp;
        public List<Peri> peri;
    }

    public static class InfNFe
    {
        public String chNFe;
        @JsonProperty("SegCodBarra")
        public String segCodBarra;
        public String indReentrega;
        public List<InfUnidTransp> infUnidTransp;
        public List<Peri> peri;
    }

    public static class InfMDFeTransp
    {
        public String chMDFe;
        public String indReentrega;
        public List<InfUnidTransp> infUnidTransp;
        public List<Peri> peri;
    }

    public static class InfMunDescarga
    {
        public String cMunDescarga;
        public String xMunDescarga;
        public List<InfCTe> infCTe;
        public List<InfNFe> infNFe;
        public List<InfMDFeTransp> infMDFeTransp;
    }

    public static class InfDoc
    {
        public List<InfMunDescarga> infMunDescarga;
    }

    public static class InfResp
    {
        public String respSeg;
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String cPF;
    }

    public static class InfSeg
    {
        public String xSeg;
        @JsonProperty("CNPJ")
        public String CNPJ;
    }

    public static class Seg
    {
        public InfResp infResp;
        public InfSeg infSeg;
        public String nApol;
        public String nAver;
    }

    public static class Tot
    {
        public String qCTe;
        public String qNFe;
        public String qMDFe;
        public String vCarga;
        public String cUnid;
        public String qCarga;
    }

    public static class Lacre
    {
        public String nLacre;
    }

    public static class AutXML
    {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String cPF;
    }

    public static class InfAdic
    {
        public String infAdFisco;
        public String infCpl;
    }

    public static class InfCIOT
    {
        @JsonProperty("CIOT")
        public String cIOT;
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("CNPJ")
        public String CNPJ;
    }

    public static class Disp
    {
        @JsonProperty("CNPJForn")
        public String CNPJForn;
        @JsonProperty("CNPJPg")
        public String CNPJPg;
        @JsonProperty("CPFPg")
        public String CPFPg;
        public String nCompra;
        public String vValePed;
        public String tpValePed;
    }

    public static class ValePed
    {
        public List<Disp> disp;
        public String categCombVeic;
    }

    public static class InfContratante
    {
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("CNPJ")
        public String CNPJ;
    }

    public static class InfANTT
    {
        @JsonProperty("RNTRC")
        public String RNTRC;
        public List<InfCIOT> infCIOT;
        public ValePed valePed;
        public List<InfContratante> infContratante;
        public InfPag infPag;
    }

    public static class InfPag
    {
        public String xNome; //String
		public String CPF; //String
		public String CNPJ; //String
		public String idEstrangeiro; //String
		public Comp Comp; //COMP
		public String vContrato; //String
		public String indAltoDesemp; //String
		public String indPag; //String
		public String vAdiant; //String
		public InfPrazo infPrazo; //InfPrazo
		public InfBanc infBanc; //InfBanc
    }

    public static class Comp 
    {
        public String tpComp; //String
		public String vComp; //String
		public String xComp; //String
    }

    public static class InfPrazo 
    {
        public String nParcela;
        public String dVenc;
        public String vParcela;    
    }

    public static class InfBanc 
    {
        public String codBanco; //String
		public String codAgencia; //String
		public String CNPJIPEF; //String
		public String PIX; //Sitrng
    }

    public static class Prop
    {
        @JsonProperty("CPF")
        public String cPF;
        @JsonProperty("CNPJ")
        public String cNPJ;
        @JsonProperty("RNTRC")
        public String rNTRC;
        public String xNome;
        @JsonProperty("IE")
        public String iE;
        @JsonProperty("UF")
        public String uF;
        public String tpProp;
    }

    public static class Condutor
    {
        public String xNome;
        @JsonProperty("CPF")
        public String CPF;
    }

    public static class VeicTracao
    {
        public String cInt;
        public String placa;
        @JsonProperty("RENAVAM")
        public String RENAVAM;
        public String tara;
        public String capKG;
        public String capM3;
        public Prop prop;
        public List<Condutor> condutor;
        public String tpRod;
        public String tpCar;
        @JsonProperty("UF")
        public String UF;
    }

    public static class VeicReboque
    {
        public String cInt;
        public String placa;
        @JsonProperty("RENAVAM")
        public String rENAVAM;
        public String tara;
        public String capKG;
        public String capM3;
        public Prop prop;
        public String tpCar;
        @JsonProperty("UF")
        public String uF;
    }

    public static class LacRodo
    {
        public String nLacre;
    }

    public static class Rodo
    {
        public InfANTT infANTT;
        public VeicTracao veicTracao;
        public List<VeicReboque> veicReboque;
        public String codAgPorto;
        public List<LacRodo> lacRodo;
    }

    public static class Aereo
    {
        public String nac;
        public String matr;
        public String nVoo;
        public String cAerEmb;
        public String cAerDes;
        public String dVoo;
    }

    public static class InfTermCarreg
    {
        public String cTermCarreg;
        public String xTermCarreg;
    }

    public static class InfTermDescarreg
    {
        public String cTermDescarreg;
        public String xTermDescarreg;
    }

    public static class InfEmbComb
    {
        public String cEmbComb;
        public String xBalsa;
    }

    public static class InfUnidCargaVazia
    {
        public String idUnidCargaVazia;
        public String tpUnidCargaVazia;
    }

    public static class InfUnidTranspVazia
    {
        public String idUnidTranspVazia;
        public String tpUnidTranspVazia;
    }

    public static class Aquav
    {
        public String irin;
        public String tpEmb;
        public String cEmbar;
        public String xEmbar;
        public String nViag;
        public String cPrtEmb;
        public String cPrtDest;
        public String prtTrans;
        public String tpNav;
        public List<InfTermCarreg> infTermCarreg;
        public List<InfTermDescarreg> infTermDescarreg;
        public List<InfEmbComb> infEmbComb;
        public List<InfUnidCargaVazia> infUnidCargaVazia;
        public List<InfUnidTranspVazia> infUnidTranspVazia;
    }

    public static class Trem
    {
        public String xPref;
        public String dhTrem;
        public String xOri;
        public String xDest;
        public String qVag;
    }

    public static class Vag
    {
        public String pesoBC;
        public String pesoR;
        public String tpVag;
        public String serie;
        public String nVag;
        public String nSeq;
        @JsonProperty("TU")
        public String tU;
    }

    public static class Ferrov
    {
        public Trem trem;
        public List<Vag> vag;
    }

    public static class InfModal
    {
        public Rodo rodo;
        public Aereo aereo;
        public Aquav aquav;
        public Ferrov ferrov;
        public String versaoModal;
    }

    public static class InfMDFe
    {
        public String versao;
        @JsonProperty("Id")
        public String id;
        public Ide ide;
        public Emit emit;
        public InfDoc infDoc;
        public List<Seg> seg;
        public Tot tot;
        public List<Lacre> lacres;
        public List<AutXML> autXML;
        public InfAdic infAdic;
        public InfModal infModal;
        public ProdPred prodPred;
    }

    public static class ProdPred
    {
        public String tpCarga;
        public String xProd;
        public String cEAN;
        public String NCM;
        public InfLotacao infLotacao;
    }

    public static class InfLotacao
    {
        public InfLocalCarrega infLocalCarrega;
        public InfLocalDescarrega infLocalDescarrega;
    }

    public static class InfLocalCarrega
    {
        public String CEP;
        public String latitude;
        public String longitude;
    }

    public static class InfLocalDescarrega
    {
        public String CEP;
        public String latitude;
        public String longitude;
    }

    public static class MDFe
    {
        public InfMDFe infMDFe;
    }
}

package br.eti.ns.nssuite.JSON.MDFe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class InfMunCarrega
{
    public String cMunCarrega;
    public String xMunCarrega;
}

class InfPercurso
{
    @JsonProperty("UFPer")
    public String uFPer;
}

class Ide
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
    public String uFIni;
    @JsonProperty("UFFim")
    public String uFFim;
    public List<InfMunCarrega> infMunCarrega;
    public List<InfPercurso> infPercurso;
    public String dhIniViagem;
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

class Emit {
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("IE")
    public String iE;
    public String xNome;
    public String xFant;
    public EnderEmit enderEmit;
}

class LacUnidTransp {
    public String nLacre;
}

class LacUnidCarga{
    public String nLacre;
}

class InfUnidCarga {
    public String tpUnidCarga;
    public String idUnidCarga;
    public List<LacUnidCarga> lacUnidCarga;
    public String qtdRat;
}

class InfUnidTransp {
    public String tpUnidTransp;
    public String idUnidTransp;
    public List<LacUnidTransp> lacUnidTransp;
    public List<InfUnidCarga> infUnidCarga;
    public String qtdRat;
}

class Peri {
    public String nONU;
    public String xNomeAE;
    public String xClaRisco;
    public String grEmb;
    public String qTotProd;
    public String qVolTipo;
}

class InfCTe {
    public String chCTe;
    @JsonProperty("SegCodBarra")
    public String segCodBarra;
    public String indReentrega;
    public List<InfUnidTransp> infUnidTransp;
    public List<Peri> peri;
}


class InfNFe
{
    public String chNFe;
    @JsonProperty("SegCodBarra")
    public String segCodBarra;
    public String indReentrega;
    public List<InfUnidTransp> infUnidTransp;
    public List<Peri> peri;
}

class InfMDFeTransp
{
    public String chMDFe;
    public String indReentrega;
    public List<InfUnidTransp> infUnidTransp;
    public List<Peri> peri;
}

class InfMunDescarga
{
    public String cMunDescarga;
    public String xMunDescarga;
    public List<InfCTe> infCTe;
    public List<InfNFe> infNFe;
    public List<InfMDFeTransp> infMDFeTransp;
}

class InfDoc
{
    public List<InfMunDescarga> infMunDescarga;
}

class InfResp
{
    public String respSeg;
    @JsonProperty("CNPJ")
    public String cNPJ;
    @JsonProperty("CPF")
    public String cPF;
}

class InfSeg
{
    public String xSeg;
    @JsonProperty("CNPJ")
    public String cNPJ;
}

class Seg
{
    public InfResp infResp;
    public InfSeg infSeg;
    public String nApol;
    public List<String> nAver;
}

class Tot
{
    public String qCTe;
    public String qNFe;
    public String qMDFe;
    public String vCarga;
    public String cUnid;
    public String qCarga;
}

class Lacre
{
    public String nLacre;
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

class InfCIOT
{
    @JsonProperty("CIOT")
    public String cIOT;
    @JsonProperty("CPF")
    public String cPF;
    @JsonProperty("CNPJ")
    public String cNPJ;
}

class Disp
{
    @JsonProperty("CNPJForn")
    public String cNPJForn;
    @JsonProperty("CNPJPg")
    public String cNPJPg;
    @JsonProperty("CPFPg")
    public String cPFPg;
    public String nCompra;
    public String vValePed;
}

class ValePed
{
    public List<Disp> disp;
}

class InfContratante
{
    @JsonProperty("CPF")
    public String cPF;
    @JsonProperty("CNPJ")
    public String cNPJ;
}

class InfANTT
{
    @JsonProperty("RNTRC")
    public String rNTRC;
    public List<InfCIOT> infCIOT;
    public ValePed valePed;
    public List<InfContratante> infContratante;
}

class Prop
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

class Condutor
{
    public String xNome;
    @JsonProperty("CPF")
    public String cPF;
}

class VeicTracao
{
    public String cInt;
    public String placa;
    @JsonProperty("RENAVAM")
    public String rENAVAM;
    public String tara;
    public String capKG;
    public String capM3;
    public Prop prop;
    public List<Condutor> condutor;
    public String tpRod;
    public String tpCar;
    @JsonProperty("UF")
    public String uF;
}

class VeicReboque
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

class LacRodo
{
    public String nLacre;
}

class Rodo
{
    public InfANTT infANTT;
    public VeicTracao veicTracao;
    public List<VeicReboque> veicReboque;
    public String codAgPorto;
    public List<LacRodo> lacRodo;
}

class Aereo
{
    public String nac;
    public String matr;
    public String nVoo;
    public String cAerEmb;
    public String cAerDes;
    public String dVoo;
}

class InfTermCarreg
{
    public String cTermCarreg;
    public String xTermCarreg;
}

class InfTermDescarreg
{
    public String cTermDescarreg;
    public String xTermDescarreg;
}

class InfEmbComb
{
    public String cEmbComb;
    public String xBalsa;
}

class InfUnidCargaVazia
{
    public String idUnidCargaVazia;
    public String tpUnidCargaVazia;
}

class InfUnidTranspVazia
{
    public String idUnidTranspVazia;
    public String tpUnidTranspVazia;
}

class Aquav
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

class Trem
{
    public String xPref;
    public String dhTrem;
    public String xOri;
    public String xDest;
    public String qVag;
}

class Vag
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

class Ferrov
{
    public Trem trem;
    public List<Vag> vag;
}

class InfModal
{
    public Rodo rodo;
    public Aereo aereo;
    public Aquav aquav;
    public Ferrov ferrov;
    public String versaoModal;
}

class InfMDFe
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
}

class MDFe
{
    public InfMDFe infMDFe;
}

class MDFeJSON
{
    @JsonProperty("MDFe")
    public MDFe mDFe;
}


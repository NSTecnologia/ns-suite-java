package br.eti.ns.nssuite.JSON.GTVe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GTVeJSON {
    @JsonProperty("GTVe")
    public GTVe GTVe;
    
    public static class GTVe{
        public String versao;
        public InfCTe infCTe;
    }

    public static class InfCTe {
        public String versao;
        public String Id;
        public Ide ide;
        public Compl compl;
        public Emit emit;
        public Rem rem;
        public Dest dest;
        public Origem origem;
        public Destino destino;
        public DetGTV detGTV;
        public AutXML autXML;
        public InfRespTec infRespTec;
        public InfCTeSupl infCTeSupl;
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
        public String verProc;
        public String cMunEnv;
        public String xMunEnv;
        public String UFEnv;
        public String modal;
        public String tpServ;
        public String indIEToma;
        public String dhSaidaOrig;
        public String dhChegadaDest;
        public Toma toma;
        public TomaTerceiro tomaTerceiro;
        public String dhCont;
        public String xJust;
    }

    public static class Toma {
        public String toma;
    }

    public static class TomaTerceiro {
        public String toma;
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String CPF;
        @JsonProperty("IE")
        public String IE;
        public String xNome;
        public String xFant;
        public String fone;
        public EnderToma enderToma;
    }

    public static class EnderToma {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairo;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP")
        public String CEP;
        @JsonProperty("UF")
        public String UF;
        public String cPais;
        public String xPais;
        public String email;
    }

    public static class Compl {
        public String xCaracAd;
        public String xCaracSer;
        public String xEmi;
        public String xObs;
        public OBSCont ObsCont;
        public OBSFisco ObsFisco;
    }

    public static class OBSCont {
        public String xCampo;
        public String xTexto;
    }

    public static class OBSFisco {
        public String xCampo;
        public String xTexto;
    }

    public static class Emit{
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("IE")
        public String IE;
        @JsonProperty("IEST")
        public String IEST;
        public String xNome;
        public String xFant;
        public EnderEmit enderEmit;
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

    public static class Rem {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String CPF;
        @JsonProperty("IE")
        public String IE;
        public String xNome;
        public String xFant;
        public String fone;
        public String email;
        public EnderReme enderReme;
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

    public static class Dest {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String CPF;
        @JsonProperty("IE")
        public String IE;
        public String xNome;
        public String fone;
        @JsonProperty("ISUF")
        public String ISFU;
        public String email;
        public EnderDest enderDest;
    }

    public static class EnderDest {
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

    public static class Origem {
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

    public static class Destino {
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

    public static class DetGTV {
        public InfEspecie infEspecie;
        public String qCarga;
        public InfVeiculo infVeiculo;
    }

    public static class AutXML {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String CPF;
    }

    public static class InfEspecie {
        public String tpEspecie;
        public String vEspecie;
        public String tpNumerario;
        public String xMoedaEstr;
    }

    public static class InfVeiculo {
        public String placa;
        @JsonProperty("UF")
        public String UF;
        @JsonProperty("RNTRC")
        public String RNTRC;
    }

    public static class AuXMl {
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF")
        public String CPF;
    }

    public static class InfRespTec {
        @JsonProperty("CNPJ")
        public String CNPJ;
        public String xContato;
        public String email;
        public String fone;
        public String idCSRT;
        public String hashCSRT;
    }

    public static class InfCTeSupl {
        public String qrCodCTe;
    }
}
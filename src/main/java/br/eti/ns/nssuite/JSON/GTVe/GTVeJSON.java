package br.eti.ns.nssuite.JSON.GTVe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GTVeJSON {
    @JsonProperty("GTVe")
    public Gtve GTVe;
    
    public Class Gtve{
        public String versao;
        public InfCTe infCTe;
    }

    public class InfCTe {
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

    public Class Ide {
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
        public Toma toma
        public TomaTerceiro tomaTerceiro;
        public String dhCont;
        public String xJust;
    }

    public Class Toma {
        public String toma;
    }

    public Class TomaTerceiro {
        public String toma;
        @JsonProperty("CNPJ")
        public String CNPJ;
        @JsonProperty("CPF");
        public String CPF;
        @JsonProperty("IE");
        public String IE;
        public String xNome;
        public String xFant;
        public String fone;
        public EnderToma enderToma;
    }

    public Class EnderToma {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairo;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String cPais;
        public String xPais;
        public String email;
    }

    public Class Compl {
        public String xCaracAd;
        public String xCaracSer;
        public String xEmi;
        public String xObs;
        public OBSCont ObsCont;
        public OBSFisco ObsFisco;
    }

    public Class OBSCont {
        public String xCampo;
        public String xTexto;
    }

    public Class OBSFisco {
        public String xCampo;
        public String xTexto;
    }

    public Class Emit {
        @JsonProperty("CNPJ");
        public String CNPJ;
        @JsonProperty("IE");
        public String IE;
        @JsonProperty("IEST");
        public String IEST;
        public String xNome;
        public String xFant;
        public EnderEmit enderEmit;
    }

    public Class EnderEmit {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String fone;
    }

    public Class Rem {
        @JsonProperty("CNPJ");
        public String CNPJ;
        @JsonProperty("CPF");
        public String CPF;
        @JsonProperty("IE");
        public String IE;
        public String xNome;
        public String xFant;
        public String fone;
        public String email;
        public EnderReme enderReme;
    }

    public Class EnderReme {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String cPais;
        public String xPais;
    }

    public Class Dest {
        @JsonProperty("CNPJ");
        public String CNPJ;
        @JsonProperty("CPF");
        public String CPF;
        @JsonProperty("IE");
        public String IE;
        public String xNome;
        public String fone;
        @JsonProperty("ISUF")
        public String ISFU;
        public String email;
        public EnderDest enderDest;
    }

    public Class EnderDest {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String cPais;
        public String xPais;
    }

    public Class Origem {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String fone;
    }

    public Class Destino {
        public String xLgr;
        public String nro;
        public String xCpl;
        public String xBairro;
        public String cMun;
        public String xMun;
        @JsonProperty("CEP");
        public String CEP;
        @JsonProperty("UF");
        public String UF;
        public String fone;
    }

    public Class DetGTV {
        public InfEspecie infEspecie;
        public String qCarga;
        public InfVeiculo infVeiculo;
    }

    public Class InfEspecie {
        public String tpEspecie;
        public String vEspecie;
        public String tpNumerario;
        public String xMoedaEstr
    }

    public Class InfVeiculo {
        public String placa;
        @JsonProperty("UF");
        public String UF;
        @JsonProperty("RNTRC");
        public String RNTRC;
    }

    public Class AuXMl {
        @JsonProperty("CNPJ");
        public String CNPJ;
        @JsonProperty("CPF");
        public String CPF;
    }

    public Class InfRespTec {
        @JsonProperty("CNPJ")
        public String CNPJ;
        public String xContato;
        public String email;
        public String fone;
        public String idCSRT;
        public String hashCSRT;
    }
    
    public Class InfCTeSupl {
        public String qrCodCTe;
    }
}
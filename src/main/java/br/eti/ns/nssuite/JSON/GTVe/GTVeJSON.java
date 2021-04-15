package br.eti.ns.nssuite.JSON.GTVe;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class GTVeJSON {
    public String versao;
    @JsonProperty("GTVe")
    public InfCTe infCTe;
    
    public class InfCTe {
        public String versao;
        public Ide ide;
        public Emit emit;
        public Rem rem;
        public Dest dest;
        public DetGTV detGTV;
    }

    public class Ide {
        public 
    }
}
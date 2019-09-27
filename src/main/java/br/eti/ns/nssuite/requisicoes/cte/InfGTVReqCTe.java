package br.eti.ns.nssuite.requisicoes.cte;

import java.util.ArrayList;

public class InfGTVReqCTe {
    public String chCTe;
    public String tpAmb;
    public String dhEvento;
    public String nSeqEvento;
    public ArrayList<InfGTV> infGTV;


    public static class InfGTV{
        public String nDoc;
        public String id;
        public String serie;
        public String subserie;
        public String dEmi;
        public String nDV;
        public String qCarga;
        public String placa;
        public String UF;
        public String RNTRC;
        public ArrayList<InfEspecie> infEspecie;
        public Rem rem;
        public Dest dest;
    }

    public static class InfEspecie{
        public String tpEspecie;
        public String vEspecie;
    }

    public static class Rem{
        public String CNPJ;
        public String CPF;
        public String IE;
        public String UF;
        public String xNome;
    }

    public static class Dest{
        public String CNPJ;
        public String CPF;
        public String IE;
        public String UF;
        public String xNome;
    }
}

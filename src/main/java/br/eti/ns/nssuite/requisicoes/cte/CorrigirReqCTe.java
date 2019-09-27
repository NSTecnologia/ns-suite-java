package br.eti.ns.nssuite.requisicoes.cte;

public class CorrigirReqCTe {
    public String chCTe;
    public InfCorrecao infCorrecao;

    public static class InfCorrecao{
        public String grupoAlterado;
        public String campoAlterado;
        public String valorAlterado;
        public String nroItemAlterado;
    }
}


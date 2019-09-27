package br.eti.ns.nssuite.compartilhados;

public class Endpoints {

    public String BPeEnvio = "https://bpe.ns.eti.br/v1/bpe/issue";
    public String BPeConsStatusProcessamento  = "https://bpe.ns.eti.br/v1/bpe/issue/status";
    public String BPeDownload  = "https://bpe.ns.eti.br/v1/bpe/get";
    public String BPeDownloadEvento  = "https://bpe.ns.eti.br/v1/bpe/get/event";
    public String BPeCancelamento  = "https://bpe.ns.eti.br/v1/bpe/cancel";
    public String BPeNaoEmb  = "https://bpe.ns.eti.br/v1/bpe/naoemb";
    public String BPeConsSit  = "https://bpe.ns.eti.br/v1/bpe/status";

    // CT-e
    public String CTeEnvio  = "https://cte.ns.eti.br/cte/issue";
    public String CTeOSEnvio  = "https://cte.ns.eti.br/cte/issueos";
    public String CTeConsStatusProcessamento  = "https://cte.ns.eti.br/cte/issueStatus/300";
    public String CTeDownload  = "https://cte.ns.eti.br/cte/get/300";
    public String CTeDownloadEvento  = "https://cte.ns.eti.br/cte/get/event/300";
    public String CTeCancelamento  = "https://cte.ns.eti.br/cte/cancel/300";
    public String CTeCCe  = "https://cte.ns.eti.br/cte/cce/300";
    public String CTeConsCad  = "https://cte.ns.eti.br/util/conscad";
    public String CTeConsSit  = "https://cte.ns.eti.br/cte/stats/300";
    public String CTeInfGTV  = "https://cte.ns.eti.br/cte/gtv";
    public String CTeInutilizacao  = "https://cte.ns.eti.br/cte/inut";
    public String CTeListarNSNRecs  = "https://cte.ns.eti.br/util/list/nsnrecs";

    // DDF-e
    public String DDFeDesacordo  = "https://ddfe.ns.eti.br/events/cte/disagree";
    public String DDFeDownloadUnico  = "https://ddfe.ns.eti.br/dfe/unique";
    public String DDFeDownloadLote  = "https://ddfe.ns.eti.br/dfe/bunch";
    public String DDFeManifestacao  = "https://ddfe.ns.eti.br/events/manif";

    // MDF-e
    public String MDFeEnvio  = "https://mdfe.ns.eti.br/mdfe/issue";
    public String MDFeConsStatusProcessamento  = "https://mdfe.ns.eti.br/mdfe/issue/status";
    public String MDFeDownload  = "https://mdfe.ns.eti.br/mdfe/get";
    public String MDFeDownloadEvento  = "https://mdfe.ns.eti.br/mdfe/get/event";
    public String MDFeCancelamento  = "https://mdfe.ns.eti.br/mdfe/cancel";
    public String MDFeEncerramento  = "https://mdfe.ns.eti.br/mdfe/closure";
    public String MDFeIncCondutor  = "https://mdfe.ns.eti.br/mdfe/adddriver";
    public String MDFeConsNaoEncerrados  = "https://mdfe.ns.eti.br/util/consnotclosed";
    public String MDFeConsSit  = "https://mdfe.ns.eti.br/mdfe/stats";
    public String MDFePrevia  = "https://mdfe.ns.eti.br/util/preview/mdfe";
    public String MDFeListarNSNRecs  = "https://mdfe.ns.eti.br/util/list/nsnrecs";

    // NFC-e
    public String NFCeEnvio  = "https://nfce.ns.eti.br/v1/nfce/issue";
    public String NFCeDownload  = "https://nfce.ns.eti.br/v1/nfce/get";
    public String NFCeCancelamento  = "https://nfce.ns.eti.br/v1/nfce/cancel";
    public String NFCeConsSit  = "https://nfce.ns.eti.br/v1/nfce/status";
    public String NFCeEnvioEmail  = "https://nfce.ns.eti.br/v1/util/resendemail";
    public String NFCeInutilizacao  = "https://nfce.ns.eti.br/v1/nfce/inut";

    // NF-e
    public String NFeEnvio  = "https://nfe.ns.eti.br/nfe/issue";
    public String NFeConsStatusProcessamento  = "https://nfe.ns.eti.br/nfe/issue/status";
    public String NFeDownload  = "https://nfe.ns.eti.br/nfe/get";
    public String NFeDownloadEvento  = "https://nfe.ns.eti.br/nfe/get/event";
    public String NFeCancelamento  = "https://nfe.ns.eti.br/nfe/cancel";
    public String NFeCCe  = "https://nfe.ns.eti.br/nfe/cce";
    public String NFeConsStatusSefaz  = "https://nfe.ns.eti.br/util/wssefazstatus";
    public String NFeConsCad  = "https://nfe.ns.eti.br/util/conscad";
    public String NFeConsSit  = "https://nfe.ns.eti.br/nfe/stats";
    public String NFeEnvioEmail  = "https://nfe.ns.eti.br/util/resendemail";
    public String NFeInutilizacao  = "https://nfe.ns.eti.br/nfe/inut";
    public String NFeListarNSNRecs  = "https://nfe.ns.eti.br/util/list/nsnrecs";
    public String NFePrevia  = "https://nfe.ns.eti.br/util/preview/nfe";

}

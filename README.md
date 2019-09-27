# NSSuiteJava

Utilizando a NS API, este exemplo - criado em Java - possui funcionalidades para consumir documentos fiscais eletrônicos em geral, como por exemplo: 
+ NFe; 
+ CTe; 
+ NFCe;
+ MDFe;
+ BPe;

Simplificando todos os projetos utilizados em um único exemplo, deixando mais pratica e facil a integração com a NS API.

## Primeiros passos:
### Integrando ao sistema:

Para utilizar as funções de comunicação com a API, você precisa realizar os seguintes passos:

1. Extraia o conteúdo da pasta compactada que você baixou;
2. Copie para sua aplicação a pasta src, na qual contem todos as classes que serão utilizadas;
3. Abra o seu projeto e importe a pasta copiada.
4. A aplicação utiliza as bibliotecas <strong>jersey-client</strong> e <strong>jackson-databind</strong> para realizar a comunicação com a API e fazer a manipulação de dados JSON, respectivamente. Ative as duas referencias em seu projeto, como mostrado abaixo:

![dependency](https://confluence.ns.eti.br/download/attachments/25690610/image2019-3-18%208%3A24%3A8.png?version=1&modificationDate=1552908140508&api=v2)

<strong>Pronto!</strong> Agora, você já pode consumir a NS Suite API através do seu sistema. Todas as funcionalidades de comunicação foram implementadas na classe NSSuite.java.

------

## Emissão Sincrona:

### Realizando uma Emissão Sincrona:

Para realizar uma emissão completa de uma NFe (utilizada para exemplo), você poderá utilizar a função emitirNFeSincrono da classe NSSuite. Veja abaixo sobre os parâmetros necessários, e um exemplo de chamada do método.

##### Parametros:

<strong>ATENÇÃO:</strong> o <strong>token</strong> também é um parâmetro necessário e você deve, primeiramente, defini-lo na classe <strong>NSSuite.java</strong>, como pode ver abaixo:
![dependency](https://confluence.ns.eti.br/download/attachments/25690625/image2019-3-18%208%3A27%3A54.png?version=1&modificationDate=1552909202040&api=v2)

Parametros     | Descrição
:-------------:|:-----------
conteudo       | Conteúdo de emissão do documento.
tpConteudo     | Tipo de conteúdo que está sendo enviado. Valores possíveis: json, xml, txt
CNPJ           | CNPJ do emitente do documento.
tpDown         | Tipo de arquivos a serem baixados.Valores possíveis: *( X - XML // J - JSON // P - PDF // XP - XML e PDF // JP - JSON e PDF)*
tpAmb          | Ambiente onde foi autorizado o documento.Valores possíveis: *(1 - produção // 2 - homologação)*
caminho        | Caminho onde devem ser salvos os documentos baixados.
exibeNaTela    |Se for baixado, exibir o PDF na tela após a autorização.Valores possíveis: (*True - será exibido  // False - não será exibido*) 

##### Exemplo de chamada:

Após ter todos os parâmetros listados acima, você deverá fazer a chamada da função. Veja o código de exemplo abaixo:
           
    String retorno = NSSuite.emitirNFeSincrono(conteudo, tpConteudo, cnpjEmit, tpDown, tpAmb, caminho, exibeNaTela)
    
    JOptionPane.showMessageDialog(null, retorno);

A função emitirNFeSincrono fará o envio, a consulta e download do documento, utilizando as funções emitirDocumento, consultarStatusProcessamento e downloadDocumentoESalvar, presentes na classe NSSuite.java. Por isso, o retorno será um JSON com os principais campos retornados pelos métodos citados anteriormente. No exemplo abaixo, veja como tratar o retorno da função emitirNFeSincrono:

##### Exemplo de tratamento de retorno:

O JSON retornado pelo método terá os seguintes campos: statusEnvio, statusConsulta, statusDownload, cStat, chNFe, nProt, motivo, nsNRec, erros. Veja o exemplo abaixo:

    {
        "statusEnvio": "200",
        "statusConsulta": "200",
        "statusDownload": "200",
        "cStat": "100",
        "chNFe": "43181007364617000135550000000119741004621864",
        "nProt": "143180007036833",
        "motivo": "Autorizado o uso da NF-e",
        "nsNRec": "313022",
        "erros": ""
    }
      
Confira um código para tratamento do retorno, no qual pegará as informações dispostas no JSON de Retorno disponibilizado:


    ObjectMapper objectMapper = new ObjectMapper();
    String retorno = NSSuite.emitirNFeSincrono(conteudo,"json", "07364617000135", "XP", "2", "./Notas", true);
    JsonNode respostaJSON = objectMapper.readTree(retorno);
    String statusEnvio = respostaJSON.get("statusEnvio").asText();
    String statusConsulta = respostaJSON.get("statusConsulta").asText();
    String statusDownload = respostaJSON.get("statusDownload").asText();
    String cStat = respostaJSON.get("cStat").asText();
    String chNFe = respostaJSON.get("chNFe").asText();
    String nProt = respostaJSON.get("nProt").asText();
    String motivo = respostaJSON.get("motivo").asText();
    String nsNRec = respostaJSON.get("nsNRec").asText();
    ArrayList<String> erros = objectMapper.readValue(respostaJSON.get("erros").toString(), new TypeReference<ArrayList<String>>(){});
    if (statusEnvio.equals("200") || statusEnvio.equals("-6")){
        if (statusConsulta.equals("200")){
            if (cStat.equals("100")){
                JOptionPane.showMessageDialog(null, motivo);
                if (!statusDownload.equals("200")){
                    JOptionPane.showMessageDialog(null, "Erro Downlaod");
                }
            }else{
                JOptionPane.showMessageDialog(null, motivo);
            }
        }else{
            JOptionPane.showMessageDialog(null, motivo + "\n" + erros.toString());
        }
    }else{
        JOptionPane.showMessageDialog(null, motivo + "\n" + erros.toString());
    }      
      
      
      
  

## Documentação:




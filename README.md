# NSSuiteJava

This is an example of how to communicate with the NSTechnology BPe API. Developed in Java, it aims to exemplify and facilitate the development of integration.

## First Steps:

### Integrating with the system:


To use the functions of communicating with the API, you need to perform the following steps:

1. Extract the contents of the compressed folder you downloaded;
2. Copy the src folder to your application, which contains all the classes that will be used;
3. Open your project and import the copied folder.
4. The application uses the **jersey-client** and **jackson-databind** libraries to communicate with the API and manipulate JSON data, respectively. Activate these two references in your project too.

**Done!** Now, you can now consume the NS Suite API through your application. All communication features were implemented in the **NSSuite.java** class.

------

## Synchronous Issue process:

### Realizando uma Emissão Sincrona:

Para realizar uma emissão completa de uma NFe (utilizada para exemplo), você poderá utilizar a função emitirNFeSincrono da classe NSSuite. Veja abaixo sobre os parâmetros necessários, e um exemplo de chamada do método.

##### Parâmetros:

**ATENÇÃO:** o **token** também é um parâmetro necessário e você deve, primeiramente, defini-lo na classe **NSSuite.java**, como pode ver abaixo:


Parametros     | Descrição
:-------------:|:-----------
conteudo       | Conteúdo de emissão do documento.
tpConteudo     | Tipo de conteúdo que está sendo enviado. Valores possíveis: json, xml, txt
CNPJ           | CNPJ do emitente do documento.
tpDown         | Tipo de arquivos a serem baixados.Valores possíveis: <ul> <li>**X** - XML</li> <li>**J** - JSON</li> <li>**P** - PDF</li> <li>**XP** - XML e PDF</li> <li>**JP** - JSON e PDF</li> </ul> 
tpAmb          | Ambiente onde foi autorizado o documento.Valores possíveis:<ul> <li>1 - produção</li> <li>2 - homologação</li> </ul>
caminho        | Caminho onde devem ser salvos os documentos baixados.
exibeNaTela    | Se for baixado, exibir o PDF na tela após a autorização.Valores possíveis: <ul> <li>**True** - será exibido</li> <li>**False** - não será exibido</li> </ul> 

##### Exemplo de chamada:

Após ter todos os parâmetros listados acima, você deverá fazer a chamada da função. Veja o código de exemplo abaixo:
           
    String retorno = NSSuite.emitirBPeSincrono(conteudo, tpConteudo, cnpjEmit, tpDown, tpAmb, caminho, exibeNaTela)
    
    JOptionPane.showMessageDialog(null, retorno);

A função emitirNFeSincrono fará o envio, a consulta e download do documento, utilizando as funções emitirDocumento, consultarStatusProcessamento e downloadDocumentoESalvar, presentes na classe **NSSuite.java**. Por isso, o retorno será um JSON com os principais campos retornados pelos métodos citados anteriormente. No exemplo abaixo, veja como tratar o retorno da função emitirNFeSincrono:

##### Exemplo de tratamento de retorno:

O JSON retornado pelo método terá os seguintes campos: statusEnvio, statusConsulta, statusDownload, cStat, chNBpe, nProt, motivo, nsNRec, erros. Veja o exemplo abaixo:

    {
        "statusEnvio": "200",
        "statusConsulta": "200",
        "statusDownload": "200",
        "cStat": "100",
        "chBPe": "43181007364617000135550000000119741004621864",
        "nProt": "143180007036833",
        "motivo": "Autorizado o uso do BP-e",
        "nsNRec": "313022",
        "erros": ""
    }
      
Confira um código para tratamento do retorno, no qual obterá as informações dispostas no JSON de Retorno disponibilizado:


    ObjectMapper objectMapper = new ObjectMapper();
    String retorno = NSSuite.emitirBPeSincrono(conteudo,"json", "07364617000135", "XP", "2", "./BPe", true);
    JsonNode respostaJSON = objectMapper.readTree(retorno);
    String statusEnvio = respostaJSON.get("statusEnvio").asText();
    String statusConsulta = respostaJSON.get("statusConsulta").asText();
    String statusDownload = respostaJSON.get("statusDownload").asText();
    String cStat = respostaJSON.get("cStat").asText();
    String chBPe = respostaJSON.get("chBPe").asText();
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

-----

![Ns](https://nstecnologia.com.br/blog/wp-content/uploads/2018/11/ns%C2%B4tecnologia.png) | Obrigado pela atenção!

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

  public List<Conteudo> extraiConteudos(String json) {

    JsonParser parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();
    
    for (Map<String, String> atributos : listaDeAtributos) {

      String copyright = atributos.get("copyright");
      String urlImagem = atributos.get("url");
      var conteudo = new Conteudo(copyright, urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
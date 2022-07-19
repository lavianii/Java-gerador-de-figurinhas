import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        try {

            // acessando a url fazendo a conexao HTTP
            String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
            URI endereco = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();

            // extrair só os dados que interessam(titulo, imagem, classificacao)
            var parser = new JsonParser();
            List<Map<String, String>> listaDeFilmes = parser.parse(body);

            // exibir e manipular os dados
            for (Map<String, String> filme : listaDeFilmes) {

                String urlImagem = filme.get("image");
                String titulo = filme.get("title");
                
                InputStream inputStream = new URL(urlImagem).openStream();
                String nomeArquivo = titulo + ".png";

                GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
                geradora.cria(inputStream, nomeArquivo);
                
                System.out.println(titulo);
                System.out.println();

            }
        } catch (Exception e) {
        } // Não vai dar erro

    }
}

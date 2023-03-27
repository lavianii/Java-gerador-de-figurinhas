import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        String urlNasa = "https://imersao-java-apis.s3.amazonaws.com/NASA-APOD_1_url.jpg";

        ClienteHttp http = new ClienteHttp();
        String jsonNasa = http.buscaDados(urlNasa);

        ExtratorDeConteudo extratorDaNasa = new ExtratorDeConteudoDaNasa();
        List<Conteudo> conteudosNasa = extratorDaNasa.extraiConteudos(jsonNasa);

        for (Conteudo conteudo : conteudosNasa) {
            
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getUrlImagem() + ".png";

            GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
        }

    }
}

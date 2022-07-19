import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) {

        try {
            // leitura da imagem
     
            // InputStream inputStream = new FileInputStream(new File("entrada/filme-maior.jpg"));
            // InputStream inputStream = 
            //                     new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
            // .openStream();

            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // cria nova imagem em memoria com transparencia e com tamanho novo
     
            int altura = imagemOriginal.getHeight();
            int largura = imagemOriginal.getWidth();
            int novaAltura = altura + 200;
            BufferedImage novaImagem = new BufferedImage(largura,
                                                         novaAltura,
                                                         BufferedImage.TRANSLUCENT);

            // copiar a imagem original para nova imagem (em memoria)
     
            Graphics2D caneta = (Graphics2D) novaImagem.getGraphics();
            caneta.drawImage(imagemOriginal, 0, 0, null);

            // configurar a fonte
     
            Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
            caneta.setFont(fonte);
            caneta.setColor(Color.ORANGE);

            // escrever uma farse na nova imagem
     
            caneta.drawString("TESTE",215,novaAltura - 100);

            // escrever a nova imagem em um arquivo
     
            ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        } catch (Exception e) {
            e.getMessage();
        }

    }


}

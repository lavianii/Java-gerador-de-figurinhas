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
  
            BufferedImage imagemOriginal = ImageIO.read(inputStream);

            // cria nova imagem em memoria com transparencia e com tamanho novo
            int altura = imagemOriginal.getHeight();// pega a altura da imagem
            int largura = imagemOriginal.getWidth();// pega a largura da imagem
            int novaAltura = altura + 200; // deixa a altura maior
            BufferedImage novaImagem = new BufferedImage(largura,
                    novaAltura, BufferedImage.TRANSLUCENT); // deixa a segunda imagem transparente

            // copiar a imagem original para nova imagem (em memoria)

            Graphics2D caneta = (Graphics2D) novaImagem.getGraphics();
            caneta.drawImage(imagemOriginal, 0, 0, null);

            // configurar a fonte

            Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64); // tipo da fonte, modelo da fonte, tamanho da fonte
            caneta.setFont(fonte);// atribui oq foi alterado na fonte
            caneta.setColor(Color.ORANGE);// muda a cor da fonte

            // escrever uma frase na nova imagem

            caneta.drawString("TESTE", 215, novaAltura - 100);// escreve na imagem, centraliza a frase, posiciona a frase

            // escrever a nova imagem em um arquivo

            ImageIO.write(novaImagem, "png", new File("saida/"+ nomeArquivo));// faz com que apareca o que foi escrito na imagem

        } catch (Exception e) {
            e.getMessage();
        }

    }

}

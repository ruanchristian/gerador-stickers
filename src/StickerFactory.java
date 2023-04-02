import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerFactory {
    private String text;
    private File file = new File("output");

    public StickerFactory(String text) {
        this.text = text.toUpperCase();
    }

    public void create(InputStream inputStream, String fileName) {
        System.out.println("Criando sticker...");

        try {
            // Ler imagem original
            BufferedImage sourceImg = ImageIO.read(inputStream);

            // Criação de uma nova imagem a partir da original, com altura aumentada
            int newHeight = sourceImg.getHeight() + 250;
            int width = sourceImg.getWidth();
            BufferedImage newImg = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

            // Copiar imagem original para nova imagem
            Graphics2D graphics = (Graphics2D) newImg.getGraphics();
            graphics.drawImage(sourceImg, 0, 0, null);

            // Configuração da fonte
            Font fonte = new Font(Font.SERIF, Font.BOLD, 70);
            graphics.setColor(Color.YELLOW);
            graphics.setFont(fonte);
            Rectangle2D rectangle = graphics.getFontMetrics().getStringBounds(this.text, graphics);
            graphics.drawString(this.text, (width - (int) rectangle.getWidth()) / 2, newHeight - 80);

            // Escrever a nova imagem em um arquivo
            if(!file.exists()) file.mkdir();
            ImageIO.write(newImg, "png", new File("output/" + fileName));

            System.out.println("\u001b[38;2;255;255;255m \u001b[48;2;42;122;228m " + fileName + " \u001b[m foi criado com sucesso! \u2705");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

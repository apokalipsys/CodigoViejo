

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
 
public class Xporter {
    static void save(Component comp, File file) throws IOException
    {
        BufferedImage image = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        comp.paint(g);
        g.dispose();
        ImageIO.write(image, "jpeg", new File(file.toString()+".jpg"));
        image.flush();
    }
}   
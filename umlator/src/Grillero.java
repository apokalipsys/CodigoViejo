
/**
 * Clase que maneja las grillas
 * 
 * @author BOo
 * @version 0.1
 */

import java.awt.*;
import java.awt.geom.*;

public class Grillero
{
    private static int size = 40; 
    private static Color plomito = new Color(218,218,218);
    /**
     * Dibuja una grilla de lineas continuas
     *
     * @param  g2 Graphics2D para dibujar
     * @param  X   Coordenada X desde donde se comienza a dibujar
     * @param  Y   Coordenada Y desde donde se comienza a dibujar
     * @param  W   limite derecho
     * @param  H   limite inferior
     */
    public static void grillaLinea(Graphics2D g2, int X, int Y, int W, int H)
    {
        g2.setColor(plomito); 
        for(int i = Y; i<= H; i++)
        {
              int y = Y + i * size; 
              g2.draw(new Linea2D(X,y,X+W,y));
        }
            for(int j = X; j<= W; j++)
            {
                int x = X + j * size;
                
                g2.draw(new Linea2D(x,Y,x, Y+H));
            }
        g2.setColor(Color.black);
    }
 
 
 

}

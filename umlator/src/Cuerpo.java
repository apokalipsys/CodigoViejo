
/**
 * Un cuerpo para nuestro monito
 * 
 * @author BOo
 * @version 0.1
 */
import java.awt.*;
import java.awt.geom.*;

public class Cuerpo implements Shape
{
    Polygon brazos, cuerpo, pierna1, pierna2;
    int x, y, ancho, alto;

    /**
     * Crea un cuerpo especificando el punto (x,y) inicial, y el (ancho,alto) requerido.
     *           (x,y)      _ 
     *               |  |   |  
     *               | -|-  |   alto
     *               | /\   |
     *               |------|
     *                ancho
     * @param X coordenada X inicial
     * @param Y coordenada Y inicial
     * @param Ancho el ancho del objeto
     * @param Alto el alto del objeto                
     */
    public Cuerpo(int X, int Y, int Ancho, int Alto)
    {
        x = X;
        y = Y;
        ancho = Ancho;
        alto = Alto;
        brazos = new Polygon();
        brazos.addPoint(x,y+alto/4);
        brazos.addPoint(x+ancho,y+alto/4);
        cuerpo = new Polygon();
        cuerpo.addPoint(x + (ancho/2),y);
        cuerpo.addPoint(x + (ancho/2),y+ (alto/2));
        pierna1 = new Polygon();
        pierna1.addPoint(x + (ancho/2),y + (alto/2));
        pierna1.addPoint(x, y + alto);
        pierna2 = new Polygon();
        pierna2.addPoint(x + ancho, y + alto);
        pierna2.addPoint(x + (ancho/2),y + (alto/2));
    }
    
    /**
     * Dibujar el Cuerpo en el Graphics especificado.
     * 
     * @param  g el objeto Graphics en el que se dibujara.
     */
    public void dibujar(Graphics g)
    {
        Graphics2D gr2 = (Graphics2D)g;
        dibujar(gr2);   
    }
    
    /**
     * Dibujar el Cuerpo en el Graphics2D especificado.
     * 
     * @param  g2d  el objeto Graphics2D en el que se dibujara.
     */
    public void dibujar(Graphics2D g2d)
    {
        g2d.setColor(Color.white);
	    g2d.fill(getBounds2D());
	    g2d.setColor(Color.black);
        g2d.draw(brazos);
        g2d.draw(cuerpo);
        g2d.draw(pierna1);
        g2d.draw(pierna2);
    }
    
    public boolean contains(double X, double Y)
     {
         return (X<=x+ancho && X>=x && Y<=y+alto && Y>= y); 
     }
     public boolean contains(double X, double Y, double w, double h)
     {
         return contains(X,Y) && contains(X+w, Y+h);
     }
     public boolean contains(Point2D p)
     {
         return contains(p.getX(),p.getY());    
     }
     public boolean contains(Rectangle2D r)
     {
         return contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());    
     }
     public Rectangle getBounds()
     {
         return new Rectangle(x,y,ancho,alto);    
     }
     public Rectangle2D getBounds2D()
     {
         return new Rectangle2D.Double(x,y,ancho,alto);    
     }
     public PathIterator getPathIterator(AffineTransform at)
     {
         return getBounds().getPathIterator(at);    
     }
     public PathIterator getPathIterator(AffineTransform at, double flatness)
     {
         return getBounds().getPathIterator(at,flatness);    
     }
     public boolean intersects(double X, double Y, double w, double h)
     {
         return contains(X,Y) || contains(x+w,y+h) || contains(x,y+h) || contains(x+w,y);    
     }
     public boolean intersects(Rectangle2D r)
     {
         return intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight());      
     }
}

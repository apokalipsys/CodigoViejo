
/**
 * Dibujar un objeto Cadena
 * 
 * @author BOo 
 * @version 0.2
 */
import java.awt.*;
import java.awt.geom.*;

public class Cadena implements Shape
{
    String laCadena = "";
    Font laFuente;
    Rectangle2D limite;
    Graphics g;
    int x,y;
	/**
	 * Construye un objeto Cadena.
	 * 
	 * @param cadena la cadena que corresponde al objeto
	 * @param fuente la fuente que se utiliza para la cadena
	 * @param gr el objeto Graphics relacionado a la cadena
	 * 
	 */
	public Cadena(String cadena, int X, int Y, Font fuente, Graphics gr)
	{
		laCadena = cadena;
		laFuente = fuente;
		g = gr;
		limite = gr.getFontMetrics(fuente).getStringBounds(laCadena,g);
		x = X;
		y = Y;
	}
	
	/**
	 * Dibujar el Cadena.
	 * 
	 * @param  gr	el objeto Graphics en el que se dibujara.
	 */
	public void dibujar(Graphics gr)
	{
	    cambiaGraphics(gr);
	    Graphics2D gd2 = (Graphics2D)g;
	    dibujar(gd2);
  	}
	
	/**
	 * Dibujar el Cadena.
	 * 
	 */
	public void dibujar()
	{
	    Graphics2D gd2 = (Graphics2D)g;
	    dibujar(gd2);
	}
	
	public void dibujar(Graphics2D g2)
	{
	    g2.drawString(laCadena, x, y );
	}
	
	public void cambiaGraphics(Graphics gr)
	{
	    g = gr;
	    limite = limite = gr.getFontMetrics(laFuente).getStringBounds(laCadena,g);
	}

	public void setX(int X)
	{
	    x = X;
	}
	
	public void setY(int Y)
	{
	    y = Y;
	}
	
	public int getX()
	{
	    return x;
	}
	
	public int getY()
	{
	    return y;
	}
	
	public void setFrame(Rectangle2D r)
	{
	    limite.setFrame(r);
	    y = (int) r.getY();
	    x = (int) r.getX();
	}
	 public boolean contains(double x, double y)
	 {
	     return limite.contains(x,y); 
     }
     public boolean contains(double x, double y, double w, double h)
     {
         return limite.contains(x,y,w,h);
     }
     public boolean contains(Point2D p)
     {
         return limite.contains(p);    
     }
     public boolean contains(Rectangle2D r)
     {
         return limite.contains(r);    
     }
     public Rectangle getBounds()
     {
         return limite.getBounds();    
     }
     public Rectangle2D getBounds2D()
     {
         return limite.getBounds2D();    
     }
     public PathIterator getPathIterator(AffineTransform at)
     {
         return limite.getPathIterator(at);    
     }
     public PathIterator getPathIterator(AffineTransform at, double flatness)
     {
         return limite.getPathIterator(at,flatness);    
     }
     public boolean intersects(double x, double y, double w, double h)
     {
         return limite.intersects(x,y,w,h);    
     }
     public boolean intersects(Rectangle2D r)
     {
         return limite.intersects(r);    
     }
}
	

/**
 * Dibujar un objeto Entidad
 * 
 * @author BOo 
 * @version 0.2
 */
import java.awt.*;
import java.awt.geom.*;

public class Entidad extends Ovulo2D implements Shape
{
	/**
	 * Calcula y contruye un objeto Entidad, especificando las coordenadas iniciales, el ancho y 
	 * el alto.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Entidad(int x1, int y1, int ancho, int alto )
	{
		super((double)x1,(double)y1,(double)ancho,(double)alto);
	}
	
	/**
	 * Calcula y contruye un objeto Entidad, especificando las coordenadas iniciales, el ancho y 
	 * el alto, pero como doble.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Entidad(double x1, double y1, double ancho, double alto )
	{
		super(x1,y1,ancho,alto);
	}
	
	/**
	 * Dibujar el Entidad.
	 * 
	 * @param  g	el objeto Graphics en el que se dibujara.
	 */
	public void dibujar(Graphics g)
	{
	    Graphics2D gd2 = (Graphics2D)g;
	    dibujar(gd2);
  	}
	
	/**
	 * Dibujar el Entidad.
	 * 
	 * @param  g2	el objeto Graphics2D en el que se dibujara.
	 */
	public void dibujar(Graphics2D g2)
	{
	    g2.draw(new Line2D.Double(getX(),getY()+(getWidth()),getX()+getWidth(),getY()+getWidth()));
	    g2.setColor(Color.white);
	    g2.fill((RectangularShape) this);
	    g2.setColor(Color.black);
	    g2.draw((RectangularShape) this);
	    g2.drawString(getNombre(), (int)(getX()), (int)(getY()+getHeight()+(g2.getFont()).getSize()+3) );
	    
	}
	
	public void setFrame(Rectangle2D r)
	{
	    super.setFrame(r);
	}
	 public boolean contains(double x, double y)
	 {
	     return super.contains(x,y); 
     }
     public boolean contains(double x, double y, double w, double h)
     {
         return super.contains(x,y,w,h);
     }
     public boolean contains(Point2D p)
     {
         return super.contains(p);    
     }
     public boolean contains(Rectangle2D r)
     {
         return super.contains(r);    
     }
     public Rectangle getBounds()
     {
         return super.getBounds();    
     }
     public Rectangle2D getBounds2D()
     {
         return super.getBounds2D();    
     }
     public PathIterator getPathIterator(AffineTransform at)
     {
         return super.getPathIterator(at);    
     }
     public PathIterator getPathIterator(AffineTransform at, double flatness)
     {
         return super.getPathIterator(at,flatness);    
     }
     public boolean intersects(double x, double y, double w, double h)
     {
         return super.intersects(x,y,w,h);    
     }
     public boolean intersects(Rectangle2D r)
     {
         return super.intersects(r);    
     }
     
     public String getInfo()
    {
        return "3#"+getX()+"#"+getY()+"#"+getWidth()+"#"+getHeight()+"#"+getNombre(); 
    }
}
	
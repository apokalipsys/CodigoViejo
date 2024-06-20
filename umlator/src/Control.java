
/**
 * Dibujar un objeto Control
 * 
 * @author BOo 
 * @version 0.2
 */
import java.awt.*;
import java.awt.geom.*;

public class Control extends Ovulo2D implements Shape
{
	private Triangulo t;
	
	/**
	 * Calcula y contruye un objeto Control, especificando las coordenadas iniciales, el ancho y 
	 * el alto.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Control(int x1, int y1, int ancho, int alto )
	{
	    super((double)x1,(double)y1,(double)ancho,(double)alto); 
		t = new Triangulo(x1+(ancho/2), y1, (x1+3*ancho/4), y1+(6), (x1+3*ancho/4),y1-(6));
	}
	
	/**
	 * Calcula y contruye un objeto Control, especificando las coordenadas iniciales, el ancho y 
	 * el alto, pero como doble.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Control(double x1, double y1, double ancho, double alto )
	{
		super(x1,y1,ancho,alto); 
		t = new Triangulo(x1+(ancho/2), y1, (x1+3*ancho/4), y1+(6), (x1+3*ancho/4),y1-(6));
	}
	
	/**
	 * Dibujar el control.
	 * 
	 * @param  g	el objeto Graphics en el que se dibujara.
	 */
	public void dibujar(Graphics g)
	{
	    Graphics2D gd2 = (Graphics2D)g;
	    dibujar(gd2);
  	}
	
	/**
	 * Dibujar el control.
	 * 
	 * @param  g2	el objeto Graphics2D en el que se dibujara.
	 */
	public void dibujar(Graphics2D g2)
	{
	    g2.setColor(Color.white);
	    g2.fill((RectangularShape) this);
	    g2.setColor(Color.black);
	    t.fillDibujar(g2);
	    g2.draw((RectangularShape) this);
	    g2.drawString(getNombre(), (int)getX(), (int)(getY()+getHeight()+(g2.getFont()).getSize()+3) );
	}
	
	public void setFrame(Rectangle2D r)
	{
	    super.setFrame(r);
	    t = new Triangulo(getX()+(getWidth()/2), getY(), (getX()+3*getWidth()/4), getY()+(6), (getX()+3*getWidth()/4),getY()-(6));
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
        return "2#"+getX()+"#"+getY()+"#"+getWidth()+"#"+getHeight()+"#"+getNombre() ;
    }
}
	
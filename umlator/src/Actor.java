
/**
 * Dibujar un Actor
 * 
 * @author BOo 
 * @version 0.2
 */
import java.awt.*;
import java.awt.geom.*;

public class Actor extends Ovulo2D implements Shape
{
    Cuerpo cuerpito;
	/**
	 * Calcula y contruye un objeto Actor, especificando las coordenadas iniciales, el ancho y 
	 * el alto.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Actor(int x1, int y1, int ancho, int alto )
	{
		super((double)x1,(double)y1,(double)ancho,(double)alto/3);
		cuerpito = new Cuerpo((int)getX(),(int)(getY()+super.getHeight()),(int)getWidth(), (int)super.getHeight()*2);
	}
	
	/**
	 * Calcula y contruye un objeto Actor, especificando las coordenadas iniciales, el ancho y 
	 * el alto, pero como doble.
	 * 
	 * @param x1 coordenada X inicial
	 * @param y1 coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto
	 */
	public Actor(double x1, double y1, double ancho, double alto )
	{
		super(x1,y1,ancho,alto/3);
		cuerpito = new Cuerpo((int)getX(),(int)(getY()+super.getHeight()),(int)getWidth(), (int)super.getHeight()*2);
	}
	
	/**
	 * Dibujar el Actor.
	 * 
	 * @param  g	el objeto Graphics en el que se dibujara.
	 */
	public void dibujar(Graphics g)
	{
	    Graphics2D gd2 = (Graphics2D)g;
	    dibujar(gd2);
  	}
	
	/**
	 * Dibujar el Actor.
	 * 
	 * @param  g2	el objeto Graphics2D en el que se dibujara.
	 */
	public void dibujar(Graphics2D g2)
	{
	    cuerpito.dibujar(g2);
	    g2.setColor(Color.white);
	    g2.fill((RectangularShape) this);
	    g2.setColor(Color.black);
	    g2.draw((RectangularShape) this);
	    
	    g2.drawString(getNombre(), (int)(getX()), (int)(getY()+getHeight()*3+(g2.getFont()).getSize()+3) );
	}
	
	public void setFrame(Rectangle2D r)
	{
	    super.x = r.getX();
	    super.y = r.getY();
	    cuerpito = new Cuerpo((int)getX(),(int)(getY()+super.getHeight()),(int)getWidth(), (int)super.getHeight()*2);
	}
	 public boolean contains(double x, double y)
	 {
	     return super.contains(x,y) || cuerpito.contains(x,y); 
     }
     public boolean contains(double x, double y, double w, double h)
     {
         return super.contains(x,y,w,h) || cuerpito.contains(x,y,w,h);
     }
     public boolean contains(Point2D p)
     {
         return super.contains(p) || cuerpito.contains(p);    
     }
     public boolean contains(Rectangle2D r)
     {
         return super.contains(r)  || cuerpito.contains(r);    
     }
     public Rectangle getBounds()
     {
         return new Rectangle((int)(super.getBounds()).getX(),(int)(super.getBounds()).getY(),
                              (int)(cuerpito.getBounds()).getWidth(),(int)((cuerpito.getBounds()).getHeight()+ super.getHeight()));    
     }
     public Rectangle2D getBounds2D()
     {
         return new Rectangle.Double((super.getBounds2D()).getX(),(super.getBounds2D()).getY(),
                              (cuerpito.getBounds2D()).getWidth(),((cuerpito.getBounds()).getHeight()+ super.getHeight()));     
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
         return super.intersects(x,y,w,h) || cuerpito.intersects(x,y,w,h);    
     }
     public boolean intersects(Rectangle2D r)
     {
         return super.intersects(r) || cuerpito.contains(r);    
     }
     
     public String getInfo()
    {
        return "4#"+getX()+"#"+getY()+"#"+getWidth()+"#"+getHeight()+"#"+getNombre(); 
    }
    
    public double getHeight()
    {
        return super.getHeight() /* 3*/;
    }
}
	
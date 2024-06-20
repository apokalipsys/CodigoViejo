
/**
 * Un triangulo para utilizar cuando sea necesario
 * 
 * @author BOo
 * @version 0.1
 */
import java.awt.*;
import java.awt.geom.*;

public class Triangulo extends Polygon implements Shape
{
	int npoints = 3;

	/**
	 * Crea un triangulo especificando el punto (x,y) inicial, y el (ancho,alto) requerido.
	 *              (x,y)  _ 
	 *                 /\  |  
	 *                /  \ |   alto
	 *               /____\-
	 *              |------|
	 *                ancho
	 * @param x coordenada X inicial
	 * @param y coordenada Y inicial
	 * @param ancho el ancho del objeto
	 * @param alto el alto del objeto                
	 */
	public Triangulo(int x, int y, int ancho, int alto)
	{
		super();
	    
        super.addPoint(x,y);
        super.addPoint(x + (ancho/2),y + alto);
        super.addPoint(x - (ancho/2),y + alto); 
	}
	
	/**
	 * Crea un triangulo con los puntos especificados.
	 * 
	 *               (x1,y1) 
	 *                 /\    
	 *                /  \ 
	 *               /____\
	 *          (x2, y2)  (x3,y3)
	 *
	 * @param X1 coordenada X inicial
	 * @param Y1 coordenada Y inicial
	 * @param X2 coordenada X secundaria
	 * @param Y2 coordenada Y secundaria
	 * @param X3 tercera coordenada X
	 * @param Y3 tercera coordenada Y
	 */
	public Triangulo(int X1, int Y1, int X2, int Y2, int X3, int Y3)
	{
	    super();
	    
        super.addPoint(X1,Y1);
        super.addPoint(X2,Y2);
        super.addPoint(X3,Y3);
	     
	}
	
	public Triangulo(double X1, double Y1, double X2, double Y2, double X3, double Y3)
	{
	    super();
	    
        super.addPoint((int)X1,(int)Y1);
        super.addPoint((int)X2,(int)Y2);
        super.addPoint((int)X3,(int)Y3);
	}     
	
	/**
	 *  Crea un triangulo con las coordenadas x e y especificadas por un arreglo
	 *  
	 * @param XS un arreglo de coordenadas X
	 * @param YS un arregla de coordenadas Y
	 */
	 public Triangulo(int[] XS, int[] YS)
	{
	    super(XS,YS,3);
	} 
	
	/**
	 * Dibujar el Triangulo en el Graphics especificado.
	 * 
	 * @param  g el objeto Graphics en el que se dibujara.
	 */
	public void dibujar(Graphics g)
	{
	    Graphics2D gr2 = (Graphics2D)g;
	    dibujar(gr2);   
	}
	
	/**
	 * Dibujar el Triangulo en el Graphics2D especificado.
	 * 
	 * @param  g2d	el objeto Graphics2D en el que se dibujara.
	 */
	public void dibujar(Graphics2D g2d)
	{
	    g2d.draw((Polygon)this);
	}
	
	/**
	 * Dibujar el Triangulo en el Graphics2D especificado.
	 * Esta vez el triangulo estara relleno.
	 * 
	 * @param  g2d	el objeto Graphics2D en el que se dibujara.
	 */
	public void fillDibujar(Graphics2D g2d)
	{
	    g2d.fill((Polygon)this);
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
}

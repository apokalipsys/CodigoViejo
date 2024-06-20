
/**
 * Una Linea que ese ajusta a nuestros requerimientos.
 * 
 * @author BOo
 * @version 0.15
 */
import java.awt.geom.*;
import java.awt.*;
import java.util.List;

public class Linea2D extends Line2D.Double implements Shape
{
    /**
     * Crea una linea.
     */
    public Linea2D()
    {
        super();
    }
    
    public Linea2D(int x, int y, int w, int h)
    {
        super((double)x,(double)y,(double)w,(double)h);
    }
    
    public Linea2D(double x, double y, double w, double h)
    {
        super(x,y,w,h);
    }
    
    public Linea2D(Point2D inicio, Point2D fin)
    {
        super(inicio,fin);
    }
    
    public void setFrame(Rectangle r)
    {
       super.setLine(r.getX(),r.getY(),r.getX()+r.getWidth(),r.getY()+r.getHeight());      
    }
    
    /**
     * Dibuja la linea en un Graphics2D
     *
     * @param  g2 Objeto Graphics2D que se usa para dibujar
     */
    public void dibujar(Graphics2D g2)
    {
        g2.draw(this);
    }
    
    /**
     * Redefine la coordenada X del primer punto que define a la linea
     *
     * @param  xx1  un double representando la nueva coordenada x
     */
    public void setX1(double xx1)
    {
        super.x1 = xx1;
    }
    
    /**
     * Redefine la coordenada X del segundo punto que define a la linea
     *
     * @param  xx2  un double representando la nueva coordenada x
     */
    public void setX2(double xx2)
    {
        super.x2 = xx2;
    }
    
    /**
     * Redefine la coordenada Y del primer punto que define a la linea
     *
     * @param  yy1  un double representando la nueva coordenada x
     */
    public void setY1(double yy1)
    {
        super.y1 = yy1;
    }
    
    /**
     * Redefine la coordenada Y del segundo punto que define a la linea
     *
     * @param  yy2  un double representando la nueva coordenada x
     */
    public void setY2(double yy2)
    {
        super.y2 = yy2;
    }
    
    /**
     * Metodo Contains, de la interfaz Shape
     *
     * @param  p   Un punto
     * @return     verdadero si el punto pertenece a la linea, si no falso
     */
    public boolean contains(Point2D p)
    {
        return /*(p.getY() == pendiente()*p.getX() + ene())*/getBounds().contains(p);
    }
    
    /**
     * Valor de la Pendiente de esta linea
     *
     * @return     la pendiente de esta linea
     */
    public double pendiente()
    {
       return (getY2() - getY1())/(getX2() - getX1());
    }
    
    /**
     * Valor de N  para esta linea.
     * Este valor corresponde a Y1 - M*X1
     *
     * @return     el valor de n para esta linea
     */
    public double ene()
    {
        return getY1() - pendiente()*getX1();
    }
    
    
}


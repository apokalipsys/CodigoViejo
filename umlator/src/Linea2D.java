
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
    private String nonvre = "Nombre";
    private Ovulo2D primero, segundo;
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
    
    public Linea2D(Point inicio, Point fin)
    {
        super(inicio,fin);
    }
    
    public String getInfo()
    {
        return "0#"+getX1()+"#"+getY1()+"#"+getX2()+"#"+getY2()+"#"+getNombre(); 
    }
    
    public void setNombre(String nn)
    {
        nonvre = nn;
    }
    
    public String getNombre()
    {
        return nonvre;
    }
    
    public Ovulo2D puntoUno()
    {
        return primero;
    }
    
    public Ovulo2D puntoDos()
    {
        return segundo;
    }
    
    public void setFrame(Rectangle r)
    {
       super.setLine(r.getX(),r.getY(),r.getX()+r.getWidth(),r.getY()+r.getHeight());      
    }
    
    public boolean correctLine(List lista)
    {
        Ovulo2D unOvulo = null;
        List array = lista;
        boolean b1 = false , b2 =  false;
        
        for(int j = 0; j < array.size(); j++)
        {
           unOvulo = (Ovulo2D)array.get(j);
           if(unOvulo.contains(getX1(),getY1()) || unOvulo.contains(getX2(),getY2()))
           {
               if(b1)
               {
                   segundo = unOvulo;
                   b2 = true;
               }
               else
               {
                   primero = unOvulo;
                   b1 = true;
               }
           }
        }
        
        return b1 && b2;
    }
    
    /**
     * Dibuja la linea en un Graphics2D
     *
     * @param  g2 Objeto Graphics2D que se usa para dibujar
     */
    public void dibujar(Graphics2D g2)
    {
        //setLine(new Point2D.Double(primero.getX(), primero.getY()),new Point2D.Double(segundo.getX(), segundo.getY()));
        calculaPosicion();
        g2.draw(this);
        g2.drawString(getNombre(), (int)((getX1()+getX2())/2), (int)((getY1()+getY2())/2));
    }
    
    /**
     * Calcula la posicion en que debe ir la linea, segun esten posicionados los objetos a los que une.
     *
     */
    public void calculaPosicion()
    {
        Rectangle Primero = primero.getBounds(), Segundo = segundo.getBounds();
        
        setX1(Primero.getX()+Primero.getWidth() /2);
        setX2(Segundo.getX() +Segundo.getWidth()/2);
        setY1(Primero.getY()+Primero.getHeight() /2);
        setY2(Segundo.getY() +Segundo.getHeight()/2);    
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
     * Revisa si uno de sus punteros es nulo.De ser asi, se procede a 
     * retirarlo de la lista.
     *
     * @param  lista  lista donde se encuentra este objeto
     * @return     un boolean que será true si se ha quitado con exito
     */
    public boolean pointerNull(List lista)
    {
        if(primero == null || segundo == null)
        {
            return lista.remove(this);
        }
        else return false;
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

import java.awt.geom.*;
import java.awt.*;

/**
 * 
 * Clase generalizadora de los objetos basicos del diagrama, como lo son
 * Control, Entidad y Frontera.
 * 
 * @author BOo
 * @version 0.15
 */

public abstract class Ovulo2D extends Ellipse2D.Double
{
    private String nombre = "Nombre";
    private boolean limitar = false;
    
    /**
     * Este constructor en realidad no hace nada!!
     * Debe definirse el constructor en cada hijo
     */
    protected Ovulo2D()
    {
        super();
    }
    protected Ovulo2D(double x, double y, double w, double g)
    {
        super(x,y,w,g);
    }
       
    
    /**
     * Dibujar en un objeto de tipo Graphics.
     * Debe definirse en cada hijo.
     * 
     * @param  g    el objeto Graphics en el que se dibujara.
     */
    abstract public void dibujar(Graphics g);
    
    /**
     * Dibujar en Graphics2D
     * 
     * @param g2 el objeto Graphics2D donde se dibujara.
     */ 
    abstract public void dibujar(Graphics2D g2);
    
    /**
     * Coloca el punto de inicio de el Ovulo2D
     *
     * @param  y   Coordenada y
     * @param x Coordenada X
     */
    public void addStartPoint(double x, double y)
    {
        super.x = x;
        super.y = y;
    }
    
    /**
     * Coloca el ancho
     *
     * @param  w  el ancho
     */
    public void setWidth(double w)
    {
        super.width = w;
    }
    
    /**
     * Coloca el alto
     *
     * @param  h   el alto
     */
    public void setHeight(double h)
    {
        super.height = h;
    }
    
    /**
     * Coloca un nuevo nombre
     *
     * @param  newName  El nuevo nombre que identifica al objeto
     */
    public void setNombre(String newName)
    {
        nombre = newName;
    }
    
    /**
     * Devuelve el nombre que identifica al objeto
     *
     * @return una String con el nombre de el objeto
     */
    public String getNombre()
    {
        return nombre;
    }
    
    public void dibujarLimite(Graphics g, Color color)
    {
        if(limitar)
            dibujarLimite((Graphics2D)g, color);
    }
    
    public void dibujarLimite(Graphics2D g2d, Color color)
    {
        if(limitar)
        {
            Color actual = g2d.getColor();
            g2d.setColor(color);
            g2d.draw(super.getBounds());
            g2d.setColor(actual);
            limitar = false;
        }
    }
    
    public void permisoLimite(boolean permiso)
    {
        limitar = permiso;
    }
    
    /**
     * Devuelve una cadena que esta compuesta por los datos básicos para reconstruir el objeto
     *
     * @return una cadena con los datos
     */
    public String getInfo()
    {
        return "0#"+getX()+"#"+getY()+"#"+getWidth()+"#"+getHeight()+"#"+getNombre(); 
    }
    
    /**
     * Coloca el ovulo en una nueva coordenada X
     *
     * @param  X   una nueva coordenada X
     */
    public void setX(int X)
    {
        setX((double)X);
    }
    
    /**
     * Coloca el ovulo en una nueva coordenada X
     *
     * @param  X   una nueva coordenada X
     */
    public void setX(double X)
    {
        super.x = X;
    }
    
    /**
     * Coloca el ovulo en una nueva coordenada Y
     *
     * @param  Y   una nueva coordenada Y
     */
    public void setY(int Y)
    {
        setX((double)Y);
    }
    
    /**
     * Coloca el ovulo en una nueva coordenada Y
     *
     * @param  Y   una nueva coordenada Y
     */
    public void setY(double Y)
    {
        super.x = Y;
    }
}

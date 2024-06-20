
/**
 * Clase que transforma la Linea2D en una Flecha
 * 
 * @author BOo
 * @version 0.1
 */

import java.awt.geom.*;
import java.awt.*;

public class Flecha extends Linea2D
{
    Triangulo t;
    /**
     * Constructores.... llaman a los constructores de Linea2D
     */
	public Flecha()
	{
		super();
	}
    
    public Flecha(int x, int y, int w, int h)
    {
        super((double)x,(double)y,(double)w,(double)h);
    }
    
    public Flecha(double x, double y, double w, double h)
    {
        super(x,y,w,h);
    }
    
    public Flecha(Point inicio, Point fin)
    {
        super(inicio,fin);
    }
    
    public String getInfo()
    {
        return "1#"+getX1()+"#"+getY1()+"#"+getX2()+"#"+getY2()+"#"+getNombre(); 
    }
    
	/**
     * Dibuja la linea en un Graphics2D
     *
     * @param  g2 Objeto Graphics2D que se usa para dibujar
     */
    public void dibujar(Graphics2D g2)
    {
        calculaPosicion();
        t = new Triangulo((int)getX2(),(int)getY2(),10,10);
        t.fillDibujar(g2);
        g2.draw(this);
    }
}

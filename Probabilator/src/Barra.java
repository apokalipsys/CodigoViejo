
/**
 * Una barra super exacta
 * 
 * @author BOo
 * @version 0.1
 */

import java.awt.*;
import java.awt.geom.*;

public class Barra extends Line2D.Double
{
	

	/**
	 * Constructor
	 */
	public Barra(double xInicial, double yInicial, double valor)
	{
		super(xInicial, yInicial, xInicial, yInicial-valor);
	}
}

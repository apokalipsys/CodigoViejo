import java.awt.*;

public class Bala
{
	private Graphics g;
	private int x, y;

	public Bala(int unX, int unY, Graphics gr)
	{
		x = unX;
		y = unY;
		g = gr;
	}
	
	public Bala(int unX, int unY)
	{
	    x = unX;
	    y = unY;
	}

	public void pintar()
	{
		g.drawOval(x,y,1,1);
	}
	
	public void pintar(Graphics g)
	{
	    g.drawOval(x,y,1,1);
	}
	
	public void moverX(int nuevaX)
	{
	    x = nuevaX;
	}
	
	public void moverY(int nuevaY)
	{
	    y = nuevaY;
	}
	
	public int X()
	{
	    return x;
	}
	
	public int Y()
	{
	    return y;
	}
}

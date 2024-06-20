import javax.microedition.lcdui.*;

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
		g.drawLine(x,y,x+1,y+1);
	}
	
	public void pintar(Graphics g)
	{
	    g.drawLine(x,y,x+1,y+1);
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

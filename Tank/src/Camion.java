import java.awt.*;

public class Camion
{
	private int x,y;
	private int inicioX, inicioY, separacionX, separacionY;
	private Graphics g;
	private Lista camiones;

	public Camion(Graphics grafico, int cantidadDeCamiones, int inX, int inY, int saltoX, int saltoY)
	{
	    g = grafico;
	    inicioX = inX;
	    inicioY = inY;
	    separacionX = saltoX;
	    separacionY = saltoY;
	    camiones = new Lista();
	    crearLista(cantidadDeCamiones);
	}
	
	public Camion(int cantidadDeCamiones, int inX, int inY, int saltoX, int saltoY)
	{
	    inicioX = inX;
	    inicioY = inY;
	    separacionX = saltoX;
	    separacionY = saltoY;
	    camiones = new Lista();
	    crearListaSinGraficos(cantidadDeCamiones);
	}
	
	public Camion(int laX, int laY)
	{
		x = laX;
		y = laY;
	}
	
	public Camion(int X, int Y, Graphics grafico)
	{
		x = X;
		y = Y;
		g = grafico;
	}

	public void crearLista(int numero)
	{
	    for(int i = 0; i<numero; i++)
	    {
	        camiones.agregar(new Camion(inicioX, inicioY,g));
	        inicioX+=separacionX;
	        inicioY+=separacionY;
	    }
	}
	
	public void crearListaSinGraficos(int numero)
	{
	    for(int i = 0; i<numero; i++)
	    {
	        camiones.agregar(new Camion(inicioX, inicioY));
	        inicioX+=separacionX;
	        inicioY+=separacionY;
	    }
	}
	
	public void poner(int indice)
	{
	    Camion c = (Camion) camiones.mostrarObjeto(indice);
	    c.poner();
	}
	
	public void poner(int indice, Graphics g)
	{
	    Camion j = (Camion) camiones.mostrarObjeto(indice);
	    j.poner(g);
	}
	
	
	public void poner()
	{
		g.setColor(Color.white);
		g.fillRect(x,y,5,10);
		g.setColor(Color.green);
		g.fillRect(x,y,5,10);
		g.setColor(Color.black);
	}
	
	public void poner(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(x,y,5,10);
		g.setColor(Color.green);
		g.fillRect(x,y,5,10);
		g.setColor(Color.black);
	}
	
	public void moverX(int nuevaX)
	{
	    x = nuevaX;
	}
	
	public void moverY(int nuevaY)
	{
	    y = nuevaY;
	}
	
	public int Y()
	{
	    return y;   
	}
	
	public int Y(int indice)
	{
	    Camion d = (Camion) camiones.mostrarObjeto(indice);
	    return d.Y();
	}
}

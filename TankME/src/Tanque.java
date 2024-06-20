import javax.microedition.lcdui.*;

public class Tanque
{
	private Graphics g;
	private int x,y;
	private int inicioX, inicioY, separacionX, separacionY;
	Lista tanques;
	
	public Tanque(Graphics grafico, int cantidadDeTanques, int inX, int inY, int saltoX, int saltoY)
	{
	    g = grafico;
	    inicioX = inX;
	    inicioY = inY;
	    separacionX = saltoX;
	    separacionY = saltoY;
	    tanques = new Lista();
	    crearLista(cantidadDeTanques);
	}
	
	public Tanque(int cantidadDeTanques, int inX, int inY, int saltoX, int saltoY)
	{
	    inicioX = inX;
	    inicioY = inY;
	    separacionX = saltoX;
	    separacionY = saltoY;
	    tanques = new Lista();
	    crearListaSinGraficos(cantidadDeTanques);
	}
    
    public Tanque(int laX, int laY)
	{
		x = laX;
		y = laY;
	}
    
	public Tanque(int laX, int laY,Graphics graficos)
	{
		x = laX;
		y = laY;
		g = graficos;
	}
    
    public void crearLista(int numero)
	{
	    for(int i = 0; i<numero; i++)
	    {
	        tanques.agregar(new Tanque(inicioX, inicioY,g));
	        inicioX+=separacionX;
	        inicioY+=separacionY;
	    }
	}
	
	public void crearListaSinGraficos(int numero)
	{
	    for(int i = 0; i<numero; i++)
	    {
	        tanques.agregar(new Tanque(inicioX, inicioY));
	        inicioX+=separacionX;
	        inicioY+=separacionY;
	    }
	}
	
	public void dibujar(int indice)
	{
	    Tanque j = (Tanque) tanques.mostrarObjeto(indice);
	    j.dibujar();
	}
	
	public void dibujar(int indice, Graphics g)
	{
	    Tanque j = (Tanque) tanques.mostrarObjeto(indice);
	    j.dibujar(g);
	}
	
	public void dibujar()
	{
		g.drawRect(x,y,5,10);
		g.drawRect(x+5,y+5,5,1);
	}
	
	public void dibujar(Graphics g)
	{
		g.drawRect(x,y,5,10);
		g.drawRect(x+5,y+5,5,1);
	}
	
	public void cambiarY(int newY)
	{
	    y = newY;
	}
}

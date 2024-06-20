
/**
 * Write a description of class Durabatt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Durabatt
{
	private int[] pila;
	private static final int MAX = 1000;
	private int tope = 0;

	public Durabatt()
	{
		pila = new int[MAX];
	}

	public void agregar(int y)
	{
		if(!estaLlena())
		{
		    pila[tope] = y;
		    tope++;
		}
	}
	
	public int sacarTope()
	{
	     tope--;
	     return pila[tope];
	}
	
	public void cambiarFoco(int indice)
	{
	    int auxiliar;
	    
	    auxiliar = pila[indice];
	    for(int i = indice; i < tope; i++)
	    {
	        pila[i] = pila[i+1];
	    }
	    
	    pila[tope-1] = auxiliar;
	    
	}
	
	public boolean estaLlena()
	{
	     return(tope == MAX);
	}
}

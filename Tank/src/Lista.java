
public class Lista
{
	private Object[] lista;
	private int largo, MAX = 1000;

	public Lista()
	{
		lista = new Object[MAX];
		largo = 0;
	}

	public int lenght()
	{
		return largo+1;
	}
	
	public void agregar(Object dato)
	{
	    lista[largo] = dato;
	    largo++;
	}   
	
	public void borrar(int pos)
	{
	    for(int i = pos; i<= largo; i++)
	    {
	        lista[i] = lista[i+1];    
	    }   
	        
	    largo--;
	}   
	
	public Object mostrarObjeto(int posicion)
	{
	    return lista[posicion];
	}
	
	public String toString()
	{
	    String mostrar = "";
	    
	    for(int i = 0; i<= largo; i++)
        {
	        mostrar = lista[i] + "\n";    
	    }  
	        
	    return mostrar;   
	}
}

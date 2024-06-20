public class Cola
{
	private static final int MAX = 1000;
	private Object[] cola = new Object[MAX];
	private int puntero;
	

	public Cola()
	{
		puntero = -1;
	}

	public void pone(Object y)
	{
		if(!llena())
		{
		    puntero++;
		    cola[puntero] = y;
		}    
	}
	
	public void saca()
	{
	    if(!isVacio())
	    {
	        for(int i=0;i<=puntero;i++)
	            cola[i] = cola[i+1];
	        
	        puntero--;  
	    }   
	        
	}
	
	public Object primero()
	{
	    Object f = null;
	    
	    if(!isVacio())
	        f = cola[0];
	        
	    return f;    
	}
	
	public void anula()
	{
	    puntero = -1;
	}
	
	public boolean isVacio()
	{
	    return (puntero == -1);
	}
	
	public boolean llena()
	{
	    return (puntero == MAX-1);
	}
	
	public Object ver(int indice)
	{
	    return cola[indice];
	}
	
	public int largo()
	{
	    return puntero;
	}
	
	public String toString()
	{
	    String h = "";
	    if(!isVacio())
	    {
	        for(int i = 0; i<=puntero; i++)
	            h = h + " " + cola[i];
	    }
	    
	    return h;
	}    
}

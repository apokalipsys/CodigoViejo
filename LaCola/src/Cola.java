public class Cola
{
	private static final int MAX = 100;
	private int[] cola = new int [MAX];
	private int ultimo;
	

	public Cola()
	{
		ultimo = -1;
	}

	public void pone(int y)
	{
		if(!llena())
		{
		    ultimo++;
		    cola[ultimo] = y;
		}    
	}
	
	public void saca()
	{
	    if(!isVacio())
	    {
	        for(int i=0;i<ultimo;i++)
	            cola[i] = cola[i+1];
	        
	        ultimo--;  
	    }   
	        
	}
	
	public int primero()
	{
	    int f = -1;
	    
	    if(!isVacio())
	        f = cola[0];
	        
	    return f;    
	}
	
	public void anula()
	{
	    ultimo = -1;
	}
	
	public boolean isVacio()
	{
	    return (ultimo == -1);
	}
	
	public boolean llena()
	{
	    return (ultimo == MAX);
	}
	
	public String toString()
	{
	    String h = "";
	    if(!isVacio())
	    {
	        for(int i = 0; i<=ultimo; i++)
	            h = h + " " + cola[i];
	    }
	    
	    return h;
	}    
}

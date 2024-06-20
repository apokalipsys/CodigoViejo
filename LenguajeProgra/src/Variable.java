
/**
 * Write a description of class Variable here.
 * 
 * @author ApokalipsyS
 * @version 0.1
 */
public class Variable
{
	private String nombre, valor;

	public Variable(String n, String v)
	{
		nombre = n;
		valor = v;
	}

	public String valor()
	{
		return valor;
	}
	
	public String nombre()
	{
	    return nombre;
	}
	
	public boolean equals(Object o)
	{
	    return ((Variable)o).nombre().equals(nombre);
	}
}

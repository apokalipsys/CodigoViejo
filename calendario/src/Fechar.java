
/**
 * Objeto de fechas.
 * 
 * @author BOo 
 * @version 0.1
 */
public class Fechar
{
	private int dd,mm,aa;
	String titulo;

	/**
	 * Constructor for objects of class Fechar
	 */
	public Fechar(String nombre,int dia, int mes, int yy)
	{
		titulo = nombre;
		dd = dia;
		mm = mes;
		aa = yy;
	}

	public int Year()
	{
	    return aa;
	}
	
	public int Mes()
	{
	    return mm;
	}
	
	public int Dia()
	{
	    return dd;
	}
	
	public String toString()
	{
	    return titulo;
	}
	
	public String numToString()
	{
	    return dd+"/"+mm+"/"+aa;
	}
}

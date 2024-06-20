package startup;


/**
 * Usuario de JMinder
 * 
 * @author BOo 
 * @version 0.1 15.03.2005
 */

import java.io.*;

public class Usuario
{
	private String name;
	private String md5Pass;

	/**
	 * Constructor
	 */
	public Usuario(String nn, String pass)throws Exception
	{
		name = nn;
		md5Pass = HashPass.md(name+pass);
	}

	/**
	 * Retornadores 
	 */
	public String getName()
	{
		return name;
	}
   
    public String getHashPass()
	{
		return md5Pass;
	}
	
   /**
    * Comprueba si el parametro es la clave interna
    */
   public boolean comparePass(String pass) throws Exception
   {
        return md5Pass.equalsIgnoreCase(HashPass.md(name+pass));
   }
   
   public boolean compareHashPass(String hashPass) 
   {
        return md5Pass.equalsIgnoreCase(hashPass);
   }
   
   /**
    * Entrada, salida
    */
   public void guardar()throws IOException
   {
       FileOutputStream fs = new FileOutputStream(new File("users/"+name+".usr"));
       PrintStream destino = new PrintStream(fs);
            
       destino.println(md5Pass);
            
       fs.close();     
   }
   
   public boolean abrir()throws IOException
   {
       String linea = "";
       BufferedReader lector = new BufferedReader(new FileReader("users/"+name+".usr"));
       linea = lector.readLine();
       lector.close();
       
       return compareHashPass(linea);
   }
   
 
}

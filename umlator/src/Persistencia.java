import java.io.*;
/**
 * Metodos para la persistencia de objetos
 * 
 * @author BOo
 * @version 0.2
 */
public class Persistencia
{
    /**
     * Guarda un Objeto en un Archivo.
     * En caso de ocurrir un error lanza un IOException
     * 
     * @param  filename nombre del archivo
     * @param o El Objeto a guardar 
     */
     public static void guardar(String filename, Object o) throws IOException 
     {
         FileOutputStream archivo = new FileOutputStream(filename);
         ObjectOutputStream grabar = new ObjectOutputStream(archivo);
  
         grabar.writeObject(o);
 
         grabar.flush();
         archivo.close();
     }

     /**
      * Recupera un Objeto desde un archivo.
      * Lanzara un error IOException en caso de ocurrir un error
      *
      * @param  filename Nombre del archivo a abrir
      * @return   el objeto contenido en el archivo
      */
     public static Object leer(String filename) throws Exception 
     {
         Object i;
  
         FileInputStream archivo = new FileInputStream(filename);
         ObjectInputStream leer = new ObjectInputStream(archivo); 
         
         i = leer.readObject();      
         
         archivo.close();
         
         return(i);
    }

}

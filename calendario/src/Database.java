import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * A very simple database of people in a university. This class simply stores
 * persons and, at request, lists them on standard output.
 *
 * Written as a first demo program for BlueJ.
 *
 * @author  Michael Kolling
 * @version 1.1, March 2002; @Version 3 by BOo, Jul 2004
 */

public class Database{

    private Persona[] persons;
    private final int MAX = 10000;
    private int largo; 

    /**
     * Create a new, empty person database.
     */
    public Database() 
    {
        persons = new Persona[MAX];
        largo = 0;
    }

    /**
     * Add a person to the database.
     */
    public void add(Persona p) 
    {
        if(!isFull())
        {
           persons[largo] = p;
           largo++;
        }
    }

    /**
     * List all the persons currently in the database on standard out.
     * DEPRECATED
     */
   /*
    public void listAll () 
    {
        for (Iterator i = persons.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }
    } */
    /**
     * Methods by BOo
     */
    
     public int size()
     {
         return largo;
     }

     public boolean isFull()
     {
         return largo == MAX;
     } 

     public boolean isEmpty()
     {
         return largo == 0;
     }
     
     public Persona get(int indice)
     {
         return (Persona)persons[indice];
     }
     /**
      * Added a Person in a specific place.
      * DEPRECATED. Replaced by set(int, Persona)
      */
     public void add(int indice, Persona objeto)
     {
          if(indice<largo) persons[indice] = objeto;
     }
     
     public void remove(int indice)
     {
       if(!isEmpty())
       {
         for(int i = indice; i<= largo; i++)
	   {
               persons[i] = persons[i+1];    
	   }   
	        
	   largo--;
       }
     }
     
     public void set(int indice, Persona objeto)
     {
         if(indice<largo) persons[indice] = objeto;

     }

    
     
     /**
      * Methods of person
      * 
      * 
      */
     /**
      * @deprecated 
      */ 
     public void reordenarPorNombre()
     {
          int contador, aux;
          Persona name1, name2;
          String cadena1, cadena2;
          
          do
          {
              contador = 0;
              
              for( int i = 1; i <= size(); i++)
              {
                  name1 = get(i);
                  name2 = get(i+1);
                  cadena1 = name1.getName();
                  cadena2 = name2.getName();
                  aux = cadena1.compareTo(cadena2);
                  
                  if(aux>0)
                  {
                      add(i,name2);
                      remove(i+2);
                      contador++;
                  }
                  
              }  
              
          } while (contador != 0);
     }
     
     /**
      * @deprecated 
      */
     public void reordenarPorApellido()
     {
          int contador, aux;
          Persona name1, name2;
          String cadena1, cadena2;
          
          do
          {
              contador = 0;
              
              for( int i = 1; i <= size(); i++)
              {
                  name1 = get(i);
                  name2 = get(i+1);
                  cadena1 = name1.getSurname();
                  cadena2 = name2.getSurname();
                  aux = cadena1.compareTo(cadena2);
                  
                  if(aux>0)
                  {
                      add(i,name2);
                      remove(i+2);
                      contador++;
                  }
                  
              }  
              
          } while (contador != 0);
     }
     
     public int buscar(String nombre)
     {
          int devolver = 0;
          Persona persona;

          for(int i = 1; i<=size();i++)
          {
                persona = get(i);    
                if(nombre.equals(persona.getName()) || nombre.equals(persona.getSurname()))
                    devolver = i;
          }
          return devolver;
     }

    public void Eliminar(String nombre)
    {
           int REMOVE = buscar(nombre);

           if(REMOVE != 0)
           {
               int opc = JOptionPane.showConfirmDialog(null, 
                                          "Desea borrar este contacto de la lista? \n"+get(REMOVE), 
                                          "Confirmaci�n", JOptionPane.YES_NO_OPTION);
                                          
               switch(opc)
               {
                case JOptionPane.YES_OPTION : remove(REMOVE); break;
                case JOptionPane.NO_OPTION : ; break;
               }                                
           }
           else
               JOptionPane.showMessageDialog(null, "No se encontro \n"+nombre,
                                                "Error",
                                                JOptionPane.ERROR_MESSAGE);

    }
     
public void guardar(String filename) 
{
    try{
    
    	FileOutputStream archivo = new FileOutputStream(filename);
    	PrintStream grabar = new PrintStream(archivo);
  
    	for (int i = 0; i< largo;i++) 
    	{ 
            		Persona p = (Persona)persons[i];
             		grabar.println(p.toString());
     	}    
    
    	archivo.close();

          }
          catch(Exception E)
            {JOptionPane.showMessageDialog(null, "No se guardo el archivo: \n"+E.toString(),
                                               			 "Error",
                                                		JOptionPane.ERROR_MESSAGE);
            }
}

public static Database leer(String filename) 
{
  Database i=new Database();
  
  String linea = "";
  try{
  BufferedReader leer = new BufferedReader(new FileReader(filename)); 

   
     while( (linea = leer.readLine() ) != null )
     {
         StringTokenizer tokens = new StringTokenizer(linea, ":");
         
         Persona h = new Persona(tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken(), tokens.nextToken());
         
         i.add(h);
     }
            leer.close();     
     }
    
  catch(Exception E){JOptionPane.showMessageDialog(null, "No se abri� el archivo: \n"+E.toString(),
                                                "Error",
                                                JOptionPane.ERROR_MESSAGE);}
         

         
  return(i);
}

}

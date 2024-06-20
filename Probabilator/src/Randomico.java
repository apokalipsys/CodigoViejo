
/**
 * Crea un grupo de numeros randomicos
 * 
 * @author BOo
 * @version 0.1
 */
public class Randomico
{
    private int[] grupo;
    private int rank;
    private boolean incluyeCero = false;

    /**
     * Constructor
     */
    public Randomico(int tamano, int rango) // el rango es 100 
    {
        grupo = new int[tamano];
        rank = rango;
        llenarArreglo();
    }

    public Randomico(int tamano, int rango, boolean incluirCero) // el rango es 100 
    {
        grupo = new int[tamano];
        rank = rango;
        incluyeCero = incluirCero;
        llenarArreglo();
    }

    /**
     * llena el arreglo con numeros randomicos, desde el 1 a rank
     * 
     */
    private void llenarArreglo()
    {
        for(int i = 0; i< grupo.length; i++)
        {
            if(incluyeCero)
                grupo[i] = (int) (Math.random()*(rank+1));
            else
                grupo[i] = (int) (Math.random()*rank+1);
        }    
    }
    
    /**
     * El arreglo con N numeros randomicos
     *
     * @return     un arreglo de enteros
     */
     public int[] elArreglo()
     {
        return grupo;
     }
        
     /**
      * El mismo arreglo, pero como objeto
      *
      * @return     el mismo arreglo, pero como Objeto Integer
      */
     public Integer[] elArregloObjeto()
     {
        Integer[] retorno = new Integer[grupo.length];
        
        for(int i = 0; i< grupo.length; i++)
            retorno[i] = new Integer(grupo[i]);
            
        return retorno;    
     }
       
}

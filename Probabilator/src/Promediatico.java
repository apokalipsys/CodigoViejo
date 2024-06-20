
/**
 * Saca 200 muestras de tamano n, y le saca el promedio
 * 
 * @author BOo
 * @version 0.1
 */
public class Promediatico
{
	private int[] population;
	private int[] promedios = new int[200];
	int tamano; 

	/**
	 * Constructor
	 */
	public Promediatico(int[] poblacion, int tamanoMuestra)
	{
		population = poblacion;
		tamano = tamanoMuestra;
		sacarPromedios();
	}

	/**
	 * saca promedios como loco
	 */
	private void sacarPromedios()
	{
		for(int j = 0; j < promedios.length; j++)
		    promedios[j] = unPromedio();
	}
	
	Estado[] losEstados;
	/**
     * Calcula un promedio a una muestra
     *
     * @return     el promedio
     */
     private int unPromedio()
     {
        losEstados = new Estado[population.length]; 
        for(int h = 0; h<population.length; h++)
           losEstados[h] = new Estado();
        
        int[] y = new int[tamano];
        
        for(int h = 0; h<tamano; h++)
           y[h] = unPoblador();
           
        int suma = 0;
        
        for(int c = 0; c<tamano; c++)
           suma += y[c];
           
           
        return suma/tamano;
     }
 
     /**
      * Pa ke no se repitan
      *
      * @return     un entero ke representa a un elemento del arreglo poblacional
      */
     public int unPoblador()
     {
         int devolvedor = (int)(Math.random()*population.length);
        if(losEstados[devolvedor].estadoActual() == Estado.VACIO)
        {
            losEstados[devolvedor].cambiaEstado(Estado.OCUPADO);
            return population[devolvedor];
        }
         else
            return unPoblador();
     }
     
     public int[] losPromedios()
     {
        return promedios;
     }
     
     /**
      * El mismo arreglo, pero como objeto
      *
      * @return     el mismo arreglo, pero como Objeto Double
      */
     public Integer[] elArregloObjeto()
     {
        Integer[] retorno = new Integer[promedios.length];
        
        for(int i = 0; i< promedios.length; i++)
            retorno[i] = new Integer(promedios[i]);
            
        return retorno;    
     } 
}


/**
 * Uso taaaantas tablas que mejor las creo aqui
 * 
 * @author BOo
 * @version 0.1
 */

import javax.swing.*;

public class Tablas
{
	/**
	 * La tabla de la poblacion
	 * 
	 * @param  enteros  los valores ke representan la poblacion
	 * @return     Una tabla con los valores
	 */
	public static JTable poblacion(Integer[] enteros)
	{
		String[] titulos = {"N°","Valor"};
		
		Object[][] datos = new Object[enteros.length][2];
		
		for(int i = 0; i< enteros.length; i++)
		{
		    datos[i][0] = ""+(i+1);
		    datos[i][1] = enteros[i];
		}
		
		return new JTable(datos, titulos);
	}
	
	/**
	 * La tabla de muestras
	 * 
	 * @param  y   a sample parameter for a method
	 * @return     the sum of x and y 
	 */
	public static JTable muestra(Integer[] valores)
	{
		String[] titulos = {"Muestra N°","Promedio"};
		
		Object[][] datos = new Object[valores.length][2];
		
		for(int i = 0; i< valores.length; i++)
		{
		    datos[i][0] = ""+(i+1);
		    datos[i][1] = valores[i];
		}
		
		return new JTable(datos, titulos);
	}
}


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
	 * La tabla 
	 * @return     Una tabla con los valores
	 */
	public static JTable tabla()
	{
		String[] titulos = {"RUT","Nombre","Dirección","Comuna","Teléfono","Teléfono (2)","Celular","Celular (2)","Email"};
		/*
		Object[][] datos = new Object[enteros.length][2];
		
		for(int i = 0; i< enteros.length; i++)
		{
		    datos[i][0] = ""+(i+1);
		    datos[i][1] = enteros[i];
		}
		*/
		return new JTable(null/*datos*/, titulos);
	}
	
	public static JTable tabla(String[] arr)
	{
		String[] titulos = {"RUT","Nombre","Dirección","Comuna","Teléfono","Teléfono (2)","Celular","Celular (2)","Email"};
		
		Object[][] datos = new Object[1][titulos.length];
		
		for(int y = 0; y< titulos.length;y++)
		    datos[0][y] = arr[y];
		
		return new JTable(datos, titulos);
	}
}

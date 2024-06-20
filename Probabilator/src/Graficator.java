
/**
 * Una pantalla para graficar
 * 
 * @author BOo
 * @version 0.1
 */

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Graficator extends JPanel
{
	private Polygon canchaX, canchaY, grafo;
	int minimo,  maximo, maxAltura = 0, minAltura;
	private int tamanito, n = 0;

	/**
	 * Constructor 
	 */
	public Graficator(int min, int max)
	{
	    super(true);
	    minimo = min;
		maximo = max;
		
		creaCancha();
		creaGrafo();
	}

	/**
	 * dibuja
	 */
	protected void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         Graphics2D g2 =(Graphics2D)g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
         creaCancha();
         dibujaCancha(g2);
         //creaGrafo();
         dibujaGrafo(g2);
     }

     /**
      * dibuja la cancha
      *
      * @param  g2  los graficos
      */
     private void dibujaCancha(Graphics2D g2)
     {
        g2.draw(canchaX);
        g2.draw(canchaY);
        g2.draw(new Line2D.Double(40,tamanito-5,40,tamanito+5));
        g2.draw(new Line2D.Double((((tamanito - 50)*maximo)/maximo)+40,tamanito-5,(((tamanito - 50)*maximo)/maximo)+40,tamanito+5));
        g2.drawString(""+minimo, 40, tamanito+15);
        g2.drawString(""+maximo, (((tamanito - 50)*maximo)/maximo)+40, tamanito+15);
        if(maxAltura != 0)
          g2.drawString(""+maxAltura, 3, 40);
     }
     
     /**
      * crea la kancha
      */
     private void creaCancha()
     {
        tamanito = Math.min(getHeight(), getWidth()) - 30;
		canchaY = new Polygon();
		canchaX = new Polygon();
		canchaY.addPoint(30,30);
		canchaY.addPoint(30,tamanito);
		canchaX.addPoint(30,tamanito);
		canchaX.addPoint(tamanito,tamanito);
     }
     
     /**
      * Crea el grafico
      */
     private void creaGrafo()
     {
        grafo = new Polygon();
		grafo.addPoint(40, tamanito-10);
		
	 }
     
     /**
      * dibuja el grafico
      *
      * @param  g2  los graficos
      */
     private void dibujaGrafo(Graphics2D g2)
     {
        g2.setColor(Color.red);
        //g2.draw(grafo);
        if(valores != null)
        {
            g2.draw((Line2D)(new Barra(40,tamanito, (valores[0]*(tamanito-60))/maxAltura)));
         for(int w = 1; w<maximo; w++)
        {
            double x = (((tamanito - 50)*(w+1))/maximo)+40;
            g2.draw((Line2D)(new Barra(x,tamanito, (valores[w]*(tamanito-60))/maxAltura)));
            
        }
        }
     }
     int[] valores;
     /**
      * calcula y crea el grafico
      */
     public void creaPuntos(int[] numeros)
     {
        valores = new int[maximo]; 
        n = numeros.length;
        for(int q = minimo; q<=maximo; q++)
        {
            int contador = 0;
            for(int d = 0;d<numeros.length;d++)
            {
                if(q == numeros[d]) contador++;
                
            }
            if(maxAltura < contador) maxAltura = contador;
            valores[q-1] = contador;
        }
        
     }
     
     int Xmax, Xmin;
     public double amplitud()
     {
         
         double k = 1 + 3.3 * Math.log(n);
         
         for(int h = 0; h<maximo; h++)
         {
             if(valores[h] != 0)
             {
                 Xmin = valores[h];
                 break;
             }
         }
         for(int h = maximo-1; h>minimo; h--)
         {
             if(valores[h] != 0)
             {
                 Xmax = valores[h];
                 break;
             }
         }
         
         return (Xmax-Xmin)/k;
     }
}

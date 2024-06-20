/**
 *   Dibujador JA!
 *   @author version 0.1: GuRu, Danilote (TiTaN TeaM), version 0.2 : BOo
 *   @version 0.2
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.print.*;

public class PanelDibujo extends JPanel implements Printable
{
     /* lineas guarda las lineas, uml_2 guarda los objetos de modelado de aplicaciones web, uml_1 es un proyecto.*/ 
     List lineas, uml_1, uml_2;
     /* los "ActionListener" estaran en otra clase */
     /* PanelAccion acciones; */
     Linea2D linea;
     private boolean arrastrado = false, dibujaLimite = false, grilla_uno = false;
     
     Dimension area;
     /**
      * Contructor del panel
      */
     public PanelDibujo()
     {
         lineas = new ArrayList();
         uml_2 = new ArrayList();
         linea = new Linea2D();
         setBackground(Color.white);
         area = new Dimension(getWidth(),getHeight());
     }
     
     /**
      *  Dibujador de todo.
      *  
      *  @param g Graficos donde se dibuja todo
      */  
     protected void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         Graphics2D g2 =(Graphics2D)g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
         dibujaGrilla(g2);
         dibujaFiguras(g2);
     }
     
     /**
      * Dibuja todo en las listas
      *
      * @param  g2   Los Graphics2D correspondientes
      */
     private void dibujaFiguras(Graphics2D g2)
     {
        for(int j = 0; j < lineas.size(); j++)
             ((Linea2D)lineas.get(j)).dibujar(g2);
         for(int j = 0; j < uml_2.size(); j++)
         {
             ((Ovulo2D)uml_2.get(j)).dibujar(g2);
             if(dibujaLimite)
                 ((Ovulo2D)uml_2.get(j)).dibujarLimite(g2,new Color(54,137,199));
         }    
         if(arrastrado)
             g2.draw(linea);
     }
     
     /**
      * Dibuja la grilla, si es que esta seleccionada
      *
      * @param  gg  el Graphics2D en el ke se dibuja
      */
     private void dibujaGrilla(Graphics2D gg)
     {
        if(grilla_uno) Grillero.grillaLinea(gg,0,0,getWidth(),getHeight());
     }
     
     /**
      *  Dibuja la linea temporal.
      *  
      *  @param p1, p2 Puntos que definen la linea
      */  
     public void setLine(Point p1, Point p2)
     {
         linea.setLine(p1, p2);
         repaint();
     }
     
     /**
      *  Obtener la lista de modelado de aplicaciones web.
      *  
      *  @return la lista de objetos
      */
     public List getUML2List()
     {
         return uml_2;
     }
     
     /**
      *  Reemplaza la lista de modelado de aplicaciones web.
      *  
      *  @param la nueva lista de objetos
      */
     public void setUML2List(List nueva)
     {
         uml_2 = nueva;
     }
     
     /** 
      * Obtener la lista de lineas.
      * 
      * @return la lista de lineas
      */
     public List getLineList()
     {
         return lineas;
     }
     
     /**
      *  Reemplaza la lista de lineas.
      *  
      *  @param la nueva lista de lineas
      */
     public void setLineList(List nueva)
     {
         lineas = nueva;
     }
     
     /**
      * Borra todos los objetos.
      */
     public void borraTodo()
     {
         uml_2.clear();
         lineas.clear();
         setAreaWidth(0);
         setAreaHeight(0);
         repaint();
     }
     
     public void arrastrar(boolean buliano)
     {
         arrastrado = buliano;
     }
     
     public void dibujarLimite(boolean bb)
     {
         dibujaLimite = bb;
     }
     
     public boolean arrastrando()
     {
         return arrastrado;
     }
     
     public boolean dibujandoLimite()
     {
         return dibujaLimite;
     }
     
     public Dimension getPreferredSize()
     {
         return area;
     }
     
     public int print(Graphics g, PageFormat pf, int pi) throws PrinterException 
     {
        if (pi >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        dibujaFiguras((Graphics2D) g);
            return Printable.PAGE_EXISTS;
    }
    
    /**
     * Borra un objeto de la lista.
     *
     * @param  ovo  El ovulo que se eliminara
     */
    public void borrarEste(Ovulo2D ovo)
    {
        boolean blas = uml_2.remove(ovo);
        Linea2D lk = null;
        
        for(int j = 0; j < lineas.size(); j++)
        {
            lk = ((Linea2D)lineas.get(j));
            
            if( ovo.equals(lk.puntoUno()) )
            {
                blas = lineas.remove(lk);
                j--;
            }
            else if( ovo.equals(lk.puntoDos()) )
            {
                blas = lineas.remove(lk);
                j--;
             }
        }
    }
    
    /**
     * Borra una linea de la lista.
     *
     * @param  line  La linea que se eliminara
     */
    public void borrarEste(Linea2D line)
    {
        boolean blas = lineas.remove(line);
    }
    
    /**
     * Devuelve el tamaño actual del panel.
     * Este dato cambia conforme a como se dibujen las figuras.
     * Si no existen figuras, se retornara un objeto Dimension igual a (0,0)
     *
     * @return    el tamaño del panel
     */
    public Dimension Area()
    {
        return area;
    }
    
    /**
     * Cambia el ancho representativo del objeto.
     *
     * @param  W  un nuevo ancho
     */
    public void setAreaWidth(int W)
    {
        area.width = W;
    }
    
    /**
     * Cambia el alto representativo del objeto.
     *
     * @param  H  un nuevo ancho
     */
    public void setAreaHeight(int H)
    {
        area.height = H;
    }
    
    /**
     * Setea el tipo de grilla uno. Para sacarlo se debe setear  ninguna grilla
     *
     */
    public void setGrilla1()
    {
        grilla_uno = true;
    }
    
    /**
     * Elimina cualquier grilla
     *
     */
    public void setNoGrilla()
    {
        grilla_uno = false;
    }
}


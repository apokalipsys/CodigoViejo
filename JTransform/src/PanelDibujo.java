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
    Estrellita estrella;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    private JLabel p5;
    private JLabel coord;
     /**
      * Contructor del panel
      */
     public PanelDibujo()
     {
         setBackground(Color.white);
         
        coord = new javax.swing.JLabel("Coordenadas");
        p1 = new javax.swing.JLabel("P1");
        p2 = new javax.swing.JLabel("P2");
        p3 = new javax.swing.JLabel("P3");
        p4 = new javax.swing.JLabel("P4");
        p5 = new javax.swing.JLabel("P5");
        
        
     }
     
     /**
      *  Dibujador de todo.
      *  
      *  @param g Graficos donde se dibuja todo
      */  
     protected void paintComponent(Graphics g)
     {
         if(estrella == null)
         {
             Point2D.Double centro = new Point2D.Double(getWidth()/2,getHeight()/2/*200,200*/);
             estrella = new Estrellita(5,centro,20,2, -0.5*Math.PI);
             
             org.jdesktop.layout.GroupLayout panelDibujoLayout = new org.jdesktop.layout.GroupLayout(this);
        setLayout(panelDibujoLayout);
        panelDibujoLayout.setHorizontalGroup(
            panelDibujoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDibujoLayout.createSequentialGroup()
                .add(panelDibujoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(p1)
                    .add(coord)
                    .add(p2)
                    .add(p3)
                    .add(p4)
                    .add(p5))
                .addContainerGap(1567, Short.MAX_VALUE))
        );
        panelDibujoLayout.setVerticalGroup(
            panelDibujoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelDibujoLayout.createSequentialGroup()
                .add(coord)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(p5)
                .addContainerGap(296, Short.MAX_VALUE))
        );
        revalidate();
         }
         
         super.paintComponent(g);
         Graphics2D g2 =(Graphics2D)g;
         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
         dibujaFiguras(g2);
     }
     
     /**
      * Dibuja todo en las listas
      *
      * @param  g2   Los Graphics2D correspondientes
      */
     private void dibujaFiguras(Graphics2D g2)
     {
       estrella.dibujar(g2);
       cambiaCoordenadas();
     }
     
     private void cambiaCoordenadas()
     {
         try
         {
             p1.setText("P1: "+(int)estrella.getPoint2DAt(0).getX()+" "+(int)estrella.getPoint2DAt(0).getY());
             p2.setText("P2: "+(int)estrella.getPoint2DAt(1).getX()+" "+(int)estrella.getPoint2DAt(1).getY());
             p3.setText("P3: "+(int)estrella.getPoint2DAt(2).getX()+" "+(int)estrella.getPoint2DAt(2).getY());
             p4.setText("P4: "+(int)estrella.getPoint2DAt(3).getX()+" "+(int)estrella.getPoint2DAt(3).getY());
             p5.setText("P5: "+(int)estrella.getPoint2DAt(4).getX()+" "+(int)estrella.getPoint2DAt(4).getY());
         }catch(java.lang.ArrayIndexOutOfBoundsException aioobe){;}
     }
     
     public void traslar(double tx, double ty)
     {
         estrella.traslar(tx,ty);
     }
     
     public void rotar(double tx, double ty, double theta )
     {
        estrella.rotar(tx,ty,theta);
     }
     
     public void escalar(double sx, double sy)
     {
         estrella.escalar(sx,sy);
     }
     
     public void shear(double shx, double shy)
     {
         estrella.shear(shx,shy);
     }
     
     public void afinar(double h1,double h2,double h3,double h4)
     {
         estrella.afinar(h1,h2,h3,h4);
     }
     
     public int print(Graphics g, PageFormat pf, int pi) throws PrinterException 
     {
        if (pi >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        dibujaFiguras((Graphics2D) g);
            return Printable.PAGE_EXISTS;
    }
    
    public void setEstrella(Estrellita e)
    {
        estrella = e;
    }
    
    public void updateView()
    {
        Rectangle u = estrella.getBounds();
        int centroX = 100;//getWidth()/2;
        int centroY = 100;//getHeight()/2;
        
        if(!getVisibleRect().contains(u))
        {
            Point2D.Double[] aux = estrella.getRealPoints2D().clone();
            setPreferredSize(new Dimension(u.width,u.height));
            int difX = u.x - centroX;
            int difY = u.y - centroY;
            estrella.traslar((double)-difX,(double)-difY);
            estrella.setRealPoints2D(aux);
        }
        scrollRectToVisible(u);
        //setPreferredSize(new Dimension(getWidth()+u.x+u.width,getHeight()+u.height+u.y));
        revalidate();
    }
}



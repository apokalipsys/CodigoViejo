
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class cara extends Applet implements AdjustmentListener
{
    Scrollbar ojos, nariz, boca;
    int vojos, vnariz, vboca;

    public void init()
    {
    
        resize(800,600);
        
        Label o = new Label ("Tipo de Ojos");
        add(o);
        ojos = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 7);
        add(ojos);
        ojos.addAdjustmentListener(this);
        
        Label n = new Label ("Tipo de Nariz");
        add(n);
        nariz = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 5);
        add(nariz);
        nariz.addAdjustmentListener(this);
        
        Label b = new Label ("Tipo de Boca");
        add(b);
        boca = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 7);
        add(boca);
        boca.addAdjustmentListener(this);

    }

    public void paint(Graphics g)
    {
        g.setColor(Color.yellow);
        g.fillOval(200,100,400,400);
        g.setColor(Color.white);
        g.fillOval(300,170,60,60);
        g.fillOval(440,170,60,60);
        g.setColor(Color.black);
        
        switch (vojos)
        {
            case 1: { g.fillOval(320,190,20,20);
                      g.fillOval(460,190,20,20);
                    }                           ;break;
            case 2: { g.fillOval(320,170,20,20);
                      g.fillOval(460,170,20,20);
                    }                           ;break;
            case 3: { g.fillOval(320,210,20,20);
                      g.fillOval(460,210,20,20);
                    }                           ;break;
            case 4: { g.fillOval(300,190,20,20);
                      g.fillOval(440,190,20,20);
                    }                           ;break;
            case 5: { g.fillOval(340,190,20,20);
                      g.fillOval(480,190,20,20);
                    }                           ;break;
            case 6: { g.fillOval(340,190,20,20);
                      g.fillOval(440,190,20,20);
                    }                           ;break;
        }
        
        switch (vnariz)
        {   
            case 1 :{ g.fillOval(390,310,5,5);
                      g.fillOval(410,310,5,5);
                    }                             ;break;
            case 2 :{ g.drawLine(400,200,430,310);
                      g.drawLine(430,310,400,350);
                    }                             ;break;
            case 3 :{ g.drawLine(360,350,400,300);
                      g.drawLine(400,300,440,350);
                    }                             ;break;
            case 4 :{ g.drawLine(360,350,400,300);
                      g.drawLine(400,300,440,350);
                      g.drawLine(360,350,440,350);
                      g.drawLine(400,200,400,300);
                    }                             ;break;
         }    
         
         switch (vboca)
         {  
            case 1 : g.drawArc(350,410,100,50,180,180); break;
            case 2 : g.drawArc(350,410,100,50,0,180);   break;
            case 3 : g.drawLine(350,410,450,410);       break;
            case 4 : {g.setColor(Color.red);
                      g.fillArc(400,385,50,50,180,180);
                      g.setColor(Color.black);
                      g.drawLine(350,410,450,410);
                     }                                  break;
            case 5 : g.fillOval(375,375,50,50);         break;
            case 6 : g.fillArc(350,410,100,50,180,180); break; 
         }
         
    }
    
    public void adjustmentValueChanged (AdjustmentEvent event)
    {
        vojos = ojos.getValue();
        vnariz = nariz.getValue();
        vboca = boca.getValue();
        
        repaint();
    }
    
    public static void main(String[] argumento)
    {
        final Frame f = new Frame("Cara");
      
      f.addWindowListener
      (
        new WindowAdapter()
       {
            public void windowClosing(WindowEvent e)
            {
               f.dispose();
            }
       }
      );

        Applet applet = new cara();
        f.add(applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(320,360));
        f.setVisible(true);
    }
}
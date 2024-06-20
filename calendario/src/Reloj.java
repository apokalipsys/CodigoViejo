import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
/**
 * Inicializa el reloj JavaClock 2.0 by Antony Pranata
 * 
 * @author BOo
 * @version 0.1
 */
public class Reloj
{
    public Reloj()
    {
        final Frame f = new Frame("Reloj");
      
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

        Applet applet = new Analog();
        f.add(applet);
        applet.init();

        f.pack();
        f.setSize(new Dimension(170,132));
        f.setResizable(false);
        f.setVisible(true);
        
        while(true)
        {
           try{
               Thread.sleep(50);
           } catch(InterruptedException IE) {;}    
           applet.repaint();
        }   
    }

}

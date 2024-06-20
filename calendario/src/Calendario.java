import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;


/**
 * Crea un calendario Visual.
 * 
 * @author BOo
 * @version 0.1
 */
public class Calendario
{
	public Calendario()
	{
		final Frame f = new Frame("Calendario Perpetuo Visual");
      
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

        Applet applet = new pantCalendar();
        f.add(applet);
        applet.init();
        f.pack();
        f.setSize(new Dimension(320,360));
        f.setVisible(true);
        
        f.setIconImage(makeIcon.iCalendario);
        
	}

	
}

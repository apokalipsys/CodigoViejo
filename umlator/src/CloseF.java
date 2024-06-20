import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Cerrador de Frames, solo lo cierra y punto...
 * 
 * @author BOo
 * @version 0.1
 */
public class CloseF
{
	JFrame aCerrar;
			
	public CloseF(JFrame frame)
	{
	    aCerrar = frame;
	    
	    aCerrar.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   System.exit(0);
              }
           }   
        );
    }    
}

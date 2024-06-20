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
	Frame aCerrar;
	String alerta;
	
	
	public CloseF(Frame frame, String aviso)
	{
	    aCerrar = frame;
	    alerta = aviso;
	    
	    aCerrar.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                    JOptionPane.showMessageDialog(null,alerta);
                    System.exit(0);
              }
           }   
        );
	}
	
	public CloseF(Frame frame)
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

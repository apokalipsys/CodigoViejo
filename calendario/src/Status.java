import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.Applet;
/**
 * Ventana que muestra el analisis previo al calculo de fecha
 * 
 * @author BOo
 * @version 0.2
 */
public class Status extends Frame
{
    static TextArea u;
    
    public Status()
    {
        setSize(320,120);
        setTitle("Status");
        
        u = new TextArea("",15,15);
        u.setEditable(false);
        add(u);
        
        this.setVisible(true);
        
        this.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   dispose();
              }
           }   
        );
        
        this.setIconImage(makeIcon.iStatus);
    }

    public static TextArea recuTextA()
    {
        return u;
    }
}

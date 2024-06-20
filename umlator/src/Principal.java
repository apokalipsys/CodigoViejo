import java.awt.*;
import javax.swing.*;

/**
 * Principal, eso, crea la ventana..
 * 
 * @author BOo
 * @version 0.11
 * 
 */
public class Principal extends JFrame implements Vendible
{
    public Principal()
    {
       setTitle("UMLator");
    }
   
    public static void main(String args[])
    {
        SplashWindow spl = new SplashWindow();
        final JFrame nf = new Principal();
         
        spl.manejaProgresoBarra(20);
        nf.setSize(800,600);
        spl.manejaProgresoBarra(40);
        final Faz gui = new Faz(nf);
        spl.manejaProgresoBarra(60);
        CloseF cerrar = new CloseF(nf);
        spl.manejaProgresoBarra(80);
        nf.setVisible(true);
        spl.manejaProgresoBarra(100);
        spl.remove();
    }    

    
}
                  

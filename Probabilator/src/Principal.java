import java.awt.*;
import javax.swing.*;

/**
 * Principal, eso, crea la ventana..
 * 
 * @author BOo
 * @version 0.11
 * 
 */
public class Principal extends JFrame
{
    public Principal()
    {
       setTitle("Estadistico (Teorema Central del Límite)");
    }
   
    public static void main(String args[])
    {
        final JFrame nf = new Principal();
         
        nf.setSize(800,600);
        final Estadistico gui = new Estadistico(nf);
        nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nf.setVisible(true);
    }    

    
}
                  

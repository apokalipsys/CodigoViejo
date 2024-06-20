import java.awt.*;
import javax.swing.*;
/**
 * Ejecuta el programa Calendario Perpetuo Moret.
 * 
 * @author BOo
 * @version 0.1
 */
public class Corrible extends JFrame
{
    public Corrible()
    {
        setTitle("Calendario Perpetuo Moret");
    }

    public static void main(String args[])
    {
        if(args.length > 0 && args[0].equals("startup"))
            startup.Start.startup();
        else
        {
            final JFrame nf = new Corrible();
            nf.setSize(800,600);
            final IG gui = new IG(nf);
            CloseF cerrar = new CloseF(nf);
            nf.setVisible(true);
        }
    }    
}

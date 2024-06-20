
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

public class SplashWindow extends JWindow
    implements WindowListener
{

    private JLabel image;
    private JProgressBar tarea;

    public SplashWindow()
    {
        java.net.URL url = getClass().getResource("/src/splash.jpg");
        ImageIcon imageicon = new ImageIcon(url);
        image = new JLabel(imageicon);
        image.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        getContentPane().add(image);
        tarea = new JProgressBar(0,100);
        tarea.setValue(0); 
        tarea.setStringPainted(true);
        tarea.setString("Cargando");
        getContentPane().add(tarea, BorderLayout.SOUTH); 
        pack();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dimension.width - getSize().width) / 2, (dimension.height - getSize().height) / 2);
        addWindowListener(this);
        setVisible(true);
    }

    public void remove()
    {
        dispose();
    }

    public void windowOpened(WindowEvent windowevent)
    {
        Graphics2D graphics2d = (Graphics2D)getGlassPane().getGraphics();
        graphics2d.setColor(new Color(51, 102, 153));
        graphics2d.setFont(new Font("SansSerif", 0, 16));
        graphics2d.drawString("BETA BETA", 26, image.getHeight() - 20);
    }

    public void windowActivated(WindowEvent windowevent)
    {
    }

    public void windowClosed(WindowEvent windowevent)
    {
    }

    public void windowClosing(WindowEvent windowevent)
    {
    }

    public void windowDeactivated(WindowEvent windowevent)
    {
    }

    public void windowDeiconified(WindowEvent windowevent)
    {
    }

    public void windowIconified(WindowEvent windowevent)
    {
    }
    
    public void manejaProgresoBarra(int porcentaje)
    {
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        tarea.setValue(porcentaje);
        tarea.setString("Cargando "+porcentaje+"%");
        if (porcentaje == 100)
        { 
            Toolkit.getDefaultToolkit().beep();
            getContentPane().setCursor(null); 
            tarea.setValue(tarea.getMinimum()); 
            tarea.setString("Listo");
        } 
    }

}

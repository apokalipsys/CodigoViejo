import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Crea los iconos de las diferentes ventanas
 *
 * @author BOo
 * @version 0.2
 */
public class makeIcon
{
	 public final static Image iCorrible = Toolkit.getDefaultToolkit().createImage(makeIcon.class.getResource("icoPrinc.jpg"));
	 public final static Image iStatus = Toolkit.getDefaultToolkit().createImage(makeIcon.class.getResource("icoCheckStatus.gif"));
	 public final static Image iFechaImp = Toolkit.getDefaultToolkit().createImage(makeIcon.class.getResource("icoFechIMP.gif"));
	 public final static Image iCalendario = Toolkit.getDefaultToolkit().createImage(makeIcon.class.getResource("icoCalendarVis.gif"));
	 private final static int VERSION = 0;
	 private final static int VERSION_TRY = 2;
                 private final static String AUTOR = "BOo";

                 public static String autor()
                 {
                             return AUTOR;
                  }

                 public static String version()
                 {
                             return VERSION+"."+VERSION_TRY;
                  }

                  public static void showAvailableIcons()
                  {
                            Image IMAGES[] = new Image[4];

                            IMAGES[0]=iCorrible;
                            IMAGES[1]=iStatus;
                            IMAGES[2]=iFechaImp;
                            IMAGES[3]=iCalendario;

                             JOptionPane.showMessageDialog(null, IMAGES,
                                                "Iconos Disponibles",
                                                JOptionPane.INFORMATION_MESSAGE, null);
                   }
}

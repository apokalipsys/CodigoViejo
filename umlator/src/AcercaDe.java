import javax.swing.*;
import java.awt.*;
/**
 * Solo una tontera
 * 
 * @author BOo 
 * @version 0.1
 */
public class AcercaDe
{
    
    private static String uno = "UMLator 2.0 beta";
    private static String uno1 = "Hecho para Modelado Visual (Programacion IV)";
    private static String uno2 = "Ramo impartido por G.Donoso.";
    private static String dos = "UMLator © Todos Los Derechos";
    private static String dos1 = "El que copia la idea se va de P.L.R.";
    private static String tres = "Corriendo sobre :";
    private static String tres1 = "Máquina Virtual : " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + " (" + System.getProperty("java.vm.vendor") + ")";
    private static String tres2 = "Sistema Operativo : " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ")";
    private static String cuatro = "Agradecemos los trabajos de :";
    private static String cuatro1 = "   - TiTaN Team (TiTaN Paint! v. 1.0.1)";
    private static String cuatro2 = "   - BOo Softgüare (Blok de Apuntes 2.0 Experimental (v 0.487 beta 1) )";
    private static String cuatro3 = "Nos sirvieron, see XD.";
    private static String wip = "\"Work in Progress\"";
    private static String wip1 = "- Aun faltan algunas cosas con la linea";
    private static String wip2 = "- Scrollbars :S";
    private static String bug = "Fallas y Bugs";
    private static String bug1 = "no se han detectado errores graves :)";
    private static String qs = "Somos un trio de alumnos que, intentando pasar";
    private static String qs1 = "un ramo, nos embarcamos en este cachito.";
    private static String qs2 = "Programador en Jefe: BOo (Darío Díaz)";
    private static String qs3 = "Programación, investigación y  pruebas: Jota (Manuel Morales)";
    private static String qs4 = "                                        JEGA (Jaime Guala)";
    private static String nullo = "";

    /**
     * Todo lo que se tiene que saber el usuario acerca de los programadores.
     * 
     * @return   un JTabbedPane con toda la info.
     */
    public static JTabbedPane de()
    {
        JTabbedPane jtp = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT );
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(0,1));
        jp.add(new JLabel(uno));
        jp.add(new JLabel(uno1));
        jp.add(new JLabel(uno2));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(dos));
        jp.add(new JLabel(dos1));
        jtp.addTab("Programa", null, jp, "Acerca del Programa");
        jp = new JPanel();
        jp.setLayout(new GridLayout(0,1));
        jp.add(new JLabel(cuatro));
        jp.add(new JLabel(cuatro1));
        jp.add(new JLabel(cuatro2));
        jp.add(new JLabel(cuatro3));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(dos));
        jp.add(new JLabel(dos1));
        jtp.addTab("Agradecimientos", null, jp, "En que nos basamos");
        jp = new JPanel();
        jp.setLayout(new GridLayout(0,1));
        jp.add(new JLabel(tres));
        jp.add(new JLabel(tres1));
        jp.add(new JLabel(tres2));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(dos));
        jp.add(new JLabel(dos1));
        jtp.addTab("Sist. Operativo", null, jp, "Estamos funcionando en tu S.O.");
        jp = new JPanel();
        jp.setLayout(new GridLayout(0,1));
        jp.add(new JLabel(qs));
        jp.add(new JLabel(qs1));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(qs2));
        jp.add(new JLabel(qs3));
        jp.add(new JLabel(qs4));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(dos));
        jp.add(new JLabel(dos1));
        jtp.addTab("Quienes Somos", null, jp, "Un pequeño review");
        jp = new JPanel();
        jp.setLayout(new GridLayout(0,1));
        jp.add(new JLabel(wip));
        jp.add(new JLabel(wip1));
        jp.add(new JLabel(wip2));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(bug));
        jp.add(new JLabel(bug1));
        jp.add(new JLabel(nullo));
        jp.add(new JLabel(dos));
        jp.add(new JLabel(dos1));
        jtp.addTab("WIP/BUGS", null, jp, "Nada es perfecto...");
        return jtp;
    }
}

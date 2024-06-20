import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Agenda Mula.
 * 
 * @author BOo
 * @version 0.1
 */
public class Agendita extends Frame implements ActionListener 
{
    private MenuBar barra;
    private Menu File, nada, Santo;
    private MenuItem abrir, salir, guardar, reset, linea;
    private Santoral ss;
    private ManejadorArchivo manej;
    private TextArea texto;
    private int agendaDia, agendaMes, agendaAgno;

    public Agendita(int dia, int mes, int year)
    {
        agendaDia = dia;
        agendaMes = mes;
        agendaAgno = year;
        
        setTitle("Agenda : "+agendaDia+"/"+agendaMes+"/"+agendaAgno);
        
        barra = new MenuBar();
        
        File = new Menu("Archivo");
        
        abrir = new MenuItem("Abrir");
        File.add(abrir);
        abrir.addActionListener(this);
        guardar = new MenuItem("Guardar");
        File.add(guardar);
        guardar.addActionListener(this);
        File.addSeparator();
        reset = new MenuItem("Limpiar Pantalla");
        File.add(reset);
        reset.addActionListener(this);
        File.addSeparator();
        salir = new MenuItem("Salir");
        File.add(salir);
        salir.addActionListener(this);
        barra.add(File);
        
        nada = new Menu("Herramientas");
        linea = new MenuItem("--------------");
        nada.add(linea);
        linea.addActionListener(this);
        barra.add(nada);
        
        
        ss = new Santoral(agendaDia,agendaMes-1);
        
        Santo = new Menu("Santoral: "+ss.elSanto());
        barra.add(Santo);
        
        this.setMenuBar(barra);
        
        texto = new TextArea("",10,50);
        add(texto); 
        
        manej = new ManejadorArchivo(this);
        manej.abrirSilent(texto, "A"+agendaDia+agendaMes+agendaAgno+".agn");
        
        this.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                  JTextField o = new JTextField();
                  o.setText(texto.getText());
                   manej.Cerrar(o);
                   dispose();
              }
           }   
        );
        
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == abrir)
        {
            JTextField o = new JTextField();
            manej.Abrir(o);
            texto.setText(o.getText());
        }
        if(e.getSource() == guardar)
            manej.Updatear(new JTextField(texto.getText()), "A"+agendaDia+agendaMes+agendaAgno+".agn");
        
        if(e.getSource() == reset)
        {
            int opc = JOptionPane.showConfirmDialog(null,"Desea Borrar todo el contenido de esta Agenda?");
        
            if(opc == JOptionPane.YES_OPTION)
            {
                texto.setText("");
            }
        
            else 
            if(opc == JOptionPane.NO_OPTION)
            {
            }
            else
            if(opc == JOptionPane.CANCEL_OPTION)
            {
            }
            else
            if(opc == JOptionPane.CLOSED_OPTION)
            {
            }
        }
        
        if(e.getSource() == salir)
        {
            JTextField o = new JTextField();
                  o.setText(texto.getText());
                   manej.Cerrar(o);
            dispose();
        }    
        
        if(e.getSource() == linea)
            texto.insertText("\n--------------------------------------------------\n",(int)texto.getSelectionStart());
    }
}

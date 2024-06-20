import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
/**
 * Agenda Telef�nica
 * 
 * @author BOo 
 * @version 0.2
 */
public class AgendaTelefonica extends JFrame implements ActionListener
{
    private Database base;
    private MenuBar barra;
    private Menu File, Buscar, cant;
    private MenuItem agregar, edit, porNombre, porApellido, b1, b2; 
    private JTabbedPane ag;

    public AgendaTelefonica()
    {
        base = new Database();
        if((new File("DB00001.db")).exists())       
            base = base.leer("DB00001.db");

        setTitle("Agenda Telefónica");
        
        barra = new MenuBar();
        
        File = new Menu("Archivo");
        agregar = new MenuItem("Agregar Persona");
        File.add(agregar);
        agregar.addActionListener(this);
        agregar.setEnabled(true);
        edit = new MenuItem("Editar");
        File.add(edit);
        edit.addActionListener(this);
        
        barra.add(File);
        
        /*
        Buscar = new Menu("Buscar");
        b1 = new MenuItem("Buscar");
        Buscar.add(b1);
        b1.addActionListener(this);
        b2 = new MenuItem("Buscar (S&D)");
        Buscar.add(b2);
        b2.addActionListener(this);
        
        barra.add(Buscar);
        */
        cant = new Menu("    Personas : "+base.size()+"    ");
        barra.add(cant);
        
        
        
        setMenuBar(barra);
        
        ag = new JTabbedPane();
        
        for(int i = 65; i <= 90; i++)
           ag.addTab(String.valueOf((char)i), null, Tablas.tabla(), String.valueOf((char)i));
           
        ag.addTab("Todos", null, Tablas.tabla(), "All po!");   
        
        
        addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   base.guardar("DB00001.db");
                  
                   dispose();
              }
           }   
        );
        
    }

    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getSource() == agregar)
        {
            CreatePerson venta = new CreatePerson(base, "DB00001.db");
            venta.setSize(285,400);
            venta.setVisible(true);
        }
        
        if(evento.getSource() == edit)
        {
            CreatePerson venta = new CreatePerson(base, "DB00001.db");
            venta.setSize(285,400);
            venta.setVisible(true);
        }

        boolean byName = false;
        boolean bySur = false;
        if(evento.getSource() == porNombre)
        {
            byName = true;
            bySur = false;
            base.reordenarPorNombre();
        }
        
        if(evento.getSource() == porApellido)
        {
            byName = false;
            bySur = true;
            base.reordenarPorApellido();
        }
        
//        if(evento.getSource() == der)
//        {
//            i++;
//
//            if(i >= base.size())
//               i = 0;
//
//            if(byName)
//            {
//                Persona esta = base.get(i);
//                texto.setText(esta.toStringbyName());
//            }
//            if(bySur)
//            {
//                Persona esta = base.get(i);
//                texto.setText(esta.toStringbySurname());
//            }
//        }
//
//        if(evento.getSource() == izq)
//        {
//            i--;
//
//            if(i<0)
//               i = base.size()-1;
//
//            if(byName)
//            {
//                Persona esta = base.get(i);
//                texto.setText(esta.toStringbyName());
//            }
//            if(bySur)
//            {
//                Persona esta = base.get(i);
//                texto.setText(esta.toStringbySurname());
//            }
//        }
        
        if(evento.getSource() == b1)
        {
            String este;
            Persona ver;
            int n;
            
            este = (String) JOptionPane.showInputDialog(null, "Introduzca Nombre o Apellido",
                                                        "Buscar", JOptionPane.INFORMATION_MESSAGE);
            
            n = base.buscar(este);
            
            if(n != 0)
            {
                ver = base.get(n);
                
                if(byName)
                {
                    //texto.setText(ver.toStringbyName());
                }
                if(bySur)
                {
                    //texto.setText(ver.toStringbySurname());
                }  
            }
            else
                JOptionPane.showMessageDialog(null, "No se encontro \n"+este,
                                                "Error",
                                                JOptionPane.ERROR_MESSAGE);
        }
        
        if(evento.getSource() == b2)
        {
            String este;
            
            este = (String) JOptionPane.showInputDialog(null, "Introduzca Nombre o Apellido",
                                                        "Seek & Destroy", JOptionPane.INFORMATION_MESSAGE);
            
            base.Eliminar(este);
        }
        
    }
}

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;
/**
 * Interfaz de Calendario Perpetuo.
 * 
 * @author BOo
 * @version 0.2b
 */
public class IG implements ActionListener
{
    private JMenuBar barra;
    private JMenu File, hAbout, Herra, Agenda1;
    private JMenuItem abrir, salir, about;
    private JMenuItem vHoy, feImpor, calc, vCal, clok, san, opcB;
    private JMenuItem agenda2, telef;
    private JFrame padre;
    private JTextField Texto;
    private Choice d, m, a;
    private ManejadorArchivo evAr;
    private JButton boton;
    private Icon icoRelojes;
    private String opc;
    private Date fecha;
    
    public IG(JFrame frame)
    {
        padre = frame;
        
        barra = new JMenuBar();
        
        File = new JMenu("Archivo");
        
        abrir = new JMenuItem("Abrir Log");
        File.add(abrir);
        abrir.addActionListener(this);
        File.addSeparator();
        salir = new JMenuItem("Salir");
        File.add(salir);
        salir.addActionListener(this);
        barra.add(File);
        
        Herra = new JMenu("Herramientas");
        
        calc = new JMenuItem("Ver dia");
        Herra.add(calc);
        calc.addActionListener(this);
        vHoy = new  JMenuItem("Ver dia \"HOY\"");
        Herra.add(vHoy);
        vHoy.addActionListener(this);
        feImpor = new JMenuItem("Fechas Importantes");
        Herra.add(feImpor);
        feImpor.addActionListener(this);
        Herra.addSeparator();
        vCal = new JMenuItem("Ver Calendario");
        Herra.add(vCal);
        vCal.addActionListener(this);
        clok = new JMenuItem("Reloj");
        Herra.add(clok);
        clok.addActionListener(this);
        clok.setEnabled(false);
        san = new JMenuItem("Santoral de Hoy");
        Herra.add(san);
        san.addActionListener(this);
        Herra.addSeparator();
        opcB = new JMenuItem("Opciones");
        Herra.add(opcB);
        opcB.addActionListener(this);
        opcB.setEnabled(false);
        
        Agenda1 = new JMenu("Agenda");
        agenda2 = new JMenuItem("Ver Hoy");
        Agenda1.add(agenda2);
        agenda2.addActionListener(this);
        telef = new JMenuItem("Agenda Telef�nica");
        Agenda1.add(telef);
        telef.addActionListener(this);
        telef.setEnabled(true);
        Herra.add(Agenda1);
        
        barra.add(Herra);
        
        hAbout = new JMenu("Ayuda");
        
        about = new JMenuItem("Acerca de...");
        hAbout.add(about);
        about.addActionListener(this);
        barra.add(hAbout);
        
        padre.setJMenuBar(barra);
        
        JPanel superior = new JPanel();
        
        JLabel di = new JLabel("Dia");
        d = new Choice();
        for(int i = 1; i<=31; i++)
           d.add(""+i);
        
        JLabel me = new JLabel("Mes");
        m = new Choice();
        for(int i = 1; i<=12; i++)
           m.add(""+i);   
        
        JLabel aL = new JLabel("Año");
        a = new Choice();
        for(int i = 1; i<=2499; i++)
           a.add(""+i);   
        
        superior.add(di);
        superior.add(d);
        superior.add(me);
        superior.add(m);
        superior.add(aL);
        superior.add(a);
        
        boton = new JButton("Ver Dia");
        superior.add(boton);
        boton.addActionListener(this);
        
        padre.getContentPane().add("North", superior);
        
        Texto = new JTextField("");
        padre.getContentPane().add("Center",Texto); 
        
        evAr = new ManejadorArchivo(padre);
        
        
        opc = "";
        try
        {
            BufferedReader lector = new BufferedReader(new FileReader("C:\\moret.opc"));
            opc = (String) lector.readLine();  
            lector.close();
         }
        catch(IOException error)
        {
            JOptionPane.showMessageDialog(null, "Error al cargar las opciones :\n"+
                                                error.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
        }

        
        fecha = new Date();
        String fechast = ""+fecha.getDate()+"/"+(fecha.getMonth()+1)+"/"+(fecha.getYear()+1900)+"."+fecha.getHours()+"."+
                         fecha.getMinutes()+"."+fecha.getSeconds();
        String felog = ""+(fecha.getMonth()+1)+(fecha.getYear()+1900);
        
        Texto.setText("Sesi�n Iniciada : "+fechast);
        evAr.Updatear(Texto, "L"+felog+".mor");
        
        icoRelojes = new ImageIcon("lib/images/icoclocks.jpg");
        
        padre.setIconImage(makeIcon.iCorrible);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == abrir)
        {
            evAr.Abrir(Texto);   
        }
        if(e.getSource() == salir)
        {
            System.exit(0);
        }
        if(e.getSource() == calc || e.getSource() == boton)
        {
            Frame vU = new Status();
            calendas fechilla = new calendas(Integer.parseInt(d.getSelectedItem()), Integer.parseInt(m.getSelectedItem()), Integer.parseInt(a.getSelectedItem()));
            TextArea tta = new TextArea(Texto.getText());
            fechilla.procesar(tta, Status.recuTextA());
            Texto.setText(tta.getText());
            evAr.Updatear(new JTextField(Status.recuTextA().getText()), null);
            evAr.Updatear(new JTextField(""+d.getSelectedItem()+"/"+m.getSelectedItem()+"/"+m.getSelectedItem()), null);
            evAr.Updatear(Texto, null);
        }
        
        if(e.getSource() == feImpor)
        {
            Frame vI = new FechaImp();
        }
        
        if(e.getSource() == vHoy)
        {
            String Day="";
            Date puroWe = new Date();
            
            switch(puroWe.getDay())
            {
                case 0 : Day = "Domingo"; break;
                case 1 : Day = "Lunes"; break;
                case 2 : Day = "Martes"; break;
                case 3 : Day = "Miercoles"; break;
                case 4 : Day = "Jueves"; break;
                case 5 : Day = "Viernes"; break;
                case 6 : Day = "Sabado"; break;
            }
            
            Texto.setText("Hoy es "+Day);
            
            evAr.Updatear(Texto, null);
        }
        
        if(e.getSource() == vCal)
        {
            Calendario visual = new Calendario();
        }
        
        if(e.getSource() == clok)
        {
            Reloj ver = new Reloj();
        }
        
        if(e.getSource() == san)
        {
            Texto.setText(Santoral.santoralHoy());
            
            evAr.Updatear(new JTextField(""+d.getSelectedItem()+"/"+m.getSelectedItem()+"/"+m.getSelectedItem()), null);
            evAr.Updatear(Texto, null);
        }
        
        if(e.getSource() == opcB)
        {
            String este;
            
            este = JOptionPane.showInputDialog(null, "Directorios\nLog", "Opciones", JOptionPane.INFORMATION_MESSAGE);
            try
            {
                    PrintWriter escritor = new PrintWriter(new FileWriter("C:\\moret.opc"), true);
                    escritor.print(este);
                    escritor.close();
            }catch (IOException E)
            {
                JOptionPane.showMessageDialog(null, "Error al guardar los datos :\n"+
                                                E.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
            }
            
            JOptionPane.showMessageDialog(null, "Los cambios tendr�n efecto la siguiente vez que inicie el programa");
        }
        
        if(e.getSource() == agenda2)
        {
            Agendita age = new Agendita(fecha.getDate(),(fecha.getMonth()+1),(fecha.getYear()+1900));
            age.setSize(300,300);
            age.setVisible(true);
        }
        
        if(e.getSource() == telef)
        {
            Frame at = new AgendaTelefonica();
            at.setSize(300,300);
            at.setVisible(true);
        }
        
        if(e.getSource() == about)
        {
            JOptionPane.showMessageDialog(null, "Calendario Perpetuo Moret v0.132 Beta� JAVAX-1\n"+
                                                "Hecho por BOo\n\n"+
                                                "Corriendo sobre :\n"+
                                                "M�quina Virtual : " + System.getProperty("java.vm.name") + " " + System.getProperty("java.vm.version") + " (" + System.getProperty("java.vm.vendor") + ")\n"+
                                                "Sistema Operativo : " + System.getProperty("os.name") + " " + System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ")\n\n"+
                                                "Calendario Perpetuo Moret � Todos Los Derechos\n"+
                                                "El que copia la idea se va de P.L.R.",
                                                "Acerca de \"Calendario Perpetuo Moret\"",
                                                JOptionPane.INFORMATION_MESSAGE, icoRelojes);
        }
    }  

}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 * Crea una nueva entrada en contactos y la agrega a la base
 * 
 * @author BOo
 * @version 0.1
 */
public class CreatePerson extends Frame implements ActionListener
{
    private Database data;
    private String archivo;
    private Button OK, CANCEL;
    private TextField nombre, apellido, nro1, nro2, nro3, nro4, web, mail, direccion, ciudad, trabajo;
    private Label n,ap,no1,no2,no3,no4,w,m,d,c, t;
    private Panel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10, p11, p12;
    private Persona persona;

    public CreatePerson(Database a, String b)
    {
        setTitle("Crear Contacto");
        
        data = a;
        archivo = b;
        
        OK = new Button("OK");
        CANCEL = new Button("Cancelar");
        OK.addActionListener(this);
        CANCEL.addActionListener(this);
        
        nombre = new TextField(20);
        apellido = new TextField(20);
        nro1 = new TextField(20);
        nro2 = new TextField(20);
        nro3 = new TextField(20);
        nro4 = new TextField(20);
        web = new TextField(20);
        mail = new TextField(20);
        direccion = new TextField(20);
        ciudad = new TextField(20);
        trabajo = new TextField(20);
        
        n = new Label("Nombre :");
        ap = new Label("Apellido :");
        no1 = new Label("Teléfono :");
        no2 = new Label("Fax :");
        no3 = new Label("Tel. Móvil :");
        no4 = new Label("Pager :");
        w = new Label("Página Web :");
        m = new Label("E-m@il :");
        d = new Label("Dirección :");
        c = new Label("Comuna :");
        t = new Label("Ocupacion :");
        
        p1 = p2 = p3 = p4 = p5 = p6 = p7 = p8 = p9 = p10 = p11 = p12 = new Panel();
        
        p1.add(n);
        p1.add(nombre);
        p2.add(ap);
        p2.add(apellido);
        p3.add(no1);
        p3.add(nro1);
        p4.add(no2);
        p4.add(nro2);
        p5.add(no3);
        p5.add(nro3);
        p6.add(no4);
        p6.add(nro4);
        p7.add(w);
        p7.add(web);
        p8.add(m);
        p8.add(mail);
        p9.add(d);
        p9.add(direccion);
        p10.add(c);
        p10.add(ciudad);
        p12.add(t);
        p12.add(trabajo);
        p11.add(OK);
        p11.add(CANCEL);
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
        add(p10);
        add(p12);
        add(p11);
        
        this.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   data.guardar(archivo);
                   dispose();
              }
           }   
        );
        
        setVisible(true);
        setResizable(false);
    }

    public CreatePerson(Database a, String b, int indice)
    {
        setTitle("Editar Contacto");
        
        data = a;
        archivo = b;
        
        persona = data.get(indice);
        
        OK = new Button("OK");
        CANCEL = new Button("Cancelar");
        OK.addActionListener(this);
        CANCEL.addActionListener(this);
        
        nombre = new TextField(persona.getName());
        apellido = new TextField(persona.getSurname());
        nro1 = new TextField(persona.getPhone());
        nro2 = new TextField(persona.getFax());
        nro3 = new TextField(persona.getMovil());
        nro4 = new TextField(persona.getPager());
        mail = new TextField(persona.getMail());
        direccion = new TextField(persona.getAddress());
        ciudad = new TextField(persona.getCity());
        
        data.remove(indice);
        
        n = new Label("Nombre :");
        ap = new Label("Apellido :");
        no1 = new Label("Teléfono :");
        no2 = new Label("Fax :");
        no3 = new Label("Tel. Móvil :");
        no4 = new Label("Pager :");
        w = new Label("Página Web :");
        m = new Label("E-m@il :");
        d = new Label("Dirección :");
        c = new Label("Comuna :");
        t = new Label("Ocupacion :");
        
        p1 = p2 = p3 = p4 = p5 = p6 = p7 = p8 = p9 = p10 = p11 = p12 = new Panel();
        
        p1.add(n);
        p1.add(nombre);
        p2.add(ap);
        p2.add(apellido);
        p3.add(no1);
        p3.add(nro1);
        p4.add(no2);
        p4.add(nro2);
        p5.add(no3);
        p5.add(nro3);
        p6.add(no4);
        p6.add(nro4);
        p7.add(w);
        p7.add(web);
        p8.add(m);
        p8.add(mail);
        p9.add(d);
        p9.add(direccion);
        p10.add(c);
        p10.add(ciudad);
        p12.add(t);
        p12.add(trabajo);
        p11.add(OK);
        p11.add(CANCEL);
        
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
        add(p10);
        add(p12);
        add(p11);
        
        this.addWindowListener
        (
           new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
              {
                   data.guardar(archivo);
                   dispose();
              }
           }   
        );
        
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent y)
    {
        if(y.getSource() == OK)
        {
            int opc = JOptionPane.showConfirmDialog(null, 
                                          "Desea agregar este contacto a la lista?", "Confirmación", JOptionPane.YES_NO_OPTION);
            
            switch(opc)
            {
                case JOptionPane.YES_OPTION : {
            Persona p = new Persona(nombre.getText(), apellido.getText(),
                                    nro1.getText(), nro2.getText(), nro3.getText(), nro4.getText(),
                                    mail.getText(), web.getText(),
                                    direccion.getText(), ciudad.getText(),
                                    trabajo.getText());
                              data.add(p);                       
            
                 }; break;
                case JOptionPane.NO_OPTION : ; break;
            }                           
        }
        
        if(y.getSource() == CANCEL)
        {
            int opc = JOptionPane.showConfirmDialog(null, 
                                          "Resetear la Pantalla", "Confirmación", JOptionPane.YES_NO_OPTION);
                                          
            switch(opc)
            {
                case JOptionPane.YES_OPTION : {
                                                   nombre.setText(""); 
                                                   apellido.setText("");
                                                   nro1.setText(""); 
                                                   nro2.setText(""); 
                                                   nro3.setText(""); 
                                                   nro4.setText("");
                                                   mail.setText(""); 
                                                   web.setText("");
                                                   direccion.setText(""); 
                                                   ciudad.setText("");
                                                   trabajo.setText("");
                                               
                                               }; break;
                case JOptionPane.NO_OPTION : ; break;
            }                                  
        }
    }
}

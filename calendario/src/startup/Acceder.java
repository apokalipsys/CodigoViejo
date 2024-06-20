package startup;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class Acceder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 
public class Acceder implements ActionListener
{
	private JPanel menuConeccion;
	private JButton asd, conectar;
    private JDialog p;
    private JTextField usuario;
    private JPasswordField pass;
    
    private boolean correcto = false;

	/**
	 * Constructor for objects of class Acceder
	 */
	public Acceder()
	{
		usuario = new JTextField();
		pass = new JPasswordField();
	}
	
	public void acceder()
	{
	    creaMenuConeccion();
	}
	
	public static void crear()
	{
	    (new Acceder()).creaMenuCreacion();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	    if(ae.getSource() == asd)//crea
        {
            guardaUsr();
            p.dispose();
        }
        if(ae.getSource() == conectar)//comprueba
        {
            compruebaUsr();
            p.dispose();
        }
	}

	private void creaMenuConeccion()
 {
    menuConeccion = new JPanel();
        conectar = new JButton("Entrar");
        conectar.addActionListener(this);
        menuConeccion.setLayout(new GridLayout(0,1));
        menuConeccion.add(new JLabel("Usuario"));
        menuConeccion.add(usuario);
        menuConeccion.add(new JLabel("Contraseña"));
        menuConeccion.add(pass);
        menuConeccion.add(conectar);
        
        p = new JDialog();
        p.getContentPane().add(menuConeccion);
        p.setSize(100,100);
        p.show();
        
            p.getContentPane().repaint();
 }
 
 
 public void creaMenuCreacion()
 {
    menuConeccion = new JPanel();
        asd = new JButton("Crear");
        asd.addActionListener(this);
        menuConeccion.setLayout(new GridLayout(0,1));
        menuConeccion.add(new JLabel("Usuario"));
        menuConeccion.add(usuario);
        menuConeccion.add(new JLabel("Contraseña"));
        menuConeccion.add(pass);
        menuConeccion.add(asd);
        
        p = new JDialog();
        p.getContentPane().add(menuConeccion);
        p.setSize(100,100);
        p.show();
        
 }
 
    private boolean compruebaUsr()
    {
        boolean a = false;
        try
        {
            Usuario usr = new Usuario(usuario.getText(),String.valueOf(pass.getPassword()));
            a= usr.abrir();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Usuario o Contraseña Erroneos");}
         return a;
     }
     
     private void guardaUsr()
 {
        try
        {
            Usuario usr = new Usuario(usuario.getText(),String.valueOf(pass.getPassword()));
             usr.guardar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error al crear "+e);}
     }
}

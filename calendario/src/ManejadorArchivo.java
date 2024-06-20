import java.awt.*;
import java.io.*;
import javax.swing.*;
/**
 * Objeto para manejar archivos.
 * 
 * @author BOo
 * @version 0.1
 */
public class ManejadorArchivo
{
    private FileDialog Manejador;
    private Frame frame;
    private String file, linea, direct;
    private BufferedReader lector;
    private PrintWriter escritor;
    String defaultDir;
    
    public ManejadorArchivo(Frame f)
    {
        frame = f;
        //defaultDir = "C:/";
    }

    public void Abrir(JTextField TA)
    {
        Manejador = new FileDialog(frame,"Abrir Archivo",FileDialog.LOAD);
        Manejador.show();
        direct = Manejador.getDirectory();
        file = Manejador.getFile();
            
        try
        {
            TextArea TA2 = new TextArea("",10,10);
            
            lector = new BufferedReader(new FileReader(file));
            
            while (( linea = lector.readLine()) != null)
            {
                TA2.append(linea+"\n");
            }
            
            lector.close();
            
                   TA.setText(TA2.getText());
       }
       catch(IOException x)
       {
           JOptionPane.showMessageDialog(null, "Error al leer el Archivo :\n"+
                                                x.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
       }
       

            
    }
    
    public void guardarComo(JTextField TA)
    {
        Manejador = new FileDialog(frame,"Guardar Archivo",FileDialog.SAVE);
        Manejador.setFile(file);
        Manejador.show(); 
        
        direct = Manejador.getDirectory();
        
        file = Manejador.getFile();
        
        try
        {
            escritor = new PrintWriter(new FileWriter(direct+file), true);
            escritor.print(TA.getText());
            escritor.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error al guardar el Archivo :\n"+
                                                e.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void Updatear(JTextField TA, String archive)
    {
        if(archive != null)
          file = archive;
        
        try
        {
            TextArea TA2 = new TextArea("",10,10);
            
            lector = new BufferedReader(new FileReader(file));
            
            while (( linea = lector.readLine()) != null)
            {
                TA2.append(linea+"\n");
            }
            
            lector.close();
            
            escritor = new PrintWriter(new FileWriter(file), true);
            escritor.print(TA2.getText()+TA.getText());
            escritor.close();
        }
        catch(IOException e)
        {
            Guardar(TA, file);
        }
    }
    
    public void Guardar(JTextField TA, String param)
    {
        file = param;
        
        try
        {
            escritor = new PrintWriter(new FileWriter(file), true);
            escritor.print(TA.getText());
            escritor.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Error al Salvar el Archivo :\n"+
                                                e.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);;
        }
    }
    
    public void Cerrar(JTextField TA)
    {
        int opc = JOptionPane.showConfirmDialog(null,"El archivo actual se Guardará");
        
        if(opc == JOptionPane.YES_OPTION)
        {
            try
            {
                escritor = new PrintWriter(new FileWriter(file), true);
                escritor.print(TA.getText());
                escritor.close();
                
                TA.setText("");
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null, "Error al guardar el Archivo :\n"+
                                                e.toString() ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
            }
        }
        
        else 
        if(opc == JOptionPane.NO_OPTION)
        {
            TA.setText("");
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
    
    public void abrirSilent(TextArea TA, String param)
    {
        file = param;    
        try
        {
            //TextArea TA2 = new TextArea("",10,10);
            
            lector = new BufferedReader(new FileReader(file));
            
            while (( linea = lector.readLine()) != null)
            {
                TA/*2*/.append(linea+"\n");
            }
            
            lector.close();
            
                   //TA.setText(TA2.getText());
       }
       catch(IOException x)
       {
           ;
       }
            
    }    
}

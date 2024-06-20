import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.util.StringTokenizer;
import java.util.List;
/**
 * Objeto para manejar archivos.
 * 
 * @author BOo
 * @version 0.6
 */
public class ManejadorArchivo
{
    private JFileChooser Manejador;
    private JFrame frame;
    public String file;
    private String linea, direct;
    private PrintWriter escritor;
    String defaultDir = "C:/";
    
    public ManejadorArchivo(JFrame f)
    {
        frame = f;
        direct = defaultDir;
        Manejador = new JFileChooser();
        //Manejador.addChoosableFileFilter(new ConfigFilter("uml","Modelo UML [*.uml]"));
        Manejador.setFileFilter(new ConfigFilter("uml","Modelo UML [*.uml]"));
    }
    
    public ManejadorArchivo(JFrame f, ConfigFilter[] cfg)
    {
        frame = f;
        direct = defaultDir;
        Manejador = new JFileChooser();
        for(int d = 0; d<cfg.length; d++)
           Manejador.addChoosableFileFilter(cfg[d]);
           
        Manejador.setFileFilter(cfg[0]);   
    }

    public void Abrir(PanelDibujo TA)
    {
        Manejador.setDialogTitle("Abrir Archivo");
        Manejador.setCurrentDirectory(new File(direct)); 
        Manejador.setMultiSelectionEnabled(false);
        Manejador.setAcceptAllFileFilterUsed(true);

        int returnVal = Manejador.showOpenDialog(frame);
       
         if (returnVal == JFileChooser.APPROVE_OPTION)
        {
             List leUML2 = new ArrayList();
             List leLine = new ArrayList();
             Ovulo2D agre = null;
             Linea2D linilla = null;
             direct = ""+Manejador.getCurrentDirectory();
             file = ""+Manejador.getSelectedFile() ;
             try
             {
                 BufferedReader lector = new BufferedReader(new FileReader(file));
                 while (( linea = lector.readLine()) != null)
                {
                    StringTokenizer tokens = new StringTokenizer(linea, "#");
                    switch(Integer.parseInt(tokens.nextToken()))
                    {
                        case 1 : agre = new Frontera(Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()));break;
                        case 2 : agre = new Control(Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()));break;
                        case 3 : agre = new Entidad(Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()));break;
                        case 4 : agre = new Actor(Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken())*3);break;
                    }
                    agre.setNombre(tokens.nextToken());
                    leUML2.add(agre);
                }
            
                 lector.close();
                 
                 TA.setUML2List(leUML2);
                 
                 lector = new BufferedReader(new FileReader(file+"$2"));
                 while (( linea = lector.readLine()) != null)
                {
                    StringTokenizer tokens = new StringTokenizer(linea, "#");
                    switch(Integer.parseInt(tokens.nextToken()))
                    {
                        case 0 : linilla = new Linea2D(Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()),Double.parseDouble(tokens.nextToken()));break;
                     }
                    linilla.setNombre(tokens.nextToken());
                    if(linilla.correctLine(TA.getUML2List()))
                        leLine.add(linilla);
                }
            
                 lector.close();
                 TA.setLineList(leLine);  
                 TA.repaint();
            }
            catch(Exception x)
            {
                JOptionPane.showMessageDialog(null,"Error al abrir el archivo :\n "+x.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                x.printStackTrace();
            }
       }
            
    }

    public void abrirAt( JTextPane TA, String filename)
    {/*
        file = filename ;
        TextArea auxiliar = new TextArea("",0,0);
        try
        {
            lector = new BufferedReader(new FileReader(file));
            TA.setText("");
            
            while (( linea = lector.readLine()) != null)
            {
                auxiliar.append(linea+"\n");
            }
            
            lector.close();

    }
       catch(IOException x)
       {
           JOptionPane.showMessageDialog(null,"Error al abrir el archivo :\n "+x.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
       }

              TA.setText(auxiliar.getText());*/
    }
    
    public void guardarComo(PanelDibujo TA)
    {
        Manejador.setDialogTitle("Guardar Archivo");
        Manejador.setCurrentDirectory(new File(direct));
        Manejador.setSelectedFile(new File("Archivo"));
        Manejador.setMultiSelectionEnabled(false);
        Manejador.setAcceptAllFileFilterUsed(false);
        
         int returnVal = Manejador.showSaveDialog(frame);
       
         if (returnVal == JFileChooser.APPROVE_OPTION)
        {
             direct = ""+Manejador.getCurrentDirectory();
             file = Manejador.getSelectedFile()+".uml"  ;
        
        try
        {
            List lli = TA.getUML2List();
            List linn = TA.getLineList();
            
            FileOutputStream fs = new FileOutputStream(new File(file));
            PrintStream destino = new PrintStream(fs);
            for(int j = 0; j < lli.size(); j++)
               destino.println(((Ovulo2D)lli.get(j)).getInfo());
            fs.close();
            
            fs = new FileOutputStream(new File(file+"$2"));
            destino = new PrintStream(fs);
            for(int j = 0; j < linn.size(); j++)
               destino.println(((Linea2D)linn.get(j)).getInfo());
            fs.close();
            
        }
        catch(IOException e)
        {
           JOptionPane.showMessageDialog(null,"Error al guardar el archivo : \n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

       }
        
    }
    
    public void guardarImagenComo(PanelDibujo TA)
    {
        Manejador.setDialogTitle("Guardar Archivo");
        Manejador.setCurrentDirectory(new File(direct));
        Manejador.setSelectedFile(new File("Archivo"));
        Manejador.setMultiSelectionEnabled(false);
        Manejador.setAcceptAllFileFilterUsed(false);
        
         int returnVal = Manejador.showSaveDialog(frame);
       
         if (returnVal == JFileChooser.APPROVE_OPTION)
        {
             direct = ""+Manejador.getCurrentDirectory();
             file = ""+Manejador.getSelectedFile();
        
        try
        {
            Xporter.save(TA, Manejador.getSelectedFile());
        }
        catch(IOException e)
        {
           JOptionPane.showMessageDialog(null,"Error al guardar la imagen : \n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

       }
        
    }
    
    public void Updatear(JTextPane TA)
    {/*
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
            JOptionPane.showMessageDialog(null,"Error al trabajar en el archivo : \n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }
    
    public void Guardar(JTextPane TA, String pos)
    {/*
        try
        {
            escritor = new PrintWriter(new FileWriter(pos), true);
            escritor.print(TA.getText());
            escritor.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,"Error al guardar el archivo : \n"+e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }*/
    }
    
    public void Cerrar(JTextPane TA, String pos)
    {/*
        int opc = JOptionPane.showConfirmDialog(null, "El archivo se Guardará", "Cerrando", JOptionPane.YES_NO_OPTION);
        
        if(opc == JOptionPane.YES_OPTION)
        {
            Guardar(TA, pos);
            
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
        }*/
    }
    
    public String getDirectory()
    {
        return direct; 
    } 

    public String absFilename()
    {
       return file;
    } 

    public String nombreArchivo()
    {
       int indice = file.lastIndexOf(File.pathSeparator);
       
       if(indice == -1) indice = file.lastIndexOf("/");
       if(indice == -1) indice = file.lastIndexOf("\\");

       if(indice == -1) return "";
       else return file.substring(indice+1, file.length());   
    }         
}

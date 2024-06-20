
/**
 * Esta clase trata de convertir un archivo .tit (TiTaN UML), en algo que pueda entender UMLator
 * 
 * @author BOo
 * @version 0.1
 */

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class TitanConverter
{
    /**
     * Recupera un archivo .tit
     */
    public void recuperar(String filename) throws IOException {
        ListaArray i = new ListaArray();
        FileInputStream archivo = new FileInputStream(filename);
        ObjectInputStream leer = new ObjectInputStream(archivo);

        try
        {
            i = (ListaArray)leer.readObject();
        }
        catch(Exception E)
        {
            System.out.println("en cat");
        }
        archivo.close();
        //return(i);
    }

    /**
     * Guarda como archivo .tit
     */
    public void salvar(Component frame) throws IOException {
        ListaArray listaActual = new ListaArray();
       JFileChooser chooser = new JFileChooser();
                    chooser.setFileFilter(new FiltroTit());
                    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    chooser.showSaveDialog(frame);
                    File f;
                    String path="";
                    if(chooser.getSelectedFile().toString().toLowerCase().endsWith(".tit")){
                        f=chooser.getSelectedFile();
                        path=f.toString().toLowerCase();
                    }
                    else{
                        f=chooser.getSelectedFile();
                        path=f.toString().toLowerCase()+".tit";
                    }

       
       listaActual.path=path;
                    listaActual.nombre=f.getName();
                    
      FileOutputStream archivo = new FileOutputStream(f);
        ObjectOutputStream grabar = new ObjectOutputStream(archivo);
//        listaActual=(ListaArray)(listas.get(tabs.getSelectedIndex()));
//        grabar.writeObject(listaActual);
//        grabar.flush();
        archivo.close();
              

    }
    
    

}

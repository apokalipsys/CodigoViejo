
/**
* Copyright 2000 by Nilanjan Dutta
* ALL RIGHTS RESERVERD
*
* @(#)ConfigFilter.java 1.0
*
*/


import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
* ConfigFilter class filter the unnecessary files when
* user wants to select a particular type of files
* from a selected directory.
* 
* 
* Notes :
*
* 
* 
*
* @author . Nilanjan
* @version 1.0
*
*
*/

public class ConfigFilter extends FileFilter
{

   // declaring some constand class variables
   private String cfg, Descripcion;
   
   public ConfigFilter(String extension, String Tipo)
{
    cfg = extension;
    Descripcion = Tipo;
}
  
   // Accept all directories and all files or all .cfg files
   // Overriding the accept() method of FileFilter class
   
    public boolean accept(File f)
   {
       // checking if the file is directory or not
        if (f.isDirectory())
      {
           return true;
        }

 // storing the file name etc.
        String s = f.getName();
        int i = s.lastIndexOf('.');

 // checking the extension types
        if (i > 0 &&  i < s.length() - 1)
 {
           String extension = s.substring(i+1).toLowerCase();
           if (cfg.equals(extension))
    {
              return true;
           }
    else
    {
       return false;
           }
 }
        return false;
   }

   // The description of this filter
   // overriding the method getDescriptor()
   public String getDescription()
   {
 return Descripcion;
   }

   // Main method for unit testing purpose only
  /* public static void main(String[] args)
   {
 JFileChooser fc = new JFileChooser();
 fc.addChoosableFileFilter(new ConfigFilter());
 int returnVal = fc.showOpenDialog(new JFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION)
 {
    System.out.println("Selected file --->> " +
fc.getSelectedFile());
    System.exit(0);
 }
 else
 {
    System.exit(0);
 }
   } */

}  // end of the class ConfigFilter

 

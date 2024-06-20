package startup;

import java.io.*;
import javax.swing.*;
import java.util.Date;

public class Start
{
     public static void startup()
     {
         if(checkToDay())
         {
            access();
         }
     }
   
     private static boolean checkToDay()
     {
         Date fecha = new Date();
         return (new File("A"+fecha.getDate()+(fecha.getMonth()+1)+(fecha.getYear()+1900)+".agn")).exists();
     }
     
     private static void access()
     {
         (new Acceder()).acceder();
     }
     
         
}
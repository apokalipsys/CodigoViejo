import java.io.*;

public class FiltroTit extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".tit");
    }
    
    public String getDescription() {
        return "Archivos TiTaN UML";
    }
}
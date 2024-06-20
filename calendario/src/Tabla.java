import java.awt.*;
import java.applet.*;
/**
 * Tabla
 * 
 * @author Java for Student, modifications by BOo 
 * @version 3rd Edition (0.15 by BOo)
 */
public class Tabla
{
    private String datos[][];
    private int renglonIndice;
    private int colIndice;
    private String nuevoValor;
    
    private int suma;
    private int selectionX;
    private int selectionY;
    private Color change, backBox;
    private boolean selection = false;
    
    private final int xInicial = 20;
    private final int yInicial = 60;
    private final int cuadroAltura = 40;
    private final int cuadroAnchura = 40;

    public Tabla(int renglones, int columnas)
    {
        datos = new String[renglones][columnas];
        
        for (int renglon = 0; renglon <  renglones;  renglon++)
            for (int col = 0; col < columnas; col++)
                datos[renglon][col] = "";
    }

    public void mostrar(Graphics g)
    {
        for (int renglon = 0; renglon < datos.length;  renglon++)
        {
            for (int col = 0; col < datos[0].length; col++)
            {
                int x = xInicial + col * cuadroAnchura;
                int y = yInicial + renglon * cuadroAltura;
                if(col == 6)                                  //add by BOo
                {
                    g.setColor(Color.pink);
                    g.fillRect(x, y, cuadroAnchura, cuadroAltura);
                    g.setColor(Color.red);
                    g.drawRect(x, y, cuadroAnchura, cuadroAltura);
                    g.setColor(Color.black);
                }
                else
                  g.drawRect(x, y, cuadroAnchura, cuadroAltura);
                
                if(selection)                                        //add by BOo
                {
                    if(x == selectionX && y == selectionY)
                    {
                         g.setColor(backBox);
                         g.fillRect(selectionX,selectionY, cuadroAnchura, cuadroAltura);
                         g.setColor(change);
                         g.drawRect(selectionX,selectionY, cuadroAnchura, cuadroAltura);
                         g.setColor(Color.black);
                         selection = false;
                    }     
                 }   
                
                g.drawString((datos[renglon] [col]),
                      x + cuadroAnchura*1/4, y + cuadroAltura*3/4);
            }
        }
        
    /*  calcularSuma();
        g.drawString("El total es " + suma, 100, 150); */
        
         
    }   
    
    public void seleccionarComponente(int x, int y)
    {
        renglonIndice = (y - yInicial)/cuadroAltura;
        colIndice = (x - xInicial)/cuadroAnchura;
        datos[renglonIndice][colIndice] = nuevoValor;
    }
    
    public void establecerValor(String valor)
    {
        nuevoValor = valor;
    }
    /*
    private void calcularSuma()
    {
        suma = 0;
        for (int renglon = 0; renglon < datos.lenght;  renglon++)
            for (int col = 0; col < datos[0].lenght; col++)
                suma = suma + datos[renglon][col];
    }   */        
    
    /* methods add by BOo */
    /*************************************************************************************************/
    
    public void cambiaColor(int x, int y, Color tinte, Color fondo)      
    {
        selectionX = (20+(cuadroAnchura*((x - xInicial)/cuadroAnchura)));
        selectionY = (60+(cuadroAltura*((y - yInicial)/cuadroAltura)));
        change = tinte;
        backBox = fondo;
        selection = true;
    }
    
    public String devolverValor(int x, int y)
    {
        renglonIndice = (y - yInicial)/cuadroAltura;
        colIndice = (x - xInicial)/cuadroAnchura;
        return datos[renglonIndice][colIndice];
    }
    
    /***************************************************************************************************/
}

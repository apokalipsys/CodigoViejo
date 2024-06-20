/**
 *   @author BOo, Fixed by TiTaN TeaM for TiTaN UML. Remake by BOo for UMLator.
 *   @version 0.1
 */

import java.awt.*;
import java.util.*;

class Nodo implements java.io.Serializable
{
    /* Figura */Ovulo2D f;
    Nodo sig;
    ArrayList enlace;
    /* Este valor es el mismo que esta en Faz */
    int size = 40;
    
    public int tipo,x,y,width,height;
    public Color c;
    
    public Nodo(int tipo, int x, int y, Color c)
    {
        this.tipo  = tipo;
        this.x     = x   ;
        this.y     =y    ;
        this.c=c;
        enlace=new ArrayList();
        
        switch (tipo) {
            case 1: {
                f=new Actor(x,y,16.6, 16.6*3);break;
            }
            case 2: {
                f=new /*Interface*/Frontera(x,y,size,size);break;
            }
            case 3: {
                f=new Entidad(x,y,size,size);break;
            }
            case 4: {
                f=new Control(x,y,size,size);break;
            }
            //case 5: {
             //   f=new Linea(x,y,c);break;
            //}
        }
        sig=null;
    }
    
    public Nodo(int tipo, int x, int y, Color c,String n)
    {
        this.tipo  = tipo;
        this.x     = x   ;
        this.y     =y    ;
        this.c=c;
        enlace=new ArrayList();
        
        switch (tipo) {
            case 1: {
                f=new Actor(x,y,16.6, 16.6*3);f.setNombre(n);break;
            }
            case 2: {
                f=new /*Interface*/Frontera(x,y,size,size);f.setNombre(n);break;
            }
            case 3: {
                f=new Entidad(x,y,size,size);f.setNombre(n);break;
            }
            case 4: {
                f=new Control(x,y,size,size);f.setNombre(n);break;
            }
            //case 5: {
             //   f=new Linea(x,y,c);break;
            //}
        }
        sig=null;
    }
    
    public Nodo(int tipo, int x, int y, int width, int height, Color c)
    {
        this.tipo  = tipo;
        this.x     = x   ;
        this.y     =y    ;
        this.width = width;
        this.height=height;
        this.c=c;
        enlace=new ArrayList();
        
        switch (tipo) {
            case 1: {
                f=new Actor(x,y,16.6, 16.6*3);break;
            }
            case 2: {
                f=new /*Interface*/Frontera(x,y,size,size);break;
            }
            case 3: {
                f=new Entidad(x,y,size,size);break;
            }
            case 4: {
                f=new Control(x,y,size,size);break;
            }
            /* INCOMPATIBILIDAD TiTaN UML v/s UMLator */
            //case 5: {
              //  f=new Linea(x,y,width,height,c);break;
            //}
        }
    }
    
    
    public Graphics dibujar(Graphics g)
    {
        f.dibujar(g);
        return g;
    }
    
}
    
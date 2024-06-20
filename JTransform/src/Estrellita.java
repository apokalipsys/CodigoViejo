/*
 * Para dibujar una estrella de 5 puntas, los datos son:
 * N = 5
 * centro = cualquiera
 * radio = cualquiera
 * salto = 2
 * anguloi = 1/2 * Pi
 */

/**
 *
 * @author ApokalipsyS
 * @version ()
 */

import java.awt.geom.*;
import java.awt.*;

public class Estrellita {
    
    Point2D.Double[] vertices, realVertices;
    double alfa;
    //double angulo;
    int salto;
    Point2D.Double centro;
    /** Creates a new instance of Estrellita
     *
     *  @author ApokalipsyS
     */
    public Estrellita( int N, Point2D.Double centro, double radio,int salto, double anguloi ) {
        
        alfa = 2* Math.PI /N;
        vertices = new Point2D.Double[N];
        realVertices = new Point2D.Double[N];
        for(int i=0; i<N;i++)
        {
            vertices[i] = new Point2D.Double(centro.getX()+radio* Math.cos( (i)*alfa + anguloi ),
                           centro.getY()+ radio * Math.sin( (i)*alfa + anguloi ));
            
            realVertices[i] = new Point2D.Double(centro.getX()+radio* Math.cos( (i)*alfa + anguloi ),
                           centro.getY()+ radio * Math.sin( (i)*alfa + anguloi ));
        }
        
        this.salto = salto;
        this.centro = centro;
    }
    
    public Estrellita(Point2D.Double[] puntos)
    {
        alfa = 2*Math.PI /puntos.length;
        salto = 2;
        centro = new Point2D.Double(0,0);
        vertices = puntos;
    }
    
    public void dibujar(Graphics2D g)
    {
        int j = 0;
        int N = vertices.length;
        for(int i = 0; i<N;i++)
        {
            j = (i+ salto)%N;
            
            ( new Linea2D(vertices[i],vertices[j]) ).dibujar(g);
        }    
        
        //(new Linea2D(vertices[0],centro)).dibujar(g);
    }
    
    public double[][] puntosAMatriz()
    {
       double[][] matriz = new double[3][vertices.length];
       
       for(int i=0; i<vertices.length;i++)
           {
               matriz[0][i] = vertices[i].getX();
               matriz[1][i] = vertices[i].getY();
               matriz[2][i] = 1;
           }    
       
       return matriz;
    }
    
    private double[][] puntosRealAMatriz()
    {
       double[][] matriz = new double[3][vertices.length];
       
       for(int i=0; i<vertices.length;i++)
           {
               matriz[0][i] = realVertices[i].getX();
               matriz[1][i] = realVertices[i].getY();
               matriz[2][i] = 1;
           }    
       
       return matriz;
    }
    
    public void matrizAPuntos(double[][] puntos)
    {
        for(int i=0; i<vertices.length;i++)
           {
               vertices[i] = new Point2D.Double(puntos[0][i],puntos[1][i]);
           }  
    }
    
    public void matrizAPuntosReal(double[][] puntos)
    {
        for(int i=0; i<vertices.length;i++)
           {
               realVertices[i] = new Point2D.Double(puntos[0][i],puntos[1][i]);
           }  
    }
    
    public void traslar(double tx, double ty)
    {
         matrizAPuntos(Transformaciones.Traslar(puntosAMatriz(),tx,ty));
         matrizAPuntosReal(Transformaciones.Traslar(puntosRealAMatriz(),tx,ty));
    }
    
    public void rotar(double tx, double ty, double theta )
     {
        matrizAPuntos(Transformaciones.Rotar(puntosAMatriz(),tx,ty,theta));
        matrizAPuntosReal(Transformaciones.Rotar(puntosRealAMatriz(),tx,ty,theta));
     }
    public void escalar(double sx, double sy)
     {
          matrizAPuntos(Transformaciones.Escalar(puntosAMatriz(),sx,sy));
          matrizAPuntosReal(Transformaciones.Escalar(puntosRealAMatriz(),sx,sy));
     }
     
     public void shear(double shx, double shy)
     {
          matrizAPuntos(Transformaciones.Shear(puntosAMatriz(),shx,shy));
          matrizAPuntosReal(Transformaciones.Shear(puntosRealAMatriz(),shx,shy));
     }
     
     public void afinar(double h1,double h2,double h3,double h4)
     {
         matrizAPuntos(Transformaciones.Afinar(puntosAMatriz(),h1,h2,h3,h4));
         matrizAPuntosReal(Transformaciones.Afinar(puntosRealAMatriz(),h1,h2,h3,h4));
     }
     
     public Rectangle getBounds()
     {
         double minX=vertices[0].getX(),minY=vertices[0].getY();
         double maxX=vertices[0].getX(),maxY=vertices[0].getY();
         
         for(int i=1; i<vertices.length;i++)
           {
               if(vertices[i].getX()<minX) minX = vertices[i].getX();
               else if (vertices[i].getX()>maxX) maxX = vertices[i].getX();
               
               if(vertices[i].getY()<minY) minY = vertices[i].getY();
               else if (vertices[i].getY()>maxY) maxY = vertices[i].getY();
           }
         
         return new Rectangle((int)minX,(int)minY,(int)(maxX-minX),(int)(maxY-minY));
     }
     
     public Point2D getPoint2DAt(int i) throws java.lang.ArrayIndexOutOfBoundsException
     {
         return realVertices[i];
     }

    public double getAlfa() {
        return alfa;
    }
     
     public Point2D.Double[] getRealPoints2D()
     {
         return realVertices;
     }
     
     public void setRealPoints2D(Point2D.Double[] puntosReales)
     {
         realVertices = puntosReales;
     }
}

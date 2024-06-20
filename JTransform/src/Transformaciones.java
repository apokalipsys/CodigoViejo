/*
 * Transformaciones.java
 *
 * Created on 21 de octubre de 2006, 03:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author ApokalipsyS
 * @version ()
 */
public class Transformaciones {
    
    public static double[][] matrizTraslacion(double tx, double ty)
    {
        double[][] Ht = {{1,0,tx},
                         {0,1,ty},
                         {0,0,1}};
        return Ht;
    }
    
    public static double[][] matrizRotacion(double tx, double ty, double theta)
    {
        return new double[][] {{Math.cos(theta),-Math.sin(theta),tx},
                               {Math.sin(theta),Math.cos(theta),ty},
                               {0,               0,             1}};
    }
    
    public static double[][] matrizEscalar(double sx, double sy)
    {
        return new double[][] {{sx,0,0},
                               {0,sy,0},
                               {0,0,1}};
    }
    
    public static double[][] matrizShear(double shx, double shy)
    {
        return new double[][] {{1,shx,0},
                               {shy,1,0},
                               {0,0,1}};
    }
    
    public static double[][] matrizAfin(double h1,double h2,double h3,double h4)
    {
        return new double[][] {{h1,h2,0},
                               {h3,h4,0},
                               {0,0,1}};
    }
    
    public static double[][] Traslar(double[][] puntos, double tx, double ty)
    {
        return multiplicar(matrizTraslacion(tx,ty),puntos);
    }
    
    public static double[][] Rotar(double[][] puntos, double tx, double ty, double theta)
    {
        return multiplicar(matrizRotacion(tx,ty,theta),puntos);
    }
    
    public static double[][] Escalar(double[][] puntos, double sx, double sy)
    {
        return multiplicar(matrizEscalar(sx,sy),puntos);
    }
    
    public static double[][] Shear(double[][] puntos, double shx, double shy)
    {
        return multiplicar(matrizShear(shx,shy),puntos);
    }
    
    public static double[][] Afinar(double[][] puntos, double h1,double h2,double h3,double h4)
    {
         return multiplicar(matrizAfin(h1,h2,h3,h4), puntos);
    }
    
    public static double[][] multiplicar(double[][] matriz1, double[][] matriz2)
    {
        int a = matriz1.length;
        int b = matriz2[0].length;
        
        double[][] r = new double[a][b];
        
        for (int i= 0; i<a; i++)
            for (int j= 0; j<b; j++)
                for (int k= 0; k<matriz1[0].length; k++)
                {
                    r[i][j]+= matriz1[i][k]*matriz2[k][j]; 
                }
        return r;
    }
    
    private static void printMatrix(double[][] matrix)
    {
        int a = matrix.length;
        int b = matrix[0].length;
        
        for (int i= 0; i<a; i++)
        {
            for (int j= 0; j<b; j++)
                System.out.print(matrix[i][j]+" ");
            
            System.out.println();
        }    
    }
}

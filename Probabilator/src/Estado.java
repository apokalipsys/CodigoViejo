/**
 * Objeto Estado para el juego BARCOS DE GUERRA
 * 
 * @author BOo
 * @version 0.2
 * 
 */

public class Estado
{
    public static final int VACIO = 0, OCUPADO = 1, DISPARADO = 2, HUNDIDO = 3;
    private int esteEstado;
    public Estado()
    {
           esteEstado = VACIO;
     }

     public Estado(int estado)
     {
          esteEstado = estado;
      }

      public int estadoActual()
      {
              return esteEstado;
      }

      public void cambiaEstado(int nuevoEstado)
      {
               esteEstado = nuevoEstado;
       }
}
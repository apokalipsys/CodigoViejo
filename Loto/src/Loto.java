
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Loto extends Applet implements ActionListener
{
        private Button juego;
        private boolean sorteo = false;
        private final int NBOLAS = 39;
    
    public void init() 
    {
        juego = new Button("Jugar");
        add(juego);
        juego.addActionListener(this);
    }

    public void actionPerformed (ActionEvent event)  
    {
        sorteo = true;
        repaint();
    }

    public void paint(Graphics g)  
    {
        int[] loto = new int[7];
    
        if(sorteo)
        {
             loto[0] = (int)((Math.random() * NBOLAS)+1);

             for(int i=1;i<=6;i++) 
             {
                loto[i] = (int)((Math.random() * NBOLAS)+1);
                    
              }

            comprobar(loto);
             

            g.drawString("Los Numeros Sorteados son: " + loto[0],50,50);
            g.drawString(" " + loto[1],50,60);
            g.drawString(" " + loto[2],50,70);
            g.drawString(" " + loto[3],50,80);
            g.drawString(" " + loto[4],50,90);
            g.drawString(" " + loto[5],50,100);
            g.drawString("Comodín: " + loto[6],50,110);
   
        }
    }

    public void comprobar(int[] weas)
    {
        for(int i = 0; i<weas.length;i++ )
            for(int j = 0; j<i; j++)
              if(weas[i] == weas[j])
              {
                  weas[j] = (int)(Math.random()*NBOLAS+1);
                  comprobar(weas); 
              }
    }
}

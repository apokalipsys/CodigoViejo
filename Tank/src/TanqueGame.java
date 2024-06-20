import java.awt.*;
import java.awt.event.*;

public class TanqueGame extends Frame implements KeyListener{

    private Bala b;
    private Tanque t;
    private Camion c;
    
    private int Ytanque = 10, Ycamion = 20, Xbala = 10, Ybala, pantallaX = 110, pantallaY = 200, moverCamion = 1;
    private int puntos = 0, disparos = 0;
    private Button disparaM, arriba, abajo;
    
    private Cola balas;
    
    Image IbufReal;
    Graphics bufOculto;
    
    
    
    public TanqueGame()
    {
        addWindowListener(new WindowAdapter() {
               public void windowClosing(WindowEvent e) {
                                dispose();
                                System.exit(0);
               }
        });
        
        setTitle("Dispara Tanque #$&@ !!");
        
        setLayout(new FlowLayout());
        setSize(pantallaX,pantallaY+52);
        
        t = new Tanque(39, 10,0,0,5);
        c = new Camion(39, 100, 0, 0, 5);
        
        balas = new Cola();
        
        addKeyListener(this);
    }


    public void paint(Graphics g){
      
        IbufReal = createImage(getSize().width,getSize().height); 
        bufOculto = IbufReal.getGraphics();
        bufOculto.drawRect(0,0,pantallaX,pantallaY);
          
        if(!balas.isVacio())
        {
            for(int cb = 0; cb<=balas.largo(); cb++)
            {
                Bala pun = (Bala) balas.ver(cb);
                pun.pintar(bufOculto);
                pun.moverX(pun.X()+5);
                
                
                
                if(pun.X() >= 111)
                {
                    if(choque(pun.Y())) puntos++;
                    balas.saca();
                }
                    
            }  
            
        }
         
        moverObjetivo();
          
        t.dibujar(Ytanque, bufOculto);   
        c.poner(Ycamion, bufOculto);
        
        bufOculto.drawString("Puntaje : "+puntos, 10, 220);
        bufOculto.drawString("Disparos : "+disparos, 10, 230);
        
        if(disparos != 0) bufOculto.drawString("Porcentaje : "+(puntos*100)/disparos, 10, 240);
          
        g.drawImage(IbufReal,0,0,this);
         
        try
        {
            Thread.sleep(50);
        }
        catch(Exception e){;}
    }
    
    public void moverObjetivo()
    {
        if(Ycamion <= 0 || Ycamion >= 38)
        {
            moverCamion = -moverCamion;
        }
        Ycamion += moverCamion;
        
    }
    
    public boolean choque(int parametro)
    {
        boolean retorno = false;
        int otroParametro = c.Y(Ycamion);
        
        if(parametro >= otroParametro && parametro <= otroParametro+10)
                retorno = true;
                
        return retorno;        
    }

    public static void main(String args[])
    {
        Frame f = new TanqueGame();
        f.show();
        f.setResizable(false);
        
        while(true)
           f.repaint();
    }  
    
    public void keyPressed(KeyEvent k)
    {
        if(k.getKeyCode() == KeyEvent.VK_UP)
        {
            if(Ytanque-1 >= 0)
            {
                Ytanque -= 1;
            }
        }
        if(k.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(Ytanque+1 <= 38)
            {
                Ytanque += 1;
            }  
        }
        if(k.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(!balas.llena())
            {
                b = new Bala(Xbala,Ytanque*5+5);
                balas.pone(b);
                disparos++;
            }  
        }
    }    
    
    public void keyReleased(KeyEvent e) 
    {    
    }      
    
    public void keyTyped(KeyEvent k) 
    {
    }
    
}

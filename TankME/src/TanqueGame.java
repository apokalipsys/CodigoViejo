import javax.microedition.lcdui.*;


public class TanqueGame extends Canvas /*implements Runnable*/{

    private Bala b;
    private Tanque t;
    private Camion c;
    
    private int PTJ = 52,Ytanque = 10, Ycamion = 20, Xbala = 10, Ybala, pantallaX = getWidth(), pantallaY = getHeight()-PTJ, moverCamion = 1;
    private int puntos = 0, disparos = 0;
    /*private double KOBJETOS = 39/200;*/
        
    private Cola balas;
    
    Image IbufReal;
    Graphics bufOculto;
    
    
    
    public TanqueGame()
    {
        /*setSize(pantallaX,pantallaY+PTJ);*/
        
        t = new Tanque((int)(pantallaY * 0.195), 10,0,0,5);
        c = new Camion((int)(pantallaY * 0.195), 100, 0, 0, 5);
        
        balas = new Cola();
        
    }


    public void paint(Graphics g){
     
          
            IbufReal = Image.createImage(getWidth(),getHeight()); 
            bufOculto = IbufReal.getGraphics();
            bufOculto.drawRect(0,0,pantallaX,pantallaY);
          
        if(!balas.isVacio())
        {
            for(int cb = 0; cb<=balas.largo(); cb++)
            {
                Bala pun = (Bala) balas.ver(cb);
                pun.pintar(bufOculto);
                pun.moverX(pun.X()+5);
                
                
                
                if(pun.X() >= pantallaX)
                {
                    if(choque(pun.Y())) puntos++;
                    balas.saca();
                }
                    
            }  
            
        }
         
        moverObjetivo();
          
        t.dibujar(Ytanque, bufOculto);   
        c.poner(Ycamion, bufOculto);
        
        bufOculto.drawString("Puntaje : "+puntos, 10, pantallaY+20, g.TOP|g.LEFT);
        bufOculto.drawString("Disparos : "+disparos, 10, pantallaY+30, g.TOP|g.LEFT);
        
        if(disparos != 0) bufOculto.drawString("Porcentaje : "+(puntos*100)/disparos, 10, pantallaY+40,g.TOP|g.LEFT);
          
        g.drawImage(IbufReal,0,0,g.RIGHT|g.BOTTOM);
         
        try
        {
            Thread.sleep(400);
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
    
    public void keyPressed(int keyCode)
    {
     switch (getGameAction(keyCode)) {
	case Canvas.UP:
	    {
            if(Ytanque-1 >= 0)
            {
                Ytanque -= 1;
            }
          }
	    break;
	case Canvas.DOWN:
	    {
            if(Ytanque+1 <= 38)
            {
                Ytanque += 1;
            }  
         }
	    break;
	
	case Canvas.RIGHT:
	    if(!balas.llena())
            {
                b = new Bala(Xbala,Ytanque*5+5);
                balas.pone(b);
                disparos++;
            }
	    break;
    
    }  }  
    
}

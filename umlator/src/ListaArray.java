import java.util.*;
import java.awt.*;
import java.awt.geom.*;
/**
 * @author GuRu (TiTaN TeaM) 
 * @version 1.0
 */
public class ListaArray implements java.io.Serializable
{
    ArrayList lista;
    String nombre="";
    String path="";

    public ListaArray()
    {
        lista=new ArrayList();
    }

    public boolean isVacia()
    {
        if(lista.size()==0)return true;
        else return false;
    }
    
    public void mete(int tipo, int x, int y, Color c)
    {
        Nodo nuevo=new Nodo(tipo,x,y,c);
        lista.add(nuevo);
    }
     
     public void mete(int tipo, int x, int y, Color c,String nombre)
    {
        Nodo nuevo=new Nodo(tipo,x,y,c,nombre);
        lista.add(nuevo);
    }
    
    public void mete(int tipo, int x, int y,int w,int h, Color c)
    {
        Nodo nuevo=new Nodo(tipo,x,y,w,h,c);
        lista.add(nuevo);
    }
    
    public void mete(Nodo entry)
    {
        lista.add(entry);
    }
    
    public void elimina(Nodo nodo)
    {
        lista.remove(lista.indexOf(nodo));
    }
    
    public Graphics dibujaTodo(Graphics g)
    {
        Nodo nodo=new Nodo(0,0,0,Color.white);
        dibujaLineas(g);
        for (Iterator iter = lista.iterator(); iter.hasNext();) {
            nodo=(Nodo)iter.next();
            if(nodo.tipo!=5)
            g=nodo.dibujar(g);
        }
        return g;
    }
    
    public Graphics dibujaLineas(Graphics g)
    {
        Graphics2D g2d=(Graphics2D)g;
        Nodo nodo=new Nodo(0,0,0,Color.white);
        int i=0;
        for (Iterator iter = lista.iterator(); iter.hasNext();i++) {
            nodo=(Nodo)iter.next();
            if(nodo.enlace.size()>0){
                for(int num=0;num<nodo.enlace.size();num++){
                    Integer val=(Integer)nodo.enlace.get(num);
                    if(val.intValue()>=lista.size())return g2d;
                    Nodo otro=(Nodo)lista.get(val.intValue());
                    if(otro.enlace.indexOf(new Integer(num))!=-1){
                        g2d.draw(new Line2D.Double((2*nodo.f.getX()+nodo.f.getWidth())/2,(2*nodo.f.getY()+nodo.f.getHeight())/2,(2*otro.f.getX()+otro.f.getWidth())/2,(2*otro.f.getY()+otro.f.getHeight())/2));
                        //System.out.println((nodo.f.PosX+nodo.f.Ancho)/2+" "+(nodo.f.PosY+nodo.f.Alto)/2+" "+(otro.f.PosX+otro.f.Ancho)/2+" "+(otro.f.PosY+otro.f.Alto)/2);
                        //mete(5,nodo.f.PosX,nodo.f.PosY,otro.f.PosX,otro.f.PosY,Color.black);
                    }
                }
            }
        }
        return g2d;
    }
    
    public Nodo buscaNodo(int x,int y)
    {
        Nodo regreso=new Nodo(0,0,0,Color.white);
        Nodo actual=new Nodo(0,0,0,Color.white);
        for (Iterator iter = lista.iterator(); iter.hasNext();) {
            actual=(Nodo)iter.next();
                if(actual.tipo==5){}
                else{
                    //System.out.println(x+">="+actual.f.PosX+" && "+x +"<="+ (actual.f.PosX+actual.f.Ancho));
                    if((x >=actual.f.getX()) && (x <= actual.f.getX()+actual.f.getWidth())){
                        //System.out.println(x+">="+actual.f.PosX+" && "+x +"<="+ (actual.f.PosX+actual.f.Ancho));
                        if((y >= actual.f.getY()) && (y <= actual.f.getY()+actual.f.getHeight()))
                        {
                            regreso=actual;
                        }
                    }
                }
            }
        if(regreso.tipo==0)return null;
        return regreso;
    }
    
    public void alFrente(Nodo nodo)
    {
        lista.add(lista.remove(lista.indexOf(nodo)));
    } 
    
}

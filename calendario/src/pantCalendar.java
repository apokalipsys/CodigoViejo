import java.util.Date;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Interfaz gr�fica del Calendario
 *
 * @author BOo
 * @version 0.2 beta
 */
public class pantCalendar extends Applet implements MouseListener, ActionListener
{
    private Tabla calenda;
    private Button agnoIzq, agnoDer, mesIzq, mesDer;
    private JPanel agnoPanel, mes;
    private TextField mes2, agnoField;
    private int agno, meses, limit;
    private Date meagno;
    calendas comTab;
    Agendita ag;

    public void init()
    {
        calenda = new Tabla(6,7);
        
        meagno = new Date();
        
        agno = meagno.getYear()+1900;
        meses = meagno.getMonth()+1;
        
        Label me = new Label("Mes");
        Label agnoLabel = new Label("Año");
        
        mes2 = new TextField(2);
        add(mes2);
        mes2.setText(""+meses);
        mes2.addActionListener(this);
        
        agnoField = new TextField(4);
        add(agnoField);
        agnoField.setText(""+agno);
        agnoField.addActionListener(this);
        
        Panel p1 = new Panel();
        p1.add(agnoLabel);
        p1.add(agnoField);
        
        Panel p2 = new Panel();
        p2.add(me);
        p2.add(mes2);
        
        add(p2);
        add(p1);
        
        this.addMouseListener(this);
    }

    public void paint(Graphics g)
    {
        g.drawString("L",40,55);
        g.drawString("M",80,55);
        g.drawString("M",120,55);
        g.drawString("J",160,55);
        g.drawString("V",200,55);
        g.drawString("S",240,55);
        g.drawString("D",280,55);
        makeCalendar(); 
        calenda.mostrar(g);
    }

    public void makeCalendar()
    {
        TextArea ta= new TextArea("",10,2);
        comTab = new calendas(1,meses,agno);
        comTab.procesar(ta,ta);
        
        createLimit();
        
        int pDia = 1;
        
        if(!comTab.esBisiesto() && meses == 2)
            limit = 28;
        
        switch(comTab.tablaii)
        {
            case 1 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {    
                         calenda.establecerValor("");
                         if(col2 == 6)
                             calenda.establecerValor(Integer.toString(pDia));
                         calenda.seleccionarComponente(20+(40*col2),60);
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             pDia++;
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                         }
                     }; break;
            case 2 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor(Integer.toString(pDia));
                         calenda.seleccionarComponente(20+(40*col2),60);
                         pDia++;
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;
            case 3 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor("");
                         if(col2 >= 1)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             pDia++;
                         }    
                         calenda.seleccionarComponente(20+(40*col2),60);
                         
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;
            case 4 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor("");
                         if(col2 >= 2)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             pDia++;
                         }
                         calenda.seleccionarComponente(20+(40*col2),60);
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;
            case 5 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor("");
                         if(col2 >= 3)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             pDia++;
                         }
                         calenda.seleccionarComponente(20+(40*col2),60);
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;
            case 6 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor("");
                         if(col2 >= 4)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             pDia++;
                         }
                         calenda.seleccionarComponente(20+(40*col2),60);
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;
            case 0 :{ 
                     for(int col2 = 0; col2 < 7; col2++)
                     {
                         calenda.establecerValor("");
                         if(col2 >= 5)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             pDia++;
                         }
                         calenda.seleccionarComponente(20+(40*col2),60);
                     }
                     for (int renglon = 1; renglon <  6;  renglon++)
                         for (int col = 0; col < 7; col++)
                         {
                             calenda.establecerValor(Integer.toString(pDia));
                             if(pDia>limit)
                                calenda.establecerValor("");
                             calenda.seleccionarComponente(20+(40*col),60+(40*renglon));
                             pDia++;
                         }
                     }; break;         
        }
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == mes2)
        {
            meses = Integer.parseInt(mes2.getText());
            
            if(meses < 1)
            {
               meses = 1;
               mes2.setText(""+1);
            }
            if(meses > 12)
            {
               meses = 12;
               mes2.setText(""+12);
            }
            
           repaint();    
        }
        
        if(a.getSource() == agnoField)
        {
            agno = Integer.parseInt(agnoField.getText());
            
            if(agno < 1)
            {
                agno = 1;
                agnoField.setText(""+1);
            }    
            
            if(agno > 2499)
            {
                agno = 2499;
                agnoField.setText(""+2499);
            }
            
           repaint();    
        }       
    }
    
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        
        if(x>20 && x<300 && y>60 && y<300)
        {
            calenda.cambiaColor(x,y, Color.blue, Color.blue);
            repaint();
        } 
        
        if(e.getClickCount() == 2)
        {
            ag = new Agendita(Integer.parseInt(calenda.devolverValor(x,y)),meses,agno);
            ag.setSize(300,300);
            ag.setVisible(true);
        }
    }
    
    public void mouseReleased(MouseEvent e)
    {
    }
    
    public void mousePressed(MouseEvent e)
    {
    }
    
    public void mouseEntered(MouseEvent e)
    {   /*
        int x = e.getX();
        int y = e.getY();
       
       if(x>20 && x<300 && y>60 && y<300)
        {
            int z = Integer.parseInt(calenda.devolverValor(x,y));
            Santoral santillo = new Santoral(z,meses);
            repaint();
        } */
    }
    
    public void mouseExited(MouseEvent e)
    {
    }
    
    public void createLimit()
    {
        switch(meses)
            {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12: limit = 31; break;
                case 4:
                case 6:
                case 9:
                case 11: limit = 30; break;
                case 2: limit = 29; break;
            }
    }
}

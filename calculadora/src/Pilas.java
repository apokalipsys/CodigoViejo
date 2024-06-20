
/**
 * Este es el cerebro de la Caluladora.
 * 
 * @author BOo
 * @version 1.2c 2003.09.22.23.28 New Swing Release
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pilas extends JFrame implements ActionListener, WindowListener
{
	//Barra menu, y demases utilidades
    private JMenuItem Suma, Resta, Div, Mul, SumAgain, ResAgain, DivAgain, MulAgain;
    private JMenuItem Raiz, Raizn, Elev, Abs, Cos, Sin, Tan, AproxA, Aproxa, Log, Ln, Lx;
    private JMenuItem A, B, C, D, E, F, As, Bs, Cs, Ds, Es, Fs;
    private JMenuItem men, May;
    private JMenuItem Limpiar, Salir;
    private JMenuItem About; 
    private JMenu Cientifica, Comp, Mem, See;
    private JMenu Archivo, Oper, HAbout;
    private JMenuBar menu;
    private TextField x,y, Res, Text;
    private double res, a, b, c, d, e, f;
//tabla
    private GridBagLayout cl=new GridBagLayout();
    private GridBagConstraints cc=new GridBagConstraints();
    private Container cont;
//paneles       
    private Panel p1=new Panel();
    private Panel p2=new Panel();
    private Panel p3=new Panel();
    private Panel p4=new Panel(); 
	
	public Pilas()
	{
		setSize(350,250);
		show();
		
		cont=getContentPane();
        setTitle("Calculadora Mula");
        cont.setLayout(new FlowLayout());
        
        menu = new JMenuBar(); 
        setJMenuBar( menu );
                                                //botones del menu
        Archivo = new JMenu("Archivo");
        
        Limpiar = new JMenuItem("Limpiar Memorias");
        Archivo.add(Limpiar);
        Limpiar.addActionListener(this);
        Archivo.addSeparator();
        Salir = new JMenuItem("Salir");
        Archivo.add(Salir);
        Salir.addActionListener(this);
        
        menu.add(Archivo);                          //fin menu archivo
        
        Oper = new JMenu("Operar");
        
        Suma = new JMenuItem("Suma (x+y)");
        Oper.add(Suma);
        Suma.addActionListener(this);
        Resta = new JMenuItem("Resta (x-y)");
        Oper.add(Resta);
        Resta.addActionListener(this);
        Mul = new JMenuItem("Multiplicar (x*y)");
        Oper.add(Mul);
        Mul.addActionListener(this);
        Div = new JMenuItem("Dividir (x/y)");
        Oper.add(Div);
        Div.addActionListener(this);
        Oper.addSeparator();
        SumAgain = new JMenuItem("Sumar al resultado (res+x)");
        Oper.add(SumAgain);
        SumAgain.addActionListener(this);
        ResAgain = new JMenuItem("Restar al resultado (res-x)");
        Oper.add(ResAgain);
        ResAgain.addActionListener(this);
        MulAgain = new JMenuItem("Multiplicar al Resultado (res*x)");
        Oper.add(MulAgain);
        MulAgain.addActionListener(this);
        DivAgain = new JMenuItem("Dividir al resultado (res/x)");
        Oper.add(DivAgain);
        DivAgain.addActionListener(this);
        Oper.addSeparator();
        Cientifica = new JMenu("Calculadora Científica");
        Oper.add(Cientifica);
        Cientifica.addActionListener(this);
        Raiz = new JMenuItem("Raiz Cuadrada (raiz^2(x))");  
        Cientifica.add(Raiz);
        Raiz.addActionListener(this);
        Raizn = new JMenuItem("Raiz Enésima (raiz^y(x))");
        Cientifica.add(Raizn);
        Raizn.addActionListener(this);
        Elev = new JMenuItem("Elevar (xª)");
        Cientifica.add(Elev);
        Elev.addActionListener(this);
        Abs = new JMenuItem("Valor Absoluto (|x|)");
        Cientifica.add(Abs);
        Abs.addActionListener(this);
        Sin = new JMenuItem("Seno (sen x)");
        Cientifica.add(Sin);
        Sin.addActionListener(this);
        Cos = new JMenuItem("Coseno (cos x)");
        Cientifica.add(Cos);
        Cos.addActionListener(this);
        Tan = new JMenuItem("Tangente (tan x)"); 
        Cientifica.add(Tan);
        Tan.addActionListener(this);
        AproxA = new JMenuItem("Aproximar al Mayor (aprox x)");
        Cientifica.add(AproxA);
        AproxA.addActionListener(this);
        Aproxa = new JMenuItem("Aproximar al Menor (aprox x)");
        Cientifica.add(Aproxa);
        Aproxa.addActionListener(this);
        Log = new JMenuItem("Logaritmo (log x)");
        Cientifica.add(Log);
        Log.addActionListener(this);
        Ln = new JMenuItem("Log. Natural (loge X)");
        Cientifica.add(Ln);
        Ln.addActionListener(this);
        Lx = new JMenuItem("Log. Enésimo (logy X)");
        Cientifica.add(Lx);
        Lx.addActionListener(this);
        Oper.addSeparator();
        Comp = new JMenu("Comparar");
        Oper.add(Comp);
        Comp.addActionListener(this);
        men = new JMenuItem("Menor que (x<y)");
        Comp.add(men);
        men.addActionListener(this);
        May = new JMenuItem("Mayor que (x>y)");
        Comp.add(May);
        May.addActionListener(this);
        Oper.addSeparator();
        Mem = new JMenu("Memoria");
        Oper.add(Mem);
        Mem.addActionListener(this);
        A = new JMenuItem("A");
        Mem.add(A);
        A.addActionListener(this);
        B = new JMenuItem("B");
        Mem.add(B);
        B.addActionListener(this);
        C = new JMenuItem("C");
        Mem.add(C);
        C.addActionListener(this);
        D = new JMenuItem("D");
        Mem.add(D);
        D.addActionListener(this);
        E = new JMenuItem("E");
        Mem.add(E);
        E.addActionListener(this);
        F = new JMenuItem("F");
        Mem.add(F);
        F.addActionListener(this);
        See = new JMenu("Ver Memoria");
        Oper.add(See);
        See.addActionListener(this);
        As = new JMenuItem("A");
        See.add(As);
        As.addActionListener(this);
        Bs = new JMenuItem("B");
        See.add(Bs);
        Bs.addActionListener(this);
        Cs = new JMenuItem("C");
        See.add(Cs);
        Cs.addActionListener(this);
        Ds = new JMenuItem("D");
        See.add(Ds);
        Ds.addActionListener(this);
        Es = new JMenuItem("E");
        See.add(Es);
        Es.addActionListener(this);
        Fs = new JMenuItem("F");
        See.add(Fs);
        Fs.addActionListener(this);
        
        menu.add(Oper);// fin menu oper
        
        HAbout = new JMenu("?");
        
        About = new JMenuItem("About");
        HAbout.add(About);
        About.addActionListener(this);
        
        menu.add(HAbout);//fin about
        
        
        this.addWindowListener(this);
        
       
        
        Label n1 = new Label("X:");
        cont.add(n1);
        x = new TextField(15);
        cont.add(x);
        x.addActionListener(this);
        Label n2 = new Label("Y:");
        cont.add(n2);
        y = new TextField(15);
        cont.add(y);
        y.addActionListener(this);
        Label r = new Label("resultado:");
        cont.add(r);
        Res = new TextField(15);
        cont.add(Res);
        Res.setEditable(false);
        Text = new TextField("Bienvenido a la Calculadora Mula by BOo");
        cont.add(Text);
        Text.setEditable(false);
        
        cont.add(p1);  //ordenando en paneles
        cont.add(p2);
        cont.add(p3);
        cont.add(p4);
        
        p1.add(Text);
        p2.add(n1);
        p2.add(x);
        p3.add(n2);
        p3.add(y);
        p4.add(r);
        p4.add(Res);
        
   }

   public void actionPerformed(ActionEvent event) // todo el programa esta aqui
   {  
       if(event.getSource() == Limpiar) //Boton Limpiar
       {  
            res = 0;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
                 
            Res.setText("");
            Text.setText("Todas las memorias limpias");
        }
        
        if(event.getSource() == Salir)    // boton salir
            System.exit(0);
        
        if(event.getSource() == Suma) //operaciones
        {  
            res = ( Double.parseDouble(x.getText()) ) + ( Double.parseDouble(y.getText()) );
            Res.setText(Double.toString(res));
            Text.setText("X e Y han sido sumados");
        }
        if(event.getSource() == Resta) 
        {
            res = ( Double.parseDouble(x.getText()) ) - ( Double.parseDouble(y.getText()) );
            Res.setText(Double.toString(res));
            Text.setText("X e Y han sido restados");
        }
        if(event.getSource() == Mul) 
        {
            res = ( Double.parseDouble(x.getText()) ) * ( Double.parseDouble(y.getText()) );
            Res.setText(Double.toString(res));
            Text.setText("X e Y han sido multiplicados");
        }
        if(event.getSource() == Div) 
        {
            res = ( Double.parseDouble(x.getText()) ) / ( Double.parseDouble(y.getText()) );
            Res.setText(Double.toString(res));
            Text.setText("X e Y han sido divididos");
        }
        if(event.getSource() == SumAgain) 
        {
                res = res + ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X y Resultado han sido sumados");
        }
        if(event.getSource() == ResAgain) 
        {
                res = res - ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X y Resultado han sido restados");
        }
        if(event.getSource() == MulAgain) 
        {
                res = res * ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X y Resultado han sido multiplicados");
        }
        if(event.getSource() == DivAgain) 
        {
                res = res / ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X y Resultado han sido divididos");
        }
        if(event.getSource() == Raiz) 
        {
                res = Math.sqrt( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'raizado'");
        }
        if(event.getSource() == Raizn)
        {
                res = Math.pow(( Double.parseDouble(x.getText()) ) , 1/( Double.parseDouble(y.getText()) ));
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'raizado' en Y");
        }        
        if(event.getSource() == Elev) 
        {
                res = Math.pow(( Double.parseDouble(x.getText()) ) , ( Double.parseDouble(y.getText()) ));
                Res.setText(Double.toString(res));
                Text.setText("X ha sido elevado a Y");
        }
        if(event.getSource() == Abs) 
        {
                res = Math.abs( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'absoluteado'");
        }
        if(event.getSource() == Cos) 
        {
                res = Math.cos( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'coseneado'");
        }
        if(event.getSource() == Sin) 
        {
                res = Math.sin( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'seneado'");
        }
        if(event.getSource() == Tan) 
        {
                res = Math.tan( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'tangeado'");
        }
        if(event.getSource() == AproxA) 
        {
                res = Math.ceil ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido aproximado al Mayor");
        }
        if(event.getSource() == Aproxa) 
        {
                res = Math.floor ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido aproximado al menor");
        }
        if(event.getSource() == Log) 
        {
                res = (Math.log ( Double.parseDouble(x.getText()) ))/(Math.log(10));
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'logaritmiado' en base 10");
        }
        if(event.getSource() == Ln)
        {
                res = Math.log ( Double.parseDouble(x.getText()) );
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'logaritmiado naturalmente'");
        }
        if(event.getSource() == Lx) 
        {
                res = (Math.log ( Double.parseDouble(x.getText()) ))/(Math.log(Double.parseDouble(y.getText())));
                Res.setText(Double.toString(res));
                Text.setText("X ha sido 'logaritmiado' en base Y");
        }
        if(event.getSource() == men)
        {
                if(Double.parseDouble(x.getText()) <  Double.parseDouble(y.getText()))
                {   
                    Res.setText("X es menor que Y");
                    Text.setText("X e Y han sido comparados");
                }
                else
                {
                    Res.setText("X no es menor que Y");
                    Text.setText("X e Y han sido comparados, pero sin exito");
                }
        }
        if(event.getSource() == May)
        {
                if(Double.parseDouble(x.getText()) >  Double.parseDouble(y.getText()))
                {   
                    Res.setText("X es mayor que Y");
                    Text.setText("X e Y han sido comparados");
                }
                else
                {
                    Res.setText("X no es mayor que Y");
                    Text.setText("X e Y han sido comparados, pero sin exito");
                }
        }
        if(event.getSource() == A) 
        {
                a = Double.parseDouble(Res.getText());
                Text.setText("Mem. A = "+Double.toString(a));
        }
        if(event.getSource() == B) 
        {
                b = Double.parseDouble(Res.getText());
                Text.setText("Mem. B = "+Double.toString(b));
        }
        if(event.getSource() == C) 
        {
                c = Double.parseDouble(Res.getText());
                Text.setText("Mem. C = "+Double.toString(c));
        }
        if(event.getSource() == D) 
        {
                d = Double.parseDouble(Res.getText());
                Text.setText("Mem. D = "+Double.toString(d));
        }
        if(event.getSource() == E) 
        {
                e = Double.parseDouble(Res.getText());
                Text.setText("Mem. E = "+Double.toString(e));
        }
        if(event.getSource() == F) 
        {
                f = Double.parseDouble(Res.getText());
                Text.setText("Mem. F = "+Double.toString(f));
        }
        if(event.getSource() == As) 
        {
                Text.setText("Mem. A = "+Double.toString(a));
        }
        if(event.getSource() == Bs) 
        {
                Text.setText("Mem. B = "+Double.toString(b));
        }
        if(event.getSource() == Cs) 
        {
                Text.setText("Mem. C = "+Double.toString(c));
        }
        if(event.getSource() == Ds) 
        {
                Text.setText("Mem. D = "+Double.toString(d));
        }
        if(event.getSource() == Es) 
        {
                Text.setText("Mem. E = "+Double.toString(e));
        }
        if(event.getSource() == Fs) 
        {
                Text.setText("Mem. F = "+Double.toString(f));
        }
            
        if(event.getSource() == About)  // mi orgullo, el about
                JOptionPane.showMessageDialog(null, "Calculadora Mula v.1.2c 2003.09.22.23.28 Swing Release.\n" + 
                                                    "Creada por BOo.\n"+
                                                    "Exclusivo para Programación II.\n"+
                                                    "Quien Copie la Idea se va de P.L.R.");
                
        repaint();

   }
         
         
    //cosas que hay que escribir por que si...     
   public void windowClosing(WindowEvent e) 
   {
       System.exit(0);
   }
         
   public void windowIconified(WindowEvent e) 
   {
   }
         
   public void windowOpened(WindowEvent e) 
   {
   }
         
   public void windowClosed(WindowEvent e) 
   {    
        JOptionPane.showMessageDialog(null,"Espero que el resultado haya sido de su agrado.\nCalculadora Mula©Todos los Derechos Reservadísimos.\nBOo Inc. 2003");
   }
         
   public void windowDeiconified(WindowEvent e) 
   {
   }
         
   public void windowActivated(WindowEvent e) 
   {
   }
         
   public void windowDeactivated(WindowEvent e) 
   {
   }
}

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * INtefaaaz
 * 
 * @author BOo 
 */
public class Estadistico implements ActionListener
{
    private JButton crearPoblacion, crearMuestras;
    private JTextField tamanoPoblacion, parametro, tamanoMuestra;
    private JTabbedPane paneles;
    private JFrame padre;
    private JTable poblacional, muestral;
    private Graficator grafico1, grafico2;
    private Container c1, c2;
    private JScrollPane panelPobla, panelMuestra;
    private int tamaPoblation;
    private int[] laPobla;
    private int[] laMostra;

    public Estadistico(JFrame elFrame) 
    {
        padre = elFrame;
        paneles = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT );
        
        tamanoPoblacion = new JTextField(3);
        tamanoPoblacion.setText("150");
        parametro = new JTextField(3);
        parametro.setText("100");
        parametro.setEditable(true);
        crearPoblacion = new JButton("Crear");
        crearPoblacion.addActionListener(this);
        JPanel ilPane = new JPanel();
        ilPane.add(new JLabel("N:"));
        ilPane.add(tamanoPoblacion);
        ilPane.add(new JLabel("                Parametro:"));
        ilPane.add(parametro);
        ilPane.add(crearPoblacion);
        poblacional = new JTable(1,2);
        panelPobla = new JScrollPane(poblacional);
        grafico1 = new Graficator(1,100);
        grafico1.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Gr�fico Poblacion (Frecuencia)"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        
        c1 = new Container();
        c1.setLayout(new BorderLayout());
        c1.add(ilPane, BorderLayout.NORTH);
        c1.add(panelPobla, BorderLayout.WEST);
        c1.add(grafico1, BorderLayout.CENTER);
        paneles.addTab("Poblacion", null, c1, "Asuntos Poblacionales");
        
        tamanoMuestra = new JTextField(3);
        tamanoMuestra.setText("15");
        crearMuestras = new JButton("Generar");
        crearMuestras.addActionListener(this);
        
        JPanel lePane = new JPanel();
        lePane.add(new JLabel("Tama�o Muestra"));
        lePane.add(tamanoMuestra);
        lePane.add(crearMuestras);
        muestral = new JTable(1,2);
        panelMuestra = new JScrollPane(muestral);
        grafico2 = new Graficator(1,100);
        grafico2.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Gr�fico Muestras (Frecuencia)"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        
        c2 = new Container();
        c2.setLayout(new BorderLayout());
        c2.add(lePane, BorderLayout.NORTH);
        c2.add(panelMuestra, BorderLayout.WEST);
        c2.add(grafico2, BorderLayout.CENTER);
        paneles.addTab("Muestra", null, c2, "Asuntos Muestrales");
        
        padre.getContentPane().add(paneles);
    }
    int para = 100; 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == crearPoblacion)
        {
            Randomico elRandom;
            try
            {
                c1.remove(panelPobla);    
                c1.remove(grafico1);
                tamaPoblation = Integer.parseInt(tamanoPoblacion.getText());
                para = Integer.parseInt(parametro.getText());
                elRandom = new Randomico(tamaPoblation,para); 
                laPobla = elRandom.elArreglo();
                poblacional =  Tablas.poblacion(elRandom.elArregloObjeto());
                panelPobla = new JScrollPane(poblacional);
                c1.add(panelPobla, BorderLayout.WEST);
                grafico1 = new Graficator(1,para);
                grafico1.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Gr�fico Poblacion (Frecuencia)"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
                grafico1.creaPuntos(laPobla);
                c1.add(grafico1, BorderLayout.CENTER);
                c1.doLayout();
            }
            catch(Exception  ee)
            {
                JOptionPane.showMessageDialog(null,"Error\n"+ee.toString());
            }          
        }
        if(e.getSource() == crearMuestras)
        {
            Promediatico mesmos;
            try
            {
                int tama = Integer.parseInt(tamanoMuestra.getText());
                if(tamaPoblation >= tama)
                {
                    c2.remove(panelMuestra);
                    c2.remove(grafico2);
                    mesmos = new Promediatico(laPobla,tama);
                    laMostra = mesmos.losPromedios();
                    muestral =  Tablas.muestra(mesmos.elArregloObjeto());
                    panelMuestra = new JScrollPane(muestral);
                    c2.add(panelMuestra, BorderLayout.WEST);
                    grafico2 = new Graficator(1,para);
                    grafico2.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Gr�fico Poblacion (Frecuencia)"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
                    grafico2.creaPuntos(laMostra);
                    c2.add(grafico2, BorderLayout.CENTER);
                    c2.doLayout(); 
                }   
                else
                    JOptionPane.showMessageDialog(null,"El tama�o de la muestra no puede ser mayor\nal tama�o de la poblacion");
            }
            catch(Exception  ee)
            {
                JOptionPane.showMessageDialog(null,"Error\n"+ee.toString());
                ee.printStackTrace();
            }          
        }
    }
    
    private void debug()
    {
        
    }
}

import java.awt.*;
import java.awt.print.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.util.List;


/**
 * Inicializador de La Interfaz del usuario.
 * 
 * @author BOo 
 * @version 0.15
 */
public class Faz implements ActionListener
{
    private JMenuBar barra;
    private JMenu File, Edit, About, Herra, export, grillas;
    private JMenuItem abrir, nuevo, guardar, imprimir, gComo, cerrar, salir, cortar, copiar, pegar, about;
    private JMenuItem juente, colorPanel, toJPEG;
    private JRadioButton grilla1, grilla2, nogrilla;
    private JToolBar barra2, barra3;
    private JButton abrirTool, nuevoTool, guardarTool, cerrarTool, cerrarTodoTool, cortarTool, copiarTool, pegarTool;
    private JToggleButton ent, cont, rel, fro, act, fle;
    private JButton cl;
    private JPopupMenu menuPanel, menuMono, menuLinea;
    boolean addControl, addFrontera, addEntidad, addLine, addActor, addFlecha, dragging;
    private JFrame padre;
    private JTextPane Texto;
    private PanelDibujo x; 
    public Color unColor = Color.white;
    private ManejadorArchivo evAr;
    private String titulo1 = "SinTitulo";
    private JTabbedPane editores;
    private Ovulo2D clipboard = null;
    final int size = 40;
    
    public Faz(JFrame frame)
    {
              
        padre = frame;
        
        creaBarra();
        creaBarraHerramienta();   
        creaBarraDibujo();

        editores = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT );
        //popupMenuTab(editores);  
        editores.setAutoscrolls(true);
        
        crearAreaDibujo();
        
        evAr = new ManejadorArchivo(padre);
        
        padre.getContentPane().add(barra2, BorderLayout.NORTH);
        padre.getContentPane().add(editores, BorderLayout.CENTER);
        padre.getContentPane().add(barra3, BorderLayout.SOUTH); 

        padre.setIconImage(Toolkit.getDefaultToolkit().createImage(Faz.class.getResource("/ico/skull.gif")));
        
        addFrontera = false;
        addControl = false;
        addEntidad = false;
        addLine = false;
        dragging = false;
        addActor = false;
        addFlecha = false;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == nuevo || e.getSource() == nuevoTool)
        {
            nuevoWin();
        }
        if(e.getSource() == abrir || e.getSource() == abrirTool)
        {
            if(editores.getTabCount() < 0) nuevoWin();
            evAr.Abrir(areaActual());
        }
        if(e.getSource() == guardar || e.getSource() == guardarTool)
        {
            evAr.guardarComo(areaActual());
        }
        if(e.getSource() == gComo)
        {
        }
        if(e.getSource() == cerrar || e.getSource() == cerrarTool)
        {
            editores.remove(editores.getSelectedIndex());
        }
        if(e.getSource() == cerrarTodoTool)
        {
            cierraTodo();
        } 
        if(e.getSource() == salir)
        {
             cierraTodo();
             System.exit(0);
        }
        if(e.getSource() == cortar || e.getSource() == cortarTool)
        {
            clipboard = selectedShape;
            areaActual().borrarEste(selectedShape);
            areaActual().repaint();
            pegar.setEnabled(true);
            pegarTool.setEnabled(true);
        }
        if(e.getSource() == copiar || e.getSource() == copiarTool)
        {
            clipboard = (Ovulo2D) selectedShape.clone(); 
            pegar.setEnabled(true);
            pegarTool.setEnabled(true);
        }
        if(e.getSource() == pegar || e.getSource() == pegarTool)
        {
            pegando = true;
        }
        if(e.getSource() == colorPanel)
        {
             JDialog jdi = coloreador(areaActual().getBackground());
             jdi.show();
             areaActual().setBackground(unColor);   
        }
        if(e.getSource() == juente)
        {
            areaActual().setFont(JFontChooser.showDialog(padre, "Seleccione Fuente", "Texto de Ejemplo", areaActual().getFont() ));
        }
        
        if(e.getSource() == toJPEG)
        {
            ConfigFilter[] cf = new ConfigFilter[1];
            cf[0] = new ConfigFilter("jpeg","Imagen JPEG [*.jpeg]");
            (new ManejadorArchivo(padre,cf)).guardarImagenComo(areaActual());
        }
        if(e.getSource() == imprimir)
        {
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setPrintable(areaActual());
            if (printJob.printDialog())
            {
                try 
                {
                    printJob.print();  
                } catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Error al imprimir:\n"+
                                                ex.toString(),
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                }
            }
         }
        if(e.getSource() == fro)
        {
            cont.setSelected(false);
            fle.setSelected(false);
            rel.setSelected(false);
            ent.setSelected(false);
            act.setSelected(false);
            addFrontera = true;
            addLine = addActor = addControl = addEntidad = addFlecha =  false;
        }
        
        if(e.getSource() == cont)
        {
            rel.setSelected(false);
            ent.setSelected(false);
            act.setSelected(false);
            fle.setSelected(false);
            fro.setSelected(false);  
            addControl = true;
            addLine = addActor = addEntidad = addFrontera = addFlecha = false;
        }
        if(e.getSource() == rel)
        {
            cont.setSelected(false);
            ent.setSelected(false);
            act.setSelected(false);
            fro.setSelected(false);
            fle.setSelected(false);
            addLine = true;
            addActor = addControl = addEntidad = addFrontera  = addFlecha = false;
         }
         if(e.getSource() == ent)
         {
            cont.setSelected(false);
            rel.setSelected(false);
            act.setSelected(false);
            fro.setSelected(false);
            fle.setSelected(false);
            addEntidad = true;
            addLine = addActor = addControl = addFrontera  = addFlecha = false;
         }
         if(e.getSource() == act)
         {
            cont.setSelected(false);
            rel.setSelected(false);
            ent.setSelected(false);
            fro.setSelected(false);
            fle.setSelected(false);
            addActor = true;
            addLine = addControl = addEntidad = addFrontera  = addFlecha = false;
          }
          if(e.getSource() == fle)
          {
             cont.setSelected(false);
             rel.setSelected(false);
             ent.setSelected(false);
             fro.setSelected(false);
             act.setSelected(false);
             addFlecha = true;
             addLine = addControl = addEntidad = addFrontera  = addActor = false;
          }
          if(e.getSource() == cl)
             areaActual().borraTodo();
          if(e.getSource() == grilla1)
          {
             areaActual().setGrilla1();
             areaActual().repaint();
          }
          if(e.getSource() == grilla2)
          {
          }
          if(e.getSource() == nogrilla)
          {
             areaActual().setNoGrilla();
             areaActual().repaint();  
          }

          if(e.getSource() == about)
          {
             JOptionPane.showMessageDialog(null, AcercaDe.de(),
                                                "Acerca de \"UMLator\"",
                                                JOptionPane.PLAIN_MESSAGE, null);
          }
    } 

    public void nuevoWin()
    {
         if( esSanoCrear())
            crearAreaDibujo();
         else
            JOptionPane.showMessageDialog(null, "ATENCION:\n"+
                                                "Existe un máximo de ventanas, el cual es de 50\n"+
                                                "Para que más?",
                                                "Alerta!!",
                                                JOptionPane.WARNING_MESSAGE);

    }

    public boolean esSanoCrear()
    {
         return editores.getTabCount() <= 50;
    }    

    private void cierraTodo()
    {
        for(int i = editores.getTabCount()-1; i>=0; i--)
        {
            evAr.guardarComo(areaActualAt(i));  
            editores.remove(i);
        }
    } 
    
    private void creaBarraHerramienta()
    {
        barra2 = new JToolBar();
        
        nuevoTool = new JButton(new ImageIcon("src/images/nuevo.gif"));
        barra2.add(nuevoTool);
        nuevoTool.setToolTipText("Nuevo");
        nuevoTool.addActionListener(this);  
        abrirTool = new JButton(new ImageIcon("src/images/abrir.gif"));
        barra2.add(abrirTool);
        abrirTool.setToolTipText("Abrir");
        abrirTool.addActionListener(this);
        guardarTool = new JButton(new ImageIcon("src/images/guardar.gif"));
        barra2.add(guardarTool);
        guardarTool.setToolTipText("Guardar");
        guardarTool.addActionListener(this);
        cerrarTool = new JButton(new ImageIcon("src/images/cerrarFile.gif"));
        barra2.add(cerrarTool);
        cerrarTool.setToolTipText("Cerrar Documento Actual");
        cerrarTool.addActionListener(this);
        barra2.addSeparator();
        barra2.addSeparator();
        cerrarTodoTool = new JButton(new ImageIcon("src/images/cerrar.gif"));
        barra2.add(cerrarTodoTool);
        cerrarTodoTool.setToolTipText("Cerrar Todo");
        cerrarTodoTool.addActionListener(this);         
        barra2.addSeparator();
        /* NO ESTAN TRABAJANDO KORRECTAMENTE, CHAO NUMAS*//*
        cortarTool = new JButton(new ImageIcon("src/images/cortar.gif"));
        barra2.add(cortarTool);
        cortarTool.setToolTipText("Cortar");
        cortarTool.addActionListener(this);
        copiarTool = new JButton(new ImageIcon("src/images/copiar.gif"));
        barra2.add(copiarTool);
        copiarTool.setToolTipText("Copiar");
        copiarTool.addActionListener(this); */ 
        pegarTool = new JButton(new ImageIcon("src/images/pegar.gif"));
        barra2.add(pegarTool);
        pegarTool.setToolTipText("Pegar");
        pegarTool.addActionListener(this);
        pegarTool.setEnabled(true);       
    }

    private void creaBarra()
    {
        barra = new JMenuBar();
        
        File = new JMenu("Archivo");
        
        nuevo = new JMenuItem("Nuevo");
        File.add(nuevo);
        nuevo.addActionListener(this);
        abrir = new JMenuItem("Abrir");
        File.add(abrir);
        abrir.addActionListener(this);
        guardar = new JMenuItem("Guardar");
        File.add(guardar);
        guardar.addActionListener(this);
        gComo = new JMenuItem("Guardar Como...");
        File.add(gComo);
        gComo.addActionListener(this);
        cerrar = new JMenuItem("Cerrar");
        File.add(cerrar);
        cerrar.addActionListener(this);
        File.addSeparator();
        imprimir = new JMenuItem("Imprimir");
        File.add(imprimir);
        imprimir.addActionListener(this);
        File.addSeparator();
        export = new JMenu("Exportar");
           toJPEG = new JMenuItem("JPEG...");
           export.add(toJPEG);
           toJPEG.addActionListener(this);
        File.add(export);
        File.addSeparator();
        salir = new JMenuItem("Salir");
        File.add(salir);
        salir.addActionListener(this);
        barra.add(File);
        
        Edit = new JMenu("Edición");
        /*  NO TRABAJAN CORRECTAMENTE, MEJOR NI PONERLOS *//*
        cortar = new JMenuItem("Cortar");
        Edit.add(cortar);
        cortar.addActionListener(this);
        copiar = new JMenuItem("Copiar");
        Edit.add(copiar);
        copiar.addActionListener(this);*/
        pegar = new JMenuItem("Pegar");
        Edit.add(pegar);
        pegar.addActionListener(this);
        pegar.setEnabled(true);
        barra.add(Edit);
        
        Herra = new JMenu("Herramientas");
        
        colorPanel = new JMenuItem("Color de Panel");
        Herra.add(colorPanel);
        colorPanel.addActionListener(this);
        juente = new JMenuItem("Fuente de Panel");
        Herra.add(juente);
        juente.addActionListener(this);
        grillas = new JMenu("Tipo de Grilla");
        ButtonGroup grupillo = new ButtonGroup();
        grilla1 = new JRadioButton("Lineas");
        grilla1.addActionListener(this);
        grupillo.add(grilla1);
        grillas.add(grilla1);
        grilla2 = new JRadioButton("Tipo 2");
        grilla2.addActionListener(this);
        grupillo.add(grilla2);
        grillas.add(grilla2);
        nogrilla = new JRadioButton("Ninguno");
        nogrilla.addActionListener(this);
        nogrilla.setSelected(true);
        grupillo.add(nogrilla);
        grillas.add(nogrilla);

        Herra.add(grillas);

        barra.add(Herra);
        
        About = new JMenu("Ayuda");
        
        about = new JMenuItem("Acerca de...");
        About.add(about);
        about.addActionListener(this);
        barra.add(About);
        
        padre.setJMenuBar(barra);

        File.setMnemonic(KeyEvent.VK_A); 
        nuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); 
        abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK)); 
        //guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK)); 
        cerrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK)); 
        imprimir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK)); 
        Edit.setMnemonic(KeyEvent.VK_E);   
        //cortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        //copiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        pegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        About.setMnemonic(KeyEvent.VK_U);    
        Herra.setMnemonic(KeyEvent.VK_H);   

    }

    private void creaBarraDibujo()
    {
        barra3 = new JToolBar();
          fro = makeToggleButton(new ImageIcon("src/images/frontera.gif"), "Frontera", this);
        barra3.add(fro);
        cont = makeToggleButton(new ImageIcon("src/images/control.gif"), "Control", this);
        barra3.add(cont);
        ent = makeToggleButton(new ImageIcon("src/images/entidad.gif"), "Entidad", this);
        barra3.add(ent);
        act = makeToggleButton(new ImageIcon("src/images/actor.gif"), "Actor", this);
        barra3.add(act);
        rel = makeToggleButton(new ImageIcon("src/images/linea.gif"), "dibuja una linea", this);
        barra3.add(rel);
        fle = makeToggleButton(new ImageIcon("src/images/linea.gif"), "dibuja una flecha", this);
        barra3.add(fle);
        cl = makeButton("Limpiar", "Elimina todo el diagrama", this);
        barra3.add(cl);
        
    }
    
    public void crearAreaDibujo()
    {
        x = new PanelDibujo();
        popupMenu(x);
        popupMenuMono(x);
        popupMenuLinea(x);
        PanelAccion(x);
        JScrollPane jsp = new JScrollPane(x);
        jsp.setPreferredSize(new Dimension(200,200));
        editores.add(jsp, titulo1, 0);
    }

    public PanelDibujo areaActual()
    {
        JScrollPane scrollPane = (JScrollPane)editores.getSelectedComponent();
      return (PanelDibujo)scrollPane.getViewport().getView();
    } 

    public PanelDibujo areaActualAt(int j)
    {
        JScrollPane scrollPane = (JScrollPane)editores.getComponentAt(j);
      return (PanelDibujo)scrollPane.getViewport().getView();
    }   
    
    public JScrollPane scrollActual()
    {
        return (JScrollPane)editores.getSelectedComponent();
    }
    
    public void escribirTitulo(String nombreTitulo)
    {
        editores.setTitleAt(editores.getSelectedIndex(), nombreTitulo);
    }   

    public void popupMenuTab(final JTabbedPane t1) 
    {
        final JPopupMenu x = new JPopupMenu();

        JMenuItem i1 = new JMenuItem("Guardar");
        JMenuItem i2 = new JMenuItem("Guardar Como");
        JMenuItem i3 = new JMenuItem("Cerrar");
    
        i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK)); 
        i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, ActionEvent.CTRL_MASK)); 
    
        x.add(i1); 
        x.add(i2); 
        x.addSeparator();  
        x.add(i3); 
    

        i1.addActionListener(new ActionListener() { 
            public void actionPerformed( ActionEvent e ) 
            {
          
            }
        }); 

        i2.addActionListener(new ActionListener() { 
            public void actionPerformed( ActionEvent e ) 
            {
                escribirTitulo(titulo1/*evAr.nombreArchivo()*/);
            }
        }); 

        i3.addActionListener(new ActionListener() { 
            public void actionPerformed( ActionEvent e ) 
            {
                editores.remove(editores.getSelectedIndex());
            }
        }); 

    
        t1.addMouseListener( new MouseAdapter() { 
            public void mousePressed( MouseEvent e ) { 
                checkForTriggerEvent(e); 
            } 
     
            public void mouseReleased( MouseEvent e ) { 
                checkForTriggerEvent(e); 
            } 
      
            private void checkForTriggerEvent( MouseEvent e ) { 
                if ( e.isPopupTrigger() ) 
                    x.show( e.getComponent(), e.getX(), e.getY() ); 
            } 
        }); 
    }
    
    public JDialog coloreador(final Color inicial)
    {
        final JColorChooser jcc = new JColorChooser(inicial);
        return JColorChooser.createDialog(null, "Seleccione Color", true,
                                          jcc,
                                          new ActionListener() { 
                                           public void actionPerformed( ActionEvent e ) 
                                           {
                                               unColor = jcc.getColor(); 
                                           }
                                          },
                                          new ActionListener() { 
                                           public void actionPerformed( ActionEvent e ) 
                                           {
                                               unColor = inicial; 
                                           }
                                          }
                                          );
    } 
    
     /**
     * Crea los menus del panel 
     */
    public void popupMenu(final PanelDibujo pd1) 
    {
          menuPanel = new JPopupMenu();

         JMenuItem i1 = new JMenuItem("Ejemplo de un menu desplegable");
         JMenuItem i2 = new JMenuItem("Pegar");
         JMenuItem i3 = new JMenuItem("Color de Fondo");
    
         i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK)); 
         i3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK)); 
    
         //menuPanel.add(i1); 
         menuPanel.add(i2); 
         menuPanel.addSeparator();  
         menuPanel.add(i3); 
         
         i1.addActionListener(new ActionListener() { 
              public void actionPerformed( ActionEvent e ) 
              {
          
              }
         }); 

         i2.addActionListener(new ActionListener() { 
             public void actionPerformed( ActionEvent e ) 
             {
                 pegando = true;
             }
         }); 

         i3.addActionListener(new ActionListener() { 
             public void actionPerformed( ActionEvent e ) 
             {
                  JDialog jdi = coloreador(areaActual().getBackground());
                  jdi.show();
                  areaActual().setBackground(unColor);
             }
         });
         
    }
    
    public void popupMenuMono(final PanelDibujo pd1) 
    {
         menuMono = new JPopupMenu();

         JMenuItem i1 = new JMenuItem("Cortar");
         JMenuItem i2 = new JMenuItem("Copiar");
         JMenuItem i3 = new JMenuItem("Cambiar Nombre");
         JMenuItem i4 = new JMenuItem("Eliminar");
    
         i1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
         i2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    
         menuMono.add(i1); 
         menuMono.add(i2); 
         menuMono.addSeparator();  
         menuMono.add(i3); 
         menuMono.addSeparator();  
         menuMono.add(i4);
         
         i1.addActionListener(new ActionListener() { 
              public void actionPerformed( ActionEvent e ) 
              {
                  Cortar(pd1,selectedShape);
              }
         }); 

         i2.addActionListener(new ActionListener() { 
             public void actionPerformed( ActionEvent e ) 
             {
                  clipboard = (Ovulo2D) selectedShape.clone(); 
             }
         }); 

         i3.addActionListener(new ActionListener() { 
             public void actionPerformed( ActionEvent e ) 
             {
                  String haucs = JOptionPane.showInputDialog(null, "Ingrese un nuevo nombre:", "Ingreso", JOptionPane.QUESTION_MESSAGE);
                  if(haucs != null)
                     selectedShape.setNombre(haucs);
                  else selectedShape.setNombre(" ");   
                  pd1.repaint();
             }
         });
         
         i4.addActionListener(new ActionListener() { 
              public void actionPerformed( ActionEvent e ) 
              {
                  pd1.borrarEste(selectedShape);
                  pd1.repaint();
              }
         });
         
    }
    
    public void popupMenuLinea(final PanelDibujo pd1) 
    {
         menuLinea = new JPopupMenu();

         JMenuItem i3 = new JMenuItem("Cambiar Nombre");
         JMenuItem i4 = new JMenuItem("Eliminar");
    
         menuLinea.add(i3); 
         menuLinea.addSeparator();  
         menuLinea.add(i4);
         
         i3.addActionListener(new ActionListener() { 
             public void actionPerformed( ActionEvent e ) 
             {
                  String haucs = JOptionPane.showInputDialog(null, "Ingrese un nuevo nombre:", "Ingreso", JOptionPane.QUESTION_MESSAGE);
                  if(haucs != null)
                     selectedLine.setNombre(haucs);
                  pd1.repaint();
             }
         });
         
         i4.addActionListener(new ActionListener() { 
              public void actionPerformed( ActionEvent e ) 
              {
                  pd1.borrarEste(selectedLine);
                  pd1.repaint();
              }
         });
         
    }
    
    private JToggleButton makeToggleButton(ImageIcon imm,
                       String toolTipText,
                       ActionListener l)
    {
        JToggleButton button = new JToggleButton(imm);
        //button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(l);
        return button;
    }

    private JButton makeButton(String actionCommand,
                       String toolTipText,
                       ActionListener l)
    {
        JButton button = new JButton(actionCommand);
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(l);
        return button;
    }
    
/*EVENTOS DEL PANEL*/

    Point offset = new Point();
    Ovulo2D selectedShape, ssSha;
    Linea2D selectedLine, ssLine;
    Point start;
    boolean pegando = false;
        
    public void PanelAccion(final PanelDibujo panelD)
    {
        panelD.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e)
            {     
                Point p = e.getPoint(); 
                List list = panelD.getUML2List();
                ssLine = null;
                // are we adding a new shape or drawing a connecting line
                Ovulo2D rs = null;
                if(addControl)
                    rs = new Control(p.x - size/2, p.y - size/2, size, size);
                if(addFrontera)
                    rs = new Frontera(p.x - size/2, p.y - size/2, size, size);
                if(addEntidad)
                    rs = new Entidad(p.x - size/2, p.y - size/2, size, size); 
                if(addActor)
                    rs = new Actor(p.x - 16.6/2, p.y - 16.6/2, 16.6, 16.6*3);  
                if(addLine && list.size() >= 2)
                {
                    start = p;
                    panelD.arrastrar(true);
                    dragging = true;
                    return;
                }
                addLine = false;
                if(addFlecha && list.size() >= 2)
                {
                    start = p;
                    panelD.arrastrar(true);
                    dragging = true;
                    return;
                }
                addFlecha = false;
                if(rs != null)
                {
                    list.add(rs);
                    panelD.repaint();
                    actualiza(panelD,rs.getBounds());
                    addActor = addControl = addEntidad = addFrontera = false;
                    resetBotones();
                    return;
                }

                // or are we selecting an existing shape to drag
                for(int j = 0; j < list.size(); j++)
                {
                    rs = (Ovulo2D)list.get(j);
                    if(rs.contains(p))
                    {
                        ssSha = selectedShape = rs;
                        Rectangle r = rs.getBounds();
                        offset.x = p.x - r.x;
                        offset.y = p.y - r.y;
                        dragging = true;
                        break;
                    }
                }
                List lineL = panelD.getLineList();
                Linea2D lineline = null;
                for(int j = 0; j < lineL.size(); j++)
                {
                    lineline = (Linea2D)lineL.get(j);
                    if(lineline.contains(p))
                    {   
                        ssLine = selectedLine = lineline;
                        Rectangle r = rs.getBounds();
                        offset.x = p.x - r.x;
                        offset.y = p.y - r.y;
                        break;
                    }
                }
                if ( e.isPopupTrigger() && ssLine != null)
                {
                    menuLinea.show( e.getComponent(), e.getX(), e.getY() );
                    ssLine = null;
                    dragging = false;
                    return;
                }
                if ( e.isPopupTrigger() && ssSha != null)
                {
                    menuMono.show( e.getComponent(), e.getX(), e.getY() );
                    ssSha = null;
                    dragging = false;
                    return;
                }
                else if ( e.isPopupTrigger() ) 
                    menuPanel.show( e.getComponent(), e.getX(), e.getY() );            
        
            }

            public void mouseReleased(MouseEvent e)
            {
                if ( e.isPopupTrigger() && selectedLine != null)
                {
                    Linea2D dd = selectedLine;
                    menuLinea.show( e.getComponent(), e.getX(), e.getY() );
                    dragging = false;
                    ssLine = null;
                    return;
                }
                if ( e.isPopupTrigger() && ssSha != null)
                {
                    menuMono.show( e.getComponent(), e.getX(), e.getY() );
                    ssSha = null;
                    dragging = false;
                    return;
                }
                else if ( e.isPopupTrigger() ) 
                    menuPanel.show( e.getComponent(), e.getX(), e.getY() );
            
                if(selectedShape == null && dragging && addLine) // finished drawing a line
                {
                    Linea2D line = new Linea2D(start, e.getPoint());
                    if(line.correctLine(panelD.getUML2List()))
                        panelD.getLineList().add(line);
                    panelD.repaint();
                    resetBotones();
                    addLine = false;
                }
                if(selectedShape == null && dragging && addFlecha) // finished drawing an arrow
                {
                    Flecha line = new Flecha(start, e.getPoint());
                    if(line.correctLine(panelD.getUML2List()))
                        panelD.getLineList().add(line);
                    panelD.repaint();
                    resetBotones();
                    addFlecha = false;
                }
                else // or finished dragging a shape
                    selectedShape = null;
            
                panelD.arrastrar(false);
                dragging = false;
                selectedLine = null;
                ssSha = null;
                ssLine = null;
                
                if(pegando) Pegar(panelD,e.getX(),e.getY());
                panelD.dibujarLimite(false); 
            }
            
        });

        panelD.addMouseMotionListener(new MouseMotionAdapter() {     
            public void mouseDragged(MouseEvent e)
            {
                if(dragging)
                {
                    Point p = e.getPoint();
                    if(selectedShape != null) // dragging a shape
                    {
                        panelD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        Rectangle r = selectedShape.getBounds();
                        r.x = p.x - offset.x;
                        r.y = p.y - offset.y;
                        selectedShape.setFrame(r);
                
                        panelD.repaint();
                        actualiza(panelD,selectedShape.getBounds());
                    }
                    
                    else // drawing a line
                    {
                        panelD.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                        panelD.setLine(start, p);
                        actualiza(panelD, p);
                    }    
                }
            }
    
            public void mouseMoved(MouseEvent e)
            {
                Point p = e.getPoint();
                List list = panelD.getUML2List();
                List list2 = panelD.getLineList();
                panelD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                
                for(int j = 0, k = 0; j < list.size(); j++)
                {
                    Ovulo2D rs = (Ovulo2D)list.get(j);
                    if(rs.contains(p))
                    {
                        panelD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        
                        break;
                    }
                    //else panelD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                
                for(int j = 0; j < list2.size(); j++)
                {
                    Linea2D ps = (Linea2D)list2.get(j);
                    
                    if(ps.contains(p))
                    {  
                        panelD.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        break;
                    }
                    //else panelD.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            }
    
        });
    }

    private void resetBotones()
    {
        rel.setSelected(false);
        cont.setSelected(false);
        ent.setSelected(false);
        act.setSelected(false);
        fro.setSelected(false); 
        fle.setSelected(false);
    }
    
    private void actualiza(PanelDibujo pane, Rectangle r) 
    {
        boolean changed = false;
        
        pane.scrollRectToVisible(r);

            int this_width = (int)(r.getX() + r.getWidth() + 2);
            if (this_width > pane.Area().width) {
                pane.setAreaWidth(this_width); changed=true;
            }

            int this_height = (int)(r.getY() + r.getHeight() + 2);
            if (this_height > pane.Area().height) {
                pane.setAreaHeight(this_height); changed=true;
            }
        
        if (changed) {
            //Update client's preferred size because
            //the area taken up by the graphics has
            //gotten larger or smaller (if cleared).
            pane.setPreferredSize(pane.Area());

            //Let the scroll pane know to update itself
            //and its scrollbars.
            pane.revalidate();
        }
        pane.repaint();
    }

    private void actualiza(PanelDibujo pane, Point r) 
    {
        boolean changed = false;
        
            int this_width = (int)(r.getX());
            if (this_width > pane.Area().width) {
                pane.setAreaWidth(this_width); changed=true;
            }

            int this_height = (int)(r.getY()+ 2);
            if (this_height > pane.Area().height) {
                pane.setAreaHeight(this_height); changed=true;
            }
        
        if (changed) {
            //Update client's preferred size because
            //the area taken up by the graphics has
            //gotten larger or smaller (if cleared).
            pane.setPreferredSize(pane.Area());

            //Let the scroll pane know to update itself
            //and its scrollbars.
            pane.revalidate();
        }
        pane.repaint();
    }
 
    
    /**
     * Metodo para pegar las figuras en el panel
     *
     * @param  panD  panel donde se pegara el objeto
     * @param X la posicion X donde se dibujara el objeto
     * @param Y la posicion Y donde se dibujara el objeto
     * 
     */
    public void Pegar(PanelDibujo panD, int X, int Y)
    {
        if(clipboard != null)
        {
            Rectangle rer = clipboard.getBounds();
            rer.x = X;
            rer.y = Y;
            clipboard.setFrame(rer);
            panD.getUML2List().add(clipboard);
            clipboard = null;
            panD.repaint();
            pegando = false;
        }
    }
    
    /**
     * Metodo para cortar Figuras de un panel
     *
     * @param  pan  panel desde donde se corta
     * @param  ovu  el objeto que se cortara
     */
    public void Cortar(PanelDibujo pan, Ovulo2D ovu)
    {
        int opc = JOptionPane.showConfirmDialog(null, "Al Cortar un objeto,\n todas las relaciones se perderán.\nDesea Continuar?", "Cortando", JOptionPane.YES_NO_OPTION);
        
         if(opc == JOptionPane.YES_OPTION)
         {
             clipboard = ovu;
             pan.borrarEste(ovu);
             pan.repaint();
         }
         else 
         if(opc == JOptionPane.NO_OPTION)
         {
            
         }
    }
    
}

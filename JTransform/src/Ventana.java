/*
 * Ventana.java
 *
 * Created on 20 de octubre de 2006, 07:30 PM
 */

/**
 *
 * @author  ApokalipsyS
 */
public class Ventana extends javax.swing.JFrame {
    
    /** Creates new form Ventana */
    public Ventana() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        traslacionBoton = new javax.swing.JButton();
        rotacionBoton = new javax.swing.JButton();
        escalarBoton = new javax.swing.JButton();
        afinBoton = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        panelDibujo = new PanelDibujo();
        barra = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        opcMenu = new javax.swing.JMenu();
        reestablecer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JTransform");
        traslacionBoton.setText("Traslaci\u00f3n");
        traslacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traslacionBotonActionPerformed(evt);
            }
        });

        rotacionBoton.setText("Rotaci\u00f3n");
        rotacionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotacionBotonActionPerformed(evt);
            }
        });

        escalarBoton.setText("Escalamiento");
        escalarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalarBotonActionPerformed(evt);
            }
        });

        afinBoton.setText("Afin");
        afinBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afinBotonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panelDibujoLayout = new org.jdesktop.layout.GroupLayout(panelDibujo);
        panelDibujo.setLayout(panelDibujoLayout);
        panelDibujoLayout.setHorizontalGroup(
            panelDibujoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 631, Short.MAX_VALUE)
        );
        panelDibujoLayout.setVerticalGroup(
            panelDibujoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 410, Short.MAX_VALUE)
        );
        scroll.setViewportView(panelDibujo);

        archivoMenu.setText("Archivo");
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });

        archivoMenu.add(menuSalir);

        barra.add(archivoMenu);

        opcMenu.setText("Opciones");
        reestablecer.setText("Reestablecer Estrella");
        reestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reestablecerActionPerformed(evt);
            }
        });

        opcMenu.add(reestablecer);

        barra.add(opcMenu);

        setJMenuBar(barra);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(traslacionBoton)
                .add(61, 61, 61)
                .add(rotacionBoton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 85, Short.MAX_VALUE)
                .add(escalarBoton)
                .add(63, 63, 63)
                .add(afinBoton)
                .addContainerGap())
            .add(scroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(traslacionBoton)
                    .add(afinBoton)
                    .add(escalarBoton)
                    .add(rotacionBoton)))
            .add(layout.createSequentialGroup()
                .add(scroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .add(27, 27, 27))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reestablecerActionPerformed
        panelDibujo.setEstrella(null);
        panelDibujo.setPreferredSize(new java.awt.Dimension(100,100));
        panelDibujo.revalidate();
        panelDibujo.repaint();
    }//GEN-LAST:event_reestablecerActionPerformed

    private void afinBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afinBotonActionPerformed
        PanelAfinamiento panelAfina = new PanelAfinamiento();
        javax.swing.JOptionPane.showMessageDialog(null,panelAfina,"Ingrese los valores",
                                                javax.swing.JOptionPane.QUESTION_MESSAGE);
        panelDibujo.afinar(panelAfina.getH1(),panelAfina.getH2(),panelAfina.getH3(),panelAfina.getH4());
        panelDibujo.repaint();
        panelDibujo.updateView();
    }//GEN-LAST:event_afinBotonActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void escalarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escalarBotonActionPerformed
      PanelEscalamiento panelEscala = new PanelEscalamiento();
        javax.swing.JOptionPane.showMessageDialog(null,panelEscala,"Ingrese los valores",
                                                javax.swing.JOptionPane.QUESTION_MESSAGE);
        panelDibujo.escalar(panelEscala.getSX(),panelEscala.getSY());
        panelDibujo.repaint();
        panelDibujo.updateView();
    }//GEN-LAST:event_escalarBotonActionPerformed

    private void rotacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotacionBotonActionPerformed
        PanelRotacion panelRotacion = new PanelRotacion();
        javax.swing.JOptionPane.showMessageDialog(null,panelRotacion,"Ingrese los valores",
                                                javax.swing.JOptionPane.QUESTION_MESSAGE);
        panelDibujo.rotar(panelRotacion.getTX(),panelRotacion.getTY(),panelRotacion.getThetaRadians());
        panelDibujo.repaint();
        panelDibujo.updateView();
    }//GEN-LAST:event_rotacionBotonActionPerformed

    private void traslacionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traslacionBotonActionPerformed
        
        PanelTraslacion panelTraslacion = new PanelTraslacion();
        javax.swing.JOptionPane.showMessageDialog(null,panelTraslacion,"Ingrese los valores",
                                                javax.swing.JOptionPane.QUESTION_MESSAGE);
        panelDibujo.traslar(panelTraslacion.getTX(),panelTraslacion.getTY());
        panelDibujo.repaint();
        panelDibujo.updateView();
    }//GEN-LAST:event_traslacionBotonActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afinBoton;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenuBar barra;
    private javax.swing.JButton escalarBoton;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenu opcMenu;
    private PanelDibujo panelDibujo;
    private javax.swing.JMenuItem reestablecer;
    private javax.swing.JButton rotacionBoton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JButton traslacionBoton;
    // End of variables declaration//GEN-END:variables
    
}

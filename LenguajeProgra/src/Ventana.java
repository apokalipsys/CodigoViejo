/*
 * Ventana.java
 *
 * Created on 3 de octubre de 2006, 08:50 PM
 */

/**
 *
 * @author  ApokalipsyS
 */
public class Ventana extends javax.swing.JFrame {
    
    /** Creates new form Ventana */
    public Ventana() {
        initComponents();
        editor.setText("$miVariable = verdadero\nsi $miVariable entonces mostrar Hola Mundo\nsino mostrar Chao Mundo");
        consola = new Consola();
        consola.setVisible(true);
        consola.requestFocus();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        interpretar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        editor = new javax.swing.JEditorPane();
        barra = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JSeudo Script Interpreter");
        setResizable(false);
        interpretar.setText("Interpretar");
        interpretar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interpretarActionPerformed(evt);
            }
        });

        editor.setFont(new java.awt.Font("Arial", 0, 18));
        jScrollPane1.setViewportView(editor);

        archivo.setText("Archivo");
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        archivo.add(salir);

        barra.add(archivo);

        setJMenuBar(barra);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(interpretar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 260, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(interpretar))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void interpretarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interpretarActionPerformed
        Interprete.interpretar(editor.getText(), consola);
    }//GEN-LAST:event_interpretarActionPerformed
    
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
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuBar barra;
    private javax.swing.JEditorPane editor;
    private javax.swing.JButton interpretar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
    private Consola consola;
}

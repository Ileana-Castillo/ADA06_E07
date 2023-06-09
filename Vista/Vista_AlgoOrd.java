package Vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Clase que implementa todos los elementos visibles en la vista.
 * @author EPolF
 */
public class Vista_AlgoOrd extends javax.swing.JFrame {

    /**
     * Creates new form Vista_BinaryInsertionSort
     */
    public Vista_AlgoOrd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jModoOrdenamiento = new javax.swing.JComboBox<>();
        jOrdenar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jAlgoritmo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jColumna = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos y metodos de ordenamiento");

        jLabel1.setText("Algoritmo de Ordenamiento");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Metodo de ordenamiento");

        jModoOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menor a mayor", "Mayor a menor", "Orden alfabetico", "Inverso al alfabetico" }));
        jModoOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModoOrdenamientoActionPerformed(evt);
            }
        });

        jOrdenar.setText("Ordenar");

        jLabel3.setText("Ordenamiento");

        jAlgoritmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Binary Insertion Sort", "Merge Sort", "Quick Sort", "Radiz Sort" }));
        jAlgoritmo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlgoritmoActionPerformed(evt);
            }
        });

        jLabel4.setText("Columa del dataset");

        jColumna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jColumnaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(304, 304, 304))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(178, 178, 178))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jAlgoritmo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jModoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jColumna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jOrdenar)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jModoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jOrdenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jModoOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModoOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jModoOrdenamientoActionPerformed

    private void jAlgoritmoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlgoritmoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlgoritmoActionPerformed

    private void jColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jColumnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jColumnaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_AlgoOrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_AlgoOrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_AlgoOrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_AlgoOrd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_AlgoOrd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jAlgoritmo;
    private javax.swing.JComboBox<String> jColumna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> jModoOrdenamiento;
    private javax.swing.JButton jOrdenar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    /**
     * Método get de la caja de selección de forma de ordenamiento.
     * @return
     */
    public JComboBox<String> getjModoOrdenamiento() {
        return jModoOrdenamiento;
    }

    /**
     * Método get de la caja del botón para ejecutar el ordenamiento.
     * @return
     */
    public JButton getjOrdenar() {
        return jOrdenar;
    }

    /**
     * Método get del scroll panel.
     * @return
     */
    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * Método get del área de texto.
     * @return
     */
    public JTextArea getjTextArea1() {
        return jTextArea1;
    }

    /**
     * Método get para elegir algoritmo de ordenamiento.
     * @return
     */
    public JComboBox<String> getjAlgoritmo() {
        return jAlgoritmo;
    }

    /**
     * Método get para elegir la columna a ordenar.
     * @return
     */
    public JComboBox<String> getjColumna() {
        return jColumna;
    }
    
    

}

package vista;

import controlador.listas.ListaEnlazada;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import ordenacion.controlador.MergeSort.MetodoMergeSort;
import ordenacion.controlador.QuickSort.MetodoQuickSort;
import vista.Utilidades.Utilidades;
import vista.modeloTabla.IntegersModelTable;


public class IntegerDialog extends javax.swing.JDialog {
    
    private ListaEnlazada<Integer> lista = new ListaEnlazada<>();
    private IntegersModelTable imt = new IntegersModelTable();

    public IntegerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    private void cargarTabla(){
        imt.setLista(lista);
        tblIntegers.setModel(imt);
        tblIntegers.updateUI();
    }
    
    private void generarDatos(){
        lista = Utilidades.generarEnteros();
        cargarTabla();
    }
    
    private void ordenar() throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException{
        LocalTime tiempoInicio = null;
        if (rbtnAscendente.isSelected()) {
            if (rbtnMergeSort.isSelected()) {
                MetodoMergeSort mms = new MetodoMergeSort();
                tiempoInicio = LocalTime.now();
                lista = mms.mergeSort(lista, null, MetodoMergeSort.ASCENDENTE);
            }else{
                MetodoQuickSort mqs = new MetodoQuickSort();
                tiempoInicio = LocalTime.now();
                lista = mqs.quickSort(lista, null, MetodoQuickSort.ASCENDENTE);
            }
        }else{
            if (rbtnMergeSort.isSelected()) {
                MetodoMergeSort mms = new MetodoMergeSort();
                tiempoInicio = LocalTime.now();
                lista = mms.mergeSort(lista, null, MetodoMergeSort.DESCENDENTE);
            }else{
                MetodoQuickSort mqs = new MetodoQuickSort();
                tiempoInicio = LocalTime.now();
                lista = mqs.quickSort(lista, null, MetodoQuickSort.DESCENDENTE);
            }
        }
        calcularTiempo(tiempoInicio);
        cargarTabla();
    }
    
    private void calcularTiempo(LocalTime tiempoInicio){
        Long [] tiempos = Utilidades.tiempoTranscurrido(tiempoInicio, LocalTime.now());
        String tiempo = "";
        String data = "";
        for (int i = 0; i < tiempos.length; i++) {
            switch (i) {
                case 0: {
                    tiempo = "minutos: " + tiempos[i] + " ";
                    data = tiempos[i] + ":";
                    continue;
                }   
                case 1: {
                    tiempo = tiempo + "segundos: " + tiempos[i] + " ";
                    data = data + tiempos[i] + ":";
                    continue;
                }
                case 2: {
                    tiempo = tiempo + "milisegundos: " + tiempos[i] + " ";
                    data = data + tiempos[i] + "";
                    continue;
                }
                default: break;
            }
        }
        txtTiempo.setText(data);
        System.out.println(tiempo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtngMetodos = new javax.swing.ButtonGroup();
        rbtngOrden = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIntegers = new javax.swing.JTable();
        btnGenerar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        rbtnQuickSort = new javax.swing.JRadioButton();
        rbtnMergeSort = new javax.swing.JRadioButton();
        rbtnDescendente = new javax.swing.JRadioButton();
        rbtnAscendente = new javax.swing.JRadioButton();
        btnOrdenar = new javax.swing.JButton();
        txtTiempo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Z003", 1, 18)); // NOI18N
        jLabel1.setText("Números aleatorios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        tblIntegers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblIntegers);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 600, 330));

        btnGenerar.setFont(new java.awt.Font("URW Gothic", 1, 15)); // NOI18N
        btnGenerar.setText("GENERAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 653, 572));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rbtngMetodos.add(rbtnQuickSort);
        rbtnQuickSort.setText("QuickSort");
        jPanel2.add(rbtnQuickSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        rbtngMetodos.add(rbtnMergeSort);
        rbtnMergeSort.setText("MergeSort");
        jPanel2.add(rbtnMergeSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        rbtngOrden.add(rbtnDescendente);
        rbtnDescendente.setText("Descendente");
        rbtnDescendente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDescendenteActionPerformed(evt);
            }
        });
        jPanel2.add(rbtnDescendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        rbtngOrden.add(rbtnAscendente);
        rbtnAscendente.setText("Ascendente");
        jPanel2.add(rbtnAscendente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        btnOrdenar.setFont(new java.awt.Font("Z003", 1, 15)); // NOI18N
        btnOrdenar.setText("ORDENAR");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });
        jPanel2.add(btnOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 110, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 600, 110));

        txtTiempo.setEditable(false);
        txtTiempo.setText("00:00:00");
        getContentPane().add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 280, 110, -1));

        jLabel2.setFont(new java.awt.Font("URW Bookman", 3, 15)); // NOI18N
        jLabel2.setText("Tiempo empleado (mm:ss:ms):");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        // TODO add your handling code here:
        generarDatos();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void rbtnDescendenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDescendenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDescendenteActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
        try {
            // TODO add your handling code here:
            ordenar();
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(IntegerDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(IntegerDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IntegerDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOrdenarActionPerformed

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
            java.util.logging.Logger.getLogger(IntegerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntegerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntegerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntegerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IntegerDialog dialog = new IntegerDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnAscendente;
    private javax.swing.JRadioButton rbtnDescendente;
    private javax.swing.JRadioButton rbtnMergeSort;
    private javax.swing.JRadioButton rbtnQuickSort;
    private javax.swing.ButtonGroup rbtngMetodos;
    private javax.swing.ButtonGroup rbtngOrden;
    private javax.swing.JTable tblIntegers;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author FOLIO 1040 G3
 */
public class MPetugas extends javax.swing.JFrame {

    /**
     * Creates new form MPetugas
     */
    public MPetugas() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttelp = new javax.swing.JTextField();
        txtkdpetugas1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        txtkatakunci = new javax.swing.JTextField();
        cmdubah = new javax.swing.JButton();
        cmdsimpan1 = new javax.swing.JButton();
        cmdubah1 = new javax.swing.JButton();
        cmdbatal = new javax.swing.JButton();
        cmdubah3 = new javax.swing.JButton();
        cmdhapus1 = new javax.swing.JButton();
        txtnmpetugas2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpetugas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ENTRY DATA PETUGAS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 10, 310, 40);

        jLabel2.setText("Kata Kunci Pencarian");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 330, 160, 30);

        jLabel3.setText("Kode Petugas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 80, 160, 30);

        jLabel4.setText("Nama Petugas");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 130, 160, 30);

        jLabel5.setText("Alamat Petugas");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 180, 160, 30);

        txttelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelpActionPerformed(evt);
            }
        });
        getContentPane().add(txttelp);
        txttelp.setBounds(170, 280, 240, 30);
        getContentPane().add(txtkdpetugas1);
        txtkdpetugas1.setBounds(170, 80, 240, 30);

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 180, 240, 80);

        txtkatakunci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkatakunciActionPerformed(evt);
            }
        });
        getContentPane().add(txtkatakunci);
        txtkatakunci.setBounds(170, 330, 240, 30);

        cmdubah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdubah.setText("UBAH");
        getContentPane().add(cmdubah);
        cmdubah.setBounds(500, 130, 110, 30);

        cmdsimpan1.setBackground(new java.awt.Color(102, 255, 0));
        cmdsimpan1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdsimpan1.setText("SIMPAN");
        getContentPane().add(cmdsimpan1);
        cmdsimpan1.setBounds(500, 80, 110, 30);

        cmdubah1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdubah1.setText("UBAH");
        getContentPane().add(cmdubah1);
        cmdubah1.setBounds(500, 130, 110, 30);

        cmdbatal.setBackground(new java.awt.Color(255, 204, 204));
        cmdbatal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdbatal.setText("BATAL");
        getContentPane().add(cmdbatal);
        cmdbatal.setBounds(500, 250, 110, 30);

        cmdubah3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdubah3.setText("HAPUS");
        getContentPane().add(cmdubah3);
        cmdubah3.setBounds(500, 180, 110, 30);

        cmdhapus1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cmdhapus1.setText("HAPUS");
        getContentPane().add(cmdhapus1);
        cmdhapus1.setBounds(500, 180, 110, 30);

        txtnmpetugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmpetugas2ActionPerformed(evt);
            }
        });
        getContentPane().add(txtnmpetugas2);
        txtnmpetugas2.setBounds(170, 130, 240, 30);

        jLabel6.setText("No. Telepon");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 280, 160, 30);

        tblpetugas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblpetugas);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 390, 650, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelpActionPerformed

    private void txtkatakunciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkatakunciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkatakunciActionPerformed

    private void txtnmpetugas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmpetugas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmpetugas2ActionPerformed

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
            java.util.logging.Logger.getLogger(MPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MPetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdhapus1;
    private javax.swing.JButton cmdsimpan1;
    private javax.swing.JButton cmdubah;
    private javax.swing.JButton cmdubah1;
    private javax.swing.JButton cmdubah3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblpetugas;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtkatakunci;
    private javax.swing.JTextField txtkdpetugas1;
    private javax.swing.JTextField txtnmpetugas2;
    private javax.swing.JTextField txttelp;
    // End of variables declaration//GEN-END:variables
}

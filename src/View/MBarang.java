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
public class MBarang extends javax.swing.JFrame {

    /**
     * Creates new form MBarang
     */
    public MBarang() {
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbsatuan = new javax.swing.JComboBox<>();
        txtnmbarang = new javax.swing.JTextField();
        txtnmkategori = new javax.swing.JTextField();
        txtstok = new javax.swing.JTextField();
        cmbkategori = new javax.swing.JComboBox<>();
        txtkdbarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtkatakunci = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbarang = new javax.swing.JTable();
        cmdbatal = new javax.swing.JButton();
        cmdsimpan = new javax.swing.JButton();
        cmdubah = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("ENTRY DATA BARANG");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, -10, 290, 70);

        jLabel2.setText("Stok");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(340, 310, 40, 30);

        jLabel3.setText("Kode Barang");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 190, 30);

        jLabel4.setText("Nama Kategori");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 110, 190, 30);

        jLabel5.setText("Kode Barang");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 160, 190, 30);

        jLabel6.setText("Nama Barang");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 210, 190, 30);

        jLabel7.setText("Satuan");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 260, 190, 30);

        cmbsatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbsatuan);
        cmbsatuan.setBounds(170, 260, 150, 40);
        getContentPane().add(txtnmbarang);
        txtnmbarang.setBounds(170, 210, 300, 40);
        getContentPane().add(txtnmkategori);
        txtnmkategori.setBounds(170, 110, 300, 40);
        getContentPane().add(txtstok);
        txtstok.setBounds(380, 310, 90, 40);

        cmbkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih-", "Item 2", "Item 3", "Item 4" }));
        cmbkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbkategoriActionPerformed(evt);
            }
        });
        getContentPane().add(cmbkategori);
        cmbkategori.setBounds(170, 60, 150, 40);

        txtkdbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkdbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txtkdbarang);
        txtkdbarang.setBounds(170, 160, 150, 40);

        jLabel8.setText("Kata Kunci Pencarian");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 360, 190, 30);
        getContentPane().add(txtkatakunci);
        txtkatakunci.setBounds(170, 360, 150, 40);

        jLabel10.setText("Harga (Rp.)");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 310, 190, 30);
        getContentPane().add(txtharga);
        txtharga.setBounds(170, 310, 150, 40);

        tblbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblbarang);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 420, 680, 110);

        cmdbatal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmdbatal.setText("BATAL");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });
        getContentPane().add(cmdbatal);
        cmdbatal.setBounds(550, 280, 140, 40);

        cmdsimpan.setBackground(new java.awt.Color(153, 255, 153));
        cmdsimpan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmdsimpan.setText("SIMPAN");
        getContentPane().add(cmdsimpan);
        cmdsimpan.setBounds(550, 100, 140, 40);

        cmdubah.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmdubah.setText("UBAH");
        cmdubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubahActionPerformed(evt);
            }
        });
        getContentPane().add(cmdubah);
        cmdubah.setBounds(550, 150, 140, 40);

        cmdhapus.setBackground(new java.awt.Color(255, 153, 153));
        cmdhapus.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmdhapus.setText("HAPUS");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });
        getContentPane().add(cmdhapus);
        cmdhapus.setBounds(550, 200, 140, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdbatalActionPerformed

    private void cmdubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdubahActionPerformed

    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdhapusActionPerformed

    private void cmbkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbkategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbkategoriActionPerformed

    private void txtkdbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkdbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkdbarangActionPerformed

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
            java.util.logging.Logger.getLogger(MBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbkategori;
    private javax.swing.JComboBox<String> cmbsatuan;
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JButton cmdubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbarang;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtkatakunci;
    private javax.swing.JTextField txtkdbarang;
    private javax.swing.JTextField txtnmbarang;
    private javax.swing.JTextField txtnmkategori;
    private javax.swing.JTextField txtstok;
    // End of variables declaration//GEN-END:variables
}

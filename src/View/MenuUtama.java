/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JPanel;

/**
 *
 * @author FOLIO 1040 G3
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        this.setSize(1000, 600);
//        jPanel1.setSize(1000, 600);
        setLocationRelativeTo(this);
        Koneksi.Database.KoneksiDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        MMenu = new javax.swing.JMenu();
        MPelanggan = new javax.swing.JMenuItem();
        MKategori = new javax.swing.JMenuItem();
        MBarang = new javax.swing.JMenuItem();
        MPetugas = new javax.swing.JMenuItem();
        MTransaksi = new javax.swing.JMenu();
        TBuktiPesan = new javax.swing.JMenuItem();
        MLaporan = new javax.swing.JMenu();
        LPelanggan = new javax.swing.JMenuItem();
        LBarang = new javax.swing.JMenuItem();
        MExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        MMenu.setText("File Master");

        MPelanggan.setText("Entry Data Pelanggan");
        MPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPelangganActionPerformed(evt);
            }
        });
        MMenu.add(MPelanggan);

        MKategori.setText("Entry Data Kategori");
        MKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MKategoriActionPerformed(evt);
            }
        });
        MMenu.add(MKategori);

        MBarang.setText("Entry Data Barang");
        MMenu.add(MBarang);

        MPetugas.setText("Entry Data Petugas");
        MPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MPetugasActionPerformed(evt);
            }
        });
        MMenu.add(MPetugas);

        jMenuBar1.add(MMenu);

        MTransaksi.setText("Transaksi");

        TBuktiPesan.setText("Bukti Pesan");
        MTransaksi.add(TBuktiPesan);

        jMenuBar1.add(MTransaksi);

        MLaporan.setText("Laporan");
        MLaporan.setToolTipText("");

        LPelanggan.setText("Laporan Data Pelanggan");
        MLaporan.add(LPelanggan);

        LBarang.setText("Laporan Data Barang");
        MLaporan.add(LBarang);

        jMenuBar1.add(MLaporan);

        MExit.setText("Exit Program");
        MExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MExitMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MExitMouseExited(evt);
            }
        });
        jMenuBar1.add(MExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPelangganActionPerformed
        View.MPelanggan P = new View.MPelanggan();
        P.setVisible(true);
        setLocationRelativeTo(this);
    }//GEN-LAST:event_MPelangganActionPerformed

    private void MExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_MExitMouseClicked

    private void MExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MExitMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MExitMouseExited

    private void MKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MKategoriActionPerformed
        View.MKategoriBarang k = new View.MKategoriBarang();
        k.setVisible(true);
        setLocationRelativeTo(this);
    }//GEN-LAST:event_MKategoriActionPerformed

    private void MPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MPetugasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MPetugasActionPerformed

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LBarang;
    private javax.swing.JMenuItem LPelanggan;
    private javax.swing.JMenuItem MBarang;
    private javax.swing.JMenu MExit;
    private javax.swing.JMenuItem MKategori;
    private javax.swing.JMenu MLaporan;
    private javax.swing.JMenu MMenu;
    private javax.swing.JMenuItem MPelanggan;
    private javax.swing.JMenuItem MPetugas;
    private javax.swing.JMenu MTransaksi;
    private javax.swing.JMenuItem TBuktiPesan;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}

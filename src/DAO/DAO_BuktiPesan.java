/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.BuktiPesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author FOLIO 1040 G3
 */
public class DAO_BuktiPesan implements Model_DAO<BuktiPesan>{

    Connection connection;
    
    public DAO_BuktiPesan(){
        connection = Database.KoneksiDB();
    }
    
    @Override
    public int autonumber(BuktiPesan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // method untuk membuat penomoran bukti pesan secara otomatis
    public String autonumber2(){
        PreparedStatement statement;
        int nomor_berikutnya = 0;
        String urutan = "";
        try {
            String COUNTER = "SELECT ifnull(max(convert(right(nopesan,5), signed integer)), 0) as kode,"
                    + "ifnull(lenght(max(convert(right(nopesan,5)+1, signed integer))),0)as panjang FROM buktipesan";
            
            statement = connection.prepareStatement(COUNTER);
            ResultSet rs2 = statement.executeQuery();
            if (rs2.next()) {
                nomor_berikutnya = rs2.getInt("kode") + 1;
                if (rs2.getInt("kode")!= 0) { //jika nomor transaksi sudah pernah ada
                    if (rs2.getInt("panjang") == 1) { // jika jumlah digitnya adalah 1
                        urutan = "BP" + "0000" + nomor_berikutnya;
                    }else if(rs2.getInt("panjang") == 2){ // jika jumlah digitnya adalah 2
                        urutan = "BP" + "000" + nomor_berikutnya;
                    } else if(rs2.getInt("panjang") == 3){ // jika jumlah digitnya adalah 3
                        urutan = "BP" + "00" + nomor_berikutnya;       
                    } else if(rs2.getInt("panjang") == 4){ // jika jumlah digitnya adalah 4
                        urutan = "BP" + "0" +nomor_berikutnya;    
                    } else if(rs2.getInt("panjang") == 5){ // jika jumlah digitnya adalah 5
                        urutan = "BP" + nomor_berikutnya;
                    }
                } else { // jika nomor transaksi belum pernah ada
                    urutan = "BP" + "00001";
                }
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
            }
        } catch (Exception e) {
        }
        return urutan;
    }
    
    @Override
    public void insert(BuktiPesan object) {
        PreparedStatement statement = null;
        try {
            String SELECT = "SELECT * FROM buktipesan WHERE nopesan=?";
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, object.getNobp());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) { // jika data sudah pernah disimpan
                JOptionPane.showMessageDialog(null, "Data sudah pernah disimpan");
            }else {
                 // jika data belum pernah disimpan
                 
                 // insert kedalam table buktisimpan
                 PreparedStatement statement2;
                 String INSERT = "INSERT INTO buktipesan(nopesan, tglpesan, kdplg) VALUES(?,?,?)";
                 statement2 = connection.prepareStatement(INSERT);
                 statement2.setString(1, object.getNobp());
                 statement2.setString(2, object.getTglbp());
                 statement2.setInt(3, object.getKodeplg());
                 statement2.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Data transaksi berhasil disimpan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method untuk simpan data ke dalam table detilpesan
    public void insert_detiltransaksi(BuktiPesan object){
        PreparedStatement statement;
        try {
            // insert ke dalam table detil pesan
            String INSERTDETIL = "INSERT INTO detilpesan(nopesan, kdbrg, hrgpsn, jmlpesan) VALUES(?,?,?,?)";
            statement = connection.prepareStatement(INSERTDETIL);
            statement.setString(1, object.getNobp());
            statement.setString(2, object.getKodebarang());
            statement.setInt(3, object.getHarga());
            statement.setInt(4, object.getQty());
            statement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // method untuk mengubah stok barang ke dalam table barang
    public void update_stok(BuktiPesan object){
        PreparedStatement statement;
        int stok_akhir = 0;
        try {
            String SELECT = "SELECT stok FROM barang WHERE kdbrg=?";
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, object.getKodebarang());
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) { // jika data ditemukan (baik null maupun tidak null)
                if (rs.getInt("stok")<0) {
                    JOptionPane.showMessageDialog(null, "Stok Kode Barang : " + object.getKodebarang() + "Kosong!");
                    stok_akhir = 0;
                } else{
                    // hitung stok akhir berdasarkan qty masing masing kode barang yang ada di JTable
                    stok_akhir = rs.getInt("stok")- object.getQty();
                    
                    // update stok barang ke dalam table barang
                    PreparedStatement statement2;
                    String UPDATESTOCK = "UPDATE barang SET stok=? WHERE kdbrg=?";
                    statement2 = connection.prepareStatement(UPDATESTOCK);
                    statement2.setInt(1, stok_akhir);
                    statement2.setString(2, object.getKodebarang());
                    statement2.executeQuery();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(BuktiPesan object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BuktiPesan> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BuktiPesan> getCari(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

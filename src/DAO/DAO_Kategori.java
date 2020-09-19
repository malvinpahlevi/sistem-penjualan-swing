/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.Kategori;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author FOLIO 1040 G3
 */
public class DAO_Kategori implements Model_DAO<Kategori>{

    Connection connection;
    
    public DAO_Kategori(){
        connection = Database.KoneksiDB();
    }
    
    String INSERT = "INSERT INTO kategori(kdkategori, nmkategori) values(?,?)";
    String UPDATE = "UPDATE kategori SET nmkategori=? WHERE kdkategori=?";
    String DELETE = "DELETE FROM kategori WHERE kdkategori=?";
    String SELECT = "SELECT * FROM kategori";
    String CARI = "SELECT * FROM kategori WHERE kdkategori LIKE ?";
    String COUNTER = "SELECT max(kdkategori) as kode FROM kategori";

    @Override
    public int autonumber(Kategori object) {
        PreparedStatement statement = null;
        int nomor = 0;
        try {
            statement = connection.prepareStatement(COUNTER);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
                nomor = rs.getInt("kode")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomor;
    }

    @Override
    public void insert(Kategori object) {
    PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(CARI);
            statement.setInt(1, object.getKode());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Data sudah pernah disimpan!");
            }else{
                PreparedStatement statement2 = null;
                statement2 = connection.prepareStatement(INSERT);
                statement2.setInt(1, object.getKode());
                statement2.setString(2, object.getNama());
                statement2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Kategori.class.getName()).log(Level.SEVERE,null,ex);
                
            }
        }
   
    }

    @Override
    public void update(Kategori object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setInt(2, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Kategori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void delete(Integer kode) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DELETE);
            statement.setInt(1, kode);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Kategori.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Kategori> getAll() {
        List<Kategori> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Kategori>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Kategori k =  new Kategori();
                k.setKode(rs.getInt("kdkategori"));
                k.setNama(rs.getString("nmkategori"));
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Kategori> getCari(String key) {
        List<Kategori> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Kategori>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Kategori k = new Kategori();
                k.setKode(rs.getInt("kdkategori"));
                k.setNama(rs.getString("nmkategori"));
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

   
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.Pelanggan;
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
public class DAO_Pelanggan implements Model_DAO<Pelanggan>{

    Connection connection;
    
    // Constructor
    public DAO_Pelanggan(){
        connection = Database.KoneksiDB();
    }
    
    String INSERT = "INSERT INTO pelanggan(kdplg,nmplg,alamatplg,telpplg) values(?,?,?,?)";
    String UPDATE = "UPDATE pelanggan SET nmplg=?, alamatplg=?, telpplg=? WHERE kdplg=?";
    String DELETE = "DELETE FROM pelanggan WHERE kdplg=?";
    String SELECT = "SELECT * FROM pelanggan";
    String CARI = "SELECT * FROM pelanggan WHERE kdplg LIKE ?";
    String COUNTER = "SELECT max(kdplg) as kode FROM pelanggan";
    
    @Override
    public int autonumber(Pelanggan object) {
        PreparedStatement statement = null;
        int nomor = 0;
        try {
            statement = connection.prepareStatement(COUNTER);
            ResultSet rs = statement.executeQuery();
            if(rs.next())
                nomor = rs.getInt("kode")+1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomor;
    }

    @Override
    public void insert(Pelanggan object) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(CARI);
            statement.setInt(1, object.getKode());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Data sudah pernah disimpan!");
            } else {
                PreparedStatement statement2 = null;
                statement2 = connection.prepareStatement(INSERT);
                statement2.setInt(1, object.getKode());
                statement2.setString(2, object.getNama());
                statement2.setString(3, object.getAlamat());
                statement2.setString(4, object.getTelp());
                statement2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }

    @Override
    public void update(Pelanggan object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setString(2, object.getAlamat());
            statement.setString(3, object.getTelp());
            statement.setInt(4, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
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
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Pelanggan> getAll() {
        List<Pelanggan> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Pelanggan>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKode(rs.getInt("kdplg"));
                p.setNama(rs.getString("nmplg"));
                p.setAlamat(rs.getString("alamatplg"));
                p.setTelp(rs.getString("telpplg"));
                list.add(p); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Pelanggan> getCari(String key) {
        List<Pelanggan> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Pelanggan>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, "%"+key+"%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setKode(rs.getInt("kdplg"));
                p.setNama(rs.getString("nmplg"));
                p.setAlamat(rs.getString("alamatplg"));
                p.setTelp(rs.getString("telpplg"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
}

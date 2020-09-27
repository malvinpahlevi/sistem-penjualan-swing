/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.Petugas;
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
public class DAO_Petugas implements Model_DAO<Petugas>{

    Connection connection;
    
    public DAO_Petugas(){
        connection = Database.KoneksiDB();
    }
    
    String INSERT = "INSERT INTO petugas(kdpetugas, nmpetugas, alamatpetugas, telppetugas) values(?,?,?,?)";
    String UPDATE = "UPDATE petugas SET nmpetugas=?, alamatpetugas=?, telppetugas=? WHERE kdpetugas=?";
    String DELETE = "DELETE FROM petugas WHERE kdpetugas=?";
    String SELECT = "SELECT * FROM petugas";
    String CARI = "SELECT * FROM petugas WHERE kdpetugas LIKE ?";
    String COUNTER = "SELECT max(kdpetugas) as kode FROM petugas";
    
    
    @Override
    public int autonumber(Petugas object) {
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
    public void insert(Petugas object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SELECT);
            statement.setInt(1, object.getKode());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Data sudah pernah disimpan!");
            }else{
                PreparedStatement statement2 = null;
                statement2 = connection.prepareStatement(INSERT);
                statement2.setInt(1, object.getKode());
                statement2.setString(2, object.getNama());
                statement2.setString(3, object.getAlamat());
                statement2.setString(4, object.getTelepon());
                statement2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }

    @Override
    public void update(Petugas object) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE);
            statement.setString(1, object.getNama());
            statement.setString(2, object.getAlamat());
            statement.setString(3, object.getTelepon());
            statement.setInt(4, object.getKode());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DAO_Petugas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Petugas> getAll() {
        List<Petugas> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Petugas>();
            statement = connection.prepareStatement(SELECT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Petugas p =  new Petugas();
                p.setKode(rs.getInt("kdpetugas"));
                p.setNama(rs.getString("nmpetugas"));
                p.setAlamat(rs.getString("alamatpetugas"));
                p.setTelepon(rs.getString("telppetugas"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Petugas> getCari(String key) {
        List<Petugas> list = null;
        PreparedStatement statement = null;
        try {
            list = new ArrayList<Petugas>();
            statement = connection.prepareStatement(CARI);
            statement.setString(1, key);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Petugas p = new Petugas();
                p.setKode(rs.getInt("kdpetugas"));
                p.setNama(rs.getString("nmpetugas"));
                p.setAlamat(rs.getString("alamatpetugas"));
                p.setTelepon(rs.getString("telppetugas"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}

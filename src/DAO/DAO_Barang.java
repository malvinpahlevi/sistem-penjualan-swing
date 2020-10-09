/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Koneksi.Database;
import Model.Barang;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author FOLIO 1040 G3
 */
public class DAO_Barang implements Model_DAO<Barang>{

    Connection connection;
    
    public DAO_Barang(){
        connection = Database.KoneksiDB();
    }
    
    String INSERT = "INSERT INTO barang(kdbrg, nmbrg, satuan, hargabrg, stok, kdkategori) values(?,?,?,?,?,?)";
    String UPDATE = "UPDATE barang SET nmbrg=?, satuan=?, hargabrg=?, stok=?, kdkategori=? WHERE kdbrg=?";
    String DELETE = "DELETE FROM barang WHERE kdbrg=?";
    String SELECT = "SELECT a.*, b.* FROM barang a, kategori b WHERE a.kdkategori=b.kdkategori ORDER BY kdbrg";
    String CARI = "SELECT a.*, b.* FROM barang a, kategori b WHERE a.kdkategori=b.kdkategori AND kdbrg LIKE ?";
    String CARIKATEGORI = "SELECT * FROM kategori WHERE kdkategori=?";
    String COMBO = "SELECT kdkategori FROM kategori ORDER BY convert(right(kdkategori, 2), signed integer)";
    String COUNTER = "SELECT ifnull(max(convert(right(kdbrg,2),signed integer)), 0) AS kode,"
            + "ifnull(length(max(convet(right(kdbrg,2), signed integer))), 0) AS panjang"
            + "FROM barang WHERE kdkategori=?";
    
    
    
    
    @Override
    public int autonumber(Barang object) {
        return 0;
    }

    @Override
    public void insert(Barang object) {
        
    }

    @Override
    public void update(Barang object) {
        
    }

    @Override
    public void delete(Integer kode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barang> getAll() {
        
    }

    @Override
    public List<Barang> getCari(String key) {
        
    }
    
    public String autonumber2(Integer id){
        
    }
    
    public List<Barang> IsiCombo(){
        
    }
    
    public List<Barang> getDataKategori(Integer id){
        
    }
    
    
}

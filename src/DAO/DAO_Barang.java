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

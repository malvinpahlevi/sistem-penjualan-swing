/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Pelanggan;
import DAO.Model_DAO;
import Model.Pelanggan;
import View.MPelanggan;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOLIO 1040 G3
 */
public class Controller_Pelanggan {
    
    MPelanggan form;
    Model_DAO<Pelanggan> model;
    // deklarasi method "list" yang sudah dibuat pada interface MODEL_DAO
    List<Pelanggan> list;
    // deklarasi variable untuk membuat judul kolom pada object JTable
    String[] header; 
    
    public Controller_Pelanggan(MPelanggan form){
        this.form = form;
        model = new DAO_Pelanggan();
        list = model.getAll();
        header = new String[]{"KODE", "NAMA PELANGGAN", "ALAMAT", "TELEPON"};
        
        form.getTblplg().setShowGrid(true);
        form.getTblplg().setShowVerticalLines(true);
        form.getTblplg().setGridColor(Color.blue);
    }
    
    //method untuk menampilkan kode pelangan berikutnya
    public void tampilurutankode(){
        Pelanggan p = new Pelanggan();
        model.autonumber(p);
        form.getTxtkdplg().setText(String.valueOf(model.autonumber(p)));
    }
    
    //method untuk membersihkan object inpputan yang ada pada form
    public void reset(){
        form.getTxtkdplg().setText("");
        form.getTxtnmplg().setText("");
        form.getTxtalamat().setText("");
        form.getTxttelp().setText("");
        form.getTxtnmplg().setText("");
        tampilurutankode();
        isiTable();
    }

    //method untuk menampilkan semua data kedalam JTable
    public void isiTable() {
        list = model.getAll();
        
        //Script agar JTable tidak bisa diedit
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header){
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for(Pelanggan p : list){
            data[0] = p.getKode();
            data[1] = p.getNama();
            data[2] = p.getAlamat();
            data[3] = p.getTelp();
            tblModel.addRow(data);
        }
        form.getTblplg().setModel(tblModel);
    }
    
    //method untuk meletakan data ke dalam text berdasarkan data yang dipilih dari JTable
    public void isiField(int row){
        form.getTxtkdplg().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtnmplg().setText(list.get(row).getNama());
        form.getTxtalamat().setText(list.get(row).getAlamat());
        form.getTxttelp().setText(list.get(row).getTelp());
    }
    
    //method untuk simpan data
    public void insert(){
        Pelanggan p = new Pelanggan();
        p.setKode(Integer.parseInt(form.getTxtkdplg().getText()));
        p.setNama(form.getTxtnmplg().getText());
        p.setAlamat(form.getTxtalamat().getText());
        p.setTelp(form.getTxttelp().getText());
        
        model.insert(p);
    }
    
    //method untuk mengubah data
    public void update(){
        Pelanggan p = new Pelanggan();
        p.setKode(Integer.parseInt(form.getTxtkdplg().getText()));
        p.setNama(form.getTxtnmplg().getText());
        p.setAlamat(form.getTxtalamat().getText());
        p.setTelp(form.getTxttelp().getText());
        
        model.update(p);
    }
    
    //method untuk menghapus data
    public void delete(){
        if(!form.getTxtkdplg().getText().trim().isEmpty()){
            int kode = Integer.parseInt(form.getTxtkdplg().getText());
            model.delete(kode);
        }else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");        }
    }
    
    //method ini akan dipakai untuk memfilter data berdasarkan inputan yg ada pada text kode pelanggan
    public void isiTableCari(){
        list = model.getCari(form.getTxtkdplg().getText().trim());
        DefaultTableModel tblModel =  new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for (Pelanggan p : list){
            data[0] = p.getKode();
            data[1] = p.getNama();
            data[2] = p.getAlamat();
            data[3] = p.getTelp();
            tblModel.addRow(data);
        }
        form.getTblplg().setModel(tblModel);
    }
    
}

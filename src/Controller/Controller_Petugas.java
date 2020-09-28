/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Petugas;
import DAO.Model_DAO;
import Model.Petugas;
import View.MPetugas;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOLIO 1040 G3
 */
public class Controller_Petugas {
    MPetugas form;
    Model_DAO<Petugas> model;
    List<Petugas> list; //deklarasi method "list" yang sudah dibuat pada interface MODEL_DAO
    String[] header; //deklarasi variable untuk membuat judul kolom pada object JTable
    
    public Controller_Petugas(MPetugas form){
        this.form = form;
        model = new DAO_Petugas();
        list = model.getAll();
        header = new String[]{"KODE PETUGAS", "NAMA", "ALAMAT", "TELEPON"};
        
       form.getTblpetugas().setShowGrid(true);
       form.getTblpetugas().setShowVerticalLines(true);
       form.getTblpetugas().setGridColor(Color.blue);
    }
    
    //method untuk menampilkan kode petugas berikutnya
    public void tampilUrutanKode(){
        Petugas p = new Petugas();
        model.autonumber(p);
        form.getTxtkdpetugas().setText(String.valueOf(model.autonumber(p)));
    }
    
    //method untuk membersihkan object inputan yang ada form
    public void reset(){
        form.getTxtkdpetugas().setText("");
        form.getTxtnmpetugas().setText("");
        form.getTxtalamat().setText("");
        form.getTxttelp().setText("");
        form.getTxttelp().requestFocus();
        tampilUrutanKode();
        isiTable();
    }

    //method untuk menampilkan semua data kedalam JTable
    public void isiTable() {
        list = model.getAll();
        
        //script agar JTable tidak bisa diedit
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header){
            public boolean isiCellEditTable(int rowIndex, int columnIndex){
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (Petugas P : list) {
            data[0] = P.getKode();
            data[1] = P.getNama();
            data[2] = P.getAlamat();
            data[3] = P.getTelepon();
            tblModel.addRow(data);
        }
        form.getTblpetugas().setModel(tblModel);
    }
    
    
    //method untuk meletakan data ke dalam text berdasarkan data yang dipilih dari JTable
    public void isiField(int row){
        form.getTxtkdpetugas().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtnmpetugas().setText(list.get(row).getNama());
        form.getTxtalamat().setText(list.get(row).getAlamat());
        form.getTxttelp().setText(list.get(row).getAlamat());
    }
    
    //method untuk simpan data
   public void insert(){
       Petugas p = new Petugas();
       p.setKode(Integer.parseInt(form.getTxtkdpetugas().getText()));
       p.setNama(form.getTxtnmpetugas().getText());
       p.setAlamat(form.getTxtalamat().getText());
       p.setTelepon(form.getTxttelp().getText());
       model.insert(p);
   }
   
   //method untuk mengubah data
   public void update(){
       Petugas p = new Petugas();
       p.setKode(Integer.parseInt(form.getTxtkdpetugas().getText()));
       p.setNama(form.getTxtnmpetugas().getText());
       p.setAlamat(form.getTxtnmpetugas().getText());
       p.setTelepon(form.getTxttelp().getText());
       model.update(p);
   }
   
   //method untuk meghapus data
   public void delete(){
        if(!form.getTxtkdpetugas().getText().trim().isEmpty()){
            int id = Integer.parseInt(form.getTxtkdpetugas().getText());
            model.delete(id);
        }else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");
        }
   }
    
   //method ini akan dipakai untuk memfilter data berdasarkan inputan yang ada pada txtkatakunci pencarian petugas
   public void isiTableCari(){
       list = model.getCari(form.getTxtkatakunci().getText().trim());
       DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
       Object[] data = new Object[header.length];
       for(Petugas p : list){
            data[0] = p.getKode();
            data[1] = p.getNama();
            data[2] = p.getAlamat();
            data[3] = p.getTelepon();
            tblModel.addRow(data);
        }
        form.getTblpetugas().setModel(tblModel);
   }
   
}

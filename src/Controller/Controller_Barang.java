/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO_Barang;
import Model.Barang;
import View.MBarang;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FOLIO 1040 G3
 */
public class Controller_Barang {
    MBarang form;
    DAO_Barang model;
    List<Barang> list; //deklarasi method "List" yang sudah dibuat pada interface MODEL_DAO
    String[] header; //deklarasi variable untuk membuat judul kolom pada object JTabel
    
    //konstruktor
    public Controller_Barang(MBarang form){
        this.form = form;
        model = new DAO_Barang();
        list = model.getAll();
        header = new String[]{"KODE BARANG", "NAMA BARANG", "SATUAN", "HARGA", "STOK","KODE KATEGORI", "NAMA KATEGORI"};
        
        form.getTblbarang().setShowGrid(true);
        form.getTblbarang().setShowVerticalLines(true);
        form.getTblbarang().setGridColor(Color.blue);    
    }
    
    //method ini akan dipakai untuk mengisi data kedalam combo kode kategori
    public void isicombokategori(){
        form.getCmbkategori().removeAllItems();
        form.getCmbkategori().addItem("-Pilih-");
        for(Barang B : model.IsiCombo()){
            form.getCmbkategori().addItem(Integer.toString(B.getKodekategori()));
        }
    }
    
    //method untuk menampilkan urutan kode barang berikutnya
    public void tampilUrutanKode(){
        if(form.getCmbkategori().getSelectedIndex() > 0){
            form.getTxtkdbarang().setText(String.valueOf(model.autonumber2(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()))));
        }
    }
    
    //method untuk menampikan semua data kedalam JTable
    public void isiTable(){
        list = model.getAll();
        //Script agar JTable tidak bisa diedit
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header){
            public boolean isiCellEditTable(int rowIndex, int columnIndex){
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for (Barang B : list ) {
            data[0] = B.getKodebarang();
            data[1] = B.getNamabarang();
            data[2] = B.getSatuan();
            data[3] = B.getHarga();
            data[4] = B.getStok();
            data[5] = B.getKodekategori();
            data[6] = B.getNamakategori();
            tblModel.addRow(data);
        }
    
        form.getTblbarang().setModel(tblModel);
    }
    
    //method untuk membersihkan object inputan yang ada pada form
    public void reset(){
        form.getCmbkategori().setSelectedIndex(0);
        form.getTxtnmkategori().setText("");
        form.getTxtkdbarang().setText("");
        form.getTxtnmbarang().setText("");
        form.getCmbsatuan().setSelectedIndex(0);
        form.getTxtharga().setText("");
        form.getTxtstok().setText("");
        form.getTxtkatakunci().setText("");
        form.getTxtnmbarang().requestFocus();
        form.getTxtnmkategori().setEditable(false);
        form.getTxtkdbarang().setEditable(false);
        isicombokategori();
        tampilUrutanKode();
        isiTable();
    }
    
    //method untuk meletakan data kedalam text berdasarkan data yang dipilih dari JTable
    public void isiField(int row){
        form.getCmbkategori().setSelectedItem(list.get(row).getKodekategori());
        form.getTxtnmkategori().setText(list.get(row).getNamakategori());
        form.getTxtkdbarang().setText(list.get(row).getKodebarang());
        form.getTxtnmbarang().setText(list.get(row).getNamabarang());
        form.getCmbsatuan().setSelectedItem(list.get(row).getSatuan());
        form.getTxtharga().setText(String.valueOf(list.get(row).getHarga()));
        form.getTxtstok().setText(String.valueOf(list.get(row).getStok()));
    }
    
    //method untuk simpan data ke database
    public void insert(){
        Barang B = new Barang();
        B.setKodebarang(form.getTxtkdbarang().getText());
        B.setNamabarang(form.getTxtnmbarang().getText());
        B.setSatuan(form.getCmbsatuan().getSelectedItem().toString());
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
        B.setStok(Integer.parseInt(form.getTxtstok().getText()));
        B.setKodekategori(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()));
        model.insert(B);
    }
    
    //method untuk mengubha data
    public void update(){
        Barang B = new Barang();
        B.setNamabarang(form.getTxtnmbarang().getText());
        B.setSatuan(form.getCmbsatuan().getSelectedItem().toString());
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
        B.setStok(Integer.parseInt(form.getTxtstok().getText()));
        B.setKodekategori(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()));
        B.setKodebarang(form.getTxtkdbarang().getText());
        model.update(B);
    }
    
    //method untuk menghapus data
    public void delete(){
        if(!form.getTxtkdbarang().getText().trim().isEmpty()){
            String id = (form.getTxtkdbarang().getText());
            model.delete(id);
        } else {
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus!");
        }
    }
    
    //method ini akan dipakai untuk memfilter data berdasarkan inputan yang ada pada text kata kunci
    public void isiTableCari(){
        list = model.getCari(form.getTxtkatakunci().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        
        for (Barang B : list) {
            data[0] = B.getKodebarang();
            data[1] = B.getNamabarang();
            data[2] = B.getSatuan();
            data[3] = B.getHarga();
            data[4] = B.getStok();
            data[5] = B.getKodekategori();
            data[6] = B.getNamakategori();
            tblModel.addRow(data); //menampilkan ke JTable
        }
        form.getTblbarang().setModel(tblModel);
    }
}

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
            form.getCmbkategori().addItem(B);
        }
    }
    
    //method untuk menampilkan urutan kode barang berikutnya
    public void tampiUrutanKode(){
        if(form.getCmbkategori().getSelectedIndex() > 0){
            form.getTxtkdbarang().setText(String.valueOf(model.autonumber2(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()))));
        }
    }
}

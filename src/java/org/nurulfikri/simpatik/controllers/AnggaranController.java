/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.nurulfikri.simpatik.models.KategoriBelanja;
import org.nurulfikri.simpatik.models.MataAnggaran;

/**
 *
 * @author rojul
 */
@ManagedBean(name="anggaran")
@SessionScoped
public class AnggaranController implements Serializable{

    private MataAnggaran mataAnggaran;
    private List<KategoriBelanja> listKategori;
    
    public AnggaranController() {
        // inisialisasi property bean
        this.mataAnggaran = new MataAnggaran();
        
        listKategori = new ArrayList<>();
        // inisialisasi data kategori belanja
        KategoriBelanja kb1 = new KategoriBelanja();
        kb1.setId(1);
        kb1.setNama("Operasional");
        
        KategoriBelanja kb2 = new KategoriBelanja();
        kb2.setId(2);
        kb2.setNama("Pegawai");
        
        KategoriBelanja kb3 = new KategoriBelanja();
        kb3.setId(3);
        kb3.setNama("Gedung");
        // masukan kedalam list
        listKategori.add(kb1);
        listKategori.add(kb2);
        listKategori.add(kb3);
    }

    public MataAnggaran getMataAnggaran() {
        return mataAnggaran;
    }

    public void setMataAnggaran(MataAnggaran mataAnggaran) {
        this.mataAnggaran = mataAnggaran;
    }
    
    public String simpan(){
        return "view";
    }

    public List<KategoriBelanja> getListKategori() {
        return listKategori;
    }

    public void setListKategori(List<KategoriBelanja> listKategori) {
        this.listKategori = listKategori;
    }
    
    
    
}

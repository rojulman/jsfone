/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.controllers;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.nurulfikri.simpatik.MyBatisConnectionFactory;
import org.nurulfikri.simpatik.dao.MataAnggaranDAO;
import org.nurulfikri.simpatik.dao.PropinsiDAO;
import org.nurulfikri.simpatik.models.KategoriBelanja;
import org.nurulfikri.simpatik.models.MataAnggaran;
import org.nurulfikri.simpatik.models.Propinsi;

/**
 *
 * @author rojul
 */
@ManagedBean(name="manggaran")
@SessionScoped
public class MAnggaranController implements Serializable{
    private MataAnggaranDAO mataAnggaranDAO = null;
    private MataAnggaran mataAnggaran;

    public MAnggaranController() {
        mataAnggaranDAO = new MataAnggaranDAO(
                MyBatisConnectionFactory.getSqlSessionFactory());
        mataAnggaran = new MataAnggaran();
    }

    public MataAnggaran getMataAnggaran() {
        return mataAnggaran;
    }

    public void setMataAnggaran(MataAnggaran mataAnggaran) {
        this.mataAnggaran = mataAnggaran;
    }

    
    public List<MataAnggaran> findAll() {
        return mataAnggaranDAO.getAll();
    }
    
    public List<KategoriBelanja> getAllKategori(){
        return mataAnggaranDAO.getAllKategori();
    }
    
    
    public String simpan(){
        if(this.mataAnggaran.getId() > 0){
            this.mataAnggaran=mataAnggaranDAO.update(mataAnggaran);
        }else{
            this.mataAnggaran = mataAnggaranDAO.save(this.mataAnggaran);
        }
        return "index";
    }
    
    public String editMataAnggaran(MataAnggaran mata){
        this.mataAnggaran = mata;
        return "form";
    }
    
    public String addMataAnggaran(){
        this.mataAnggaran = mataAnggaranDAO.createNew();
        return "form";
    }
    
    public String deleteMataAnggaran(int id){
        mataAnggaranDAO.delete(id);
        return "index";
    }
    
}

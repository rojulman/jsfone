/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.nurulfikri.simpatik.MyBatisConnectionFactory;
import org.nurulfikri.simpatik.dao.MataAnggaranDAO;
import org.nurulfikri.simpatik.models.MataAnggaran;

/**
 *
 * @author rojul
 */
@ManagedBean
@SessionScoped
public class GrafikBean {
    private List<MataAnggaran> list;
    private MataAnggaranDAO mataAnggaranDAO;
    private String tipeGrafik="column";
    private List<String> pilihanGrafik = new ArrayList<String>();

    public GrafikBean() {
        mataAnggaranDAO = new MataAnggaranDAO(
                MyBatisConnectionFactory.getSqlSessionFactory());
        list = mataAnggaranDAO.getAll();
        pilihanGrafik.add("pie");
        pilihanGrafik.add("bar");
        pilihanGrafik.add("line");
        pilihanGrafik.add("column");
    }

    public List<MataAnggaran> getList() {
        return list;
    }

    public void setList(List<MataAnggaran> list) {
        this.list = list;
    }

    public String getTipeGrafik() {
        return tipeGrafik;
    }

    public void setTipeGrafik(String tipeGrafik) {
        this.tipeGrafik = tipeGrafik;
    }

    public List<String> getPilihanGrafik() {
        return pilihanGrafik;
    }

    public void setPilihanGrafik(List<String> pilihanGrafik) {
        this.pilihanGrafik = pilihanGrafik;
    }
    
    public void redraw(){
        
    }
    
    
}

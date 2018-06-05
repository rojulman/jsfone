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
    private MataAnggaran mAnggaran;

    public MAnggaranController() {
        mataAnggaranDAO = new MataAnggaranDAO(
                MyBatisConnectionFactory.getSqlSessionFactory());
        mAnggaran = new MataAnggaran();
    }

    public MataAnggaran getmAnggaran() {
        return mAnggaran;
    }

    public void setmAnggaran(MataAnggaran mAnggaran) {
        this.mAnggaran = mAnggaran;
    }
    
    public List<MataAnggaran> findAll() {
        return mataAnggaranDAO.getAll();
    }
    
}

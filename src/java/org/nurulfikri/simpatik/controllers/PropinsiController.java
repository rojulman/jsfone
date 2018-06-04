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
import org.nurulfikri.simpatik.dao.PropinsiDAO;
import org.nurulfikri.simpatik.models.Propinsi;

/**
 *
 * @author rojul
 */
@ManagedBean
@SessionScoped
public class PropinsiController implements Serializable{

    private PropinsiDAO propinsiDAO = null;
    private Propinsi propinsi;

    public PropinsiController() {
        propinsiDAO = new PropinsiDAO(
                MyBatisConnectionFactory.getSqlSessionFactory());
        propinsi = new Propinsi();
    }
    
    public List<Propinsi> findAll(){
        return propinsiDAO.getAll();
    }

    public Propinsi getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(Propinsi propinsi) {
        this.propinsi = propinsi;
    }
    
     
}





/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.nurulfikri.simpatik.models.Propinsi;

/**
 *
 * @author rojul
 */
public class PropinsiDAO implements IDAO <Propinsi>{

    // dua class untuk eksekusi sql pada mapper
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session = null;

    public PropinsiDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Propinsi> getAll() {
        List<Propinsi> list = null;
        session = sqlSessionFactory.openSession();
        try{
            list = session.selectList("PropinsiMapper.selectPropinsi");
        }finally{
            session.close();
        }
        return list;
    }

    @Override
    public Propinsi findByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Propinsi save(Propinsi obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Propinsi update(Propinsi obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

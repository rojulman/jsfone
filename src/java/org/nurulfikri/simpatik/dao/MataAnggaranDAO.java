/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nurulfikri.simpatik.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.nurulfikri.simpatik.models.MataAnggaran;
import org.nurulfikri.simpatik.models.Propinsi;

/**
 *
 * @author rojul
 */
public class MataAnggaranDAO implements IDAO<MataAnggaran> {

    // dua class untuk eksekusi sql pada mapper
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session = null;

    public MataAnggaranDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<MataAnggaran> getAll() {
        List<MataAnggaran> list = null;
        session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("MataAnggaranMapper.selectAll");
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public MataAnggaran findByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MataAnggaran save(MataAnggaran obj) {
        session = sqlSessionFactory.openSession();
        session.insert("MataAnggaranMapper.insertMataAnggaran", obj);
        session.commit();
        session.close();
        return obj;
    }

    @Override
    public MataAnggaran update(MataAnggaran obj) {
        session = sqlSessionFactory.openSession();
        session.update("MataAnggaranMapper.updateMataAnggaran", obj);
        session.commit();
        session.close();
        return obj;
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

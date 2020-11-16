/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.daoImpl;


import com.mycompany.server.dao.DaoPerson;
import com.mycompany.server.dto.DtoPerson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class DaoImplPerson implements DaoPerson{
    
    List<DtoPerson> personDB = new ArrayList();

    @Override
    public void create(DtoPerson entity) {
        personDB.add(entity);
    }

    @Override
    public void modify(DtoPerson entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoPerson entity) {
        personDB.remove(entity);
    }

    @Override
    public DtoPerson findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoPerson> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

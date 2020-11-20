/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.serviceImpl;

import com.mycompany.commons.entities.Person;
import com.mycompany.server.dao.ApplicationContext;
import com.mycompany.server.dao.DaoEnum;
import com.mycompany.server.dao.DaoPerson;
import com.mycompany.server.dto.DtoPerson;
import com.mycompany.server.service.ServicePerson;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class ServiceImplPerson implements ServicePerson {
    

    private DaoPerson dao = (DaoPerson) ApplicationContext.getDao(DaoEnum.DAO_PERSON);
    private List<Person> personList = new ArrayList<>();
    
    
    @Override
    public void create(Person entity) {
        
        DtoPerson dtoPerson = new DtoPerson(entity.getName(),entity.getLastName());
        dao.create(dtoPerson);
        
    }

    @Override
    public void modify(Person entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Person entity) {
        
        DtoPerson dtoPerson = new DtoPerson(entity.getName(),entity.getLastName());
        dao.delete(dtoPerson);
        
    }

    @Override
    public Person findById(Long id) {
        
        DtoPerson dtoPerson = dao.findById(id);
        Person person = new Person(dtoPerson.getName(), dtoPerson.getLastName());
        person.setId(dtoPerson.getId());
        return person;
        
    }

    @Override
    public List<Person> findAll() {
        
        for(DtoPerson p: dao.findAll()){
            Person person = new Person(p.getName(), p.getLastName());
            person.setId(p.getId());
            this.personList.add(person);
        }
        return this.personList;
        
    }
    
}

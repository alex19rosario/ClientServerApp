/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server.dao;

import com.mycompany.server.daoImpl.DaoImplPerson;

/**
 *
 * @author alex_rosario
 */
public class ApplicationContext {
    
    public static GenericDao getDao(DaoEnum dao){
        
        switch(dao){
            case DAO_PERSON:
                return new DaoImplPerson();
                
            default:
                return null;
        }
    }
    
}

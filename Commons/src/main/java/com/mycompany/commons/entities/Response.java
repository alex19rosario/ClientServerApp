/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commons.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class Response<Ob> implements Serializable{
    
    private Object object;
    private List<Ob> objectList;
    private String type;
    
    public Response(Object object, String type){
        this.object = object;
        this.type = type;
    }
    
    public Response(List<Ob> objectList, String type){
        this.objectList = objectList;
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public List<Ob> getObjectList() {
        return objectList;
    }

    public String getType() {
        return type;
    }
    
    
    
}

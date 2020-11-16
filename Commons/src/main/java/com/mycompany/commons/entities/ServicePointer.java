/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.commons.entities;

import java.io.Serializable;

/**
 *
 * @author alex_rosario
 */
public class ServicePointer <O> implements Serializable{
    
    private String service;
    private String method;
    private O object;

    public ServicePointer(String service, String method, O object) {
        this.service = service;
        this.method = method;
        this.object = object;
    }

    public String getService() {
        return service;
    }

    public O getObject() {
        return object;
    }

    public String getMethod() {
        return method;
    }
  
    
}

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
public class Person implements Serializable{
    
    private long id;
    private String name;
    private String lastName;


    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
    
}

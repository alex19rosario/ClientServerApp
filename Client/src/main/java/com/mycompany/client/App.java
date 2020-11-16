package com.mycompany.client;

import com.mycompany.clientservices.Service;
import com.mycompany.commons.entities.Person;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Person person = new Person("Carlos","Rosario");
        Service.create(person, "servicePerson", "create");
        Service.delete(person, "servicePerson", "delete");
       
    }
}

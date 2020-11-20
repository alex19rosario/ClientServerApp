package com.mycompany.client;

import com.mycompany.clientservices.Service;
import com.mycompany.commons.entities.Person;


public class App 
{
    public static void main( String[] args )
    {
        
        Service service = new Service();
        service.start();
        Person person = new Person("Carlos","Rosario");
        person.setId(0L);
        Service.send(person, "servicePerson", "create");
        
        Person person2 = service.getPerson(0L, "servicePerson", "findById");
        System.out.println(person2.getId()+" "+person2.getName()+" "+person2.getLastName());
        
       
    }
}

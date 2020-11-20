package com.mycompany.client;

import com.mycompany.clientservices.Service;
import com.mycompany.commons.entities.Person;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        
        Service service = new Service();
        service.start();
        Person person = new Person("Carlos","Rosario");
        person.setId(0L);
        Person person2 = new Person("Adriel","Sanchez");
        person2.setId(1L);
        System.out.println(person2.getId());
        
        Service.send(person, "servicePerson", "create");
        Service.send(person2, "servicePerson", "create");
        
        
        Person person3 = (Person) service.getObject(1L, "servicePerson", "findById");
        System.out.println(person3.getId()+" "+person3.getName()+" "+person3.getLastName());
        
        List<Person> personList = service.getObjectList("servicePerson", "findAll");
        for(Person p: personList){
            System.out.println(p.getId()+" "+p.getName()+" "+p.getLastName());
        }
       
    }
}

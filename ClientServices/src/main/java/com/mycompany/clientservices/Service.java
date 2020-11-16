/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientservices;


import com.mycompany.commons.entities.ServicePointer;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author alex_rosario
 */
public class Service {
    
    public static<O> void create(O object, String service, String method){
        
        ServicePointer<O> servicePointer = new ServicePointer<>(service, method, object);
        
        try {
            
            Socket socket = new Socket("10.0.0.6" , 55556);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(servicePointer);
            out.close();
            socket.close();
            System.out.println("The object was sent");
                
        }
        catch (Exception ex) {
            System.out.println("The object was not sent");
        }
        
    }
    
    public static<O> void delete(O object, String service, String method){
        
        ServicePointer<O> servicePointer = new ServicePointer<>(service, method, object);
        try {
            
            Socket socket = new Socket("10.0.0.6" , 55556);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(servicePointer);
            out.close();
            socket.close();
            System.out.println("The object was sent");
                
        }
        catch (Exception ex) {
            System.out.println("The object was not sent");
        }
        
    }
    
}

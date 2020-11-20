/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientservices;


import com.mycompany.commons.entities.Person;
import com.mycompany.commons.entities.ServicePointer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_rosario
 */
public class Service extends Thread{
    
    Person person = null;
    
    public void run(){
        
        try{
            System.out.println("The client is runnig");
            ServerSocket server = new ServerSocket(55557);
            while(true){
                System.out.println("The client is runnig");
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                this.person = (Person) in.readObject();
                in.close();
                socket.close();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static<O> void send(O object, String service, String method){
        
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
    
    public Person getPerson(Long id, String service, String method){
        
        InetAddress inetAddress = null;
        
        try{
            inetAddress = InetAddress. getLocalHost();
        }
        catch(Exception e){
            
        }
        ServicePointer servicePointer = new ServicePointer(service, method, id, inetAddress.getHostAddress());
        
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
        
        //THIST PART IS JUST TO GIVE A LITTLE BIT OF TIME TO THE SERVER TO SEND THE OBJECT
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.person;
    }
    

    
}

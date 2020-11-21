/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import com.mycompany.commons.entities.Person;
import com.mycompany.commons.entities.Response;
import com.mycompany.commons.entities.ServicePointer;
import com.mycompany.server.serviceImpl.ServiceImplPerson;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_rosario
 */
public class Server extends Thread {
    
    public void run(){
        
        ServiceImplPerson servicePerson = new ServiceImplPerson();
        
        
        
        try {
            System.out.println("The server is running");
            ServerSocket server = new ServerSocket(55555);
            while(true){
                
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                
                ServicePointer servicePointer = (ServicePointer) in.readObject();
                Person person = (Person) servicePointer.getObject();
                //System.out.println(person.getId());
                
                switch(servicePointer.getService()){
                    
                    case "servicePerson":
                        if(servicePointer.getMethod().equalsIgnoreCase("create")){
                            servicePerson.create((Person) servicePointer.getObject());
                            System.out.println("The service was consumed succesfully");
                        }
                        else if(servicePointer.getMethod().equalsIgnoreCase("delete")){
                            servicePerson.delete((Person) servicePointer.getObject());
                            System.out.println("The service was consumed succesfully");
                        }
                        else if(servicePointer.getMethod().equalsIgnoreCase("findById")){
                            try {
            
                                Socket socketForClient = new Socket(servicePointer.getIp(), 55557);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(servicePerson.findById(servicePointer.getId()), "object");
                                //Person person = (Person) response.getObject();
                                //System.out.println(person.getId());
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                                System.out.println("The service was consumed succesfully");
                                System.out.println("The object was sent");

                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        else if(servicePointer.getMethod().equalsIgnoreCase("findAll")){
                            try {
            
                                Socket socketForClient = new Socket(servicePointer.getIp(), 55557);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(servicePerson.findAll(), "list");
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                                System.out.println("The service was consumed succesfully");
                                System.out.println("The object was sent");

                            }
                            catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;
                    
                    default:
                        System.out.println(servicePointer.getService()+": this service does not exist");
                }
                
                in.close();
                socket.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

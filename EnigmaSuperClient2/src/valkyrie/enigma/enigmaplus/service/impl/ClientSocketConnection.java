/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.service.impl;

import java.io.IOException;
import java.net.URI;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author heshanjayasinghe
 */


public class ClientSocketConnection {
    
    public Session session;
   
    public void start()
    { 
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
 
        String uri = "ws:/localhost:8080/WebApplication1/endpoint";//184.73.170.96:9081 == localhost:8080
        System.out.println("Connecting to " + uri);
        try {
            session = container.connectToServer(CrismasClientSocket.class, URI.create(uri));
            System.out.println("ok1");
        } catch (DeploymentException e) {
            //e.printStackTrace();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
//    public void mainMethod(String Msg, String uhash){        
//        
//    }
    public static void main(String[] args) {
        ClientSocketConnection client = new ClientSocketConnection();
        System.out.println("ok2");
        client.start(); 
        try {
            System.out.println("ok3");
            System.out.println(client.session);
            client.session.getBasicRemote().sendText("hey");
 
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
    
}

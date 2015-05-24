/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.service.impl;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
/**
 *
 * @author heshanjayasinghe
 */

public class CrismasClientSocket {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());        
    } 
    @OnMessage
    public void onMessage(String message) {
        System.out.println(message);
    } 
    @OnError
    public void onError(Throwable t) {
        //t.printStackTrace();
        
    }
}

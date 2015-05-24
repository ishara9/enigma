/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.rest;

/**
 *
 * @author heshanjayasinghe
 */
@javax.websocket.server.ServerEndpoint("/endpoint")
public class websocket {

    @javax.websocket.OnMessage
    public String onMessage(String message) {
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifs.valkyrie.enigmapuls.rest;

//import java.io.IOException;
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
///**
// *
// * @author heshanjayasinghe
// */
//
//@ServerEndpoint("/crismasendpoint")
//public class CrismasWSEndpoint {
//
//    @OnOpen
//    public void onOpen(Session session){
//        try {
//            session.getBasicRemote().sendText("Connection Established");
//        } catch (IOException ex) {
//            //ex.printStackTrace();
//        }
//    } 
//    @OnMessage
//    public void onMessage(String message, Session session){
//        System.out.println("Message from " + session.getId() + ": " + message);        
//        try {
//            for (Session sess : session.getOpenSessions()) {
//                if (sess.isOpen()){      
//                    sess.getBasicRemote().sendText(message);                        
//                }
//            }
//        } catch (IOException ex) {
//            //ex.printStackTrace();
//        }
//    } 
//    @OnClose
//    public void onClose(Session session){
//        //System.out.println("Session " +session.getId()+" has ended");
//        try {
//            
//            session.getBasicRemote().sendText("Connection is not established");
//        } catch (IOException ex) {
//            //ex.printStackTrace();
//        }
//    }
//    
//}

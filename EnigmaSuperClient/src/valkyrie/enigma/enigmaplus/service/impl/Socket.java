/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.service.impl;



import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import valkyrie.enigma.enigmaplus.model.User;
import valkyrie.enigma.enigmaplus.service.controller.ResourceHandler;


/**
 *
 * @author heshanjayasinghe
 */
public class Socket {
    
    public static void main(String[] args) {
        try {
          Timer tim;
            tim = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                     String excutePost = ResourceHandler.excutePost("http://localhost:8080/EnigmaRESTfulWebservice/user/logintest?username="+"kasun"+"&password="+"123","");
      //  String excutePost = ResourceHandler.excutePost("http://localhost:8080/EnigmaRESTfulWebservice/user/logintest?username=" + username + "&password=" + password + "", "");

        User u = null;
        System.out.println(excutePost);
        ObjectMapper mapper = new ObjectMapper();
        try {
            u = mapper.readValue(excutePost, User.class);
            if (u != null) {
                System.out.println(u.getFname());
                
            } else {
                //JOptionPane.showMessageDialog(this, "No customer found " + email);
            }
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            });
            tim.start();
            //   }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

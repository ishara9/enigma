/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package valkyrie.enigma.enigmaplus.service.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import valkyrie.enigma.enigmaplus.model.User;
import valkyrie.enigma.enigmaplus.service.UserService;
import valkyrie.enigma.enigmaplus.service.controller.ResourceHandler;

/**
 *
 * @author heshanjayasinghe
 */
public class UserServiceImpl implements UserService{

    @Override
    public User LoginUser(String username, String password) throws ClassNotFoundException {
        

 
    String excutePost = ResourceHandler.excutePost("http://localhost:8080/EnigmaRESTfulWebservice/user/logintest?username="+username+"&password="+password,"");
      //  String excutePost = ResourceHandler.excutePost("http://localhost:8080/EnigmaRESTfulWebservice/user/logintest?username=" + username + "&password=" + password + "", "");

        User u = null;
        System.out.println(excutePost);
        ObjectMapper mapper = new ObjectMapper();
        try {
            u = mapper.readValue(excutePost, User.class);
            if (u != null) {
                return u;
                
            } else {
                //JOptionPane.showMessageDialog(this, "No customer found " + email);
            }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
    
    
    
}

package ifs.valkyrie.enigmapuls.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import ifs.valkyrie.enigmapuls.model.User;
import ifs.valkyrie.enigmapuls.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.QueryParam;
import org.openrdf.OpenRDFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Path("/user")
public class UserREST {
    
    @Autowired
    private UserService userservice;
    
   

    @GET
    @Path("/print")
    public String printMessage() {
        return "ok";

    }

   

    @GET
    @Path("/login")
    public String getUsers(
            @QueryParam("username") String username,
            @QueryParam("password") String password) {
        String name = null;
        try {
            User user = userservice.LoginUser(username, password);
            name=user.getFname();
        }catch(NullPointerException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (OpenRDFException ex) {
           ex.printStackTrace();
        }
        return name;


    }
}

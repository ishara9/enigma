package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.mkyong.context.SpringApplicationContext;
import com.mkyong.context.car;
import com.mkyong.customer.CustomerBo;
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
    
    CustomerBo customerBo;

    @GET
    @Path("/print")
    public Response printMessage() {

        customerBo = (CustomerBo) SpringApplicationContext.getBean("customerBo");

        String result = customerBo.getMsg();

        return Response.status(200).entity(result).build();

    }

    @GET
    @Path("/printe")
    public Response printMessagee() {

        customerBo = (CustomerBo) SpringApplicationContext.getBean("customerBo");

        String result = customerBo.getMsg();
        car c = new car(10, "audi");
        return Response.status(200).entity(result).build();

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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserREST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OpenRDFException ex) {
            Logger.getLogger(UserREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
//		return Response
//		   .status(200)
//		   .entity("getUsers is called, from : " + from + ", to : " + to
//			+ ", orderBy" ).build();

    }
}

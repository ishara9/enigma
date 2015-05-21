/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mkyong.rest;

import com.mkyong.context.SpringApplicationContext;
import com.mkyong.context.car;
import com.mkyong.customer.CustomerBo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author heshanjayasinghe
 */



@Path("/userr")
public class userrestt {

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
	@Path("/query")
	public Response getUsers(
		@QueryParam("from") int from,
		@QueryParam("to") int to) {
 
		return Response
		   .status(200)
		   .entity("getUsers is called, from : " + from + ", to : " + to
			+ ", orderBy" ).build();
 
	}  
}

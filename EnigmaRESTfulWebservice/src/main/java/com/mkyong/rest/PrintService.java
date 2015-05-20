package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import com.mkyong.context.SpringApplicationContext;
import com.mkyong.context.car;
import com.mkyong.customer.CustomerBo;

@Path("/customer")
public class PrintService {

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
car c=new car(10,"audi");
		return Response.status(200).entity(result).build();

	}
        
      //  @GET


}
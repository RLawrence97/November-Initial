package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.REST;
import com.qa.domain.Account;

@Path("/db")
public class App {
	@Inject
	private REST restManager;
	
	@GET
	@Path("/all")
	@Produces({ "application/json" })
	public String getAll() {
		return restManager.getAll();
	}
	
	@GET
	@Path("/user/{id}")
	@Produces({ "application/json" })
	public String getbyID(@PathParam("id") int incomingID) {
		return restManager.getbyID(incomingID);
	}
	
	@DELETE
	@Path("/remove/{remove}")
	@Produces({ "application/json" })
	public String delete(@PathParam("remove") int incomingID) {
		return restManager.delete(incomingID);
	}
	
	@POST
	@Path("/update")
	@Produces({"application/json"})
	public String update(Account incoming) {
		return restManager.updateByAccount(incoming);
	}
	
	@POST
	@Path("/add")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public String addAccount(Account c) {
		return restManager.addAccount(c);
	}
}

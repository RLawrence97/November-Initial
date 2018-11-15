package com.qa.business;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.domain.Account;
import com.qa.persistence.respository.AccountRepository;
import com.qa.utils.util;

@Path("/")
public class App {
	@Inject
	private AccountRepository repoManager;
	
	@GET
	@Path("{all}")
	@Produces({ "application/json" })
	public String getAll() {
		StringBuilder sb = new StringBuilder();
		List<Account> all = repoManager.findAllAccount();
		sb.append("{");
		for (Account a: all) {
			try {
				sb.append(util.convertObjectToJSON(a) + ", ");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				sb.append("{\"attempt\" : \"failed\"}");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	
	@GET
	@Path("{id}")
	@Produces({ "application/json" })
	public String getbyID(@PathParam("id") int incomingID) {
		try {
			return util.convertObjectToJSON(repoManager.findAccountByID(incomingID));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@DELETE
	@Path("{remove}")
	@Produces({ "application/json" })
	public String delete(@PathParam("id") int incomingID) {
		return "{\" deleted account\" : \"" +repoManager.removeAccount(incomingID) + "\"}";
	}
	
	@POST
	@Path("{add}")
	@Produces({ "application/json" })
	public String addAccount(@PathParam("fN") String incomingFN, @PathParam("lN") String incomingLN, @PathParam("accNo") String incomingAN) {
		try {
			return util.convertObjectToJSON(repoManager.addAccount(new Account(incomingFN, incomingLN, incomingAN)));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

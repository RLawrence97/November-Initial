package com.qa.business;

import java.util.List;

import javax.inject.Inject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.domain.Account;
import com.qa.persistence.respository.AccountRepository;
import com.qa.utils.util;

public class REST {
	@Inject
	private AccountRepository repoManager;

	public String getAll() {
		StringBuilder sb = new StringBuilder();
		List<Account> all = repoManager.findAllAccount();
		sb.append("{ ");
		for (Account a: all) {
			try {
				sb.append(util.convertObjectToJSON(a) + ", ");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
				sb.append("{\"attempt\" : \"failed\"}");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
	
	public String getbyID(int incomingID) {
		try {
			return util.convertObjectToJSON(repoManager.findAccountByID(incomingID));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String updateByAccount(Account incoming) {
		Account a = repoManager.findAccountByID(incoming.getAccountid());
		a.updateAll(incoming);
		try {
			return util.convertObjectToJSON(repoManager.updateAccount(a));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public String delete(int incomingID) {
		return "{\" deleted account\" : \"" +repoManager.removeAccount(incomingID) + "\"}";
	}

	public String addAccount(Account incoming) {
		try {
			return util.convertObjectToJSON(repoManager.addAccount(incoming));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}

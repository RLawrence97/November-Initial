package com.qa.utils;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.domain.Account;

public class util {
	public static String convertObjectToJSON(Account incomingAccount) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(incomingAccount);
	}
	
	public static Account convertJSONtoObject(String incomingJSONString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(incomingJSONString, Account.class);
	}
}

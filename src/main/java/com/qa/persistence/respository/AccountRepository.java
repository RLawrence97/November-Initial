package com.qa.persistence.respository;

import java.util.List;

import com.qa.domain.Account;

public interface AccountRepository {
	public Account addAccount(Account incomingAccount);
	public int removeAccount(int accountID);
	public Account updateAccount(Account incomingAccount);
	public Account findAccountByID(int accountID);
	public List<Account> findAllAccount();
}

package com.qa.persistence.respository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.enterprise.inject.Alternative;

import com.qa.domain.Account;

@Alternative
public class AccountMapRepository implements AccountRepository{
	
	private Map<Integer, Account> dbStandIn = new HashMap<Integer, Account>();

	@Override
	public Account addAccount(Account incomingAccount) {
		dbStandIn.put(incomingAccount.getAccountid(), incomingAccount);
		return incomingAccount;
	}

	@Override
	public int removeAccount(int accountID) {
		dbStandIn.remove(accountID);
		return accountID;
	}

	@Override
	public Account updateAccount(Account incomingAccount) {
		dbStandIn.put(incomingAccount.getAccountid(), incomingAccount);
		return incomingAccount;
	}

	@Override
	public Account findAccountByID(int accountID) {
		Set<Entry<Integer, Account>> set = dbStandIn.entrySet();
		Iterator<Entry<Integer, Account>> iterator = set.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Account> mentry = iterator.next();
			if (mentry.getKey() == accountID) {
				return mentry.getValue();
			}
		}
		return null;
	}

	@Override
	public List<Account> findAllAccount() {
		ArrayList<Account> temp = new ArrayList<Account>(dbStandIn.values());
		return temp;
	}

}

package com.qa.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.domain.Account;

public class H2 {
	@PersistenceContext
	EntityManager em;

	public void addAccount(Account incomingAccount) {
		em.persist(incomingAccount);
	}

	public void removeAccount(int accountID) {
		try {
			Account toBeDeleted = em.find(Account.class, accountID);
			em.remove(toBeDeleted);
		} finally {

		}
	}

	@SuppressWarnings("finally")
	public Account findAccountByID(int accountID) {
		Account account = null;
		try {
			account = em.find(Account.class, accountID);
		} finally {
			return account;
		}
	}
}

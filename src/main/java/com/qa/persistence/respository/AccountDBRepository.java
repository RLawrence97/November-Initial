package com.qa.persistence.respository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.qa.domain.Account;
import com.qa.utils.util;

@Default
@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository {
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Transactional(REQUIRED)
	public Account addAccount(Account incomingAccount) {
		em.persist(incomingAccount);
		return incomingAccount;
	}

	@Transactional(REQUIRED)
	public int removeAccount(int accountID) {
		Account toBeDeleted = em.find(Account.class, accountID);
		em.remove(toBeDeleted);
		return accountID;
	}

	@Transactional(REQUIRED)
	public Account updateAccount(Account incomingAccount) {
		int id = incomingAccount.getAccountid();
		Account toBeUpdated = em.find(Account.class, id);
		toBeUpdated.updateAll(incomingAccount);
		em.merge(toBeUpdated);
		return incomingAccount;
	}

	public Account findAccountByID(int accountID) {
		return em.find(Account.class, accountID);
	}

	@SuppressWarnings({ "finally" })
	public List<Account> findAllAccount() {
		List<Account> account = new ArrayList<Account>();
		try {
			account.addAll(em.createQuery("Select a from Account a ORDER BY a.firstname DESC", Account.class)
					.getResultList());
		} catch (Exception e) {
			account.add(util.convertJSONtoObject("{\"attempt\" : \"failed\"}"));
		} finally {
			return account;
		}
	}
}

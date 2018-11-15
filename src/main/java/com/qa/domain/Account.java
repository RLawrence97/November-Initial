package com.qa.domain;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountid;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 8)
	private String accountNumber;
	
	public Account() {
		
	}
	
	public Account(int createdid, String createdFirstName, String createdLastName, String createdAccoutNum) {
		super();
		this.accountid = createdid;
		this.firstName = createdFirstName;
		this.lastName = createdLastName;
		this.accountNumber = createdAccoutNum;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void updateAll(Account incomingAccount) {
		this.firstName = incomingAccount.getFirstName();
		this.lastName = incomingAccount.getLastName();
		this.accountNumber = incomingAccount.getAccountNumber();
		
	}

}

package com.qa.domain;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	private Integer accountid;
	@Column(length = 50)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 8)
	private String accountNumber;

	public Account(String createdFirstName, String createdLastName, String createdAccoutNum) {
		super();
		this.firstName = createdFirstName;
		this.lastName = createdLastName;
		this.accountNumber = createdAccoutNum;
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

}

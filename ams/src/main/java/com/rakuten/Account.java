package com.rakuten;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accountNumber")
	private Integer accountNumber;
	
	private String accountHolderName;
	private String address;
	private int balance;
	private Date createdDate; //Import from util.
	
	@Enumerated(EnumType.STRING)
	@Column(name = "accountType")
	private TYPE accountType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "accountStatus")
	private STATUS accountStatus;
	
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public TYPE getAccountType() {
		return accountType;
	}

	public void setAccountType(TYPE accountType) {
		this.accountType = accountType;
	}

	public STATUS getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(STATUS accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
	
//	@Override
//	public String toString() {
//		String accountInfo = String.format("Account Number:: %d\n Owner Name:: %s\n Address:: %s\n Balance:: %d\n Created Date:: %s\n Account Status:: %s\n Account Type:: %s", getAccountNumber(), getAccountHolderName(), getAddress(), getBalance(), getCreatedDate(), getAccountStatus(), getAccountType());
//		accountInfo += "\n------------------------------------\n";
//		return accountInfo;
//	}
	
	public long withdraw(int amount) {
		if(amount > this.getBalance()) {
			throw new IllegalArgumentException("Low Balance, the current balance is " + this.getBalance());
		}
		
		this.setBalance(this.getBalance() - amount);
		return this.getBalance();
	}
	
	public long deposit(int amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Amount should not be negative, the entered amount is " + amount);
		}
		this.setBalance( amount + this.getBalance() );
		return this.getBalance();
	}
	
}

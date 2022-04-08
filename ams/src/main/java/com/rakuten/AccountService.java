package com.rakuten;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repository;
	
	
	void save(Account account) {
		repository.save(account);
		System.out.println("Account Saved.");
	}

	public List<Account> getAllAccounts() {
		return repository.findAll();
	}
}

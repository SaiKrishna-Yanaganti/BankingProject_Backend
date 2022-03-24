package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Account;
import com.lti.repository.AccountRepository;

@Service
public class AccountServiceAlpha implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
		return true;
	}



	
}

package com.lti.service;

import java.time.LocalDate;
import java.util.List;

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
	@Override
	public List<Account> getTransactionDetails(long accountNumber) {
		// TODO Auto-generated method stub
		List<Account> accountHistory=accountRepository.findByAccountNumber(accountNumber);
		return accountHistory;
	}



	
}

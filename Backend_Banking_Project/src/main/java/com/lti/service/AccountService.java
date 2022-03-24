package com.lti.service;

import java.time.LocalDate;
import java.util.List;

import com.lti.model.Account;

public interface AccountService {

	public boolean addAccount(Account account);
	public List<Account> getTransactionDetails(long accountNumber);
}

package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Account;
import com.lti.model.Customer;
import com.lti.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("getTransactionDetails/{accountNumber}")
	public ResponseEntity<List<Account>> getTransactionDetails(@PathVariable("accountNumber")long accountNumber){
		ResponseEntity<List<Account>> responseEntity;
		List<Account> accountHistory=accountService.getTransactionDetails(accountNumber);
		String message=null;
		if(accountHistory!=null) {
			message="Transaction Details retrieved";
			responseEntity= new ResponseEntity<List<Account>>(accountHistory,HttpStatus.OK);
		}
		else {
			message="Transaction Details not found";
			responseEntity= new ResponseEntity<List<Account>>(accountHistory,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
}

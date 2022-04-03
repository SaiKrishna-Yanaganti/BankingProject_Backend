package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Account;
import com.lti.model.Customer;
import com.lti.repository.CustomerRepository;

@Service
public class CustomerServiceAlpha implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		long accountNumber=(long)(1000000000+Math.random()*900000000);
		customer.setAccountNumber(accountNumber);
		customer.setAccountStatus("No");
		customer.setAccountBalance(1000);
		customerRepository.save(customer);
		return true;
	}
	@Override
	public boolean isCustomerExist(String customerUserName) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUserName(customerUserName);
		if(customer!=null)
			return true;
		else
			return false;
	}
	@Override
	public Customer getCustomerDetails(String userName) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUserName(userName);
		return customer;
	}
	@Override
	public boolean authenticateUser(String userName, String password) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByUserNameAndPassword(userName,password);
		if(customer!=null)
			return true;
		else 
			return false;
	}
	@Override
	public boolean deposit(long accountNumber, int amount) {
		// TODO Auto-generated method stub
		Customer customer=customerRepository.findByAccountNumber(accountNumber);
		int actualBalance=customer.getAccountBalance();
		int newBalance=actualBalance+amount;
		System.out.println("balance in to account : "+newBalance +"actual :"+actualBalance+" amount"+ amount);
		int result= customerRepository.updateAmount(newBalance, accountNumber);
		if(result!=0) {
			long transactionId=(long)(10000000+Math.random()*90000000);
			String transactionType="credit";
			LocalDate date=LocalDate.now();
			String remarks="Rs."+amount+" credited to your account";
			Account account=new Account(accountNumber,transactionId,transactionType,amount,0,"",date,remarks);
			accountService.addAccount(account);
			return true;
		}
			
		else
			return false;
	}
	@Override
	public boolean withdraw(long accountNumber, int amount) {
		// TODO Auto-generated method stub
		
		Customer customer=customerRepository.findByAccountNumber(accountNumber);
		if(customer!=null) {
			int actualBalance=customer.getAccountBalance();
			int newBalance=actualBalance-amount;
			System.out.println("my balance after transaction: "+newBalance);
			int result= customerRepository.updateAmount(newBalance, accountNumber);
			if(result!=0){
				long transactionId=(long)(10000000+Math.random()*90000000);
				String transactionType="debit";
				LocalDate date=LocalDate.now();
				String remarks="Rs."+amount+" debited from your account";
				Account account=new Account(accountNumber,transactionId,transactionType,amount,0,"",date,remarks);
				accountService.addAccount(account);
				return true;
			}
				
			else
				return false;
		}
		else {
			return false;
		}
	}
	@Override
	public boolean transferAmount(long fromAccountNumber, long toAccountNumber, int amount) {
		
		
		// TODO Auto-generated method stub
		boolean withdrawFlag=withdraw(fromAccountNumber, amount);
		boolean depositFlag=deposit(toAccountNumber, amount);
		if(withdrawFlag&&depositFlag) {
			long transactionId=(long)(10000000+Math.random()*90000000);
		String transactionType="transfer";
		Customer customer=customerRepository.findByAccountNumber(toAccountNumber);
		String toName=customer.getFirstName()+" "+customer.getLastName();
		LocalDate date=LocalDate.now();
		String remarks="Rs."+amount+" Transfer from "+fromAccountNumber+" to "+toAccountNumber;
		Account account=new Account(fromAccountNumber,transactionId,transactionType,amount,toAccountNumber,toName,date,remarks);
		accountService.addAccount(account);
		return true;
		}
		else
			return false;
	}
	@Override
	public int updatePassword(String newPassword,String userName) {
		// TODO Auto-generated method stub
		return customerRepository.updatePassword(newPassword,userName);
		
	}

}

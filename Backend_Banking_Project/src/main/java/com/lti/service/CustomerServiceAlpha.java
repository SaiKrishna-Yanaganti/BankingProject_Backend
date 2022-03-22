package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Customer;
import com.lti.repository.CustomerRepository;

@Service
public class CustomerServiceAlpha implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
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
		int result= customerRepository.updateAmount(newBalance, accountNumber);
		if(result!=0)
			return true;
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
			int result= customerRepository.updateAmount(newBalance, accountNumber);
			if(result!=0)
				return true;
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
		if(withdrawFlag&&depositFlag) 
			return true;
		else
			return false;
	}
	@Override
	public int updatePassword(String newPassword,String userName) {
		// TODO Auto-generated method stub
		return customerRepository.updatePassword(newPassword,userName);
		
	}

}

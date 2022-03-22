package com.lti.service;

import com.lti.model.Customer;

public interface CustomerService {
	
	public boolean addCustomer(Customer customer);
	public boolean isCustomerExist(String customerUserName);
	public Customer getCustomerDetails(String userName);
	public boolean authenticateUser(String userName, String password);
	public boolean deposit(long accountNumber, int amount);
	public boolean withdraw(long accountNumber, int amount);
	public boolean transferAmount(long fromAccountNumber,long toAccountNumber,int amount);
	public int updatePassword(String newPassword,String userName);
}

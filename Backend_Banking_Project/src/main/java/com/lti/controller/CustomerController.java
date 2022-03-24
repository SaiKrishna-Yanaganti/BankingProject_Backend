package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Customer;
import com.lti.repository.CustomerRepository;
import com.lti.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("save")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
		ResponseEntity<String> responseEntity;
		String customerUserName=customer.getUserName();
		
		String message=null;
		if(customerService.isCustomerExist(customerUserName)) {
			message="Customer with UserName already exist";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
			message="Customer Registeration successfull";
			customerService.addCustomer(customer);
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("getCustomerDetails/{customerUserName}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerUserName")String userName){
		ResponseEntity<Customer> responseEntity;
		
		String message=null;
		Customer customer=null;
		if(customerService.isCustomerExist(userName)) {
			message="Customer Details retrieved";
			customer= customerService.getCustomerDetails(userName);
			responseEntity= new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		else {
			message="Customer Details not found";
			customer=null;
			responseEntity= new ResponseEntity<Customer>(customer,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("login/{customerUserName}/{customerPassword}")
	public ResponseEntity<String> login(@PathVariable("customerUserName")String userName, @PathVariable("customerPassword")String password){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		Customer customer=null;
		if(customerService.authenticateUser(userName, password)) {
			message="login successfull";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="login failed";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("deposit/{accountNumber}/{amount}")
	public ResponseEntity<String> Deposit(@PathVariable("accountNumber")long accountNumber, @PathVariable("amount")int amount){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		boolean flag=customerService.deposit(accountNumber, amount);
		if(flag==true) {
			message="Deposited Rs."+amount+" into account Number "+accountNumber+" successfully";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="deposit failed";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("withdrawal/{accountNumber}/{amount}")
	public ResponseEntity<String> withdrawal(@PathVariable("accountNumber")long accountNumber, @PathVariable("amount")int amount){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		boolean flag=customerService.withdraw(accountNumber, amount);
		if(flag==true) {
			message="Withdawal of Rs."+amount+" from account Number "+accountNumber+" was successful";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="Withdrawal failed";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("transferAmount/{fromAccountNumber}/{toAccountNumber}/{amount}")
	public ResponseEntity<String> transferAmount(@PathVariable("fromAccountNumber")long fromAccountNumber,
			@PathVariable("toAccountNumber")long toAccountNumber,@PathVariable("amount")int amount){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		Customer customer=customerRepository.findByAccountNumber(fromAccountNumber);
		int actualBalance=customer.getAccountBalance();
		if(actualBalance<amount) {
			message="insufficient funds";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
			customerService.transferAmount(fromAccountNumber, toAccountNumber, amount);
			message="transaction successful";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("updatePassword/{newPassword}/{userName}")
	public ResponseEntity<String> updatePassword(@PathVariable("newPassword")String password,
			@PathVariable("userName")String userName){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		int result=customerService.updatePassword(password, userName);
		if(result!=0) {
			message="password updated successfully";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="there is a problem in updating. Please try again after some time";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "welcome to REST API Development using Spring Boot";
	}
}

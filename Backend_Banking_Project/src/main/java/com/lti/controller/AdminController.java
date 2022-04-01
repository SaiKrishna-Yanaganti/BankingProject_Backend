package com.lti.controller;

import java.util.List;

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

import com.lti.model.Account;
import com.lti.model.Admin;
import com.lti.model.Customer;
import com.lti.repository.AdminRepository;
import com.lti.service.AdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminRepository adminRepository;
	
	@PostMapping("save")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin){
		ResponseEntity<String> responseEntity;
		int adminId=admin.getAdminId();
		
		String message=null;
		if(adminService.isAdminExist(adminId)) {
			message="Admin is already exist";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		else {
			message="Admin Registeration successfull";
			adminService.addAdmin(admin);
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	@GetMapping("login/{adminId}/{adminPassword}")
	public ResponseEntity<String> login(@PathVariable("adminId")int adminId, @PathVariable("adminPassword")String adminPassword){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
	    if(adminService.authenticateUser(adminId, adminPassword)) {
			message="login successfull";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="login failed";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	@GetMapping("accountStatus/{accountNumber}")
	public ResponseEntity<String> accountStatus(@PathVariable("accountNumber")long accountNumber){
		ResponseEntity<String> responseEntity=null;
		
		String message=null;
		boolean result=adminService.accountStatus(accountNumber);
		if(result) {
			message="Account Approved";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else {
			message="Acccount is Not Approved";
			responseEntity= new ResponseEntity<String>(message,HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	

}

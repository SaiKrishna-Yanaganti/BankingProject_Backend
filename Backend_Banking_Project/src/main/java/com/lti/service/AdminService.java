package com.lti.service;

import java.util.List;

import com.lti.model.Admin;


public interface AdminService {
	
	public boolean addAdmin(Admin admin);
	public boolean isAdminExist(int adminId);
	public boolean authenticateUser(int adminId, String adminPassword);
	public boolean accountStatus(long accountNumber);
	
	
	
	
}

package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Admin;

import com.lti.repository.AdminRepository;

@Service
public class AdminServiceAlpha implements AdminService{

	@Autowired
	AdminRepository adminRepository;

	@Override
	public boolean addAdmin(Admin admin) {
		
		// TODO Auto-generated method stub
		adminRepository.save(admin);
		return true;
		
	}

	@Override
	public boolean isAdminExist(int adminId) {
		// TODO Auto-generated method stub
		Admin admin=adminRepository.findByAdminId(adminId);
		if(admin!=null)
			return true;
		else
			return false;
	}

	@Override
	public boolean authenticateUser(int adminId, String adminPassword) {
		Admin admin=adminRepository.findByAdminIdAndAdminPassword(adminId,adminPassword);
		if(admin!=null)
			return true;
		else 
			return false;
	}

	

}

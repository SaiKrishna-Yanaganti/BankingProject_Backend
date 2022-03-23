package com.lti.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, String>{

	public Admin findByAdminId(int adminId);
	public Admin findByAdminIdAndAdminPassword(int adminId,String adminPassword);
}

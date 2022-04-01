package com.lti.repository;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.lti.model.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, String>{

	public Admin findByAdminId(int adminId);
	public Admin findByAdminIdAndAdminPassword(int adminId,String adminPassword);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.accountStatus='yes' WHERE c.accountNumber=:accountNumber")
	public int updateAccountStatus(@Param(value="accountNumber")long accountNumber);
	
	
	
}

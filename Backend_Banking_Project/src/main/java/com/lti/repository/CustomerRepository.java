package com.lti.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lti.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
	public Customer findByUserName(String userName);
	public Customer findByUserNameAndPassword(String userName,String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.accountBalance=:amount WHERE c.accountNumber=:accountNumber")
	public int updateAmount(@Param(value="amount")int amount,@Param(value="accountNumber")long accountNumber);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer c SET c.password=:password WHERE c.userName=:userId")
	public int updatePassword(@Param(value="password")String password,@Param(value="userId")String userId);
	
	public Customer findByAccountNumber(long accountNumber);
}

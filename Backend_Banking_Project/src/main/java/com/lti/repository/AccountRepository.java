package com.lti.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lti.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, String>{

}

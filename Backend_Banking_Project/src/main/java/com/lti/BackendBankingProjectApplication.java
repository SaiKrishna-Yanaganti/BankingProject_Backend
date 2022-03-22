package com.lti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class BackendBankingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBankingProjectApplication.class, args);
	}

}

package com.gsp.mastek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaAuditing
@SpringBootApplication
public class GspRegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GspRegistrationServiceApplication.class, args);
		System.out.println("**************Application Started***************************");
	}
}

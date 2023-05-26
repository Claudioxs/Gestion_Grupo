package com.ufrobook.isoft.ufrobook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class UfrobookApplication {

	public static void main(String[] args) {
		SpringApplication.run(UfrobookApplication.class, args);
	}

}

package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "com.ecommerce.models")
@EnableJpaRepositories(basePackages = "com.ecommerce.repository")
public class LatestEcommerceApplication {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("kartavya"));
		System.out.println(passwordEncoder.encode("pass_word") + " :: "
				+ passwordEncoder.matches("pass_word", "$2a$10$8YPN0.TwIjrZAmIIwpvPT.aiuQc6Dy1g3C5whURCyI5Z0yGzWFO/K"));
		SpringApplication.run(LatestEcommerceApplication.class, args);
	}

}

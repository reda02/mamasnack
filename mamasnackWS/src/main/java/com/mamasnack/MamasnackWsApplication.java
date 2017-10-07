package com.mamasnack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class)
public class MamasnackWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MamasnackWsApplication.class, args);
	}
}

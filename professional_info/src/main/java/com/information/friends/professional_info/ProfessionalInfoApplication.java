package com.information.friends.professional_info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProfessionalInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessionalInfoApplication.class, args);
	}

}

package com.microservices.zipcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZipcodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipcodeApplication.class, args);
	}

}

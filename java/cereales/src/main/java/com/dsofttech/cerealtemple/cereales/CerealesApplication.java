package com.dsofttech.cerealtemple.cereales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CerealesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CerealesApplication.class, args);
	}

}

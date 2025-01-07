package com.advertise;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
public class OlxAdvertisesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertisesApplication.class, args);
		System.out.println("\n"+"Hello Advertise...");
	}
	
	@Bean
	public ModelMapper getMapper()
	{
		return new ModelMapper();
	}
	
	@Bean
//	@LoadBalanced
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
}

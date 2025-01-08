package com.masterdata;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OlxMasterDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxMasterDataApplication.class, args);
	}

    @Bean
    ModelMapper getModelMapper()
	{
		return new ModelMapper();
	}
}

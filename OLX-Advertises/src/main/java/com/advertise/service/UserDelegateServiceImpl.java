package com.advertise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDelegateServiceImpl implements UserDelegateService {

	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public boolean isTokenValid(String authToken, String expectedRoles) {
		
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization",authToken);
		headers.set("EXPECTED_ROLES",expectedRoles);
		HttpEntity entity=new HttpEntity(headers);
		
		ResponseEntity<Boolean> ex=restTemplate.exchange("http://OLX-Login/token/validate", HttpMethod.GET,
				entity,Boolean.class);
		
		return ex.getBody();
	}

}

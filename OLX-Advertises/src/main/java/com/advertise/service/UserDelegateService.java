package com.advertise.service;

public interface UserDelegateService {

	public boolean isTokenValid(String authToken,String expectedRoles);
}

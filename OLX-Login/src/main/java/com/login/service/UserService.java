package com.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.login.dto.UserDto;

public interface UserService {

	public UserDto add(UserDto obj);
	public List<UserDto> getAllinfo();
	
}

package com.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.dto.UserDto;
import com.login.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/user/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> authenticate(@RequestBody String a )  // check it afterwards
  	{
		return null;
	}
	
	@DeleteMapping(value = "/user/logout")
	public ResponseEntity<Boolean> logout(@RequestHeader("Authorization") String authToken)
	{
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
//	/Register New User
	@PostMapping(value = "/user",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> add(@RequestBody UserDto obj)
	{
		return new ResponseEntity<UserDto>(userService.add(obj),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<List<UserDto>> getAllinfo(@RequestHeader("Authorizarion") String authToken)
	{
		return new ResponseEntity<List<UserDto>>(userService.getAllinfo(),HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/token/validate")
	public ResponseEntity<Boolean> isTokenValid(@RequestHeader("Authorization") String authHeader)
	{
		return null;
	}
	
	
}













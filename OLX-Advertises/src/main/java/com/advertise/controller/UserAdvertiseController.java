package com.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.dto.AdvertiseDto;
import com.advertise.service.AdvertiseService;

@RequestMapping("/user/advertise") // 10,11,12 (done)
@RestController
public class UserAdvertiseController {

	@Autowired
	AdvertiseService service;
	
//	All advertise posted by logged in user.(10)
	@GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvertiseDto>> getAllinfo() //@RequestHeader("Authorization")String authToken
	{
		List<AdvertiseDto> allinfo  = service.getAllinfo();
		System.out.println(allinfo);
		return new ResponseEntity<List<AdvertiseDto>>(allinfo,HttpStatus.OK);
	}
	
//	find Advertise by Id for the LOGGED IN user(11)
	@GetMapping(value = "/{advertiseId}")
	public ResponseEntity<AdvertiseDto> findById(@PathVariable int advertiseId)
	{
		 
		return new ResponseEntity<AdvertiseDto>(service.findById(advertiseId),HttpStatus.FOUND);
	}
	
//	Delete the advertise posted by logged in user.(12)
	@DeleteMapping(value = "/{advertiseId}")
	public ResponseEntity<Boolean> deleteInfo(@PathVariable int advertiseId ) //@RequestHeader("Authorization")String authToken
	{
		if(service.deleteById(advertiseId))
		    return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
		return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
	}
	
	
}

























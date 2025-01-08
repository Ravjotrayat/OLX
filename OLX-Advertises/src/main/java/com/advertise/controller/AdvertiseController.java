package com.advertise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.advertise.dto.AdvertiseDto;
import com.advertise.service.AdvertiseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/advertise") //8,9,13,14,15
public class AdvertiseController {

	@Autowired
	AdvertiseService service;
	
	
//	Add new Advertise Post(8)
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdvertiseDto> add(@Valid @RequestBody AdvertiseDto dto)  // @RequestHeader("Authorization")String authToken,
	{
		return new ResponseEntity<AdvertiseDto>(service.addAdvertise(dto),HttpStatus.CREATED);// add authHeader as parameter
	}
	
	
	
//	Update Advertise Post(9)
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdvertiseDto> update(@Valid @RequestBody AdvertiseDto dto,
			@PathVariable int id)  // @RequestHeader("Authorization")String authToken,
	{
		return new ResponseEntity<AdvertiseDto>(service.updateAdvertise(dto,id),HttpStatus.CREATED);
	}
	
	
//	Applying the filter in the request Param(13)
//	title,price(ascending or descending of price),category,description,startindex and records
	@GetMapping(value = "/search/filtercriteria",produces = MediaType.APPLICATION_JSON_VALUE)  // Authorizarion is not required
	public List<AdvertiseDto> filter(
			
			@RequestParam(name = "title",required = false) String title,
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "description",required = false) String description,
			@RequestParam(name = "price",required = false) String price,
			@RequestParam(name = "startIndex",required = false,defaultValue = "0") int startIndex,
			@RequestParam(name = "records",required = false,defaultValue = "10") int records
			)
	{
		return service.searchByFilter(title, category, description, price, startIndex, records);
	}
	
	
//	SearchText any kind like(title,category and description) (14)
	@GetMapping(value ="/search",produces = MediaType.APPLICATION_JSON_VALUE)  // Authorization not required
	public List<AdvertiseDto> getAdvertiseBySearchText(
			@RequestParam(name = "searchText",required = false) String searchText,
			@RequestParam(name = "title",required = false) String title,
			@RequestParam(name = "category",required = false) String category,
			@RequestParam(name = "description",required = false) String description
			)
	{
		
		return service.searchBySearchText(searchText,title,category,description);
	}
	
//	Find Advertise by ID (15)
	@GetMapping(value="/{advertiseId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdvertiseDto> getAdvertisebyId(@PathVariable int advertiseId) {  //@RequestHeader("Authorization")String authToken,
		
		return new ResponseEntity<AdvertiseDto>(service.findAdvertiseById(advertiseId),HttpStatus.FOUND);
	}
	
	
	
	
}















package com.masterdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masterdata.dto.Adv_statusDto;
import com.masterdata.dto.CategoriesDto;
import com.masterdata.service.CategoriesService;
import com.masterdata.service.StatusService;

@RequestMapping("/advertise")
public class DataController {
	
	@Autowired
	CategoriesService categoriesService;
	
	@Autowired
	StatusService statusService;
	
//	Returns all advertisement categories (6)
	@GetMapping(value = "/category",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<CategoriesDto> getAllCategory()
	{
		return categoriesService.getAllCategory();
	}
	
//	Returns all possible advertise status (7)
	@GetMapping(value = "/status",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Adv_statusDto> getAllStatus()
	{
		return statusService.getAllStatus();
	}

}

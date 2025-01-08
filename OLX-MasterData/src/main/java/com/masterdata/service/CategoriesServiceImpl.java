package com.masterdata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterdata.dto.CategoriesDto;
import com.masterdata.entity.Adv_statusEntity;
import com.masterdata.entity.CategoriesEntity;
import com.masterdata.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	
	@Autowired
	CategoriesRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<CategoriesDto> getAllCategory() {
		List<CategoriesEntity> findAll = repository.findAll();
		
		return findAll.stream()
				.map(entity->this.mapper.map(findAll, CategoriesDto.class))
				.collect(Collectors.toList());
		
	}

}

package com.masterdata.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masterdata.dto.Adv_statusDto;
import com.masterdata.entity.CategoriesEntity;
import com.masterdata.entity.Adv_statusEntity;
import com.masterdata.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	StatusRepository repository;
	
	@Override
	public List<Adv_statusDto> getAllStatus() {
	
		List<Adv_statusEntity> list = repository.findAll();
		return list.stream()
				.map(entity->this.mapper.map(entity,Adv_statusDto.class))
				.collect(Collectors.toList());
		}

}

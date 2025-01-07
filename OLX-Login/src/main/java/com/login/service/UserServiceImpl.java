package com.login.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dto.UserDto;
import com.login.entity.UserEntity;
import com.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDto add(UserDto obj) {
		
		UserEntity entity=this.mapper.map(obj, UserEntity.class );
		entity=repository.save(entity);
		UserDto dto=this.mapper.map(entity,UserDto.class);
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDto> getAllinfo() {
		List<UserEntity> entity=repository.findAll();
		return entity.stream()
				.map(entities->this.mapper.map(entity, UserDto.class))
				.collect(Collectors.toList());
	}
	
	

}

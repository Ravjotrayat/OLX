package com.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	public List<UserEntity> findByUserName(String username);

}

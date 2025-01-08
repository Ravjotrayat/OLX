package com.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterdata.entity.Adv_statusEntity;

public interface StatusRepository extends JpaRepository<Adv_statusEntity, Integer>{

}

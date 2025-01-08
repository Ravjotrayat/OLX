package com.masterdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterdata.entity.CategoriesEntity;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {

}

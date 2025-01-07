package com.advertise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advertise.entity.AdvertiseEntity;

public interface AdvertiseRepository  extends JpaRepository<AdvertiseEntity, Integer>
{

}

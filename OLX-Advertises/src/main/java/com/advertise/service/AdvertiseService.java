package com.advertise.service;

import java.util.List;

import com.advertise.dto.AdvertiseDto;

public interface AdvertiseService {

	public List<AdvertiseDto> getAllinfo();
	public AdvertiseDto findById(int id);
	public boolean deleteById(int id);
	public AdvertiseDto addAdvertise(AdvertiseDto dto);
	public AdvertiseDto updateAdvertise(AdvertiseDto dto,int id);
	public AdvertiseDto findAdvertiseById(int id);
	public List<AdvertiseDto> searchByFilter(String title,String category,
			String description,String price,int startIndex,int records);
	
	public List<AdvertiseDto> searchBySearchText(String searchText,String title,String category,String description);
}

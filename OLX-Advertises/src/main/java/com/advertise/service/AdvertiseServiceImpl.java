package com.advertise.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.advertise.dto.AdvertiseDto;
import com.advertise.entity.AdvertiseEntity;
import com.advertise.repository.AdvertiseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	AdvertiseRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	EntityManager manager;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	UserDelegateService userDelegateService;
	
	
	
	
//	Get All advertise by logged user
	@Override
	public List<AdvertiseDto> getAllinfo() {
		List<AdvertiseEntity>entities = repository.findAll();
		return entities.stream()
				.map(entity->this.mapper.map(entities, AdvertiseDto.class))
				.collect(Collectors.toList());
	}

//	Find By ID
	@Override
	public AdvertiseDto findById(int id) {
		Optional<AdvertiseEntity> byId = repository.findById(id);
		AdvertiseDto dto = this.mapper.map(byId, AdvertiseDto.class);
		return dto;
	}

//	Delete By ID
	@Override
	public boolean deleteById(int id) {
		Optional<AdvertiseEntity> byId = repository.findById(id);
		if(byId.isPresent())
		{
			AdvertiseEntity entity = byId.get();
			repository.deleteById(entity.getId());
			return true;
		}
		return false;
	}

//	Add New Advertise
	@Override
	public AdvertiseDto addAdvertise(AdvertiseDto dto) {
		
//		if(userDelegateService.isTokenValid(authToken, "ROLE_ADMIN"));
//		{
			AdvertiseEntity entity = this.mapper.map(dto,AdvertiseEntity.class);
			entity = repository.save(entity);
			AdvertiseDto dto2=this.mapper.map(entity, AdvertiseDto.class);
			return dto2;
//		}
//		else
//			throw new RuntimeException(authToken);
		
	}

//	Update Advertise
	@Override
	public AdvertiseDto updateAdvertise(AdvertiseDto dto, int id) {
		
		Optional<AdvertiseEntity> optional = repository.findById(id);
		
		if(optional.isEmpty())
		{
			throw new EntityNotFoundException("Advertise Record ID"+id+"not found");
		}
			
		AdvertiseEntity entities = optional.get();
		entities.setTitle(dto.getTitle());
		entities.setCategory(dto.getCategory());
		entities.setStatus(dto.getStatus());
		entities.setPrice(dto.getPrice());
		entities.setDescription(dto.getDescription());
		entities.setPhoto(dto.getPhoto());
		entities.setActive(dto.isActive());
		entities.setPosted_by(dto.getPosted_by());
		entities.setUsername(dto.getUsername());
		
		AdvertiseEntity save = repository.save(entities);
		return this.mapper.map(save,AdvertiseDto.class);
	}

	
	
//	Find Advertise By ID
	@Override
	public AdvertiseDto findAdvertiseById(int id) {
		Optional<AdvertiseEntity> optional = repository.findById(id);
		if(optional.isPresent())
		{
			return this.mapper.map(optional, AdvertiseDto.class);
		}
		throw new NoSuchElementException("Advertise ID " + id + " not found"); // added the exception here.
	}

//	Filter in the Request Param
	@Override
	public List<AdvertiseDto> searchByFilter(String title, String category, String description,
			String price, int startIndex,
			int records) {
		CriteriaBuilder builder=manager.getCriteriaBuilder();
		CriteriaQuery<AdvertiseEntity> query = builder.createQuery(AdvertiseEntity.class);
		Root<AdvertiseEntity> root = query.from(AdvertiseEntity.class);
		
//		Universal variable to store the result at the end
		Predicate titlePredicate=builder.and();
		Predicate categoryPredicate=builder.and();
		Predicate descriptionPredicate=builder.and();
		
//		title,price(ascending or descending of price),category,description,startindex and records
		
//		TITLE
		if(title!=null && !"".equals(title))
		{
			titlePredicate=builder.equal(root.get("title"), title);
		}
		
//		CATEGORY	
		if(category!=null && !"".equals(category))
		{
			categoryPredicate=builder.equal(root.get("category"), category);
		}
		
//		DESCRIPTION
		if(description!=null && !"".equals(description))
		{
			descriptionPredicate=builder.equal(root.get("description"),description);
		}
		
//		PRICE
		if(price!=null && !"".equals(price))
		{
			if("asc".equalsIgnoreCase(price))
				query.orderBy(builder.asc(root.get("price")));

			if("desc".equalsIgnoreCase(price))
				query.orderBy(builder.desc(root.get("price")));
		}	
		
//		All the query is completed and submited successful
		Predicate finalPredicate=builder.and(titlePredicate,
				categoryPredicate,descriptionPredicate);
		query.where(finalPredicate);
		
		TypedQuery<AdvertiseEntity> typedQuery = manager.createQuery(query);
		typedQuery.setFirstResult(startIndex);
		typedQuery.setMaxResults(records);
		List<AdvertiseEntity> list = typedQuery.getResultList();
		
		return list.stream()
				.map(entity->this.mapper.map(entity, AdvertiseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<AdvertiseDto> searchBySearchText(String searchText, String title, String category, String description) {
		
		CriteriaBuilder builder=manager.getCriteriaBuilder();
		CriteriaQuery<AdvertiseEntity> query = builder.createQuery(AdvertiseEntity.class);
		Root<AdvertiseEntity> root = query.from(AdvertiseEntity.class);
		
		
		Predicate searchTextPredicate=builder.and();
		
		if(searchText!=null && !"".equals(searchText) )
		{
			Predicate titleSearchtextPredicate=builder.like(root.get("title"), "%"+searchText+"%");
			Predicate categorySearchtextPredicate=builder.like(root.get("category"), "%"+searchText+"%");
			Predicate descriptionSearchtextPredicate=builder.like(root.get("description"), "%"+searchText+"%");
			
			searchTextPredicate=builder.or(titleSearchtextPredicate,
									categorySearchtextPredicate,
									descriptionSearchtextPredicate);
		}
		
		Predicate finalPredicate=builder.and(searchTextPredicate);	
		query.where(finalPredicate);
		
		TypedQuery<AdvertiseEntity> typedQuery = manager.createQuery(query);
		List<AdvertiseEntity> list = typedQuery.getResultList();
		
		return list.stream()
				.map(entity->this.mapper.map(list, AdvertiseDto.class))
				.collect(Collectors.toList());
		
	}
}
	

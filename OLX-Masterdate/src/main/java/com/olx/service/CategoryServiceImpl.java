package com.olx.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.dto.Category;
import com.olx.dto.Status;
import com.olx.entity.CategoryEntity;
import com.olx.entity.StatusEntity;
import com.olx.repository.CategoryRepo;
import com.olx.repository.StatusRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepo categoryRepo;

	@Autowired
	StatusRepo statusRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<Category> getAllCategory() {
		List<CategoryEntity> categoryEntityList = categoryRepo.findAll();
		List<Category> categoryDtoList = new ArrayList<Category>();
		for (CategoryEntity categoryEntity : categoryEntityList) {
			Category category = convertEntityIntoDTO(categoryEntity);
			categoryDtoList.add(category);
		}
		return categoryDtoList;
	}

	@Override
	public List<Status> getAllStatus() {
		List<StatusEntity> statusEntityList = statusRepo.findAll();
		List<Status> statusDtoList = new ArrayList<Status>();
		for (StatusEntity statusEntity : statusEntityList) {
			Status status = convertEntityIntoDTO2(statusEntity);
			statusDtoList.add(status);
		}
		return statusDtoList;
	}

	private CategoryEntity convertDTOIntoEntity(Category category) {
		TypeMap<Category, CategoryEntity> tMap = modelMapper.typeMap(Category.class, CategoryEntity.class);
		CategoryEntity categoryEntity = modelMapper.map(category, CategoryEntity.class);
		return categoryEntity;
	}

	private Category convertEntityIntoDTO(CategoryEntity categoryEntity) {
		TypeMap<CategoryEntity, Category> tMap = modelMapper.typeMap(CategoryEntity.class, Category.class);
		Category category = modelMapper.map(categoryEntity, Category.class);
		return category;
	}

	private StatusEntity convertDTOIntoEntity2(Status status) {
		TypeMap<Status, StatusEntity> tMap = modelMapper.typeMap(Status.class, StatusEntity.class);
		StatusEntity statusEntity = modelMapper.map(status, StatusEntity.class);
		return statusEntity;
	}

	private Status convertEntityIntoDTO2(StatusEntity statusEntity) {
		TypeMap<StatusEntity, Status> tMap = modelMapper.typeMap(StatusEntity.class, Status.class);
		Status status = modelMapper.map(statusEntity, Status.class);
		return status;
	}
	
	

}

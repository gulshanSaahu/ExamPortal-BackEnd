package com.exam.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.exam.Category;
import com.exam.repository.CategoryRepository;
import com.exam.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService
{
     @Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getAllCategory() {
		
		return new HashSet<>( this.categoryRepository.findAll());
	}

	@Override
	public Category getByIdCategory(Long cId) {
		
		return this.categoryRepository.findById(cId).get();
	}

	@Override
	public void deleteCategory(Long cId) {
		Category category = new Category();
		category.setCId(cId);
		this.categoryRepository.delete(category);
		
	}

}

package com.exam.services;

import java.util.Set;

import com.exam.entities.exam.Category;

public interface CategoryService 
{

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getAllCategory();
	public Category getByIdCategory(Long cId);
	public void deleteCategory(Long cId);
}

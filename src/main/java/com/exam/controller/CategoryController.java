package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entities.exam.Category;
import com.exam.services.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController 
{

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)
	{
		Category addCategory = this.categoryService.addCategory(category);
		
		return ResponseEntity.ok(addCategory);
	}
	
	@GetMapping("/{cId}")
	public ResponseEntity<Category> getByIdCategory(@PathVariable("cId") Long cId)
	{
		Category byIdCategory = this.categoryService.getByIdCategory(cId);
		
		return ResponseEntity.ok(byIdCategory);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok( this.categoryService.getAllCategory());
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category)
	{
		return this.categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{cId}")
	public void deleteCategory(@PathVariable("cId") Long cId)
	{
		this.categoryService.deleteCategory(cId);
	}
}

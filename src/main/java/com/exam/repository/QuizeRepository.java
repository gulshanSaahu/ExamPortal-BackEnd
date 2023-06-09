package com.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entities.exam.Category;
import com.exam.entities.exam.Quiz;

public interface QuizeRepository extends JpaRepository<Quiz, Long>
{
    

	public List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category c ,Boolean b);
}

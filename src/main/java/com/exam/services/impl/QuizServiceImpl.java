package com.exam.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.exam.Category;
import com.exam.entities.exam.Quiz;
import com.exam.repository.QuizeRepository;
import com.exam.services.CategoryService;
import com.exam.services.QuizService;
@Service
public class QuizServiceImpl implements QuizService
{
	@Autowired
	private QuizeRepository quizeRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		
		return this.quizeRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		
		return this.quizeRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getAllQuiz() {
		
		return new HashSet<>(this.quizeRepository.findAll());
	}

	@Override
	public Quiz getByIdQuiz(Long qId) {
		
		return this.quizeRepository.findById(qId).get();
	}

	@Override
	public void deleteQuiz(Long qId) {
		
		this.quizeRepository.deleteById(qId);
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		
		return this.quizeRepository.findByCategory(category);
	}

	// get active quizzes
	
	@Override
	public List<Quiz> getActiveQuizzes() {
		
		return this.quizeRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {


		return this.quizeRepository.findByCategoryAndActive(c, true);
	}
	
	

}

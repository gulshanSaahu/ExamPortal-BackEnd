package com.exam.services;

import java.util.List;
import java.util.Set;

import com.exam.entities.exam.Category;
import com.exam.entities.exam.Quiz;
import com.exam.repository.QuizeRepository;

public interface QuizService 
{

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getAllQuiz();
	
	public Quiz getByIdQuiz(Long qId);
	
	public void deleteQuiz(Long qId);
	
	public List<Quiz> getQuizzesOfCategory(Category category);
	
	
	public List<Quiz> getActiveQuizzes();
	
	public List<Quiz> getActiveQuizzesOfCategory(Category c);
	
	
	
}

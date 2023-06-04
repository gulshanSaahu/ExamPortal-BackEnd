package com.exam.controller;

import java.util.List;
import java.util.Set;

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
import com.exam.entities.exam.Quiz;
import com.exam.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public  ResponseEntity<Quiz> add(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@GetMapping("/")
	public ResponseEntity<Set<Quiz>> getAll()
	{
		return ResponseEntity.ok(this.quizService.getAllQuiz());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> getSingleQuiz(@PathVariable("id") Long qId)
	{
		return ResponseEntity.ok(this.quizService.getByIdQuiz(qId));
	}
	
	@GetMapping("/category/{cId}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cId") Long cId)
	{
		Category category = new Category();
		category.setCId(cId);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
	@DeleteMapping("/{qId}")
	public void delete(@PathVariable("qId") Long qId)
	{
		this.quizService.deleteQuiz(qId);
	}
	
	
	//get active quizzes
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuizzes(){
		return this.quizService.getActiveQuizzes();
	}
	
	@GetMapping("/category/active/{cId}")
	public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cId") Long cId){
		Category category = new Category();
		category.setCId(cId);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
	

}

package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

import com.exam.entities.exam.Question;
import com.exam.entities.exam.Quiz;
import com.exam.services.QuestionService;
import com.exam.services.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController 
{
	@Autowired
	private QuizService quizService;
	
    @Autowired
    private QuestionService questionService;
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question)
    {
    	return ResponseEntity.ok(this.questionService.addQuestion(question));
    }
    
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
    	return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }
    
    @GetMapping("/")
    public ResponseEntity<Set<Question>> getAllQuestion()
    {
    	return ResponseEntity.ok(this.questionService.getAllQuestion());
    }
    
    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getQuestionQuiz(@PathVariable("qId") Long qId)
    {
		/*
		 * Quiz quiz = new Quiz(); quiz.setQId(qId); return
		 * ResponseEntity.ok(this.questionService.getQuestionOfQuize(quiz));
		 */
    	
    	Quiz byIdQuiz = this.quizService.getByIdQuiz(qId);
    	Set<Question> questions = byIdQuiz.getQuestions();
    	List<Question> list = new ArrayList<>(questions);
    	if(list.size()>Integer.parseInt(byIdQuiz.getNumberOfQuestions()))
    	{
    		list = list.subList(0, Integer.parseInt(byIdQuiz.getNumberOfQuestions()+1));
    	}
    	list.forEach((q)->{
    		q.setAnswer("");
    	});
    	
    	Collections.shuffle(list);
    	return ResponseEntity.ok(list);
    	
    	
    	
    }
    
    @GetMapping("/quiz/all/{qId}")
    public ResponseEntity<?> getQuestionQuizAdmin(@PathVariable("qId") Long qId)
    {
		
		  Quiz quiz = new Quiz(); 
		  quiz.setQId(qId);
		  return ResponseEntity.ok(this.questionService.getQuestionOfQuize(quiz));
		 
    	
    	//return ResponseEntity.ok(list);
    	
    	
    	
    }
    
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId)
    {
    	return this.questionService.getId(quesId);
    }
    
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId)
    {
    	this.questionService.deleteQuestion(quesId);
    }
    
    // eval quiz
    @PostMapping("eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
    {
    	System.out.println(questions);
    	
    	double marksGot = 0;
    	int correctAnswers = 0;
    	int attempted=0;
    	
    	for (Question q:questions){
    		// single question
    		Question question = this.questionService.get(q.getQuesId());
    		if(question.getAnswer().equals(q.getGivenAnswer()))
    		{
    			//correct
    			correctAnswers++;
    			
    			double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
    			marksGot += marksSingle;
    			
    			
    			System.out.println("marksSingle:"+marksSingle);
    			System.out.println("marksGot:"+marksGot);
    			
    		}
    		if( q.getGivenAnswer() != null) {
    			attempted++;
    		}
    	};
    	Map<String, Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
    	return ResponseEntity.ok(map);
    }
    
    
    
}

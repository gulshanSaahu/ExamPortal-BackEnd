package com.exam.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.exam.Question;
import com.exam.entities.exam.Quiz;
import com.exam.repository.QuestionRepository;
import com.exam.services.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService
{
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getAllQuestion() {
		
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question fetByIdQuestion(Long qId) {
		
		return this.questionRepository.findById(qId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuize(Quiz quiz) {
		
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public Question getId(Long quesId) {
		
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public void deleteQuestion(Long quesId) {
		this.questionRepository.deleteById(quesId);
		
	}

	@Override
	public Question get(Long quesId) {
		
		return this.questionRepository.getOne(quesId);
	}

}

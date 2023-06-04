package com.exam.services;

import java.util.Set;

import com.exam.entities.exam.Question;
import com.exam.entities.exam.Quiz;

public interface QuestionService 
{
   public Question addQuestion(Question question);
   
   public Question updateQuestion(Question question);
   
   public Set< Question> getAllQuestion();
   
   public Question fetByIdQuestion(Long qId);
   public Set<Question> getQuestionOfQuize(Quiz quiz);
   
   public Question getId(Long quesId);
   
   public void deleteQuestion(Long quesId);
   
   public Question get(Long quesId);
   
}

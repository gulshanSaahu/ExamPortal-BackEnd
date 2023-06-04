package com.exam.entities.exam;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesId;
	
	@Column(length = 5000)
	private String content;
	
	private String image;
	
	@Column(length = 2000)
	private String option1;
	@Column(length = 2000)
	private String option2;
	@Column(length = 2000)
	private String option3;
	@Column(length = 2000)
	private String option4;
	
	
	private String answer;
	
	@Transient
	private String givenAnswer;
	
     @ManyToOne(fetch = FetchType.EAGER)
	private Quiz quiz;
     
     
     
     
}

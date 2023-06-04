package com.exam.entities.exam;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Quiz {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	private Long qId;
     
     private String title;
     
     private String description;
     
     private String maxMarks;
     
     private String numberOfQuestions;
     
     private boolean active = false;
     
     @ManyToOne(fetch=FetchType.EAGER)
     private Category category;
     
     @OneToMany(mappedBy = "quiz",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
     @JsonIgnore
     private Set<Question> questions = new HashSet<>();

	public Quiz(String title, String description, String maxMarks, String numberOfQuestions, boolean active) {
		super();
		this.title = title;
		this.description = description;
		this.maxMarks = maxMarks;
		this.numberOfQuestions = numberOfQuestions;
		this.active = active;
	}
     
     
     
     
}

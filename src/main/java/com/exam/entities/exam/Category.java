package com.exam.entities.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Quiz> quizzes = new LinkedHashSet<>();

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

}

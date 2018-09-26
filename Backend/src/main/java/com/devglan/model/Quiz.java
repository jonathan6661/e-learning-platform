package com.devglan.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue
	private Long quizId;
	@Column
	private String name;
	@Column
	private String description;
	@ManyToOne
	private Lesson lesson;
	@ManyToOne
	private Teacher createdBy;
	@OneToMany(mappedBy = "quiz")
	@JsonIgnore
	private List<Question> questions;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(Long quizId, String name, String description, Lesson lesson, Teacher createdBy) {
		super();
		this.quizId = quizId;
		this.name = name;
		this.description = description;
		this.lesson = lesson;
		this.createdBy = createdBy;
	}
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}
	public Teacher getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Teacher createdBy) {
		this.createdBy = createdBy;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
	
	
}

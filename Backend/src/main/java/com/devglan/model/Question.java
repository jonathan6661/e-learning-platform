package com.devglan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
    @GeneratedValue
	private Long idQuestion;
	private String text;
	private Integer order;
	@ManyToOne
	@JsonIgnore
	private Quiz quiz;
	@JsonIgnore
	@OneToOne
	private Answer correctAnswer;
	@OneToMany(mappedBy = "question")	
	private List<Answer> answers;
	@JsonIgnore
	private Boolean isValid = false;
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Question(String text, Integer order, Quiz quiz, Answer correctAnswer, Boolean isValid) {
		super();
		this.text = text;
		this.order = order;
		this.quiz = quiz;
		this.correctAnswer = correctAnswer;
		this.isValid = isValid;
	}
	public Long getIdQuestion() {
		return idQuestion;
	}
	public void setIdQuestion(Long idQuestion) {
		this.idQuestion = idQuestion;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Quiz getQuiz() {
		return quiz;
	}
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	public Answer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Answer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;	
	}

	
}

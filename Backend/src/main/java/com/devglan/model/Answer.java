package com.devglan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
	@Id 
	@GeneratedValue
	private Long idAnswer;
	private String text;
	private Integer order;
	@ManyToOne
	@JsonIgnore
	private Question question;
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(String text, Integer order, Question question) {
		super();
		this.text = text;
		this.order = order;
		this.question = question;
	}
	public Long getIdAnswer() {
		return idAnswer;
	}
	public void setIdAnswer(Long idAnswer) {
		this.idAnswer = idAnswer;
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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	

}

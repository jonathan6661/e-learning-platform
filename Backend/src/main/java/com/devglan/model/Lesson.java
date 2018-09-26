package com.devglan.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lesson {

	 @Id
	 @GeneratedValue
	 private Long idlesson;
	 @Column
	 private String title;
	 @Column
	 private int number;
	 @ManyToOne
	 private Course course;
	 @OneToMany(mappedBy="lesson")
	 private List<Quiz> quiz;
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(String title, int number, Course course) {
		super();
		this.title = title;
		this.number = number;
		this.course = course;
	}
	public Long getIdlesson() {
		return idlesson;
	}
	public void setIdlesson(Long idlesson) {
		this.idlesson = idlesson;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Quiz> getQuiz() {
		return quiz;
	}
	public void setQuiz(List<Quiz> quiz) {
		this.quiz = quiz;
	}
	 
}

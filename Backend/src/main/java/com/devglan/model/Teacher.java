package com.devglan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Teacher")
public class Teacher extends User{

	private String qualification;
	@OneToMany(mappedBy="teacher")
	private List<Student> students;
	@JsonIgnore
	@OneToMany(mappedBy="teacher")
	private List<Course> courses;
	@OneToMany(mappedBy="createdBy")
	private List<Quiz> quizs;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String username, String email, String password, String nom, String prenom, int age, String srcimg,
			String interest, String qualification) {
		super(username, email, password, nom, prenom, srcimg, interest);
		this.qualification = qualification;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Quiz> getQuizs() {
		return quizs;
	}
	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
	
	
	
	
}

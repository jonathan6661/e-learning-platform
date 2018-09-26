package com.devglan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Student")
public class Student extends User{

	@ManyToOne
	@JoinColumn(name="TeacherId")
	private Teacher teacher;
	@JsonIgnore
	@ManyToMany
	@JoinTable(
            name = "user_attends_course",
            joinColumns = @JoinColumn(name = "Student_Id"),
            inverseJoinColumns = @JoinColumn(name = "Course_Id")
    )
	private List<Course> attends;
	@JsonIgnore
    @ManyToMany
	@JoinTable(
            name = "user_wishlist_course",
            joinColumns = @JoinColumn(name = "Student_Id"),
            inverseJoinColumns = @JoinColumn(name = "Course_Id")
    )
    private List<Course> wishes;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String username, String email, String password, String nom, String prenom, int age, String srcimg,
			String interest, Teacher teacher) {
		super(username, email, password, nom, prenom, srcimg, interest);
		this.teacher = teacher;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Course> getAttends() {
		return attends;
	}
	public void setAttends(List<Course> attends) {
		this.attends = attends;
	}
	public List<Course> getWishes() {
		return wishes;
	}
	public void setWishes(List<Course> wishes) {
		this.wishes = wishes;
	}
	
	
	
	
}

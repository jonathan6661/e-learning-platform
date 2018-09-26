package com.devglan.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course{

	@Id
	@GeneratedValue
	private Long courseId;
	@Column
	private String title;
	@Column
	private String description; 
	@Column
	private String link;
	@Column
    private String category;
	@Column
	private String level;
	@Column
	private String imgsrc;
	@Column
	private String quizsrc;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="TeacherId")
	private Teacher teacher;
	
	@OneToMany(mappedBy="course")
	private List< Lesson> lessons;
	@JsonIgnore
	@ManyToMany(mappedBy="attends")
	private List<Student> isAttendedBy;
	@JsonIgnore
	@ManyToMany(mappedBy="wishes")
    private List<Student> isWishedBy;
	
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String title, String description, String link, String category, String level, String imgsrc,
			String quizsrc, Teacher teacher) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
		this.category = category;
		this.level = level;
		this.imgsrc = imgsrc;
		this.quizsrc = quizsrc;
		this.teacher = teacher;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public String getQuizsrc() {
		return quizsrc;
	}
	public void setQuizsrc(String quizsrc) {
		this.quizsrc = quizsrc;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public List<Student> getIsAttendedBy() {
		return isAttendedBy;
	}
	public void setIsAttendedBy(List<Student> isAttendedBy) {
		this.isAttendedBy = isAttendedBy;
	}
	public List<Student> getIsWishedBy() {
		return isWishedBy;
	}
	public void setIsWishedBy(List<Student> isWishedBy) {
		this.isWishedBy = isWishedBy;
	}
	
	
	
	
	
}

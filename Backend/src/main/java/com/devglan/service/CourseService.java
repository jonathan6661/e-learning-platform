package com.devglan.service;

import java.util.List;

import com.devglan.model.Course;

public interface CourseService {

	public void create(Course course);
	public Course findById(Long id);
    public List<Course> findAll(); 
    public void update(Course course);
    public void delete(Long id);
    
   public List<Course> addToWishlist(Long idCourse,String studentUsername);
   public List<Course> getList(String username);


}

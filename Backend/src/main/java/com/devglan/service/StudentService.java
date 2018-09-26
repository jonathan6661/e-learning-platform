package com.devglan.service;

import java.util.List;

import com.devglan.model.Student;
import com.devglan.model.UserDto;

public interface StudentService {
	public void create(UserDto student);
	public void delete(Long id);
	public List<Student> findAll();
	public Student findById(Long id);
}

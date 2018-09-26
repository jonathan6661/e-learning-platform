package com.devglan.service;

import java.util.List;

import com.devglan.model.Teacher;
import com.devglan.model.TeacherDto;
import com.devglan.model.UserDto;

public interface TeacherService {

	public void create(UserDto teacher);
	public void delete(Long id);
	public List<Teacher> findAll();
	public Teacher findById(Long id);
}

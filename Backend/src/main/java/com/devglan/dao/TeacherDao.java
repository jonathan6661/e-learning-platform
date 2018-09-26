package com.devglan.dao;

import org.springframework.data.repository.CrudRepository;

import com.devglan.model.Teacher;

public interface TeacherDao extends CrudRepository<Teacher, Long> {

}

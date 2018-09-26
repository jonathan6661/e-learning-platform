package com.devglan.dao;

import org.springframework.data.repository.CrudRepository;

import com.devglan.model.Student;

public interface StudentDao extends CrudRepository<Student, Long>{
    Student findByUsername(String username);

}

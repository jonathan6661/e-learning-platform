package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Long>{

}

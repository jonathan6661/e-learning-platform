package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.Question;

public interface QuestionDao extends JpaRepository<Question, Long> {

}

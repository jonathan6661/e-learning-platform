package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.Answer;

public interface AnswerDao extends JpaRepository<Answer, Long> {

}

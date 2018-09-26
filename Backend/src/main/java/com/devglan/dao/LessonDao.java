package com.devglan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devglan.model.Lesson;

public interface LessonDao extends JpaRepository<Lesson, Long> {

}

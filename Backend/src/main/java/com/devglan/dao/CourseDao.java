package com.devglan.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devglan.model.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

	@Query("select c from Course c where c.title like :x")
	public Page<Course> chercher(@Param("x") String mc,Pageable pageable);
}

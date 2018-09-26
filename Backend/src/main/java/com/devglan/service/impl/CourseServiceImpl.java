package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devglan.dao.CourseDao;
import com.devglan.dao.StudentDao;
import com.devglan.dao.UserDao;
import com.devglan.model.Course;
import com.devglan.model.Student;
import com.devglan.model.User;
import com.devglan.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao cr;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private UserDao userDao;

	@Override
	public void create(Course course) {
		// TODO Auto-generated method stub
		cr.save(course);
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return cr.findOne(id);
	}

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void update(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cr.delete(id);
	}

	@Override
	public List<Course> addToWishlist(Long idCourse, String studentUsername) {
		// TODO Auto-generated method stub
		Student student=studentDao.findByUsername(studentUsername); 
		Course currentCourse =cr.findOne(idCourse);
		List<Course> wishlistList = student.getWishes();
		if(!wishlistList.contains(currentCourse)) {
			
			wishlistList.add(currentCourse);
			student.setWishes(wishlistList);
			studentDao.save(student);
		}
		List<Course> list = new ArrayList<>();
		student.getWishes().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public List<Course> getList(String username) {
		// TODO Auto-generated method stub
		Student student=studentDao.findByUsername(username); 
		return student.getWishes();

	}



}

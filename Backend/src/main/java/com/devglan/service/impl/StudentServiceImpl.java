package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devglan.dao.RoleDao;
import com.devglan.dao.StudentDao;
import com.devglan.model.Role;
import com.devglan.model.Student;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	


	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		studentDao.delete(id);
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<>();
		studentDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentDao.findOne(id);
	}

	@Override
	public void create(UserDto student) {
		Student newStudent= new Student();
		newStudent.setUsername(student.getUsername());
		newStudent.setEmail(student.getEmail());
		newStudent.setPassword(bcryptEncoder.encode(student.getPassword()));
		newStudent.setNom(student.getNom());
		newStudent.setPrenom(student.getPrenom());
	    newStudent.setSrcimg(student.getSrcimg());
	    newStudent.setInterest(student.getInterest());
		Role role= new Role();
		role.setName("USER");	
		role.setDescription("User role");
		roleDao.save(role);
		newStudent.setRoles(Arrays.asList(role));
	    studentDao.save(newStudent);
	}

}

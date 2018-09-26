package com.devglan.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devglan.dao.RoleDao;
import com.devglan.dao.TeacherDao;
import com.devglan.model.Role;
import com.devglan.model.Teacher;
import com.devglan.model.TeacherDto;
import com.devglan.model.UserDto;
import com.devglan.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

	@Autowired 
	private TeacherDao teacherDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder encoder;

	
	
	

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		teacherDao.delete(id);
	}

	@Override
	public List<Teacher> findAll() {
		// TODO Auto-generated method stub
		List<Teacher> list = new ArrayList<>();
		teacherDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public Teacher findById(Long id) {
		// TODO Auto-generated method stub
		return teacherDao.findOne(id);
	}

	@Override
	public void create(UserDto teacher) {
		// TODO Auto-generated method stub
		Teacher newTeacher= new Teacher();
		newTeacher.setUsername(teacher.getUsername());
		newTeacher.setEmail(teacher.getEmail());
		newTeacher.setPassword(encoder.encode(teacher.getPassword()));
		newTeacher.setNom(teacher.getNom());
		newTeacher.setPrenom(teacher.getPrenom());
		//newTeacher.setQualification(teacher.getQualification());
		Role role= new Role();
		role.setName("TEACHER");	
		role.setDescription("Teacher role");
		roleDao.save(role);
		newTeacher.setRoles(Arrays.asList(role));
	    teacherDao.save(newTeacher);
	}

}

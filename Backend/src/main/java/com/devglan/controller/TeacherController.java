package com.devglan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.dao.TeacherDao;
import com.devglan.model.Student;
import com.devglan.model.Teacher;
import com.devglan.model.TeacherDto;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.StudentService;
import com.devglan.service.TeacherService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherDao teacherDao;
	
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
	    @RequestMapping(value="/teachers", method = RequestMethod.GET)
	public List<Teacher> findAll(){
	        return teacherService.findAll();
	    }
    @PreAuthorize("hasAnyRole('USER','TEACHER', 'ADMIN')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    public Teacher getOne(@PathVariable Long id){
        return teacherDao.findOne(id);
    }


    @RequestMapping(value="/signup/teacher", method = RequestMethod.POST)
    public void create(@RequestBody UserDto teacher){
    teacherService.create(teacher);
    }

    
}

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

import com.devglan.dao.StudentDao;
import com.devglan.model.Student;
import com.devglan.model.User;
import com.devglan.model.UserDto;
import com.devglan.service.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentDao studentDao;
	
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
	    @RequestMapping(value="/students", method = RequestMethod.GET)
	    public List<Student> listUser(){
	        return studentService.findAll();
	    }
    @PreAuthorize("hasAnyRole('USER','TEACHER', 'ADMIN')")
    ////@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable Long id){
        return studentDao.findOne(id);
    }


    @RequestMapping(value="/signup/student", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDto user){
         studentService.create(user);
    }

    
    
}

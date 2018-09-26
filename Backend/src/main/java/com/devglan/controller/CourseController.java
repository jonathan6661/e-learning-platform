package com.devglan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devglan.dao.CourseDao;
import com.devglan.dao.StudentDao;
import com.devglan.model.Course;
import com.devglan.model.Student;
import com.devglan.model.User;
import com.devglan.service.CourseService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CourseController {

	@Autowired
	private CourseService cm;
	@Autowired
	private CourseDao cr;
	@Autowired
	private StudentDao studentDao;
	
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/courses",method=RequestMethod.POST)
	public void create(@RequestBody Course course) {
		cm.create(course);
	}
    @PreAuthorize("hasAnyRole('USER', 'ADMIN','TEACHER')")
	@RequestMapping(value="/courses/{id}",method=RequestMethod.GET)
	public Course findById(@PathVariable Long id) {
		return cm.findById(id);
		
	}
    @PreAuthorize("hasAnyRole('USER', 'ADMIN','TEACHER')")
    @RequestMapping(value="/courses",method=RequestMethod.GET)
    public List<Course> findAll(){
		
		return cm.findAll();
		
	}
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/courses/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
		cm.delete(id);
	}
    
    @RequestMapping(value="/cherchercourses",method=RequestMethod.GET)
    public Page<Course> chercher(@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")   int size){
		
		return cr.chercher("%"+mc+"%",  new PageRequest(page, size));	}
    
/*	@RequestMapping(value="/addToWishlist")
	public void addToWishlist(@RequestParam("id")Long id,
			@RequestParam("username") String username){
		cm.addToWishlist(id, username);
		
	}*/
	@RequestMapping(value="/addToWishlist", method = RequestMethod.GET)
	public List<Course> addToWishlist(@RequestParam Map<Long,String> requestParams){
		
	    String id=requestParams.get("id");
	    String userName=requestParams.get("username");
		Long ids=Long.parseLong(id);
		return cm.addToWishlist(ids,userName);
		
		
	}
	
	/*@RequestMapping(value = "/profil", method = RequestMethod.GET)
    @ResponseBody
    public User findByUsername(@RequestParam("username") String userName) {
        return userDao.findByUsername(userName);
    }*/
	   @RequestMapping(value="/wishlist",method=RequestMethod.GET)
	   @ResponseBody
	   public List<Course> getList(@RequestParam("username")  String username){
			
			return cm.getList(username);
			
		}
    
}

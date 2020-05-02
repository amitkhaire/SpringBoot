package com.jpaWithH2Curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpaWithH2Curd.entity.User;
import com.jpaWithH2Curd.service.UserService;

@RestController
public class ControllerDemo {

	@Autowired
	UserService service;

	@RequestMapping("/")
	public String home() {
		return "Hello This is spring Boot appliation";
	}

	// http://localhost:8080/getAllUser
	@RequestMapping(value = "/getAllUser")
	public List<User> getAllUser() {
		return service.getUserList();
	}

	// http://localhost:8080/user/101
	// creating a get mapping that retrieves the detail of a specific student
	@GetMapping("/user/{id}")
	private User getStudent(@PathVariable("id") int id) {
		return service.getStudentById(id);
	}

	// http://localhost:8080/user/101
	// creating a delete mapping that deletes a specific student
	@DeleteMapping("/user/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		service.deleteById(id);
	}

	//http://localhost:8080/user
	// creating post mapping that post the student detail in the database
	@PostMapping("/user")
	private int saveStudent(@RequestBody User user) {
		service.saveOrUpdate(user);
		return user.getId();
	}
}

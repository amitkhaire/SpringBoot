package com.jpaWithH2Curd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaWithH2Curd.controller.repository.UserRepository;
import com.jpaWithH2Curd.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		userRepository.findAll().forEach(userList::add);
		System.out.println("--------" + userList.toString());
		return userList;

	}

	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	// getting a specific record
	/*
	 * public void getUserById(int id) {
	 * 
	 * Optional<User> user = userRepository.findById(id); if (user.isPresent()) {
	 * return user.get(); }
	 * 
	 * userRepository.findById(id); }
	 */

	public void sveOrUpdate(User user) {
		userRepository.save(user);
	}

	// getting a specific record
	public User getStudentById(int id) {
		return userRepository.findById(id).get();
	}

	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
}

package com.jush.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.User;
import com.jush.repository.UserRepository;
import com.jush.service.UserService;

@RestController
public class UserController {
	
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		
		User savedUser=userService.registerUser(user);
		
		return savedUser;
	}
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		
		List<User> users=userRepository.findAll();
		return users;
	}
	
	@GetMapping("/api/users/{userid}")
	public User getUserById(@PathVariable("userid") Integer id) throws Exception {
		
		 User user =userService.findUserById(id);
		 return user;
	}
	

	@PutMapping("/api/users/{userid}")
	public User updateUser(@RequestBody User user,@PathVariable Integer userid) throws Exception {
		
		
			User updatedUser=userService.updateUser(user, userid);
			return updatedUser;
		
	}
	
	@PutMapping("/api/users/follow/{userid1}/{userid2}")
	public User followUserHandler(@PathVariable Integer userid1,@PathVariable Integer userid2) throws Exception{
		
		User user=userService.followUser(userid1, userid2);
		
		return user;
		
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users=userService.searchUser(query);
		return users;
	}
	
	
	
}

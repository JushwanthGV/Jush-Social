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
	
	@GetMapping("/users")
	public List<User> getUsers() {
		
		List<User> users=userRepository.findAll();
		return users;
	}
	
	@GetMapping("/users/{userid}")
	public User getUserById(@PathVariable("userid") Integer id) throws Exception {
		
		
	}
	

	
	
	@PutMapping("/users/{userid}")
	public User updateUser(@RequestBody User user,@PathVariable Integer userid) throws Exception {
		
		
		
		Optional<User> user1 = userRepository.findById(userid);
		
		if (user1.isEmpty()) {
			throw new Exception("user not exist with id "+userid);
			
		}
		
		User oldUser=user1.get();
		
		
		if (user.getFirstName()!=null) {
			oldUser.setFirstName(user.getFirstName());
		}
		if (user.getLastName()!=null) {
			oldUser.setLastName(user.getLastName());
		}
		if (user.getEmail()!=null) {
			oldUser.setEmail(user.getEmail());
		}
		
		User updatedUser=userRepository.save(oldUser);
		
		return updatedUser;
	}
	
	
	@DeleteMapping("/users/{userid}")
	public String deleteUser(@PathVariable("userid") Integer userid) throws Exception {
		
Optional<User> user = userRepository.findById(userid);
		
		if (user.isEmpty()) {
			throw new Exception("user not exist with id "+userid);
			
		}
		userRepository.delete(user.get());
		return "user deleted succesfully with id "+userid;
	
	}
	
	
	
	
}

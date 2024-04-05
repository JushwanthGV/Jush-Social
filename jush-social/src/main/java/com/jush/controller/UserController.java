package com.jush.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.model.relational.SqlStringGenerationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jush.exceptions.UserException;
import com.jush.models.User;
import com.jush.repository.UserRepository;
import com.jush.service.UserService;

@RestController
public class UserController {
	
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/api/users")
	public List<User> getUsers() {
		
		List<User> users=userRepository.findAll();
		return users;
	}
	
	@GetMapping("/api/users/{userid}")
	public User getUserById(@PathVariable("userid") Integer id) throws UserException {
		
		 User user =userService.findUserById(id);
		 return user;
	}
	

	@PutMapping("/api/users")
	public User updateUser(@RequestHeader("Authorization")String jwt,@RequestBody User user) throws UserException {
			
		
		User reqUser=userService.findUserByJwt(jwt);
		
			User updatedUser=userService.updateUser(user, reqUser.getId());
			
			return updatedUser;
		
	}
	
	@PutMapping("/api/users/follow/{userid2}")
	public User followUserHandler(@RequestHeader("Authorization")String jwt, @PathVariable Integer userid2) throws UserException{
		
		User reqUser=userService.findUserByJwt(jwt);
		
		User user=userService.followUser(reqUser.getId(), userid2);
		
		return user;
		
	}
	
	@GetMapping("/api/users/search")
	public List<User> searchUser(@RequestParam("query") String query){
		List<User> users=userService.searchUser(query);
		return users;
	}
	
	@GetMapping("/api/users/profile")
	public User getUserFromToken(@RequestHeader("Authorization")String jwt) {
		
		User user=userService.findUserByJwt(jwt);
		
		user.setPassword(null);
		
		return user;
	}
	
	

}
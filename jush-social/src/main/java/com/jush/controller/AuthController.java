package com.jush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.User;
import com.jush.repository.UserRepository;
import com.jush.service.UserService;

@RestController
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) throws Exception {
		
		User isExist= userRepository.findByEmail(user.getEmail()); 
		
		if (isExist!=null) {
			
			throw new Exception("this email already being used with another account");
			
		}
		
		User newUser=new User();
		
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User savedUser=userRepository.save(newUser);
		
		
		
		
		return savedUser;
	}
	
}

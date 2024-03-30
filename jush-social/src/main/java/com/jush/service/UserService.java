package com.jush.service;

import java.util.List;

import com.jush.models.User;

public interface UserService {

	
	
	public User registerUser(User user);
	
	public User findUserById(Integer userid);
	
	public User findUserByEmail(String email);
	
	public User followUser(Integer userid1,Integer userid2);
	
	public User updateUser(User user);
	
	public List<User> searchUser(String query);
		
}

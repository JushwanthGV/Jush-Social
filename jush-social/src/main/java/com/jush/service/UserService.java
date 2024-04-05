package com.jush.service;

import java.util.List;

import com.jush.exceptions.UserException;
import com.jush.models.User;

public interface UserService {

	
	
	public User registerUser(User user);
	
	public User findUserById(Integer userid) throws UserException;
	
	public User findUserByEmail(String email);
	
	public User followUser(Integer userid1,Integer userid2) throws UserException;
	
	public User updateUser(User user,Integer userid) throws UserException;
	
	public List<User> searchUser(String query);
	
	public User findUserByJwt(String jwt);
		
}

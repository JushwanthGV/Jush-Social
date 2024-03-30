package com.jush.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.User;
import com.jush.repository.UserRepository;





@Service
public class UserServiceImplementation implements UserService{

	
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public User registerUser(User user) {
		User newUser=new User();
		newUser.setEmail(user.getEmail());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(user.getPassword());
		newUser.setId(user.getId());
		
		User savedUser=userRepository.save(newUser);
		
		return savedUser;
	}

	@Override
	public User findUserById(Integer userid) throws Exception {
Optional<User> user =userRepository.findById(userid);
		
		if(user.isPresent()) {
			return user.get();
		}
	
		throw new Exception("there is no user with this id " + userid);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User followUser(Integer userid1, Integer userid2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUser(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}

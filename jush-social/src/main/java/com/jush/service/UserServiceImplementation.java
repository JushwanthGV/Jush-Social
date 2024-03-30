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
		User user=userRepository.findByEmail(email);
		return user;
	}

	@Override
	public User followUser(Integer userid1, Integer userid2) throws Exception {
		
		User user1=findUserById(userid1);
		
		User user2=findUserById(userid2);
		
		user2.getFollowers().add(user1.getId());
		user1.getFollowings().add(user2.getId());
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		return user1;
	}

	@Override
	public User updateUser(User user,Integer userid) throws Exception {
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

	@Override
	public List<User> searchUser(String query) {
		
		
		return userRepository.searchUser(query);
	}

	
	
	
}

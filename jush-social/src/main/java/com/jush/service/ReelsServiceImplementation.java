package com.jush.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.Reels;
import com.jush.models.User;
import com.jush.repository.ReelsRepository;

@Service
public class ReelsServiceImplementation implements ReelsService{

	@Autowired
	private ReelsRepository reelsRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public Reels createReels(Reels reel, User user) {
		 Reels createReel=new Reels();
		 createReel.setTitle(reel.getTitle());
		 createReel.setUser(user);
		 createReel.setVideo(reel.getVideo());
		 
		 
		return reelsRepository.save(createReel);
	}

	@Override
	public List<Reels> findAllReels() {
		
		return reelsRepository.findAll();
	}

	@Override
	public List<Reels> findUsersReel(Integer userid) throws Exception {
		userService.findUserById(userid);
		return reelsRepository.findByUserId(userid);
	}

	
	
	
}

package com.jush.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.Reels;
import com.jush.models.User;
import com.jush.service.ReelsService;
import com.jush.service.UserService;

@RestController
public class ReelsController {
	
	@Autowired
	private ReelsService reelsService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/reels")
	public Reels createReels(@RequestBody Reels reel,@RequestHeader("Authorization")String jwt) {
		
		User reqUser=userService.findUserByJwt(jwt);
		
		Reels createdReels=reelsService.createReels(reel, reqUser);
		
		return createdReels;
	}
	
	@GetMapping("/api/reels")
	public List<Reels> findAllReels() {
		
		List<Reels> reels=reelsService.findAllReels();
		
		return reels;
	}
	
	@GetMapping("/api/reels/user/{userid}")
	public List<Reels> findUserReels(@PathVariable Integer userid) throws Exception {
		
		List<Reels> reels=reelsService.findUsersReel(userid) ;
		
		return reels;
	}
	
	
}

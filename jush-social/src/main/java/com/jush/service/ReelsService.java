package com.jush.service;

import java.util.List;

import com.jush.models.Reels;
import com.jush.models.User;

public interface ReelsService {

	public Reels createReels(Reels reel,User user);
	
	public List<Reels> findAllReels();
	
	public List<Reels> findUsersReel(Integer userid) throws Exception;
	
}

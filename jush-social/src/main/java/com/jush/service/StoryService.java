package com.jush.service;

import java.util.List;

import com.jush.models.Story;
import com.jush.models.User;

public interface StoryService {

	public Story createStory(Story story,User user);
	
	public List<Story> findStoryByUserId(Integer userid) throws Exception;
	
	
	
}

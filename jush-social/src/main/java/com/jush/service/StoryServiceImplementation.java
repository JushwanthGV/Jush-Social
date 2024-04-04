package com.jush.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.Story;
import com.jush.models.User;
import com.jush.repository.StoryRepository;

@Service
public class StoryServiceImplementation implements StoryService{

	
	@Autowired
	private StoryRepository storyRepository;
	
	@Autowired
	private UserService userService;
	
	
	@Override
	public Story createStory(Story story, User user) {
		
		Story createdStory=new Story();
		createdStory.setCaptions(story.getCaptions());
		createdStory.setImage(story.getImage());
		createdStory.setUser(user);
		createdStory.setTimestamp(LocalDateTime.now());
		
		return storyRepository.save(createdStory);
	}

	@Override
	public List<Story> findStoryByUserId(Integer userid) throws Exception {
		
		User user=userService.findUserById(userid);
		
		
		return storyRepository.findByUserId(userid);
	}


	
}

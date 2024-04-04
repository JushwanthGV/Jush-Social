package com.jush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jush.models.Story;

public interface StoryRepository extends JpaRepository<Story,Integer>{

	
	
	
	public List<Story> findByUserId(Integer userid);
	
	
	
	
}

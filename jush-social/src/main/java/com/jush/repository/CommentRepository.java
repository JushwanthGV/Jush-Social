package com.jush.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jush.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	
	

}

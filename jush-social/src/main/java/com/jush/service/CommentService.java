package com.jush.service;

import com.jush.models.Comment;

public interface CommentService {

	public Comment createComment(Comment comment, Integer postid, Integer userid) throws Exception;
	
	public Comment findCommentById(Integer commentid) throws Exception;
	
	public Comment likeComment(Integer commentid,Integer userid) throws Exception;
}

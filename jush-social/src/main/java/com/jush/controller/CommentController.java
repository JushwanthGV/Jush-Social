package com.jush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.Comment;
import com.jush.models.User;
import com.jush.service.CommentService;
import com.jush.service.UserService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/comments/post/{postid}")
	public Comment createComment(@RequestBody Comment comment,@RequestHeader("Authorization")String jwt,@PathVariable("postid") Integer postid) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		
		Comment createdComment =  commentService.createComment(comment, postid, user.getId());
		
		return createdComment;
	
		
}
	
	@PutMapping("/api/comments/like/{commentid}")
	public Comment likeComment(@RequestHeader("Authorization")String jwt,@PathVariable Integer commentid) throws Exception {
		
		User user = userService.findUserByJwt(jwt);
		
		Comment likedComment =  commentService.likeComment(commentid, user.getId());
		
		return likedComment;
	
		
}
	

}
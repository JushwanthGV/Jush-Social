package com.jush.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.Comment;
import com.jush.models.Post;
import com.jush.models.User;
import com.jush.repository.CommentRepository;
import com.jush.repository.PostRepository;


@Service
public class CommentServiceImplementation implements CommentService {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Comment createComment(Comment comment, Integer postid, Integer userid) throws Exception {
		User user=userService.findUserById(userid);
		Post post=postService.findPostById(postid);
		
		comment.setUser(user);
		comment.setContent(comment.getContent());
		comment.setCreatedAt(LocalDateTime.now());
		
		Comment savedComment=commentRepository.save(comment);
		
		post.getComments().add(savedComment);
		
		postRepository.save(post);
		
		return savedComment;
	}

	@Override
	public Comment findCommentById(Integer commentid) throws Exception {
		Optional<Comment> opt=commentRepository.findById(commentid);
		
		if (opt.isEmpty()) {
			throw new Exception("comment not exist");
		}
		
		return opt.get();
	}

	@Override
	public Comment likeComment(Integer commentid, Integer userid) throws Exception {
		
		Comment comment= findCommentById(commentid);
		User user=userService.findUserById(userid);
		
		if (!comment.getLiked().contains(user)) {
			
			comment.getLiked().add(user);
		}
		else {
			comment.getLiked().remove(user);
		}
		return commentRepository.save(comment);
	}

	
	
}

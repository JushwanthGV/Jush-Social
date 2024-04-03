package com.jush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.Post;
import com.jush.models.User;
import com.jush.response.ApiResponse;
import com.jush.service.PostService;
import com.jush.service.UserService;

@RestController
public class PostController {
	
	@Autowired 
	PostService postService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/posts")
	public ResponseEntity<Post> createPost(@RequestHeader("Authorization")String jwt,@RequestBody Post  post) throws Exception{
		
		User reqUser=userService.findUserByJwt(jwt);
		
		Post createdPost = postService.createNewPost(post, reqUser.getId());
		
		
		return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/posts/{postid}/user/{userid}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception {
		
		String message=postService.deletePost(postid, userid);
		ApiResponse res=new ApiResponse(message,true);
		
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.OK);
	}
	
	
	@GetMapping("/posts/{postid}")
	public ResponseEntity<Post> findPostByHandler(@PathVariable Integer postid) throws Exception{
		
		Post post=postService.findPostById(postid);
		
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/posts/user/{userid}")
	public ResponseEntity<List<Post>> findUsersPost(@PathVariable Integer userid){
		List<Post> posts=postService.findPostByUserId(userid);
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
		
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<Post>> findAllPost(){
		List<Post> posts=postService.findAllPost();
		
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
		
	}
	
	
	@PutMapping("/posts/save/{postid}/user/{userid}")
	public ResponseEntity<Post> savedPostHandler(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception{
		
		Post post=postService.savedPost(postid, userid);
		
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/posts/like/{postid}/user/{userid}")
	public ResponseEntity<Post> likePostHandler(@PathVariable Integer postid,@PathVariable Integer userid) throws Exception{
		
		Post post=postService.likePost(postid, userid);
		
		return new ResponseEntity<Post>(post,HttpStatus.ACCEPTED);
	}
	
	
	
}

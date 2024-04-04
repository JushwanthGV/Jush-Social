package com.jush.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jush.models.Message;
import com.jush.models.User;
import com.jush.service.MessageService;
import com.jush.service.UserService;

@RestController
public class CreateMessage {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/api/messages/chat/{chatid}")
	public Message createMessage(@RequestBody Message req,
			@RequestHeader("Authorization")String jwt,
			@PathVariable Integer chatid) throws Exception {
		
		User user=userService.findUserByJwt(jwt);
		Message message=messageService.createMessage(user, chatid, req);
		
		return message;
		
	}
	
	
	@GetMapping("/api/messages/chat/{chatid}")
	public List<Message> findChatsMessage(
			@RequestHeader("Authorization")String jwt,
			@PathVariable Integer chatid) throws Exception {
		
		User user=userService.findUserByJwt(jwt);
		List<Message> messages=messageService.findChatsMessages(chatid);
		
		
		return messages;
		
	}
	
	
	
}

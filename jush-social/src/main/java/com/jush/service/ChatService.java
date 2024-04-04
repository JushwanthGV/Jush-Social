package com.jush.service;

import java.util.List;

import com.jush.models.Chat;
import com.jush.models.User;

public interface ChatService {
	
	public Chat createChat(User reqUser,User user2);
	
	
	public Chat findChatById(Integer chatid) throws Exception;
	
	
	public List<Chat> findUsersChat(Integer userid);
	
}

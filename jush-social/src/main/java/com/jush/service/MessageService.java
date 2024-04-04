package com.jush.service;

import java.util.List;

import com.jush.models.Chat;
import com.jush.models.Message;
import com.jush.models.User;

public interface MessageService {

	public Message createMessage(User user,Integer chatid,Message req) throws Exception;
	
	public List<Message> findChatsMessages(Integer chatid) throws Exception;
	
	
	
}

package com.jush.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.Chat;
import com.jush.models.Message;
import com.jush.models.User;
import com.jush.repository.ChatRepository;
import com.jush.repository.MessageRepository;

@Service
public class MessageServiceImplementation implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ChatService chatService;
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public Message createMessage(User user,Integer chatid,Message req) throws Exception {
		
		Chat chat=chatService.findChatById(chatid);
		Message message=new Message();
		
		message.setChat(chat);
		message.setContent(req.getContent());
		message.setImage(req.getImage());
		message.setUser(user);
		message.setTimestamp(LocalDateTime.now());
		Message savedMessage=messageRepository.save(message);
		
		chat.getMessages().add(savedMessage);
		chatRepository.save(chat);
		
		return savedMessage;
	}

	@Override
	public List<Message> findChatsMessages(Integer chatid) throws Exception {
		Chat chat=chatService.findChatById(chatid);
		
		
		return messageRepository.findByChatId(chatid);
	}

}

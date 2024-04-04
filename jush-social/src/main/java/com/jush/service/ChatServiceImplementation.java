package com.jush.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jush.models.Chat;
import com.jush.models.User;
import com.jush.repository.ChatRepository;

@Service
public class ChatServiceImplementation implements ChatService {

	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Chat createChat(User reqUser, User user2) {
		
		Chat isExist=chatRepository.findChatByUsersId(user2, reqUser);
		
		if (isExist!=null) {
			
			return isExist;
		}
		Chat chat=new Chat();
		chat.getUsers().add(user2);
		chat.getUsers().add(reqUser);
		chat.setTimestamp(LocalDateTime.now());
		return chatRepository.save(chat);
		
	}

	@Override
	public Chat findChatById(Integer chatid) throws Exception {
		Optional<Chat> opt=chatRepository.findById(chatid);
		
		if (opt.isEmpty()) {
			throw new Exception("chat is not found with the id : "+chatid);
			
		}
		
		return opt.get();
	}
  
	@Override
	public List<Chat> findUsersChat(Integer userid) {
		// TODO Auto-generated method stub
		return chatRepository.findByUsersId(userid);
	}

}

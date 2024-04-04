package com.jush.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jush.models.Chat;
import com.jush.models.User;
import com.jush.service.UserService;

public interface ChatRepository extends JpaRepository<Chat, Integer>{
	
	public List<Chat> findByUsersId(Integer userdid);
	
	@Query("SELECT c FROM Chat c WHERE :user MEMBER OF c.users AND :reqUser MEMBER OF c.users")
	public Chat findChatByUsersId(@Param("user") User user ,@Param("reqUser") User reqUser); 

}

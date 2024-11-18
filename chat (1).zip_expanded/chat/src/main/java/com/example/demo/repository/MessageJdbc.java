package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.relational.core.query.Update;

import com.example.demo.model.Entity.Message;

public interface MessageJdbc {
	//新增訊息
	int addMessage(Message message);
	
	//多筆: 查詢所有訊息
	List<Message> findMessage();
	
	//單筆:查詢傳送者所有訊息
	Optional<Message> findMessageSendById(Integer sendUserId,Integer ReceiveId);
	
	//單筆:查詢接收者所有訊息
	Optional<Message> findMessageReceiveById(Integer ReceiveId,Integer sendUserId);
}

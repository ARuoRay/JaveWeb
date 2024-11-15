package com.example.controller;


import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Message;
import com.example.repository.MessageRepository;

@RestController
@RequestMapping("/api")
public class ChatController {
	 
	 @Autowired
	 private MessageRepository messageRepository;
	 
	 @GetMapping
	 public List<Message>getAllMessages(){
		 return messageRepository.findAll();
	 }
	 
	 
	 //發送
	 @PostMapping("/messages")
	 public Message sendMessage(@RequestBody Message message) {
		 String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		 message.setTimestamp(timestamp);
		 return messageRepository.save(message);
	 }
	 
	
}

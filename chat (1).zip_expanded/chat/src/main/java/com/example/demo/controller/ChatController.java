package com.example.demo.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Entity.Message;

@Controller
public class ChatController {

	@GetMapping("/chat")
	public String getChatPage(Model model) {
		return "chat";
	}

	@MessageMapping("/sendMessage")
	@SendTo("/topic/messages")
	public Message sendMessage(Message message) {
		message.setUpdateTime(new Date());
		return message;
	}
}

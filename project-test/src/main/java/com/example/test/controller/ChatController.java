package com.example.test.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.test.model.ChatMessage;

import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    // 處理來自客戶端的消息，並將其轉發給訂閱的用戶
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(@Payload ChatMessage chatMessage) {
    	System.out.println("Received message: " + chatMessage.getContent());
    	return chatMessage;
    }
}

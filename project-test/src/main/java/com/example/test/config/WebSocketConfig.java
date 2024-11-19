package com.example.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 配置消息代理，指定前綴 "/topic" 為客戶端訂閱
        config.enableSimpleBroker("/topic");
        // 配置應用目的地前綴 "/app"，處理來自前端的消息
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 註冊 WebSocket 端點，並允許跨域訪問
        registry.addEndpoint("/chat").setAllowedOriginPatterns("*").withSockJS();
    }
}

package com.cjw.config;

import com.cjw.webSocket.WebSocketChatHandler;
import com.cjw.interceptor.WebSocketInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Value("${webSocket.url}")
    private String webSocketUrl;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketChatHandler(), webSocketUrl)
                .addInterceptors(new WebSocketInterceptor()).setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler webSocketChatHandler() {
        return new WebSocketChatHandler();
    }
}



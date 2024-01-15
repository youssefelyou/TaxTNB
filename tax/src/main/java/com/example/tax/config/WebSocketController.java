package com.example.tax.config;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketMessage;

@Controller
public class WebSocketController {

    @MessageMapping("/send/message")
    @SendTo("/topic/messages")
    public WebSocketMessage sendMessage(WebSocketMessage message) {
        return message;
    }
}


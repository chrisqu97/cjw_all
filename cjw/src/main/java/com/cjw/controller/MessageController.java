package com.cjw.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
//    @Autowired
//    SimpMessagingTemplate messagingTemplate;
//
//    @MessageMapping("/ws/chat")
//    public void chatHandle(String msg) {
//        String accepter = msg.substring(msg.lastIndexOf(";") + 1, msg.length());
//        String message = msg.substring(0, msg.lastIndexOf(";"));
//
//        MessagePojo messagePojo=new MessagePojo();
//        messagePojo.setContent(message);
//        messagingTemplate.convertAndSendToUser(accepter, "/queue/chat", messagePojo);
//
//    }

}

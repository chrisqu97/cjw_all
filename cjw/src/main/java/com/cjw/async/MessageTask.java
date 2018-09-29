package com.cjw.async;

import com.cjw.pojo.MessagePojo;
import com.cjw.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 消息的异步执行
 */
@Component
public class MessageTask {
    @Autowired
    private MessageService messageService;

    /**
     * 异步添加消息
     */
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void addMessage(MessagePojo messagePojo) {
        System.out.println("start：" + System.currentTimeMillis());
        messageService.add(messagePojo);
        System.out.println("end：" + System.currentTimeMillis());
    }
}

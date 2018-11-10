package com.cjw.async;

import com.alibaba.fastjson.JSON;
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
        messageService.add(messagePojo);
    }

    /**
     * 转换消息
     * 格式：{"userId":xxx,"accepterId":xxx,"content":"xxxx","positionId":xxx}
     *
     * @param message
     * @return
     */
    public MessagePojo convertToMessagePojo(String message) {
        MessagePojo messagePojo = JSON.parseObject(message, MessagePojo.class);
        messagePojo.setCreateTime(System.currentTimeMillis());
        messagePojo.setIfRead(1);
        return messagePojo;
    }

}

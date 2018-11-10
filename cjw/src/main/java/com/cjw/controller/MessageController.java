package com.cjw.controller;

import com.cjw.async.MessageTask;
import com.cjw.pojo.MessagePojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.MessageService;
import com.cjw.utils.DateUtils;
import com.sun.tools.javadoc.Start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/Message")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageTask messageTask;

    /**
     * 测试异步执行
     * @return
     */
    @RequestMapping(value = "/addMessageTask", method = RequestMethod.GET)
    public ResultPojo addMessageTask() {
        ResultPojo resultPojo = new ResultPojo();

        System.out.println("start");

        MessagePojo messagePojo = new MessagePojo();
        messagePojo.setPositionId(1);
        messagePojo.setUserId(1);
        messagePojo.setAccepterId(1);

        messagePojo.setContent(System.currentTimeMillis() + "");
        messagePojo.setCreateTime(System.currentTimeMillis());
        messageTask.addMessage(messagePojo);

        System.out.println("end");

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加成功");
        return resultPojo;
    }

}

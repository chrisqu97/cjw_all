package com.cjw.controller;

import com.cjw.async.MessageTask;
import com.cjw.pojo.MessagePojo;
import com.cjw.pojo.MessageSearchPojo;
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
     *
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


    /**
     * 获取聊天记录
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByUserIdAndPositionId", method = RequestMethod.POST)
    public ResultPojo findByUserIdAndPositionId(MessageSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();
        if (searchPojo.getUserId() == null) {
            resultPojo.setMessage("用户id为空");
            return resultPojo;
        }
        if (searchPojo.getPositionId() == null) {
            resultPojo.setMessage("职位id为空");
            return resultPojo;
        }

        searchPojo = messageService.findByUserIdAndPositionId(searchPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("获取聊天记录成功");
        resultPojo.setData(searchPojo);
        return resultPojo;
    }
}

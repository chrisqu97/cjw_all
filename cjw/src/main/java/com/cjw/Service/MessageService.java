package com.cjw.service;

import com.cjw.common.Constant;
import com.cjw.dao.MessageDao;
import com.cjw.dao.entity.Message;
import com.cjw.pojo.MessagePojo;
import com.cjw.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public MessagePojo add(MessagePojo messagePojo) {
        Message message = new Message();
        message.setUserId(message.getUserId());
        message.setAccepterId(messagePojo.getAccepterId());
        message.setPositionId(messagePojo.getPositionId());
        message.setContent(messagePojo.getContent());
        try {
            SimpleDateFormat simpleDateFormat = DateUtils.getDateTimeFormat();
            message.setCreateTime(simpleDateFormat.parse(messagePojo.getCreateTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        message.setIfRead(Constant.STATE.VALUE);
        message.setState(Constant.STATE.VALUE);

        messageDao.add(message);
        return messagePojo;
    }
}

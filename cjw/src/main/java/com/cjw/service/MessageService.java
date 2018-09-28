package com.cjw.service;

import com.cjw.common.Constant;
import com.cjw.dao.MessageDao;
import com.cjw.dao.entity.Message;
import com.cjw.pojo.MessagePojo;
import com.cjw.pojo.MessageSearchPojo;
import com.cjw.utils.CollectionUtils;
import com.cjw.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public MessageSearchPojo findByPositionId(MessageSearchPojo searchPojo) {
        PageHelper.startPage(searchPojo.getPageNum(), searchPojo.getPageSize());
        List<Message> messages = messageDao.findByPositionId(searchPojo.getPositionId(), searchPojo.getUserId());
        if (CollectionUtils.isNotEmpty(messages)) {
            PageInfo pageInfo = new PageInfo(messages, searchPojo.getPageSize());
            List<MessagePojo> messagePojos = new ArrayList<>();
            for (Message message : messages) {
                MessagePojo messagePojo = new MessagePojo();
                messagePojo.setMessageId(message.getMessageId());
                messagePojo.setUserId(message.getUserId());
                messagePojo.setAccepterId(message.getAccepterId());
                messagePojo.setContent(message.getContent());
                messagePojo.setPositionId(message.getPositionId());
                try {
                    SimpleDateFormat simpleDateFormat = DateUtils.getDateTimeFormat();
                    messagePojo.setCreateTime(simpleDateFormat.format(message.getCreateTime()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                messagePojo.setIfRead(message.getIfRead());
                messagePojos.add(messagePojo);
            }
            searchPojo.setTotalPage(pageInfo.getPages());
            searchPojo.setTotalCount((int) pageInfo.getTotal());
            searchPojo.setMessagePojos(messagePojos);
        }
        return searchPojo;
    }
}

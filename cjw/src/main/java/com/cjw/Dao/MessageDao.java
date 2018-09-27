package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.Message;
import com.cjw.dao.entity.MessageExample;
import com.cjw.dao.mapper.MessageMapper;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDao {
    @Autowired
    private MessageMapper messageMapper;

    public Message add(Message message) {
        messageMapper.insert(message);
        return message;
    }

    public Message findById(Integer id) {
        MessageExample example = new MessageExample();
        example.createCriteria()
                .andMessageIdEqualTo(id)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<Message> messages = messageMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(messages)) {
            return messages.get(0);
        }
        return null;
    }

    public List<Message> findByAcceptId(Integer accepterId, Integer positionId) {
        MessageExample example = new MessageExample();
        example.createCriteria()
                .andAccepterIdEqualTo(accepterId)
                .andPositionIdEqualTo(positionId)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<Message> messages = messageMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(messages)) {
            return messages;
        }
        return null;
    }

    public List<Message> findByUserId(Integer userId, Integer positionId) {
        MessageExample example = new MessageExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andPositionIdEqualTo(positionId)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<Message> messages = messageMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(messages)) {
            return messages;
        }
        return null;
    }

    public List<Message> findForNotRead(Integer accepterId) {
        MessageExample example = new MessageExample();
        example.createCriteria()
                .andAccepterIdEqualTo(accepterId)
                .andIfReadEqualTo(Constant.STATE.VALUE)
                .andStateEqualTo(Constant.STATE.VALUE);
        List<Message> messages = messageMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(messages)) {
            return messages;
        }
        return null;
    }
}

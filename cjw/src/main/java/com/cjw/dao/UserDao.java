package com.cjw.dao;

import com.cjw.dao.entity.User;
import com.cjw.dao.entity.UserExample;
import com.cjw.dao.mapper.UserMapper;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public User add(User user) {
        userMapper.insert(user);
        return user;
    }

    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    public User findById(Integer id) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andUserIdEqualTo(id);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    public User findByOpenId(String openId) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    public List<User> findAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(users)) {
            return users;
        }
        return null;
    }

    public Integer countAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        return userMapper.countByExample(example);
    }

    public int ifExistUser(Integer userId, String sessionKey) {
        return userMapper.ifExistUser(userId, sessionKey);
    }
}

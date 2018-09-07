package com.cjw.Dao;

import com.cjw.Dao.Entity.User;
import com.cjw.Dao.Entity.UserExample;
import com.cjw.Dao.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    public User findByOpenId(String openId) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }
        return null;
    }

    public List<User> findAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> users = userMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(users)) {
            return users;
        }
        return null;
    }

    public Integer countAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        return userMapper.countByExample(example);
    }

}

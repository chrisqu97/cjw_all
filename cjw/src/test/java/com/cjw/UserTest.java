package com.cjw;

import com.cjw.dao.UserDao;
import com.cjw.dao.entity.User;
import com.cjw.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends TestBase{
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @Test
    public void fun(){
        System.out.println(userService.checkSessionKey(1,"FaMjT1vp0Yr/kzeOWX1lWA==?1537079194272"));
    }

    @Test
    public void fun1(){
        User byId = userDao.findById(1);
        System.out.println(byId);
    }
}

package com.cjw;

import com.cjw.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends TestBase{
    @Autowired
    private UserService userService;

    @Test
    public void fun(){
        System.out.println(userService.checkSessionKey(1,"FaMjT1vp0Yr/kzeOWX1lWA==?1537079194272"));
    }
}

package com.cjw.controller;

import com.cjw.auth.AuthUser;
import com.cjw.auth.CurrentUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test")
    public String test(@CurrentUser AuthUser user){
        System.out.println("currentUser:"+user.getUserId());
        return "test success";
    }
}

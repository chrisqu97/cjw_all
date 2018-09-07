package com.cjw.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        return "test success";
    }
}

package com.cjw.config;

import com.alibaba.fastjson.JSONObject;
import com.cjw.Service.UserService;
import com.cjw.Utils.HttpUtils;
import com.cjw.common.PermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户拦截器
 * 如果用户请求中没有userId和openId直接拦下
 * 如果openId与数据库中对不上也拦下
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpUtils httpUtils;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        JSONObject jsonData = httpUtils.getRequestJsonObject(httpServletRequest);
        if (jsonData.getInteger("userId") == null || jsonData.getString("openId") == null) {
            throw new PermissionException("userId or openId is empty");
        } else {
            if(userService.checkOpenId(jsonData.getInteger("userId"), jsonData.getString("openId"))){
                return true;
            }else{
                throw new PermissionException("permission check failed");
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

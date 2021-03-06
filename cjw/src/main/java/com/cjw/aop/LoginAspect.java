package com.cjw.aop;

import com.cjw.pojo.ResultPojo;
import com.cjw.pojo.SessionKeyPojo;
import com.cjw.service.UserService;
import com.cjw.utils.StringUtils;
import com.cjw.utils.WxUtiles;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chrisqu
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {
    @Autowired
    private UserService userService;
    @Autowired
    private WxUtiles wxUtiles;

    private static final String POINT = "!execution(* com.cjw.controller.UserController.login (..)) && execution(* com.cjw.controller.*.*(..)) ";

    /**
     * 校验权限
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Exception
     */
    @Around(POINT)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String sessionKey = request.getHeader("session_key");

        if (StringUtils.isNotEmpty(sessionKey)) {
            SessionKeyPojo sessionKeyPojo = wxUtiles.decodeSessionKey(sessionKey);
            if (sessionKeyPojo != null && userService.checkSessionKey(sessionKeyPojo.getUserId(), sessionKeyPojo.getSessionKey())) {
                try {
                    return proceedingJoinPoint.proceed();
                } catch (Throwable throwable) {
                    log.error(throwable.getMessage(), throwable);
                    ResultPojo resultPojo = new ResultPojo();
                    resultPojo.setMessage(throwable.getMessage());
                    return resultPojo;
                }
            } else {
                ResultPojo resultPojo = new ResultPojo();
                resultPojo.setMessage("permission check failed");
                return resultPojo;
            }
        } else {
            ResultPojo resultPojo = new ResultPojo();
            resultPojo.setMessage("session_key is empty");
            return resultPojo;
        }
    }

}

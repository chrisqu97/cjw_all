package com.cjw.config;

import com.cjw.pojo.ResultPojo;
import com.cjw.pojo.SessionKeyPojo;
import com.cjw.service.UserService;
import com.cjw.Utils.AESUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chrisqu
 */
@Aspect
@Component
public class LoginAspect {
    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass());

    private static final String POINT = "!execution(* com.cjw.Controller.UserController.login (..)) && execution(* com.cjw.Controller.*.*(..)) ";

    /**
     * 校验权限
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Exception
     */
    @Around(POINT)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String sessionKey = request.getHeader("session_key");

        if (!StringUtils.isEmpty(sessionKey)) {
            SessionKeyPojo sessionKeyPojo = decodeSessionKey(sessionKey);
            if (sessionKeyPojo != null && userService.checkSessionKey(sessionKeyPojo.getUserId(), sessionKeyPojo.getSessionKey())) {
                try {
                    Object result = proceedingJoinPoint.proceed();
                    return result;
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
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
        return null;
    }


    public SessionKeyPojo decodeSessionKey(String sessionKey) {
        try {
            String[] split = AESUtils.decrypt(sessionKey).split("&");
            SessionKeyPojo sessionKeyPojo = new SessionKeyPojo();
            sessionKeyPojo.setUserId(Integer.parseInt(split[0]));
            sessionKeyPojo.setSessionKey(split[1]);
            return sessionKeyPojo;
        } catch (Exception e) {
            return null;
        }

    }
}

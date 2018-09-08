package com.cjw.config;

import com.cjw.Pojo.BasePojo;
import com.cjw.Pojo.ResultPojo;
import com.cjw.Service.UserService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoginAspect {
    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass());
    private final String ExpGetResultDataPonit = "!execution(* com.cjw.Controller.UserController.login (..)) && execution(* com.cjw.Controller.*.*(..)) ";

    /**
     * 校验权限
     * @param proceedingJoinPoint
     * @return
     * @throws Exception
     */
    @Around(ExpGetResultDataPonit)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
        Object[] obj = proceedingJoinPoint.getArgs();
        for (Object argItem : obj) {
            if (argItem instanceof BasePojo) {
                BasePojo basePojo = (BasePojo) argItem;
                if (basePojo.getUserId() != null && basePojo.getOpenId() != null && userService.checkOpenId(basePojo.getUserId(), basePojo.getOpenId())) {
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
            }
        }

        return null;
    }


}

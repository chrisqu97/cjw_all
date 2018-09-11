package com.cjw.Controller;

import com.cjw.Pojo.ResultPojo;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static Logger logger = LogManager.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultPojo errorHandler(HttpServletRequest request, Exception e) throws Exception {
        ResultPojo resultPojo=new ResultPojo();
        resultPojo.setMessage(e.getMessage());
        logger.trace(e.getMessage());
        return resultPojo;
    }

}

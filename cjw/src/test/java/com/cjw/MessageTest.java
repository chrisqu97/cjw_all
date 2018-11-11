package com.cjw;

import com.cjw.async.MessageTask;
import com.cjw.pojo.MessagePojo;
import com.cjw.service.MessageService;
import com.cjw.utils.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MessageTest extends TestBase {
    @Autowired
    private MessageTask messageTask;
    @Autowired
    private MessageService messageService;

    @Test
    public void fun() {
        Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
        //ca.setTime(new Date()); // 设置时间为当前时间
        ca.set(2011, 11, 1);// 月份是从0开始的，所以11表示12月
//        ca.add(Calendar.YEAR, -1); // 年份减1
//        ca.add(Calendar.MONTH, -1);// 月份减1
        ca.add(Calendar.DATE, -1);// 日期减1
        Date resultDate = ca.getTime(); // 结果
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(resultDate));
    }

    @Test
    public void fun2() {
        MessagePojo messagePojo = new MessagePojo();
        messagePojo.setPositionId(1);
        messagePojo.setUserId(1);
        messagePojo.setAccepterId(1);

        SimpleDateFormat dateTimeFormat = DateUtils.getDateTimeFormat();
        messagePojo.setContent(System.currentTimeMillis() + "");
        messagePojo.setCreateTime(System.currentTimeMillis());
        messageService.add(messagePojo);
    }
}

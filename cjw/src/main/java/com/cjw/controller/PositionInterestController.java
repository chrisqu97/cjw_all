package com.cjw.controller;

import com.cjw.pojo.PositionInterestPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.PositionInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qucl
 * @date 2018/10/30 15:09
 * 用户对职位的兴趣程度
 */
@RestController
@RequestMapping("/PositionInterest")
public class PositionInterestController {
    @Autowired
    private PositionInterestService positionInterestService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultPojo add(@RequestBody PositionInterestPojo positionInterestPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (positionInterestPojo.getPositionId() == null) {
            resultPojo.setMessage("职位id为空");
            return resultPojo;
        }
        if (positionInterestPojo.getPreference() == null) {
            resultPojo.setMessage("偏好为空");
            return resultPojo;
        }

        positionInterestService.add(positionInterestPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加成功");
        return resultPojo;
    }

}

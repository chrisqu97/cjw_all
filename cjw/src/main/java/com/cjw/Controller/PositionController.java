package com.cjw.controller;

import com.cjw.Pojo.PositionPojo;
import com.cjw.Pojo.PositionSearchPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    /**
     * 根据id查找
     *
     * @param positionPojo
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public ResultPojo findById(@RequestBody PositionPojo positionPojo) {
        ResultPojo resultPojo = new ResultPojo();
        return resultPojo;
    }

    /**
     * 添加职位
     *
     * @param positionPojo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultPojo add(@RequestBody PositionPojo positionPojo) {
        ResultPojo resultPojo = new ResultPojo();
        return resultPojo;
    }

    /**
     * 条件查询
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByCondition", method = RequestMethod.POST)
    public ResultPojo findByCondition(@RequestBody PositionSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();
        return resultPojo;
    }
}

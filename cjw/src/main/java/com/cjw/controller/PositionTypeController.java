package com.cjw.controller;

import com.cjw.pojo.PositionTypePojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.PositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PositionType")
public class PositionTypeController {
    @Autowired
    private PositionTypeService positionTypeService;

    /**
     * 根据父节点id获取下一级的类型
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/findByParentId/{parentId}", method = RequestMethod.GET)
    public ResultPojo findByParentId(@PathVariable("parentId") Integer parentId) {
        ResultPojo resultPojo = new ResultPojo();

        List<PositionTypePojo> typePojos = positionTypeService.findByParentId(parentId);

        resultPojo.setSuccess(true);
        resultPojo.setData(typePojos);
        return resultPojo;
    }
}

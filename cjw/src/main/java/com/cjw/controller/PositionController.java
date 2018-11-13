package com.cjw.controller;

import com.cjw.pojo.PositionPojo;
import com.cjw.pojo.PositionSearchPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.PositionService;
import com.cjw.service.PositionTypeService;
import com.cjw.utils.CollectionUtils;
import com.cjw.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @Autowired
    private PositionTypeService positionTypeService;

    /**
     * 根据id查找
     *
     * @param positionPojo
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public ResultPojo findById(@RequestBody PositionPojo positionPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (positionPojo.getPositionId() == null) {
            resultPojo.setMessage("职位id为空");
            return resultPojo;
        }

        Map<String, String> all = positionTypeService.findAll();
        positionPojo = positionService.findById(positionPojo.getPositionId(), all);

        if (positionPojo == null) {
            resultPojo.setMessage("未查到该职位");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setData(positionPojo);
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

        if (positionPojo.getCompanyId() == null) {
            resultPojo.setMessage("公司id为空");
            return resultPojo;
        }
        if (positionPojo.getUserId() == null) {
            resultPojo.setMessage("用户id为空");
            return resultPojo;
        }

        positionPojo = positionService.add(positionPojo);

        resultPojo.setSuccess(true);
        resultPojo.setData(positionPojo);
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


    /**
     * 根据公司id查找
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByCompanyId", method = RequestMethod.POST)
    public ResultPojo findByCompanyId(@RequestBody PositionSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (searchPojo.getCompanyId() == null) {
            resultPojo.setMessage("公司id为空");
            return resultPojo;
        }

        searchPojo = positionService.findByCompanyId(searchPojo);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);
        return resultPojo;
    }

    /**
     * 根据职位名称查询
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByPositionName", method = RequestMethod.POST)
    public ResultPojo findByPositionName(@RequestBody PositionSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (searchPojo.getPositionName() == null) {
            resultPojo.setMessage("职位名称为空");
            return resultPojo;
        }

        searchPojo = positionService.findByPositionName(searchPojo);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);
        return resultPojo;
    }

    /**
     * 模糊匹配获取职位名称
     *
     * @param positionName
     * @return
     */
    @RequestMapping(value = "/getPositionName", method = RequestMethod.GET)
    public ResultPojo getPositionName(@RequestParam String positionName) {
        ResultPojo resultPojo = new ResultPojo();

        if (StringUtils.isEmpty(positionName)) {
            resultPojo.setMessage("职位名称为空");
            return resultPojo;
        }

        List<String> list = positionService.getPositionName(positionName);

        resultPojo.setSuccess(true);
        resultPojo.setData(list);
        return resultPojo;
    }

    /**
     * 根据职位id列表获取
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByPositionIds", method = RequestMethod.POST)
    public ResultPojo findByPositionIds(@RequestBody PositionSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (CollectionUtils.isEmpty(searchPojo.getPositionIds())) {
            resultPojo.setMessage("职位id列表为空");
            return resultPojo;
        }

        searchPojo = positionService.findByPositionIds(searchPojo);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);
        return resultPojo;
    }

    /**
     * 随机查找职位
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByRandom", method = RequestMethod.POST)
    public ResultPojo findByRandom(@RequestBody PositionSearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();

        searchPojo = positionService.findByRandom(searchPojo);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);
        return resultPojo;
    }
}

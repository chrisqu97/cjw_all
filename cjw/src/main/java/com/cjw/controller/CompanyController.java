package com.cjw.controller;

import com.cjw.pojo.CompanyPojo;
import com.cjw.pojo.CompanySearchPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.service.CompanyService;
import com.cjw.service.StaticDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private StaticDataService staticDataService;

    /**
     * 通过条件查询
     *
     * @param searchPojo
     * @return
     */
    @RequestMapping(value = "/findByCondition", method = RequestMethod.POST)
    public ResultPojo findByCondition(@RequestBody CompanySearchPojo searchPojo) {
        ResultPojo resultPojo = new ResultPojo();

        Map<String, String> map = staticDataService.findByTypeCode("COMPANY_TYPE");
        searchPojo = companyService.findByCondition(searchPojo, map);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);

        return resultPojo;
    }

    /**
     * 根据id查询
     *
     * @param companyPojo
     * @return
     */
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public ResultPojo findById(@RequestBody CompanyPojo companyPojo) {
        ResultPojo resultPojo = new ResultPojo();

        Map<String, String> map = staticDataService.findByTypeCode("COMPANY_TYPE");
        companyPojo = companyService.findById(companyPojo.getCompanyId(), map);

        if (companyPojo == null) {
            resultPojo.setMessage("不存在该id的公司");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setData(companyPojo);
        return resultPojo;
    }

    /**
     * 获取公司类型
     *
     * @return
     */
    @RequestMapping(value = "/getCompanyType", method = RequestMethod.GET)
    public ResultPojo getCompanyType() {
        ResultPojo resultPojo = new ResultPojo();

        Map<String, String> company_type = staticDataService.findByTypeCode("COMPANY_TYPE");

        resultPojo.setSuccess(true);
        resultPojo.setMessage("获取公司类型成功");
        resultPojo.setData(company_type);
        return resultPojo;
    }

    /**
     * 添加公司
     *
     * @param companyPojo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultPojo add(@RequestBody CompanyPojo companyPojo) {
        ResultPojo resultPojo = new ResultPojo();

        companyService.add(companyPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加公司成功");
        return resultPojo;
    }

}

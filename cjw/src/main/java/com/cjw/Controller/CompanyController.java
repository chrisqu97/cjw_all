package com.cjw.Controller;

import com.cjw.Pojo.CompanySearchPojo;
import com.cjw.Pojo.ResultPojo;
import com.cjw.Service.CompanyService;
import com.cjw.Service.StaticDataService;
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

        Map<String,String> map=staticDataService.findByTypeCode("COMPANY_TYPE");
        searchPojo = companyService.findByCondition(searchPojo,map);

        resultPojo.setSuccess(true);
        resultPojo.setData(searchPojo);
        return resultPojo;
    }



}

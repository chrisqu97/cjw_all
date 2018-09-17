package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.cjw.dao.CompanyDao;
import com.cjw.dao.entity.Company;
import com.cjw.pojo.CompanyPojo;
import com.cjw.pojo.CompanySearchPojo;
import com.cjw.pojo.PlacePojo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public CompanySearchPojo findByCondition(CompanySearchPojo searchPojo, Map<String, String> companyType) {
        PageHelper.startPage(searchPojo.getPageNum(), searchPojo.getPageSize());
        List<Company> companies = companyDao.findByCondition(searchPojo);
        List<CompanyPojo> companyPojos = new ArrayList<>();
        if (!CollectionUtils.isEmpty(companies)) {
            PageInfo pageInfo = new PageInfo(companies, searchPojo.getPageSize());
            for (Company company : companies) {
                CompanyPojo companyPojo = new CompanyPojo();
                if (company.getArea() != null) {
                    companyPojo.setPlacePojo(JSON.parseObject(company.getArea(), PlacePojo.class));
                }
                if (company.getSize() != null) {
                    companyPojo.setSize(company.getSize());
                }
                if (company.getCompanyType() != null) {
                    companyPojo.setCompanyType(company.getCompanyType());
                    companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType() + ""));
                }
                companyPojos.add(companyPojo);
            }
            searchPojo.setTotalCount((int) pageInfo.getTotal());
            searchPojo.setTotalPage(pageInfo.getPages());
        }
        searchPojo.setCompanyPojos(companyPojos);
        return searchPojo;
    }
}

package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.cjw.common.Constant;
import com.cjw.dao.CompanyDao;
import com.cjw.dao.entity.Company;
import com.cjw.pojo.CompanyPojo;
import com.cjw.pojo.CompanySearchPojo;
import com.cjw.utils.CollectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (CollectionUtils.isNotEmpty(companies)) {
            List<CompanyPojo> companyPojos = new ArrayList<>();
            PageInfo pageInfo = new PageInfo<>(companies, searchPojo.getPageSize());
            for (Company company : companies) {
                CompanyPojo companyPojo = new CompanyPojo();
                companyPojo.setCompanyId(company.getCompanyId());
                companyPojo.setCompanyName(company.getCompanyName());
                companyPojo.setSize(company.getSize());
                if (company.getPlace() != null) {
                    companyPojo.setPlace(JSON.parseArray(company.getPlace(), String.class));
                }
                if (company.getCompanyType() != null) {
                    companyPojo.setCompanyType(company.getCompanyType());
                    companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType() + ""));
                }
                companyPojos.add(companyPojo);
            }
            searchPojo.setTotalCount((int) pageInfo.getTotal());
            searchPojo.setTotalPage(pageInfo.getPages());
            searchPojo.setCompanyPojos(companyPojos);
        }

        return searchPojo;
    }

    public CompanyPojo findById(Integer id, Map<String, String> companyType) {
        Company company = companyDao.findById(id);
        if (company != null) {
            CompanyPojo companyPojo = new CompanyPojo();
            companyPojo.setCompanyId(company.getCompanyId());
            companyPojo.setCompanyName(company.getCompanyName());
            companyPojo.setCompanyType(company.getCompanyType());
            companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType() + ""));
            companyPojo.setSize(company.getSize());
            companyPojo.setPlace(JSON.parseArray(company.getPlace(), String.class));
            return companyPojo;
        } else {
            return null;
        }
    }

    public CompanyPojo add(CompanyPojo companyPojo) {
        Company company = new Company();
        company.setCompanyName(companyPojo.getCompanyName());
        company.setCompanyType(companyPojo.getCompanyType());
        company.setSize(companyPojo.getSize());
        company.setState(Constant.STATE.VALUE);
        company.setPlace(JSON.toJSONString(companyPojo.getPlace()));
        company.setState(Constant.STATE.VALUE);
        companyDao.add(company);
        return companyPojo;
    }
}

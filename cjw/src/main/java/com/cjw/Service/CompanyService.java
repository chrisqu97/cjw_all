package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.cjw.common.Constant;
import com.cjw.dao.CompanyDao;
import com.cjw.dao.entity.Company;
import com.cjw.pojo.CompanyPojo;
import com.cjw.pojo.CompanySearchPojo;
import com.cjw.pojo.PlacePojo;
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
        List<CompanyPojo> companyPojos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(companies)) {
            PageInfo pageInfo = new PageInfo(companies, searchPojo.getPageSize());
            for (Company company : companies) {
                CompanyPojo companyPojo = new CompanyPojo();
                if (company.getPlace() != null) {
                    PlacePojo placePojo = JSON.parseObject(company.getPlace(), PlacePojo.class);
                    companyPojo.setPlace(new ArrayList<>());
                    companyPojo.getPlace().add(placePojo.getProvince());
                    companyPojo.getPlace().add(placePojo.getCity());
                    companyPojo.getPlace().add(placePojo.getArea());
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

    public CompanyPojo findById(Integer id, Map<String, String> companyType) {
        Company company = companyDao.findById(id);
        if (company != null) {
            CompanyPojo companyPojo = new CompanyPojo();
            companyPojo.setCompanyId(company.getCompanyId());
            companyPojo.setCompanyName(company.getCompanyName());
            companyPojo.setCompanyType(company.getCompanyType());
            companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType() + ""));
            companyPojo.setSize(company.getSize());
            PlacePojo placePojo = JSON.parseObject(company.getPlace(), PlacePojo.class);
            companyPojo.setPlace(new ArrayList<>());
            companyPojo.getPlace().add(placePojo.getProvince());
            companyPojo.getPlace().add(placePojo.getCity());
            companyPojo.getPlace().add(placePojo.getArea());
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
        PlacePojo placePojo = new PlacePojo();
        placePojo.setProvince(companyPojo.getPlace().get(0));
        placePojo.setCity(companyPojo.getPlace().get(1));
        placePojo.setArea(companyPojo.getPlace().get(2));
        company.setPlace(JSON.toJSONString(placePojo));
        companyDao.add(company);
        return companyPojo;
    }
}

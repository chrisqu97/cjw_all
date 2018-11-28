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

    public CompanySearchPojo findByCondition(CompanySearchPojo searchPojo, Map<String, String> companyType, Map<String, String> companySize) {
        List<CompanyPojo> companyPojos = new ArrayList<>();
        PageHelper.startPage(searchPojo.getPageNum(), searchPojo.getPageSize());
        List<Company> companies = companyDao.findByCondition(searchPojo);

        if (CollectionUtils.isNotEmpty(companies)) {
            PageInfo pageInfo = new PageInfo<>(companies, searchPojo.getPageSize());
            for (Company company : companies) {
                CompanyPojo companyPojo = new CompanyPojo();
                companyPojo.setCompanyId(company.getCompanyId());
                companyPojo.setCompanyName(company.getCompanyName());
                companyPojo.setSize(company.getSize());
                companyPojo.setSizeName(companySize.get(company.getSize() + ""));
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
        searchPojo.setCompanyPojos(companyPojos);
        return searchPojo;
    }

    public CompanyPojo findById(Integer id, Map<String, String> companyType, Map<String, String> companySize) {
        Company company = companyDao.findById(id);
        if (company != null) {
            CompanyPojo companyPojo = new CompanyPojo();
            companyPojo.setCompanyId(company.getCompanyId());
            companyPojo.setCompanyName(company.getCompanyName());
            companyPojo.setDescription(company.getDescription());
            companyPojo.setCompanyType(company.getCompanyType());
            companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType() + ""));
            companyPojo.setSize(company.getSize());
            companyPojo.setSizeName(companySize.get(company.getSize() + ""));
            companyPojo.setLinkMan(company.getLinkMan());
            companyPojo.setPhone(company.getPhone());
            companyPojo.setEmail(company.getEmail());
            companyPojo.setPlace(JSON.parseArray(company.getPlace(), String.class));
            companyPojo.setDetailPlace(company.getDetailPlace());
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
        company.setState(Constant.State.VALUE);
        company.setPlace(JSON.toJSONString(companyPojo.getPlace()));
        companyDao.add(company);
        return companyPojo;
    }
}

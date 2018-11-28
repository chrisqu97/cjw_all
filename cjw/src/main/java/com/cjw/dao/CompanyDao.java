package com.cjw.dao;

import com.cjw.common.Constant;
import com.cjw.dao.entity.Company;
import com.cjw.dao.entity.CompanyExample;
import com.cjw.dao.mapper.CompanyMapper;
import com.cjw.pojo.CompanySearchPojo;
import com.cjw.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CompanyDao {
    @Autowired
    private CompanyMapper companyMapper;

    public Company add(Company company) {
        companyMapper.insert(company);
        return company;
    }

    public int update(Company company) {
        return companyMapper.updateByPrimaryKey(company);
    }

    public Company findById(Integer id) {
        CompanyExample example = new CompanyExample();
        example.createCriteria()
                .andCompanyIdEqualTo(id)
                .andStateEqualTo(Constant.State.VALUE);
        List<Company> companies = companyMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(companies)) {
            return companies.get(0);
        }
        return null;
    }

    public List<Company> findAll() {
        CompanyExample example = new CompanyExample();
        example.createCriteria().andStateEqualTo(Constant.State.VALUE);
        List<Company> companies = companyMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(companies)) {
            return companies;
        }
        return null;
    }

    public int countAll() {
        CompanyExample example = new CompanyExample();
        example.createCriteria().andStateEqualTo(Constant.State.VALUE);
        return companyMapper.countByExample(example);
    }

    public List<Company> findByCondition(CompanySearchPojo searchPojo) {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria().andStateEqualTo(Constant.State.VALUE);
        if(searchPojo.getSize()!=null){
            criteria.andSizeEqualTo(searchPojo.getSize());
        }
        if(searchPojo.getCompanyType()!=null){
            criteria.andCompanyTypeEqualTo(searchPojo.getCompanyType());
        }
        example.setOrderByClause("company_id desc");
        List<Company> companies = companyMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(companies)) {
            return companies;
        }
        return new ArrayList<>();
    }
}

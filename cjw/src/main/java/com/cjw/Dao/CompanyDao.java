package com.cjw.Dao;

import com.cjw.Dao.Entity.Company;
import com.cjw.Dao.Entity.CompanyExample;
import com.cjw.Dao.Mapper.CompanyMapper;
import com.cjw.Pojo.CompanySearchPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
                .andCompanyIdEqualTo(id);
        List<Company> companies = companyMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(companies)) {
            return companies.get(0);
        }
        return null;
    }

    public List<Company> findAll() {
        CompanyExample example = new CompanyExample();
        example.createCriteria();
        List<Company> companies = companyMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(companies)) {
            return companies;
        }
        return null;
    }

    public int countAll() {
        CompanyExample example = new CompanyExample();
        example.createCriteria();
        return companyMapper.countByExample(example);
    }

    public List<Company> findByCondition(CompanySearchPojo searchPojo) {
        CompanyExample example = new CompanyExample();
        example.createCriteria()
                .andSizeEqualTo(searchPojo.getSize())
                .andCompanyTypeEqualTo(searchPojo.getCompanyType());
        List<Company> companies = companyMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(companies)) {
            return companies;
        }
        return null;
    }
}

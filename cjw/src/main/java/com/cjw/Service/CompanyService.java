package com.cjw.Service;

import com.alibaba.fastjson.JSON;
import com.cjw.Dao.CompanyDao;
import com.cjw.Dao.Entity.Company;
import com.cjw.Pojo.CompanyPojo;
import com.cjw.Pojo.CompanySearchPojo;
import com.cjw.Pojo.PlacePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    @Autowired
    private CompanyDao companyDao;

    public CompanySearchPojo findByCondition(CompanySearchPojo searchPojo, Map<String,String> companyType){

        List<Company> companies = companyDao.findByCondition(searchPojo);
        List<CompanyPojo> companyPojos=new ArrayList<>();
        for(Company company :companies){
            CompanyPojo companyPojo=new CompanyPojo();
            if(company.getArea()!=null){
                companyPojo.setPlacePojo(JSON.parseObject(company.getArea(), PlacePojo.class));
            }
            if(company.getSize()!=null){
                companyPojo.setSize(company.getSize());
            }
            if(company.getCompanyType()!=null){
                companyPojo.setCompanyType(company.getCompanyType());
                companyPojo.setCompanyTypeName(companyType.get(company.getCompanyType()+""));
            }
            companyPojos.add(companyPojo);
        }
        searchPojo.setCompanyPojos(companyPojos);
        return searchPojo;
    }
}

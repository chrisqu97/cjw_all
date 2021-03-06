package com.cjw;


import com.cjw.dao.CompanyDao;
import com.cjw.dao.entity.Company;
import com.cjw.utils.WxUtiles;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CompanyTest extends TestBase {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private WxUtiles wxUtiles;

    @Test
    public void fun() {
        System.out.println("hello");
    }

    @Test
    public void fun2() {
        Company company = new Company();
        company.setCompanyName("test");
        companyDao.add(company);
        System.out.println(company);
    }

    @Test
    public void fun3() {
        Company company = companyDao.findById(1);
        System.out.println(company);
    }

    @Test
    public void fun4() {
        System.out.println(wxUtiles.createApiUrl("123456"));
    }

}

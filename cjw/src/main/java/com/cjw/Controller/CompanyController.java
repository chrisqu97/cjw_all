package com.cjw.Controller;

import com.cjw.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


}

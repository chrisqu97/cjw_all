package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompanyPojo {
    private Integer companyId;
    private String companyName;
    private Integer companyType;
    private String companyTypeName;
    private String size;
    private List<String> place;
}

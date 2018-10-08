package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompanyPojo {
    private Integer companyId;
    private String companyName;
    private Integer companyType;
    private String companyTypeName;
    private Integer size;
    private String sizeName;
    private List<String> place;
}

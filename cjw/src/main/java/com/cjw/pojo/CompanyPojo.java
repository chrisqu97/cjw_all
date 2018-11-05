package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompanyPojo {
    private Integer companyId;
    private String companyName;
    private String description;
    private Integer companyType;
    private String companyTypeName;
    private Integer size;
    private String sizeName;
    private String linkMan;
    private String phone;
    private List<String> place;
    private String detailPlace;
    private String email;
}

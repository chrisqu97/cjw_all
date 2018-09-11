package com.cjw.Pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompanySearchPojo {
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalCount;
    private Integer totalNum;
    private List<CompanyPojo> companyPojos;
    private String size;
    private Integer companyType;
}

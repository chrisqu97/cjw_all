package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class CompanySearchPojo {
    private Integer pageSize;
    private Integer pageNum;
    private Integer totalCount;
    private Integer totalPage;
    private List<CompanyPojo> companyPojos;
    private Integer size;
    private Integer companyType;
}

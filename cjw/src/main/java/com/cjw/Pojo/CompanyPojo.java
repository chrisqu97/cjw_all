package com.cjw.pojo;

import lombok.Data;

@Data
public class CompanyPojo {
    private Integer companyId;
    private String companyName;
    private Integer companyType;
    private String companyTypeName;
    private String size;
    private com.cjw.pojo.PlacePojo placePojo;
}

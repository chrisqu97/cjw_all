package com.cjw.Pojo;

import lombok.Data;

@Data
public class CompanyPojo {
    private Integer companyId;
    private String companyName;
    private Integer companyType;
    private String companyTypeName;
    private String size;
    private PlacePojo placePojo;
}

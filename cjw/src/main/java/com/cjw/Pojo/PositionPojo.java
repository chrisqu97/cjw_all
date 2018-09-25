package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PositionPojo {
    private Integer positionId;
    private String positionName;
    private Integer positionType;
    private String positionTypeName;
    private List<String> place;
    private String educationalRequirements;
    private String experienceRequirements;
    private String salary;
    private String description;
    private Integer companyId;
    private String companyName;
    private Integer userId;
    private String userName;
}

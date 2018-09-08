package com.cjw.Pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserPojo extends BasePojo{
    private String userName;
    private String birthday;
    private String phone;
    private Integer education;
    private List<WorkExperiencePojo> workExperiences;
    private List<ProjectExperiencePojo> projectExperiencePojos;
    private List<EducationalExperiencePojo> educationalExperiencePojos;
    private PlacePojo desiredWorkingPlace;
    private String myAdvantage;
    private JobIntensionPojo jobIntension;
}

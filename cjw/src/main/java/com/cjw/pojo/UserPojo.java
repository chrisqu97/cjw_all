package com.cjw.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserPojo {
    private Integer userId;
    private String userName;
    private String birthday;
    private String phone;
    private Integer education;
    private List<com.cjw.pojo.WorkExperiencePojo> workExperiences;
    private List<ProjectExperiencePojo> projectExperiences;
    private List<PracticeExperiencePojo> practiceExperiences;
    private List<EducationalExperiencePojo> educationalExperiences;
    private List<String> desiredWorkingPlace;
    private String myAdvantage;
    private JobIntensionPojo jobIntension;
}

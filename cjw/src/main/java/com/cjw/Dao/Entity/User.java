package com.cjw.Dao.Entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer userId;

    private Integer userType;

    private String userName;

    private String userEmail;

    private Integer gender;

    private Date joinWork;

    private Date birthday;

    private String openId;

    private String sessionKey;

    private String myAdvantage;

    private String myAnswer;

    private String practiceExperience;

    private String projectExperience;

    private String educationalExperience;

    private String jobIntension;

    private String userSetting;

    private Integer state;

    private Integer education;

    private String phone;

    private String desiredWorkingPlace;

    private String livingPlace;

    private String workExperience;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getJoinWork() {
        return joinWork;
    }

    public void setJoinWork(Date joinWork) {
        this.joinWork = joinWork;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    public String getMyAdvantage() {
        return myAdvantage;
    }

    public void setMyAdvantage(String myAdvantage) {
        this.myAdvantage = myAdvantage == null ? null : myAdvantage.trim();
    }

    public String getMyAnswer() {
        return myAnswer;
    }

    public void setMyAnswer(String myAnswer) {
        this.myAnswer = myAnswer == null ? null : myAnswer.trim();
    }

    public String getPracticeExperience() {
        return practiceExperience;
    }

    public void setPracticeExperience(String practiceExperience) {
        this.practiceExperience = practiceExperience == null ? null : practiceExperience.trim();
    }

    public String getProjectExperience() {
        return projectExperience;
    }

    public void setProjectExperience(String projectExperience) {
        this.projectExperience = projectExperience == null ? null : projectExperience.trim();
    }

    public String getEducationalExperience() {
        return educationalExperience;
    }

    public void setEducationalExperience(String educationalExperience) {
        this.educationalExperience = educationalExperience == null ? null : educationalExperience.trim();
    }

    public String getJobIntension() {
        return jobIntension;
    }

    public void setJobIntension(String jobIntension) {
        this.jobIntension = jobIntension == null ? null : jobIntension.trim();
    }

    public String getUserSetting() {
        return userSetting;
    }

    public void setUserSetting(String userSetting) {
        this.userSetting = userSetting == null ? null : userSetting.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDesiredWorkingPlace() {
        return desiredWorkingPlace;
    }

    public void setDesiredWorkingPlace(String desiredWorkingPlace) {
        this.desiredWorkingPlace = desiredWorkingPlace == null ? null : desiredWorkingPlace.trim();
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace == null ? null : livingPlace.trim();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience == null ? null : workExperience.trim();
    }
}
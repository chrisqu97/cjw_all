package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjw.common.Constant;
import com.cjw.common.EducationEnum;
import com.cjw.dao.UserDao;
import com.cjw.dao.entity.User;
import com.cjw.pojo.*;
import com.cjw.utils.AESUtils;
import com.cjw.utils.DateUtils;
import com.cjw.utils.StringUtils;
import com.cjw.utils.WxUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private WxUtiles wxUtils;
    @Autowired
    private RestTemplate restTemplate;

    public UserPojo update(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            try {
                if (StringUtils.isNotEmpty(userPojo.getBirthday())) {
                    SimpleDateFormat sf = DateUtils.getDateFormat();
                    user.setBirthday(sf.parse(userPojo.getBirthday()));
                }
                if (userPojo.getDesiredWorkingPlace() != null) {
                    user.setDesiredWorkingPlace(JSON.toJSONString(userPojo.getDesiredWorkingPlace()));
                }
                if (userPojo.getEducation() != null) {
                    user.setEducation(userPojo.getEducation());
                }
                if (StringUtils.isNotEmpty(userPojo.getMyAdvantage())) {
                    user.setMyAdvantage(userPojo.getMyAdvantage());
                }
                if (StringUtils.isNotEmpty(userPojo.getPhone())) {
                    user.setPhone(userPojo.getPhone());
                }
                if (StringUtils.isNotEmpty(userPojo.getUserName())) {
                    user.setUserName(userPojo.getUserName());
                }
                if (userPojo.getWorkExperiences() != null) {
                    user.setWorkExperience(JSON.toJSONString(userPojo.getWorkExperiences()));
                }
                userDao.update(user);
                return userPojo;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public UserPojo findByUserId(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());

        if (user != null) {
            userPojo = new UserPojo();
            userPojo.setUserId(user.getUserId());
            userPojo.setUserName(user.getUserName());
            userPojo.setPhone(user.getPhone());
            try {
                if (user.getBirthday() != null) {
                    SimpleDateFormat sf = DateUtils.getDateFormat();
                    userPojo.setBirthday(sf.format(user.getBirthday()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            userPojo.setEducation(user.getEducation());
            userPojo.setEducationName(getEducationName(userPojo.getEducation()));
            userPojo.setMyAdvantage(user.getMyAdvantage());
            if (StringUtils.isNotEmpty(user.getWorkExperience())) {
                userPojo.setWorkExperiences(JSONObject.parseArray(user.getWorkExperience(), WorkExperiencePojo.class));
            }
            if (StringUtils.isNotEmpty(user.getPracticeExperience())) {
                userPojo.setPracticeExperiences(JSONObject.parseArray(user.getPracticeExperience(), PracticeExperiencePojo.class));
            }
            if (StringUtils.isNotEmpty(user.getProjectExperience())) {
                userPojo.setProjectExperiences(JSONObject.parseArray(user.getProjectExperience(), ProjectExperiencePojo.class));
            }
            if (StringUtils.isNotEmpty(user.getEducationalExperience())) {
                userPojo.setEducationalExperiences(JSONArray.parseArray(user.getEducationalExperience(), EducationalExperiencePojo.class));
                userPojo.getEducationalExperiences().get(0).setEducationName(getEducationName(userPojo.getEducation()));
            }
            if (StringUtils.isNotEmpty(user.getDesiredWorkingPlace())) {
                userPojo.setDesiredWorkingPlace(JSON.parseObject(user.getDesiredWorkingPlace(), List.class));
            }
            if (StringUtils.isNotEmpty(user.getJobIntension())) {
                userPojo.setJobIntension(JSON.parseObject(user.getJobIntension(), JobIntensionPojo.class));
            }
        }
        return userPojo;
    }

    public UserPojo addWorkExperience(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setWorkExperience(JSON.toJSONString(userPojo.getWorkExperiences()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addProjectExperience(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setProjectExperience(JSON.toJSONString(userPojo.getProjectExperiences()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addPracticeExperience(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setPracticeExperience(JSON.toJSONString(userPojo.getPracticeExperiences()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addEducationalExperience(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setEducationalExperience(JSON.toJSONString(userPojo.getEducationalExperiences()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addMyAdvantage(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setMyAdvantage(userPojo.getMyAdvantage());
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addJobIntension(UserPojo userPojo) {
        User user = userDao.findById(userPojo.getUserId());
        if (user != null) {
            user.setJobIntension(JSON.toJSONString(userPojo.getJobIntension()));
            userDao.update(user);
        }
        return userPojo;
    }

    public SessionKeyPojo login(LoginPojo loginPojo) throws Exception {
        String apiUrl = wxUtils.createApiUrl(loginPojo.getCode());

        JSONObject jsonObject = JSON.parseObject(restTemplate.getForObject(apiUrl, String.class));

        String openId = jsonObject.getString("openid");
        if (openId == null) {
            throw new Exception("get api failed");
        }
        User user = userDao.findByOpenId(openId);
        String sessionKey = jsonObject.getString("session_key");

        if (user == null) {
            JSONObject userData = wxUtils.decodeBase64(loginPojo.getEncryptedData(), sessionKey, loginPojo.getIv());

            user = new User();
            user.setOpenId(openId);
            user.setSessionKey(sessionKey + "?" + System.currentTimeMillis());
            user.setUserName(userData.getString("nickName"));
            user.setGender(jsonObject.getInteger("gender"));
            PlacePojo placePojo = new PlacePojo();
            placePojo.setCountry(userData.getString("country"));
            placePojo.setProvince(userData.getString("province"));
            placePojo.setCity(userData.getString("city"));
            user.setLivingPlace(JSON.toJSONString(placePojo));
            user.setState(Constant.STATE.VALUE);

            userDao.add(user);
        } else {
            user.setSessionKey(sessionKey + "?" + System.currentTimeMillis());

            userDao.update(user);
        }
        SessionKeyPojo sessionKeyPojo = new SessionKeyPojo();
        sessionKeyPojo.setUserId(user.getUserId());
        sessionKeyPojo.setSessionKey(AESUtils.encrypt(user.getUserId() + "&" + user.getSessionKey()));

        return sessionKeyPojo;
    }

    /**
     * 校验openId
     *
     * @param userId
     * @param sessionKey
     * @return
     */
    public boolean checkSessionKey(Integer userId, String sessionKey) {
        int i = userDao.ifExistUser(userId, sessionKey);
        if (i == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String getEducationName(Integer education) {
        if (EducationEnum.SPECIALTY.getCode().equals(education)) {
            return EducationEnum.SPECIALTY.getValue();
        }
        if (EducationEnum.UNDER_GRADUATE.getCode().equals(education)) {
            return EducationEnum.UNDER_GRADUATE.getValue();
        }
        if (EducationEnum.POST_GRADUATE.getCode().equals(education)) {
            return EducationEnum.POST_GRADUATE.getValue();
        }
        if (EducationEnum.MASTER.getCode().equals(education)) {
            return EducationEnum.MASTER.getValue();
        }
        if (EducationEnum.DOCTOR.getCode().equals(education)) {
            return EducationEnum.DOCTOR.getValue();
        }
        if (EducationEnum.POST_DOCTOR.getCode().equals(education)) {
            return EducationEnum.POST_DOCTOR.getValue();
        }
        if (EducationEnum.OTHER.getCode().equals(education)) {
            return EducationEnum.OTHER.getValue();
        }
        return null;
    }
}

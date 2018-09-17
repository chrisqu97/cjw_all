package com.cjw.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cjw.dao.entity.User;
import com.cjw.dao.UserDao;
import com.cjw.pojo.*;
import com.cjw.Utils.AESUtils;
import com.cjw.Utils.WxUtiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

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
        if (user == null) {
            try {
                if (userPojo.getBirthday() != null) {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    user.setBirthday(sf.parse(userPojo.getBirthday()));
                }
                if (userPojo.getDesiredWorkingPlace() != null) {
                    user.setDesiredWorkingPlace(JSON.toJSONString(userPojo.getDesiredWorkingPlace()));
                }
                if (userPojo.getEducation() != null) {
                    user.setEducation(userPojo.getEducation());
                }
                if (userPojo.getMyAdvantage() != null) {
                    user.setMyAdvantage(userPojo.getMyAdvantage());
                }
                if (userPojo.getPhone() != null) {
                    user.setPhone(userPojo.getPhone());
                }
                if (userPojo.getUserName() != null) {
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
            userPojo.setUserName(user.getUserName());
            try {
                if (user.getBirthday() != null) {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    userPojo.setBirthday(sf.format(user.getBirthday()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (user.getWorkExperience() != null) {
                userPojo.setWorkExperiences(JSONObject.parseArray(user.getWorkExperience(), WorkExperiencePojo.class));
            }
            if (user.getEducation() != null) {
                userPojo.setEducation(user.getEducation());
            }
            if (user.getEducationalExperience() != null) {
                userPojo.setEducationalExperiencePojos(JSONObject.parseArray(user.getEducationalExperience(), EducationalExperiencePojo.class));
            }
            if (user.getDesiredWorkingPlace() != null) {
                userPojo.setDesiredWorkingPlace(JSON.parseObject(user.getDesiredWorkingPlace(), PlacePojo.class));
            }
        }
        return userPojo;
    }

    public UserPojo addWorkExperience(UserPojo userPojo) {
        User user = new UserDao().findById(userPojo.getUserId());
        if (user != null) {
            user.setWorkExperience(JSON.toJSONString(userPojo.getWorkExperiences()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addProjectExperience(UserPojo userPojo) {
        User user = new UserDao().findById(userPojo.getUserId());
        if (user != null) {
            user.setPracticeExperience(JSON.toJSONString(userPojo.getProjectExperiencePojos()));
            userDao.update(user);
        }
        return userPojo;
    }

    public UserPojo addMyAdvantage(UserPojo userPojo) {
        User user = new UserDao().findById(userPojo.getUserId());
        if (user != null) {
            user.setMyAdvantage(userPojo.getMyAdvantage());
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
        User user = userDao.findById(userId);
        if (user == null) {
            return false;
        } else {
            if (user.getSessionKey().equals(sessionKey)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

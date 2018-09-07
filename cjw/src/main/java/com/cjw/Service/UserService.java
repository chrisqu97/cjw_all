package com.cjw.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cjw.Dao.Entity.User;
import com.cjw.Dao.UserDao;
import com.cjw.Pojo.*;
import com.cjw.Utils.WxUtiles;
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
        if (user == null) {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(sf.parse(userPojo.getBirthday()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            user.setDesiredWorkingPlace(JSON.toJSONString(userPojo.getDesiredWorkingPlace()));
            user.setEducation(userPojo.getEducation());
            user.setMyAdvantage(userPojo.getMyAdvantage());
            user.setPhone(userPojo.getPhone());
            user.setUserName(userPojo.getUserName());
            user.setWorkExperience(JSON.toJSONString(userPojo.getWorkExperiences()));
            userDao.update(user);
            return userPojo;
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
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                userPojo.setBirthday(sf.format(user.getBirthday()));
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

    public UserPojo login(LoginPojo loginPojo) throws Exception {
        String apiUrl = wxUtils.getApiUrl(loginPojo.getCode());

        JSONObject jsonObject = restTemplate.getForObject(apiUrl, JSONObject.class);

        String openId = jsonObject.getString("openId");
        User user = userDao.findByOpenId(openId);
        String session_key = jsonObject.getString("session_key");
        if (user == null) {
            JSONObject userData = wxUtils.decodeBase64(loginPojo.getEncryptedData(), session_key, loginPojo.getIv());

            user = new User();
            user.setUserName(userData.getString("openId"));
            user.setUserName(userData.getString("nickName"));
            user.setGender(jsonObject.getInteger("gender"));
            PlacePojo placePojo = new PlacePojo();
            placePojo.setCountry(userData.getString("country"));
            placePojo.setProvince(userData.getString("province"));
            placePojo.setCity(userData.getString("city"));
            user.setLivingPlace(JSON.toJSONString(placePojo));

            userDao.add(user);
        } else {
            if (!user.getSessionKey().equals(session_key)) {
                JSONObject userData = wxUtils.decodeBase64(loginPojo.getEncryptedData(), session_key, loginPojo.getIv());
                user.setSessionKey(session_key);
                user.setUserName(userData.getString("openId"));
                user.setUserName(userData.getString("nickName"));
                user.setGender(jsonObject.getInteger("gender"));
                PlacePojo placePojo = new PlacePojo();
                placePojo.setCountry(userData.getString("country"));
                placePojo.setProvince(userData.getString("province"));
                placePojo.setCity(userData.getString("city"));
                user.setLivingPlace(JSON.toJSONString(placePojo));

                userDao.update(user);
            }
        }
        UserPojo userPojo = new UserPojo();
        userPojo.setUserId(user.getUserId());
        userPojo.setUserName(user.getUserName());

        return userPojo;
    }

    /**
     * 校验openId
     *
     * @param userId
     * @param openId
     * @return
     */
    public boolean checkOpenId(Integer userId, String openId) {
        User user = userDao.findById(userId);
        if (user == null) {
            return false;
        } else {
            if (user.getOpenId().equals(openId)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

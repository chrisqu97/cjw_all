package com.cjw.controller;

import com.cjw.pojo.LoginPojo;
import com.cjw.pojo.ResultPojo;
import com.cjw.pojo.SessionKeyPojo;
import com.cjw.pojo.UserPojo;
import com.cjw.service.UserService;
import com.cjw.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 更新用户信息
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResultPojo updateUser(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getUserId() == null) {
            resultPojo.setMessage("userId为空");
            return resultPojo;
        }
        userPojo = userService.update(userPojo);

        if (userPojo == null) {
            resultPojo.setMessage("更新失败");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setMessage("更新成功");
        return resultPojo;
    }


    /**
     * 获取用户详细信息
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/findByUserId", method = RequestMethod.POST)
    public ResultPojo findByUserId(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        userPojo = userService.findByUserId(userPojo);

        if (userPojo == null) {
            resultPojo.setMessage("未找到该用户");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setMessage("获取用户信息成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加工作经验
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addWorkExperience", method = RequestMethod.POST)
    public ResultPojo addWorkExperience(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getWorkExperiences() == null) {
            resultPojo.setMessage("工作经验为空");
            return resultPojo;
        }

        userService.addWorkExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加工作经验成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加项目经验
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addProjectExperience", method = RequestMethod.POST)
    public ResultPojo addProjectExperience(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getProjectExperiences() == null) {
            resultPojo.setMessage("项目经验为空");
            return resultPojo;
        }

        userService.addProjectExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加项目经验成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加实习经验
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addPracticeExperience", method = RequestMethod.POST)
    public ResultPojo addPracticeExperience(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getPracticeExperiences() == null) {
            resultPojo.setMessage("实习经验 为空");
            return resultPojo;
        }

        userService.addPracticeExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加实习经验成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加教育经历
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addEducationalExperience", method = RequestMethod.POST)
    public ResultPojo addEducationalExperience(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getEducationalExperiences() == null) {
            resultPojo.setMessage("教育经历 为空");
            return resultPojo;
        }

        userService.addEducationalExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加教育经历成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加工作意向
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addJobIntension", method = RequestMethod.POST)
    public ResultPojo addJobIntension(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (userPojo.getJobIntension() == null) {
            resultPojo.setMessage("工作意向为空");
            return resultPojo;
        }

        userService.addJobIntension(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加工作意向成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加我的优势
     *
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addMyAdvantage", method = RequestMethod.POST)
    public ResultPojo addMyAdvantage(@RequestBody UserPojo userPojo) {
        ResultPojo resultPojo = new ResultPojo();

        if (StringUtils.isNotEmpty(userPojo.getMyAdvantage())) {
            resultPojo.setMessage("我的优势 为空");
            return resultPojo;
        }

        userService.addMyAdvantage(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("添加我的优势成功");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 登录
     *
     * @param loginPojo
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultPojo login(@RequestBody LoginPojo loginPojo) {
        ResultPojo resultPojo = new ResultPojo();

        try {
            SessionKeyPojo sessionKeyPojo = userService.login(loginPojo);

            resultPojo.setSuccess(true);
            resultPojo.setMessage("登录成功");
            resultPojo.setData(sessionKeyPojo);
            return resultPojo;
        } catch (Exception e) {
            resultPojo.setMessage(e.getMessage());
            return resultPojo;
        }
    }

}

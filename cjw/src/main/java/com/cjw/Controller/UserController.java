package com.cjw.Controller;

import com.cjw.Pojo.LoginPojo;
import com.cjw.Pojo.ResultPojo;
import com.cjw.Pojo.UserPojo;
import com.cjw.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

        userPojo = userService.update(userPojo);

        if (userPojo == null) {
            resultPojo.setMessage("update user Failed");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setMessage("update user success");
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
            resultPojo.setMessage("find user Failed");
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setMessage("find user success");
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

        userService.addWorkExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("add workExperience success");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加项目经验
     * @param userPojo
     * @return
     */
    @RequestMapping(value = "/addProjectExperience",method = RequestMethod.POST)
    public ResultPojo addProjectExperience(@RequestBody UserPojo userPojo){
        ResultPojo resultPojo = new ResultPojo();

        userService.addProjectExperience(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("add projectExperience success");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 添加我的优势
     * @param userPojo
     * @return
     */
    public ResultPojo addMyAdvantage(UserPojo userPojo){
        ResultPojo resultPojo = new ResultPojo();

        userService.addMyAdvantage(userPojo);

        resultPojo.setSuccess(true);
        resultPojo.setMessage("add myAdvantage success");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

    /**
     * 登录
     *
     * @param loginPojo
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultPojo login(LoginPojo loginPojo, HttpServletRequest request) {
        ResultPojo resultPojo = new ResultPojo();

        UserPojo userPojo = null;
        try {
            userPojo = userService.login(loginPojo);
        } catch (Exception e) {
            resultPojo.setMessage(e.getMessage());
            return resultPojo;
        }

        resultPojo.setSuccess(true);
        resultPojo.setMessage("success");
        resultPojo.setData(userPojo);
        return resultPojo;
    }

}

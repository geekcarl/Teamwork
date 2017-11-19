package com.teamwork.controllers;

import com.teamwork.models.User;
import com.teamwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userDao;

    /**
     * 用户登录验证接口
     *
     * @param weChatNo
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(@RequestParam("weChatNo") String weChatNo, @RequestParam("pwd") String pwd) {

        return userDao.loginCheck(weChatNo, pwd).toString();
    }

    /**
     * 用户登录验证接口
     *
     * @param userName
     * @param employeeId
     * @return
     */
    @RequestMapping(value = "/addUser")
    public String addUser(@RequestParam("userName") String userName, @RequestParam("employeeId") String employeeId) {

        User user = new User();
        user.setEmployeeId(employeeId);
        user.setUserName(userName);
        return userDao.addUser(user).toString();
    }

    @RequestMapping(value = "/queryByDay")
    public String queryByDay() {

        return "day";
    }

    @RequestMapping(value = "/queryByWeek")
    public String queryByWeek() {

        return "week";
    }

    @RequestMapping(value = "/queryByMonth")
    public String queryByMonth() {

        return "month";
    }
}

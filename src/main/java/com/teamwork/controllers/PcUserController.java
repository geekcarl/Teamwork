package com.teamwork.controllers;

import com.teamwork.models.User;
import com.teamwork.service.IActivityService;
import com.teamwork.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class PcUserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private IActivityService activityService;

    @RequestMapping(value = "/adminLogin")
    @ResponseBody
    public  User adminLogin(@RequestParam("employeeId") String employeeId, @RequestParam("pwd") String pwd){

        User user = userService.loginCheck(employeeId,pwd);
        if(user!=null){
            return user;
        }
        return null;
    }

    @RequestMapping(value = "/index")
    public  String index(){
        return "index";
    }

    @RequestMapping(value = "/findUserByEmployeeId")
    @ResponseBody
    public  User findUserByEmployeeId(@RequestParam("employeeId") String employeeId){
        User user = userService.findUserByEmployeeId(employeeId);
        return user;
    }
}

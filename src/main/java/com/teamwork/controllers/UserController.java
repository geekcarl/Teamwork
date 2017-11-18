package com.teamwork.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/login")
    public String login(@RequestParam("acount") String acount, @RequestParam("pwd") String pwd) {
        //todo
        return "SUCCESS";
    }
}

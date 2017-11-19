package com.teamwork.controllers;

import com.teamwork.models.Activity;
import com.teamwork.common.ResponseBean;
import com.teamwork.common.TWConstants;
import com.teamwork.models.User;
import com.teamwork.service.IUserService;
import com.teamwork.service.IActivityService;
import com.teamwork.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by Administrator on 2017/11/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private IActivityService activityService;

    /**
     * 用户登录验证接口
     *
     * @param weChatNo
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseBean login(@RequestParam("weChatNo") String weChatNo, @RequestParam("pwd") String pwd) {
        User user = new User();
        try {
             user = userService.loginCheck(weChatNo, pwd);
        } catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }
        return ResponseBean.OkInstance(user);
    }

    /**
     * 添加用户
     *
     * @param userName
     * @param employeeId
     * @return
     */
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public ResponseBean addUser(@RequestParam("userName") String userName, @RequestParam("employeeId") String employeeId) {

        User user = new User();
        user.setEmployeeId(employeeId);
        user.setUserName(userName);
        try {
            userService.addUser(user);
        } catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }

        return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
    }

    /**
     * 添加活动
     *
     * @param activity
     * @return
     */
    @RequestMapping(value = "/addActivity")
    @ResponseBody
    public ResponseBean addActivity(@RequestBody Activity activity) {

        try {
           activityService.addActivity(activity);
        } catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }

        return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
    }

    /**
     * 按天查询活动
     *
     * @return
     */
    @RequestMapping(value = "/queryByDay")
    public ResponseBean queryByDay() {

        return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
    }

    /**
     * 按周查询活动
     *
     * @return
     */
    @RequestMapping(value = "/queryByWeek")
    public ResponseBean queryByWeek() {

        return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
    }

    /**
     * 按月查询活动
     *
     * @return
     */
    @RequestMapping(value = "/queryByMonth")
    public ResponseBean queryByMonth() {

        return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping(value = "/imgUpLoad")
    @ResponseBody
    public ResponseBean imgUpdate(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, "", null);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        String filePath = "C:\\Users\\Dangerous\\Desktop\\uploadpictures\\";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return ResponseBean.instance(TWConstants.NORMAL_CODE, null, true);
        }catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }
    }
}

package com.teamwork.controllers;

import com.teamwork.common.FileUtil;
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

import javax.servlet.http.HttpServletRequest;
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
     * @param employId
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseBean login(@RequestParam("employId") String employId, @RequestParam("pwd") String pwd) {
        User user;
        try {
             user = userService.loginCheck(employId, pwd);
        } catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }
        return user == null ? ResponseBean.loginErrorInstance(null) : ResponseBean.OkInstance(user);
    }

    /**
     * @param name
     * @param pwd
     * @param employId
     * @param tel
     * @return
     */
    @RequestMapping(value = "/register")
    @ResponseBody
    public ResponseBean register(@RequestParam("name") String name,
                                 @RequestParam("pwd") String pwd,
                                 @RequestParam("employId") String employId,
                                 @RequestParam("tel") String tel) {
        User user;
        try {
            user = userService.findUserByEmployeeId(employId);
            if(user != null) {
                return ResponseBean.instance(TWConstants.USER_EXIST_ERROR, TWConstants.USER_EXIST_ERROR_MSG, null);
            }
            user = new User();
            user.setUserName(name);
            user.setPassWord(pwd);
            user.setEmployeeId(employId);
            user.setTel(tel);
            return userService.addUser(user) ? ResponseBean.OkInstance(null) : ResponseBean.EInstance(null);

        } catch (Exception e) {
            return ResponseBean.instance(TWConstants.ERROR_CODE, e.getMessage(), null);
        }
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
        String filePath = "G:\\img\\";
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

    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }
}

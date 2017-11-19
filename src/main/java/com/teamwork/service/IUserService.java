package com.teamwork.service;

import com.teamwork.models.User;

import java.util.List;

public interface IUserService {
    /**
     * 保存用户
     * @param user
     */
    public void saveUser(User user) throws Exception;

    /**
     * 根据名字查找用户
     * @param userName
     * @return
     */
    public List<User> findUserByUserName(String userName) throws Exception;

    /**
     *更新用户信息
     * @param user
     */
    public void updateUser(User user) throws Exception;

    /**
     *根据用户ID删除用户
     * @param userId
     */
    public void deleteUserById(Long userId)throws Exception;

    /**
     *验证用户名和密码
     * @param weChatNo
     * @param passWord
     */
    public User loginCheck(String weChatNo,String passWord) throws Exception;

    /**
     * 根据员工ID查找用户
     *
     * @param employeeId
     * @return
     */
    public User findUserByEmployeeId(String employeeId) throws Exception;

    /**
     * 新增用户
     * @param user
     */
    public Boolean addUser(User user) throws Exception;



    /**
     * 根据员工维信序列号查找用户
     *
     * @param weChatNo
     * @return
     */
    public User findUserByWeChatNo(String weChatNo) throws Exception;

    /**
     * 更新用户积分信息
     *
     * @param user
     */
    public void updateUserIntegration(User user) throws Exception;
}

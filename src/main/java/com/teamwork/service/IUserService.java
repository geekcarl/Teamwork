package com.teamwork.service;

import com.teamwork.models.User;

import java.util.List;

public interface IUserService {
    /**
     * 新增用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 根据名字查找用户
     * @param userName
     * @return
     */
    public List<User> findUserByUserName(String userName);

    /**
     *更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     *根据用户ID删除用户
     * @param userId
     */
    public void deleteUserById(Long userId);

    /**
     *验证用户名和密码
     * @param weChatNo
     * @param passWord
     */
    public User loginCheck(String weChatNo,String passWord);

    /**
     * 根据员工ID查找用户
     *
     * @param employeeId
     * @return
     */
    public User findUserByEmployeeId(String employeeId);

    /**
     * 新增用户
     * @param user
     */
    public Boolean addUser(User user);
}

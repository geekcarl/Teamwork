package com.teamwork.service;

import com.mongodb.WriteResult;
import com.teamwork.interf.IService;
import com.teamwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements IService<User> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    @Transactional
    public User add(User user) {
        mongoTemplate.save(user);
        return user;
    }


    /**
     * 根据名字查找用户
     *
     * @param userName
     * @return
     */
    public List<User> findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    /**
     * 更新用户密码信息
     *
     * @param user
     */
    @Transactional
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 更新用户积分信息
     * 积分+1
     *
     * @param userId
     */
    @Transactional
    public void updateUserIntegration(long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        User user = mongoTemplate.findOne(query,User.class);
        Update update = new Update().set("integration", user.getIntegration() + 1);
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 验证用户名和密码
     *
     * @param weChatNo
     * @param passWord
     */
    public User loginCheck(String weChatNo, String passWord) {
        Query query = new Query(Criteria.where("weChatNo").is(weChatNo).and("passWord").is(passWord));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * 根据员工ID查找用户
     *
     * @param employeeId
     * @return
     */
    public User findUserByEmployeeId(String employeeId) {
        Query query = new Query(Criteria.where("employeeId").is(employeeId));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * 根据员工维信序列号查找用户
     *
     * @param weChatNo
     * @return
     */
    public User findUserByWeChatNo(String weChatNo) {
        Query query = new Query(Criteria.where("weChatNo").is(weChatNo));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * 新增用户
     *
     * @param user
     */
    @Transactional
    public Boolean addUser(User user) {
        if (findUserByEmployeeId(user.getEmployeeId()) == null) {
            mongoTemplate.save(user);
            return true;
        }
        return false;
    }

    /**
     * 更新
     *
     * @param user
     */
    @Override
    public User update(User user) throws Exception {
        return null;
    }

    /**
     * 根据用户ID删除用户
     *
     * @param userId
     */
    @Override
    @Transactional
    public boolean deleteById(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        WriteResult writeResult = mongoTemplate.remove(query, User.class);
        return writeResult != null && writeResult.getN() > 0 ;
    }

    /**
     * 根据ID查找
     *
     * @param id
     * @return
     */
    @Override
    public User findById(String id) throws Exception {
        Query query = new Query(User.is("userId",id));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

    /**
     * find all
     *
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<User> findAllByOffset(long start, long end) throws Exception {
        return null;
    }


}

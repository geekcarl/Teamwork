package com.teamwork.service;

import com.teamwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据名字查找用户
     *
     * @param userName
     * @return
     */
    @Override
    public List<User> findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("userId").is(user.getUserId()));
        Update update = new Update().set("userName", user.getUserName()).set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, User.class);
        //更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,UserEntity.class);
    }

    /**
     * 根据用户ID删除用户
     *
     * @param userId
     */
    @Override
    public void deleteUserById(Long userId) {
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, User.class);
    }

    /**
     * 验证用户名和密码
     *
     * @param weChatNo
     * @param passWord
     */
    @Override
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
    @Override
    public User findUserByEmployeeId(String employeeId) {
        Query query = new Query(Criteria.where("employeeId").is(employeeId));
        User user = mongoTemplate.findOne(query, User.class);
        return user;
    }

//

    /**
     * 新增用户
     *
     * @param user
     */

    public Boolean addUser(User user) {
        if (findUserByEmployeeId(user.getEmployeeId())==null) {
            mongoTemplate.save(user);
            return true;
        }
        return false;
    }
}

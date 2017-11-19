package com.teamwork.service;

import com.teamwork.models.Activity;
import com.teamwork.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActivityServiceImpl implements IActivityService {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 添加活动
     *
     * @param activity
     */
    @Override
    @Transactional
    public Boolean addActivity(Activity activity) throws Exception {
        //添加活动
        mongoTemplate.save(activity);
        // 积分加1
        userService.updateUserIntegration(activity.getUserId());
        return true;
    }

}

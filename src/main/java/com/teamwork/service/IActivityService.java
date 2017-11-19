package com.teamwork.service;

import com.teamwork.models.Activity;
import com.teamwork.models.User;

public interface IActivityService {

    /**
     * 添加活动
     */
    public Boolean addActivity(Activity activity)throws Exception;



}

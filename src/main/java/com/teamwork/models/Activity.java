package com.teamwork.models;

import java.io.Serializable;
import java.sql.Date;

public class Activity implements Serializable {
    private static final long serialVersionUID = -3258839839160856615L;
    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 活动日期
     */
    private Date activityDate;
    /**
     * 发布时间
     */
    private Date publishTime ;
    /**
     * 发布人ID
     */
    private Long userId;
    /**
     * 发布人名称
     */
    private String name;
    /**
     * 新增万元户数量
     */
    private int newMillionHouseholds;
    /**
     * 面访数量
     */
    private int interviewQuantity;
    /**
     * 电访数量
     */
    private int telInterviewQuantity;
    /**
     * 是否维信群问候早安
     */
    private Boolean gmInWeChatGroup;
    /**
     * 是否安排二早
     */
    private Boolean arrangeTwoMorning;
    /**
     * 今日本人转发数量
     */
    private String selfReprintQuantity;
    /**
     * 今日推动他人转发的业务员人数
     */
    private String pushReprintQuantity;
    /**
     * 占您多对接业务员总人数的比例
     */
    private Double rate;
    /**
     * 是否参加营业部主管早会
     */
    private Boolean atendMorningMeeting;
    /**
     * 今日是否有典范案例
     */
    private Boolean hasExample;
    /**
     * 活动照片
     */
    private String picture;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNewMillionHouseholds() {
        return newMillionHouseholds;
    }

    public void setNewMillionHouseholds(int newMillionHouseholds) {
        this.newMillionHouseholds = newMillionHouseholds;
    }

    public int getInterviewQuantity() {
        return interviewQuantity;
    }

    public void setInterviewQuantity(int interviewQuantity) {
        this.interviewQuantity = interviewQuantity;
    }

    public int getTelInterviewQuantity() {
        return telInterviewQuantity;
    }

    public void setTelInterviewQuantity(int telInterviewQuantity) {
        this.telInterviewQuantity = telInterviewQuantity;
    }

    public Boolean getGmInWeChatGroup() {
        return gmInWeChatGroup;
    }

    public void setGmInWeChatGroup(Boolean gmInWeChatGroup) {
        this.gmInWeChatGroup = gmInWeChatGroup;
    }

    public Boolean getArrangeTwoMorning() {
        return arrangeTwoMorning;
    }

    public void setArrangeTwoMorning(Boolean arrangeTwoMorning) {
        this.arrangeTwoMorning = arrangeTwoMorning;
    }

    public String getSelfReprintQuantity() {
        return selfReprintQuantity;
    }

    public void setSelfReprintQuantity(String selfReprintQuantity) {
        this.selfReprintQuantity = selfReprintQuantity;
    }

    public String getPushReprintQuantity() {
        return pushReprintQuantity;
    }

    public void setPushReprintQuantity(String pushReprintQuantity) {
        this.pushReprintQuantity = pushReprintQuantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getAtendMorningMeeting() {
        return atendMorningMeeting;
    }

    public void setAtendMorningMeeting(Boolean atendMorningMeeting) {
        this.atendMorningMeeting = atendMorningMeeting;
    }

    public Boolean getHasExample() {
        return hasExample;
    }

    public void setHasExample(Boolean hasExample) {
        this.hasExample = hasExample;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

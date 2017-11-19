package com.teamwork.models;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;
    private Long userId;
    private String employeeId;
    private String userName;
    private String bankBranch;
    private String passWord;
    private String tel;
    private String eMail;
    private String gender;
    private String avatar;
    private String weChatNo;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getWeChatNo() {
        return weChatNo;
    }

    public void setWeChatNo(String weChatNo) {
        this.weChatNo = weChatNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", employeeId='" + employeeId + '\'' +
                ", userName='" + userName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", passWord='" + passWord + '\'' +
                ", tel='" + tel + '\'' +
                ", eMail='" + eMail + '\'' +
                ", gender='" + gender + '\'' +
                ", avatar='" + avatar + '\'' +
                ", weChatNo='" + weChatNo + '\'' +
                '}';
    }

    public static User getDemo(){
        User user = new User();
        user.setUserId(1L);
        user.setUserName("zouwei");
        user.setWeChatNo("123");
        user.setPassWord("123");
        return  user;
    }
}


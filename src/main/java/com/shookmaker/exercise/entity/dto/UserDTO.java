package com.shookmaker.exercise.entity.dto;

import java.time.LocalDateTime;

public class UserDTO {

    private Integer id;

    private String userName;

    private String password;

    private Integer userTypeId;

    private Integer industryId;

    private Integer jobId;

    private Integer questionNum;

    private LocalDateTime createTime;

    private String avatar;

    private String signature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }
    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Users{" +
            "id=" + id +
            ", userName=" + userName +
            ", password=" + password +
            ", userTypeId=" + userTypeId +
            ", industryId=" + industryId +
            ", jobId=" + jobId +
            ", questionNum=" + questionNum +
            ", createTime=" + createTime +
            ", avatar=" + avatar +
            ", signature=" + signature +
        "}";
    }
}

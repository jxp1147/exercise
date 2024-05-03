package com.shookmaker.exercise.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserVO {

    private Integer id;

    private String userName;

    private String password;

    private UserTypeVO userType;

    private IndustryVO industry;

    private JobVO job;

    private Integer questionNum;

    private LocalDateTime createTime;

    private String avatar;

    private String signature;

}

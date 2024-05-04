package com.shookmaker.exercise.entity.dbbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {

    private Integer id;

    private String userName;

    private String password;

    private UserTypeBO userType;

    private IndustryBO industry;

    private JobBO job;

    private Integer questionNum;

    private LocalDateTime createTime;

    private String avatar;

    private String signature;

}

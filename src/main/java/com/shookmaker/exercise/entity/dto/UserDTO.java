package com.shookmaker.exercise.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

}

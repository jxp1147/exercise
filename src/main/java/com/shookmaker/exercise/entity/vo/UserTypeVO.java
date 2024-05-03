package com.shookmaker.exercise.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeVO {


    private Integer id;

    private String typeName;

    private Integer typeValue;

}

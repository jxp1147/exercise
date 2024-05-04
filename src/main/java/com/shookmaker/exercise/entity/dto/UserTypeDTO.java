package com.shookmaker.exercise.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeDTO {

    private Integer id;

    private String typeName;

    private Integer typeValue;

}

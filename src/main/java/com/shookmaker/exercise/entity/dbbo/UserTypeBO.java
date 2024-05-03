package com.shookmaker.exercise.entity.dbbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTypeBO {

    private Integer id;

    private String typeName;

    private Integer typeValue;

}

package com.shookmaker.exercise.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobVO {

    private Integer id;

    private String jobName;

    private IndustryVO industry;

}

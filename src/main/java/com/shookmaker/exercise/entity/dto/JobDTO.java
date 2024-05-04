package com.shookmaker.exercise.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

    private Integer id;

    private String jobName;

    private String industryId;

}

package com.shookmaker.exercise.entity.dbbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobBO {

    private Integer id;

    private String jobName;

    private String industryName;

}

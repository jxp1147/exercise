package com.shookmaker.exercise.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseVO {

    private Integer id;

    private IndustryVO industry;

    private JobVO job;

    private String exerciseContent;

    private String exerciseAnswer;
}

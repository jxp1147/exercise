package com.shookmaker.exercise.entity.dbbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseBO {

    private Integer id;

    private IndustryBO industry;

    private JobBO job;

    private String exerciseContent;

    private String exerciseAnswer;

    private UserBO ownerId;

}

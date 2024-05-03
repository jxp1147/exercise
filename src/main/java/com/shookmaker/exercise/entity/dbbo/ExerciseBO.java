package com.shookmaker.exercise.entity.dbbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseBO {

    private Integer id;

    private Integer industryId;

    private Integer jobId;

    private String exerciseContent;

    private String exerciseAnswer;

    private Integer ownerId;

}

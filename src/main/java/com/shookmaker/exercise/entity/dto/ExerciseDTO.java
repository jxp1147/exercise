package com.shookmaker.exercise.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {

    private Integer id;

    private Integer industryId;

    private Integer jobId;

    private String exerciseContent;

    private String exerciseAnswer;

    private Integer ownerId;
}

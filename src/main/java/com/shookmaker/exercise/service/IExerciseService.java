package com.shookmaker.exercise.service;

import com.shookmaker.exercise.entity.dto.ExerciseDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.uitls.PageDataById;

public interface IExerciseService {
    ResultBody updateExercise(ExerciseDTO exerciseDto);
    ResultBody deleteExerciseById(Integer exerciseId);
    ResultBody getExerciseById(Integer exerciseId);
    ResultBody getExercisesByPageData(PageDataById pageDataById);
    ResultBody getCollectExercises(Integer page, Integer limit, Integer userId);
    ResultBody collectExercise(Integer userId, Integer exerciseId);
    ResultBody unCollectExercise(Integer userId, Integer exerciseId);
    ResultBody addExercise(ExerciseDTO exerciseDto);
}

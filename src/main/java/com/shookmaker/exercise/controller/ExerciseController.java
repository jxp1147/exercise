package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.ExerciseDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IExerciseService;
import com.shookmaker.exercise.uitls.PageData;
import com.shookmaker.exercise.uitls.PageDataById;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    @Autowired
    private IExerciseService service;
    @GetMapping("/{exerciseId}")
    public ResultBody getExerciseById(@PathVariable("exerciseId") Integer exerciseId) {
        return service.getExerciseById(exerciseId);
    }
    @PostMapping("/getExercisesByPageData")
    public ResultBody getExercisesByPageData(@RequestBody PageDataById pageDataById) {
        PageData pageData = pageDataById.getPageData();
        Integer userId = pageDataById.getId();
        return service.getExercisesByPageData(pageData.getCurrentPage(), pageData.getPageSize(), userId);
    }

    @PostMapping("/getCollectExercises")
    public ResultBody getCollectExercises(@RequestBody PageDataById pageDataById) {
        PageData pageData = pageDataById.getPageData();
        Integer userId = pageDataById.getId();
        return service.getCollectExercises(pageData.getCurrentPage(), pageData.getPageSize(), userId);
    }
    @PostMapping("/collectExercise")
    public ResultBody collectExercise(@Param("userId") Integer userId, @Param("exerciseId") Integer exerciseId) {
        return service.collectExercise(userId, exerciseId);
    }
    @PostMapping("/unCollectExercise")
    public ResultBody unCollectExercise(@Param("userId") Integer userId, @Param("exerciseId") Integer exerciseId) {
        return service.unCollectExercise(userId, exerciseId);
    }
    @PostMapping("/addExercise")
    public ResultBody addExercise(@Param("exerciseDto") ExerciseDTO exerciseDto) {
        return service.addExercise(exerciseDto);
    }
    @PutMapping("/updateExercise")
    public ResultBody updateExercise(@Param("exerciseDto") ExerciseDTO exerciseDto) {
        return service.updateExercise(exerciseDto);
    }
    @DeleteMapping("/{exerciseId}")
    public ResultBody deleteExerciseById(@PathVariable("exerciseId") Integer exerciseId) {
        return service.deleteExerciseById(exerciseId);
    }
    @PostMapping("/answer")
    public ResultBody answer(@Param("exerciseId") Integer exerciseId, @Param("answer") String answer) {
        return service.answer(exerciseId, answer);
    }
}

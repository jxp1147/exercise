package com.shookmaker.exercise.controller;

import com.alibaba.fastjson.JSONObject;
import com.shookmaker.exercise.entity.dto.ExerciseDTO;
import com.shookmaker.exercise.entity.vo.ExerciseVO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IExerciseService;
import com.shookmaker.exercise.uitls.GenerateModel;
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

    @Autowired
    private GenerateModel generateModel;

    final String prefixContent = "说出以下问答中，答案是否完善，若答案不完善，补充答案内容，若答案完善，则进行优化答案，字数在300以内。\n";
    @GetMapping("/{exerciseId}")
    public ResultBody getExerciseById(@PathVariable("exerciseId") Integer exerciseId) {
        return service.getExerciseById(exerciseId);
    }
    @PostMapping("/getExercisesByPageData")
    public ResultBody getExercisesByPageData(@RequestBody PageDataById pageDataById) {
        return service.getExercisesByPageData(pageDataById);
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
    public ResultBody addExercise(@RequestBody ExerciseDTO exerciseDto) {
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
        ExerciseVO exerciseVO = (ExerciseVO) service.getExerciseById(exerciseId).getData();
        String exerciseContent = exerciseVO.getExerciseContent();
        String chatContent = prefixContent + exerciseContent + "\n" + answer;
        try {
            String content = generateModel.generate(chatContent);
            JSONObject jsonObject = JSONObject.parseObject(content);
            String result = jsonObject.getString("result");
            return ResultBody.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultBody.error("生成答案失败");
        }
    }
}

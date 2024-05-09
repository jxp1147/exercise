package com.shookmaker.exercise.service.impl;

import com.shookmaker.exercise.entity.dto.ExerciseDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.ExerciseMapper;
import com.shookmaker.exercise.service.IExerciseService;
import com.shookmaker.exercise.uitls.PageData;
import com.shookmaker.exercise.uitls.PageDataById;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements IExerciseService {
    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public ResultBody addExercise(ExerciseDTO exerciseDto) {
        if (exerciseMapper.addExercise(exerciseDto) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("添加失败");
    }

    @Override
    public ResultBody updateExercise(ExerciseDTO exerciseDto) {
        if (exerciseMapper.updateExercise(exerciseDto) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("更新失败");
    }

    @Override
    public ResultBody deleteExerciseById(Integer exerciseId) {
        if (exerciseMapper.deleteExerciseById(exerciseId) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("删除失败");
    }

    @Override
    public ResultBody getExerciseById(Integer exerciseId) {
        return ResultBody.success(exerciseMapper.getExerciseById(exerciseId));
    }

    @Override
    public ResultBody getExercisesByPageData(PageDataById pageDataById) {
        PageData pageData = pageDataById.getPageData();
        Integer offset = pageData.getPageSize();
        Integer limit = (pageData.getCurrentPage() - 1) * offset;
        Integer ownerId = pageDataById.getId();
        return ResultBody.success(exerciseMapper.getExercisesByPageData(limit, offset, ownerId));
    }

    @Override
    public ResultBody getCollectExercises(Integer currentPage, Integer pageSize, Integer userId) {
        return ResultBody.success(exerciseMapper.getCollectExercises(currentPage, pageSize, userId));
    }

    @Override
    public ResultBody collectExercise(Integer userId, Integer exerciseId) {
        if (exerciseMapper.collectExercise(userId, exerciseId) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("收藏失败");
    }

    @Override
    public ResultBody unCollectExercise(Integer userId, Integer exerciseId) {
        if (exerciseMapper.unCollectExercise(userId, exerciseId) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("取消收藏失败");
    }

}

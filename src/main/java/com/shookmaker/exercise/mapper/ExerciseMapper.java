package com.shookmaker.exercise.mapper;

import com.shookmaker.exercise.entity.dto.ExerciseDTO;
import com.shookmaker.exercise.entity.vo.ExerciseVO;
import com.shookmaker.exercise.uitls.PageData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExerciseMapper {
    Integer addExercise(@Param("exerciseDto") ExerciseDTO exerciseDto);
    Integer updateExercise(@Param("exerciseDto") ExerciseDTO exerciseDto);
    Integer deleteExerciseById(@Param("exerciseId") Integer exerciseId);
    ExerciseVO getExerciseById(@Param("exerciseId") Integer exerciseId);
    Integer collectExercise(@Param("userId") Integer userId, @Param("exerciseId") Integer exerciseId);
    Integer unCollectExercise(@Param("userId") Integer userId, @Param("exerciseId") Integer exerciseId);
    List<ExerciseVO> getCollectExercises(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize,  @Param("userId") Integer userId);
    List<ExerciseVO> getExercisesByPageData(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("ownerId") Integer ownerId);
}

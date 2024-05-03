package com.shookmaker.exercise.mapper;


import com.shookmaker.exercise.entity.dto.AchieveDTO;
import com.shookmaker.exercise.entity.vo.AchieveVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface AchieveMapper {
    Integer addAchieve(@Param("achieveDto") AchieveDTO achieveDto);
    Integer updateAchieve(@Param("achieveDto") AchieveDTO achieveDto);
    Integer deleteAchieveById(@Param("achieveId") Integer achieveId);
    AchieveVO getAchieveById(@Param("achieveId") Integer achieveId);
    List<AchieveVO> getAllAchieves();
    Integer bindAchieveByUserId(@Param("userId") Integer userId, @Param("achieveId") Integer achieveId);
    Integer unbindAchieveByUserId(@Param("userId") Integer userId, @Param("achieveId") Integer achieveId);

}

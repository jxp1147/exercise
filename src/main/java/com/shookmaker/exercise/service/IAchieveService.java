package com.shookmaker.exercise.service;


import com.shookmaker.exercise.entity.dto.AchieveDTO;
import com.shookmaker.exercise.exception.ResultBody;

public interface IAchieveService {
    ResultBody getAllAchieves();
    ResultBody getAchieveById(Integer achieveId);
    ResultBody addAchieve(AchieveDTO achieveDto);
    ResultBody updateAchieve(AchieveDTO achieveDto);
    ResultBody deleteAchieveById(Integer achieveId);
    ResultBody bindAchieveByUserId(Integer userId, Integer achieveId);
    ResultBody unbindAchieveByUserId(Integer userId, Integer achieveId);

}

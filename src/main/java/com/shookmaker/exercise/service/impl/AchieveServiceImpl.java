package com.shookmaker.exercise.service.impl;

import com.shookmaker.exercise.entity.dto.AchieveDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.AchieveMapper;
import com.shookmaker.exercise.service.IAchieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AchieveServiceImpl implements IAchieveService {
    @Autowired
    private AchieveMapper achieveMapper;

    @Override
    public ResultBody getAllAchieves() {
        return ResultBody.success(achieveMapper.getAllAchieves());
    }

    @Override
    public ResultBody getAchieveById(Integer achieveId) {
        return ResultBody.success(achieveMapper.getAchieveById(achieveId));
    }

    @Override
    public ResultBody addAchieve(AchieveDTO achieveDto) {
        Integer count = achieveMapper.addAchieve(achieveDto);
        if (count == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("添加失败");

    }

    @Override
    public ResultBody updateAchieve(AchieveDTO achieveDto) {
        Integer count = achieveMapper.updateAchieve(achieveDto);
        if (count == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("更新失败");
    }

    @Override
    public ResultBody deleteAchieveById(Integer achieveId) {
        Integer count = achieveMapper.deleteAchieveById(achieveId);
        if (count == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("删除失败");
    }

    @Override
    public ResultBody bindAchieveByUserId(Integer userId, Integer achieveId) {
        Integer count = achieveMapper.bindAchieveByUserId(userId, achieveId);
        if (count == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("绑定失败");
    }

    @Override
    public ResultBody unbindAchieveByUserId(Integer userId, Integer achieveId) {
        Integer count = achieveMapper.unbindAchieveByUserId(userId, achieveId);
        if (count == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("解绑失败");
    }
}

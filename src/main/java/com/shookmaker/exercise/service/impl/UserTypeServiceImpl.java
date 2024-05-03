package com.shookmaker.exercise.service.impl;

import com.shookmaker.exercise.entity.dto.UserTypeDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.UserTypeMapper;
import com.shookmaker.exercise.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements IUserTypeService {
    @Autowired
    private UserTypeMapper userTypeMapper;

    @Override
    public ResultBody getAllUserTypes() {
        return ResultBody.success(userTypeMapper.getAllUserTypes());
    }

    @Override
    public ResultBody getUserTypeById(Integer userTypeId) {
        return ResultBody.success(userTypeMapper.getUserTypeById(userTypeId));
    }

    @Override
    public ResultBody updateUserType(UserTypeDTO userType) {
        int updatedNum = userTypeMapper.updateUserType(userType);
        if (updatedNum == 1) {
            return ResultBody.success();
        } else {
            return ResultBody.error("更新失败");
        }
    }

    @Override
    public ResultBody addUserType(UserTypeDTO userType) {
        int addNum = userTypeMapper.addUserType(userType);
        if (addNum == 1) {
            return ResultBody.success();
        } else {
            return ResultBody.error("添加失败");
        }
    }

    @Override
    public ResultBody deleteUserTypeById(Integer userTypeId) {
        int addNum = userTypeMapper.deleteUserTypeById(userTypeId);
        if (addNum == 1) {
            return ResultBody.success();
        } else {
            return ResultBody.error("删除失败");
        }
    }
}

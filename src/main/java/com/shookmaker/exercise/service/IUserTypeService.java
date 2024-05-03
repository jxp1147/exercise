package com.shookmaker.exercise.service;

import com.shookmaker.exercise.entity.dto.UserTypeDTO;
import com.shookmaker.exercise.exception.ResultBody;

public interface IUserTypeService {
    ResultBody getAllUserTypes();
    ResultBody getUserTypeById(Integer userTypeId);
    ResultBody updateUserType(UserTypeDTO userTypeDTO);
    ResultBody addUserType(UserTypeDTO userType);
    ResultBody deleteUserTypeById(Integer userTypeId);
}

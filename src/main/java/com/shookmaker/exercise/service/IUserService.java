package com.shookmaker.exercise.service;

import com.shookmaker.exercise.entity.dto.UserDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.uitls.PageData;

public interface IUserService {
    ResultBody login(UserDTO user);
    ResultBody register(UserDTO user);
    ResultBody updateUser(UserDTO user);
    ResultBody getUserById(Integer userId);
    ResultBody deleteUserById(Integer userId);
    ResultBody getUsers(PageData pageData);
}

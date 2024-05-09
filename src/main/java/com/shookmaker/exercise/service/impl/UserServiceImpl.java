package com.shookmaker.exercise.service.impl;

import com.shookmaker.exercise.entity.dto.UserDTO;
import com.shookmaker.exercise.entity.vo.UserVO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.UserMapper;
import com.shookmaker.exercise.service.IUserService;
import com.shookmaker.exercise.uitls.JwtUtil;
import com.shookmaker.exercise.uitls.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResultBody login(UserDTO userDto) {
        // 从数据库查询用户
        UserVO user = userMapper.getUserByUserName(userDto.getUserName());

        // 用户不存在或密码不匹配，返回null
        if (user == null || !user.getPassword().equals(userDto.getPassword())) {
            return ResultBody.error(-1,"账号或密码错误");
        }
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userName", user.getUserName());
        userMap.put("id", user.getId());
        userMap.put("userType", user.getUserType());
        userMap.put("jobId", user.getJob().getId());
        userMap.put("industryId", user.getIndustry().getId());
        String jwt = JwtUtil.getJwt(userMap);
        // 用户存在且密码匹配，返回用户对象
        Map<String, Object> loginResponseMap = new HashMap<>();
        loginResponseMap.put("token", jwt);
        loginResponseMap.put("user", userMap);
        return ResultBody.success(loginResponseMap);
    }

    @Override
    public ResultBody register(UserDTO user) {
        Integer registerNum = userMapper.register(user);
        if (user.getUserTypeId() == null) {
            user.setUserTypeId(3);
        }
        if (registerNum == 0) {
            return ResultBody.error(-1,"注册失败: 已存在用户名");
        }
        return ResultBody.success("注册成功！");
    }

    @Override
    public ResultBody updateUser(UserDTO user) {
        Integer updateNum = userMapper.updateUser(user);
        if (updateNum == 0) {
            return ResultBody.error(-1,"更新失败: 用户不存在");
        }
        return ResultBody.success("更新成功！");
    }

    @Override
    public ResultBody getUserById(Integer userId) {
        return ResultBody.success(userMapper.getUserById(userId));
    }

    @Override
    public ResultBody deleteUserById(Integer userId) {
        if (userMapper.deleteUserById(userId) == 0) {
            return ResultBody.error(-1,"删除失败: 用户不存在");
        }
        return ResultBody.success("删除成功");
    }

    @Override
    public ResultBody getUsers(PageData pageData) {
        Integer offset = pageData.getPageSize();
        Integer limit = (pageData.getCurrentPage() - 1) * offset;
        Map<String, Object> map = new HashMap<>();
        List<UserVO> userList = userMapper.getUsers(limit, offset);
        Integer totalCount = userMapper.getUserCount();
        PageData resultPageData = new PageData();
        resultPageData.setCurrentPage(pageData.getCurrentPage());
        resultPageData.setPageSize(pageData.getPageSize());
        resultPageData.setTotalCount(totalCount);
        map.put("data", userList);
        map.put("pageData", resultPageData);
        return ResultBody.success(map);
    }
}

package com.shookmaker.exercise.mapper;

import com.shookmaker.exercise.entity.dto.UserDTO;
import com.shookmaker.exercise.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jxp
 * @since 2024-04-22
 */
@Mapper
public interface UserMapper {
    UserVO getUserByUserName(@Param("userName") String userName);
    Integer register(@Param("userDto") UserDTO userDto);
    Integer updateUser(@Param("userDto") UserDTO userDto);
    Integer deleteUserById(@Param("userId") Integer userId);
    UserVO getUserById(@Param("userId") Integer userId);
    List<UserVO> getUsers(@Param("limit") Integer limit, @Param("offset") Integer offset);
    Integer getUserCount();
}

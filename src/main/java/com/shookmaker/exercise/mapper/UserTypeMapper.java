package com.shookmaker.exercise.mapper;

import com.shookmaker.exercise.entity.dto.UserTypeDTO;
import com.shookmaker.exercise.entity.vo.UserTypeVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jxp
 * @since 2024-04-22
 */
@Repository
public interface UserTypeMapper {
    Integer deleteUserTypeById(@Param("userTypeId") Integer userTypeId);
    UserTypeVO getUserTypeById(@Param("userTypeId") Integer userTypeId);
    List<UserTypeVO> getAllUserTypes();
    Integer addUserType(@Param("UserTypeDto") UserTypeDTO UserTypeDto);
    Integer updateUserType(@Param("UserTypeDto") UserTypeDTO UserTypeDto);
}

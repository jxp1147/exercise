package com.shookmaker.exercise.mapper;

import com.shookmaker.exercise.entity.dto.IndustryDTO;
import com.shookmaker.exercise.entity.vo.IndustryVO;
import org.apache.ibatis.annotations.Mapper;
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
@Mapper
@Repository
public interface IndustryMapper {
    Integer deleteIndustryById(@Param("industryId") Integer industryId);
    IndustryVO getIndustryById(@Param("industryId") Integer industryId);
    List<IndustryVO> getAllIndustries();
    Integer addIndustry(@Param("industryDto") IndustryDTO industryDto);
    Integer updateIndustry(@Param("industryDto") IndustryDTO industryDto);

}

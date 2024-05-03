package com.shookmaker.exercise.mapper;

import com.shookmaker.exercise.entity.dto.JobDTO;
import com.shookmaker.exercise.entity.vo.JobVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface JobMapper {
    Integer addJob(@Param("jobDto") JobDTO jobDto);
    Integer updateJob(@Param("jobDto") JobDTO jobDto);
    Integer deleteJobById(@Param("jobId") Integer jobId);
    JobVO getJobById(@Param("jobId") Integer jobId);
    List<JobVO> getJobsByIndustryId(@Param("industryId") Integer industryId);
    void deleteJobsByIndustryId(@Param("industryId") Integer industryId);
}

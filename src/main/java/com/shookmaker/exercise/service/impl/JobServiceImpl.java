package com.shookmaker.exercise.service.impl;


import com.shookmaker.exercise.entity.dto.JobDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.JobMapper;

import com.shookmaker.exercise.service.IJobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobServiceImpl implements IJobService {
    @Autowired
    private JobMapper jobMapper;

    @Override
    public ResultBody addJob(JobDTO jobDto) {
        if (jobMapper.addJob(jobDto) == 1) {
           return ResultBody.success();
        }
        return ResultBody.error("添加失败");
    }

    @Override
    public ResultBody updateJob(JobDTO jobDto) {
        if (jobMapper.updateJob(jobDto) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("更新失败");
    }

    @Override
    public ResultBody deleteJobById(Integer jobId) {
        if (jobMapper.deleteJobById(jobId) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("删除失败");
    }

    @Override
    public ResultBody getJobById(Integer jobId) {
        return ResultBody.success(jobMapper.getJobById(jobId));
    }

    @Override
    public ResultBody getJobsByIndustryId(Integer industryId) {
        return ResultBody.success(jobMapper.getJobsByIndustryId(industryId));
    }

    @Override
    public ResultBody deleteJobsByIndustryId(Integer industryId) {
        jobMapper.deleteJobsByIndustryId(industryId);
        return ResultBody.success();

    }
}

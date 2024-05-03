package com.shookmaker.exercise.service;

import com.shookmaker.exercise.entity.dto.JobDTO;
import com.shookmaker.exercise.exception.ResultBody;

public interface IJobService {
    ResultBody addJob(JobDTO jobDto);
    ResultBody updateJob(JobDTO jobDto);
    ResultBody deleteJobById(Integer jobId);
    ResultBody getJobById(Integer jobId);
    ResultBody getJobsByIndustryId(Integer industryId);
    ResultBody deleteJobsByIndustryId(Integer industryId);
}

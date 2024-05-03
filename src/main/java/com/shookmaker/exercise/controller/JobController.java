package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.JobDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Autowired
    private IJobService service;
    @GetMapping("/{jobId}")
    public ResultBody getJobById(@PathVariable("jobId") Integer jobId) {
        return service.getJobById(jobId);
    }
    @GetMapping("/getJobsByIndustryId/{industryId}")
    public ResultBody getJobsByIndustryId(@PathVariable("industryId") Integer industryId) {
        return service.getJobsByIndustryId(industryId);
    }

    @DeleteMapping("/deleteJobsByIndustryId/{industryId}")
    public ResultBody deleteJobsByIndustryId(@PathVariable("industryId") Integer industryId) {
        return service.deleteJobsByIndustryId(industryId);
    }
    @PostMapping("/addJob")
    public ResultBody addJob(@RequestBody JobDTO jobDto) {
        return service.addJob(jobDto);
    }
    @PutMapping("/updateJob")
    public ResultBody updateJob(@RequestBody JobDTO jobDto) {
        return service.updateJob(jobDto);
    }
    @DeleteMapping("/{jobId}")
    public ResultBody deleteJobById(@PathVariable("jobId") Integer jobId) {
        return service.deleteJobById(jobId);
    }
}


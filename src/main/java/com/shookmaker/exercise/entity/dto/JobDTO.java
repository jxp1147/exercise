package com.shookmaker.exercise.entity.dto;

public class JobDTO {

    private Integer id;

    private String jobName;

    private String industryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    @Override
    public String toString() {
        return "Jobs{" +
            "id=" + id +
            ", jobName=" + jobName +
            ", industryName=" + industryName +
        "}";
    }
}

package com.shookmaker.exercise.service.impl;

import com.shookmaker.exercise.entity.dto.IndustryDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.mapper.IndustryMapper;
import com.shookmaker.exercise.mapper.JobMapper;
import com.shookmaker.exercise.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IndustryServiceImpl implements IIndustryService {
    @Autowired
    private IndustryMapper userTypeMapper;

    @Autowired
    private JobMapper jobMapper;

    @Override
    public ResultBody getAllIndustries() {
        return ResultBody.success(userTypeMapper.getAllIndustries());
    }

    @Override
    public ResultBody getIndustryById(Integer industryId) {
        return ResultBody.success(userTypeMapper.getIndustryById(industryId));
    }

    @Override
    public ResultBody updateIndustry(IndustryDTO industryDto) {
        if (userTypeMapper.updateIndustry(industryDto) == 1) {
            return ResultBody.success();
        }
        return ResultBody.error("更新失败");
    }

    @Override
    public ResultBody addIndustry(IndustryDTO industryDto) {
        if (userTypeMapper.addIndustry(industryDto) == 1) {
            return ResultBody.success();
        }
            return ResultBody.error("添加失败");
    }

    @Transactional(rollbackFor = Exception.class)  // 开启事务 所有的异常都会回滚
    @Override
    public ResultBody deleteIndustryById(Integer industryId) {
        Integer count = userTypeMapper.deleteIndustryById(industryId);
        if (count == 1) {
            jobMapper.deleteJobsByIndustryId(industryId);
            return ResultBody.success();
        }
        return  ResultBody.error("删除失败");
    }
}

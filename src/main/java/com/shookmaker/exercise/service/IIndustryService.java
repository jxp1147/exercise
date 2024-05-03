package com.shookmaker.exercise.service;

import com.shookmaker.exercise.entity.dto.IndustryDTO;
import com.shookmaker.exercise.exception.ResultBody;

public interface IIndustryService {
    ResultBody getAllIndustries();
    ResultBody getIndustryById(Integer IndustryId);
    ResultBody updateIndustry(IndustryDTO IndustryDto);
    ResultBody addIndustry(IndustryDTO IndustryDto);
    ResultBody deleteIndustryById(Integer IndustryId);
}

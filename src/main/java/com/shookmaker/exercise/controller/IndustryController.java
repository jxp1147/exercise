package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.IndustryDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/industry")
public class IndustryController {
    @Autowired
    private IIndustryService service;
    @GetMapping("/getAllIndustries")
    public ResultBody getAllIndustries() {
        return service.getAllIndustries()   ;
    }

    @GetMapping("/{industryId}")
    public ResultBody getIndustryById(@PathVariable("industryId") Integer industryId) {
        return service.getIndustryById(industryId);
    }

    @PutMapping("/updateIndustry")
    public ResultBody updateIndustry(@RequestBody IndustryDTO industryDTO){
        return service.updateIndustry(industryDTO);
    }
    @DeleteMapping("/{industryId}")
    public ResultBody deleteIndustryById(@PathVariable("industryId") Integer industryId) {
        return service.deleteIndustryById(industryId);
    }
    @PostMapping("/addIndustry")
    public ResultBody addIndustry(@RequestBody IndustryDTO industryDTO) {
        return service.addIndustry(industryDTO);
    }
}

package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.AchieveDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IAchieveService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/achieve")
public class AchieveController {
    @Autowired
    private IAchieveService service;

    @GetMapping("/{achieveId}")
    public ResultBody getAchieveById(@PathVariable("achieveId") Integer achieveId) {
        return service.getAchieveById(achieveId);
    }
    @GetMapping("/getAllAchieves")
    public ResultBody getAllAchieves() {
        return service.getAllAchieves();
    }
    @PostMapping("/addAchieve")
    public ResultBody addAchieve(@RequestBody AchieveDTO achieveDto) {
        return service.addAchieve(achieveDto);
    }
    @PutMapping("/updateAchieve")
    public ResultBody updateAchieve(@RequestBody AchieveDTO achieveDto) {
        return service.updateAchieve(achieveDto);
    }
    @DeleteMapping("/{achieveId}")
    public ResultBody deleteAchieveById(@PathVariable("achieveId") Integer achieveId) {
        return service.deleteAchieveById(achieveId);
    }
    @PostMapping("/bindAchieveByUserId")
    public ResultBody bindAchieveByUserId(@Param("userId") Integer userId, @Param("achieveId") Integer achieveId) {
        return service.bindAchieveByUserId(userId, achieveId);
    }
    @PostMapping("/unbindAchieveByUserId")
    public ResultBody unbindAchieveByUserId(@Param("userId") Integer userId, @Param("achieveId") Integer achieveId) {
        return service.unbindAchieveByUserId(userId, achieveId);
    }

}

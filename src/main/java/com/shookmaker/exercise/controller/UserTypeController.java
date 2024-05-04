package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.UserTypeDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IUserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userType")
public class UserTypeController {
    @Autowired
    private IUserTypeService service;
    @GetMapping("/getAllUserTypes")
    public ResultBody getAllUserTypes() {
        return ResultBody.success(service.getAllUserTypes());
    }

    @GetMapping("/{userTypeId}")
    public ResultBody getUserTypeById(@PathVariable("userTypeId") Integer userTypeId) {
        return service.getUserTypeById(userTypeId);
    }

    @PutMapping("/updateUserTye")
    public ResultBody updateUserType(@RequestBody UserTypeDTO userTypeDTO){
        return service.updateUserType(userTypeDTO);
    }
    @DeleteMapping("/{userTypeId}")
    public ResultBody deleteUserTypeById(@PathVariable("userTypeId") Integer userTypeId) {
        return service.deleteUserTypeById(userTypeId);
    }
    @PostMapping("/addUserType")
    public ResultBody addUserType(@RequestBody UserTypeDTO userTypeDTO) {
        return service.addUserType(userTypeDTO);
    }
}

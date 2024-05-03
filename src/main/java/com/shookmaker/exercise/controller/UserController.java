package com.shookmaker.exercise.controller;

import com.shookmaker.exercise.entity.dto.UserDTO;
import com.shookmaker.exercise.exception.ResultBody;
import com.shookmaker.exercise.service.IUserService;
import com.shookmaker.exercise.uitls.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService service;
    @PostMapping("/login")
    public ResultBody login(@RequestBody UserDTO user) {
        return service.login(user);
    }

    @PostMapping("/register")
    public ResultBody register(@RequestBody UserDTO user) {
        return service.register(user);
    }
    @DeleteMapping("/{userId}")
    public ResultBody deleteUserById(@PathVariable Integer userId) {
        return service.deleteUserById(userId);
    }

    @GetMapping("/{userId}")
    public ResultBody getUserById(@PathVariable Integer userId) {
        return service.getUserById(userId);
    }
    @PutMapping("/update")
    public ResultBody updateUser(@RequestBody UserDTO user) {
        return service.updateUser(user);
    }

    @PostMapping("/getUsers")
    public ResultBody getUsers(@RequestBody PageData pageData) {
        return service.getUsers(pageData);
    }
}

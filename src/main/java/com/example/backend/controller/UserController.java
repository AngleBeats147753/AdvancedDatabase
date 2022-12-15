package com.example.backend.controller;

import com.example.backend.pojo.dto.ReturnResult;
import com.example.backend.pojo.query.UserLoginQuery;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author zhoutianlan
 * @since 2022/12/13
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public ReturnResult login(@Valid @RequestBody UserLoginQuery userLoginQuery) {
        return userService.login(userLoginQuery);
    }
}

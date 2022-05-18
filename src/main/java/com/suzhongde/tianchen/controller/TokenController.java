package com.suzhongde.tianchen.controller;

import com.suzhongde.tianchen.dto.TokenCreateRequest;
import com.suzhongde.tianchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {


    UserService userService;

    @PostMapping
    public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
        return userService.createToken(tokenCreateRequest);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

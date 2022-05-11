package com.suzhongde.tianchen.controller;

import com.suzhongde.tianchen.mapper.UserMapper;
import com.suzhongde.tianchen.service.UserService;
import com.suzhongde.tianchen.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list(){
        return userService.list().stream()
                .map(userMapper::toVo).collect(Collectors.toList());
    }

    @PostMapping("/")
    UserVo create(@RequestBody com.suzhongde.tianchen.dto.UserCreateDto userCreateDto) {
        return userMapper.toVo(userService.create(userCreateDto));
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

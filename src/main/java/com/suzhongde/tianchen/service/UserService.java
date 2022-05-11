package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.UserCreateDto;
import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username);
}
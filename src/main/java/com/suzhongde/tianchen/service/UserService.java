package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.TokenCreateRequest;
import com.suzhongde.tianchen.dto.UserCreateRequest;
import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.dto.UserUpdateRequest;
import com.suzhongde.tianchen.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userUpdateRequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest tokenCreateRequest);

    UserDto getCurrentUser();
}
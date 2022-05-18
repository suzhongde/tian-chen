package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.UserCreateRequest;
import com.suzhongde.tianchen.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseService {

    @Autowired
    UserService userService;

    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("yili");
        userCreateRequest.setNickname("yili");
        userCreateRequest.setPassword("900602");
        userCreateRequest.setGender(Gender.MALE);
        userService.create(userCreateRequest);
    }
}
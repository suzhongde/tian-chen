package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.UserCreateRequest;
import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.entity.User;
import com.suzhongde.tianchen.enums.Gender;
import com.suzhongde.tianchen.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class BaseTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @BeforeEach
    void setDefaultUser() {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setUsername("yili");
        userCreateRequest.setNickname("yili");
        userCreateRequest.setPassword("900602");
        userCreateRequest.setGender(Gender.MALE);
        UserDto userDto = userService.create(userCreateRequest);

        User user = userService.loadUserByUsername(userDto.getUsername());
        userRepository.save(user);
    }
}
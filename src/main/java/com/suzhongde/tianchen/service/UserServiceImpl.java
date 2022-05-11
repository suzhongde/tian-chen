package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.mapper.UserMapper;
import com.suzhongde.tianchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;


    @Override
    public List<UserDto> list() {
        return repository.findAll()
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
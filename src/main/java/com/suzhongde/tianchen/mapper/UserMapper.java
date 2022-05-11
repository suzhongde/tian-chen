package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.UserCreateRequest;
import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.dto.UserUpdateRequest;
import com.suzhongde.tianchen.entity.User;
import com.suzhongde.tianchen.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
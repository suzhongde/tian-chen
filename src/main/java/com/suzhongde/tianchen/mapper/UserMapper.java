package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.UserDto;
import com.suzhongde.tianchen.entity.User;
import com.suzhongde.tianchen.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
package com.suzhongde.tianchen.dto;
import com.suzhongde.tianchen.vo.RoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roles;
}
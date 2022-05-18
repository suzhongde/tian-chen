package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.SiteSettingDto;
import com.suzhongde.tianchen.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
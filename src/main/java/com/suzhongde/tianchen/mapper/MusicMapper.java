package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.MusicCreateRequest;
import com.suzhongde.tianchen.dto.MusicDto;
import com.suzhongde.tianchen.dto.MusicUpdateRequest;
import com.suzhongde.tianchen.entity.Music;
import com.suzhongde.tianchen.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = FileMapper.class)
public interface MusicMapper {
    MusicDto toDto(Music music);

    MusicVo toVo(MusicDto musicDto);

    Music createEntity(MusicCreateRequest musicCreateRequest);

    Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
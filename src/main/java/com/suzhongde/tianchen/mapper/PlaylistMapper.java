package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.PlaylistCreateRequest;
import com.suzhongde.tianchen.dto.PlaylistDto;
import com.suzhongde.tianchen.entity.Playlist;
import com.suzhongde.tianchen.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

    @Mapping(source = "coverId", target = "cover.id")
    PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
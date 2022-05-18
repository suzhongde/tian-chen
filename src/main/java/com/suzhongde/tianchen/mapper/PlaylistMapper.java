package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.PlaylistDto;
import com.suzhongde.tianchen.entity.Playlist;
import com.suzhongde.tianchen.vo.PlaylistVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    PlaylistDto toDto(Playlist playlist);

    PlaylistVo toVo(PlaylistDto playlistDto);
}
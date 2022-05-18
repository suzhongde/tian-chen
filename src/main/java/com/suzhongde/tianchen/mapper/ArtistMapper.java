package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.ArtistCreateRequest;
import com.suzhongde.tianchen.dto.ArtistDto;
import com.suzhongde.tianchen.dto.ArtistUpdateRequest;
import com.suzhongde.tianchen.entity.Artist;
import com.suzhongde.tianchen.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class})
public interface ArtistMapper {

    @Mapping(source = "photoId", target = "photo.id")
    Artist createEntity(ArtistCreateRequest artistCreateRequest);

    @Mapping(source = "photoId", target = "photo.id")
    Artist updateEntity(@MappingTarget Artist artist, ArtistUpdateRequest artistUpdateRequest);

    ArtistDto toDto(Artist artist);

    ArtistVo toVo(ArtistDto artistDto);
}
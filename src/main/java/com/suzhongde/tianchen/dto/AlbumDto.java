package com.suzhongde.tianchen.dto;

import com.suzhongde.tianchen.enums.GeneralStatus;
import lombok.Data;

import java.util.List;


@Data
public class AlbumDto extends TraceableBaseDto {
    private String name;

    private String description;

    private FileDto cover;

    private GeneralStatus status;

    private List<ArtistDto> artists;

    private List<MusicDto> musicList;
}
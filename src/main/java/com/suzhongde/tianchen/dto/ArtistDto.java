package com.suzhongde.tianchen.dto;

import com.suzhongde.tianchen.enums.ArtistStatus;
import lombok.Data;

import java.util.List;

@Data
public class ArtistDto extends BaseDto {
    private String name;

    private String remark;

    private FileDto photo;

    private List<MusicDto> musicDtoList;

    private ArtistStatus status;
}
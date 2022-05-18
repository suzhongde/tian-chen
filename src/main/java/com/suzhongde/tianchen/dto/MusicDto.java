package com.suzhongde.tianchen.dto;

import com.suzhongde.tianchen.enums.MusicStatus;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString(callSuper = true)
public class MusicDto extends BaseDto {
    private String name;

    private MusicStatus status = MusicStatus.DRAFT;

    private String description;

    private FileDto file;

    private List<ArtistDto> artistList;
}
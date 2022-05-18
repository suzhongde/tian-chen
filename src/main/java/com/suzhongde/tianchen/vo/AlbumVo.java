package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.GeneralStatus;
import lombok.Data;

import java.util.List;

@Data
public class AlbumVo extends BaseVo {
    private String name;

    private String description;

    private FileVo cover;

    private GeneralStatus status;


    private List<ArtistVo> artists;

    private List<MusicVo> musicList;
}
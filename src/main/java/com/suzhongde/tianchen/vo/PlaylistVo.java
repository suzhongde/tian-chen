package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.PlayListStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PlaylistVo extends BaseVo {

    private String name;

    private String description;

    private FileVo cover;

    private PlayListStatus status;

    private List<MusicVo> musicList;

    private Boolean recommended;

    private Integer recommendFactor;

    private Boolean special;
}
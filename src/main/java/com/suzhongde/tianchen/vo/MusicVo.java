package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.MusicStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MusicVo extends BaseVo {

    private String id;

    private String name;

    private MusicStatus status;

    private String description;

}
package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.FileStatus;
import com.suzhongde.tianchen.enums.FileType;
import lombok.Data;

@Data
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String ext;

    private Integer size;

    private FileType type;

    private FileStatus status;
}
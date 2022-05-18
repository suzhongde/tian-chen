package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.FileStatus;
import com.suzhongde.tianchen.enums.FileType;
import com.suzhongde.tianchen.enums.Storage;
import lombok.Data;

@Data
public class FileVo extends BaseVo {
    private String name;

    private String key;

    private String uri;

    private Storage storage;

    private String ext;

    private Long size;

    private FileType type;

    private FileStatus status;
}
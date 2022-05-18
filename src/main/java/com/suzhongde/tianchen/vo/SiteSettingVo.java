package com.suzhongde.tianchen.vo;

import com.suzhongde.tianchen.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}
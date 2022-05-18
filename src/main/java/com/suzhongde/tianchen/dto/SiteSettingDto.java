package com.suzhongde.tianchen.dto;

import com.suzhongde.tianchen.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
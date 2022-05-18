package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.SiteSettingDto;
import com.suzhongde.tianchen.service.FileService;
import com.suzhongde.tianchen.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Value("${cos.bucket}")
    private String bucket;


    @Value("${cos.region}")
    private String region;


    private FileService fileService;


    @Override
    public SiteSettingDto getSiteSetting() {
        SiteSettingDto siteSettingDto = new SiteSettingDto();
        siteSettingDto.setBucket(bucket);
        siteSettingDto.setRegion(region);
        siteSettingDto.setStorage(fileService.getDefaultStorage());
        return siteSettingDto;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
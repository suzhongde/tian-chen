package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.service.StorageService;
import org.springframework.stereotype.Service;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {
    @Override
    public FileUploadDto initFileUpload() {
        return null;
    }
}
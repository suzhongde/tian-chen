package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.FileUploadDto;

import java.io.IOException;

public interface StorageService {
    FileUploadDto initFileUpload() throws IOException;

    String getFileUri(String fileKey);
}
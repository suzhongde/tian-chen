package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.FileDto;
import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.dto.FileUploadRequest;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);
}
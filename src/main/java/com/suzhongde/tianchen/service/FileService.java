package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.dto.FileUploadRequest;

public interface FileService {

    FileUploadDto initUpload(FileUploadRequest fileUploadRequest);
}
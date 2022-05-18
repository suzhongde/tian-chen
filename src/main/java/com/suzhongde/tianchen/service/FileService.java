package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.FileDto;
import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.dto.FileUploadRequest;
import com.suzhongde.tianchen.entity.File;
import com.suzhongde.tianchen.enums.Storage;

import java.io.IOException;

public interface FileService {
    FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

    FileDto finishUpload(String id);

    Storage getDefaultStorage();

    File getFileEntity(String id);
}
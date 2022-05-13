package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.FileUploadRequest;
import com.suzhongde.tianchen.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);
}
package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.FileDto;
import com.suzhongde.tianchen.dto.FileUploadRequest;
import com.suzhongde.tianchen.entity.File;
import com.suzhongde.tianchen.vo.FileVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);
}
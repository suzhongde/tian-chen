package com.suzhongde.tianchen.mapper;

import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
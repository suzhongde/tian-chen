package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.FileDto;
import com.suzhongde.tianchen.dto.FileUploadDto;
import com.suzhongde.tianchen.dto.FileUploadRequest;
import com.suzhongde.tianchen.entity.File;
import com.suzhongde.tianchen.enums.FileStatus;
import com.suzhongde.tianchen.enums.Storage;
import com.suzhongde.tianchen.exception.BizException;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.FileMapper;
import com.suzhongde.tianchen.repository.FileRepository;
import com.suzhongde.tianchen.service.FileService;
import com.suzhongde.tianchen.service.StorageService;
import com.suzhongde.tianchen.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private Map<String, StorageService> storageServices;

    private FileRepository repository;

    private FileMapper mapper;

    @Override
    @Transactional
    public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
        // 创建File实体
        File file = mapper.createEntity(fileUploadRequest);
        file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
        file.setStorage(getDefaultStorage());
        File savedFile = repository.save(file);

        // 通过接口获取STS令牌
        FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

        fileUploadDto.setKey(savedFile.getKey());
        fileUploadDto.setFileId(savedFile.getId());
        return fileUploadDto;
    }

    @Override
    public FileDto finishUpload(String id) {
        Optional<File> fileOptional = repository.findById(id);
        if (!fileOptional.isPresent()) {
            throw new BizException(ExceptionType.FILE_NOT_FOUND);
        }
        // Todo: 只有上传者才能给更新finish；权限判断

        // Todo: 验证远程文件是否存在

        File file = fileOptional.get();
        file.setStatus(FileStatus.UPLOADED);
        return mapper.toDto(repository.save(file));
    }


    // Todo: 后台设置当前Storage
    public Storage getDefaultStorage() {
        return Storage.COS;
    }


    @Autowired
    public void setStorageServices(Map<String, StorageService> storageServices) {
        this.storageServices = storageServices;
    }

    @Autowired
    public void setRepository(FileRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(FileMapper mapper) {
        this.mapper = mapper;
    }
}

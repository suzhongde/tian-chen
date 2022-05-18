package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.AlbumDto;
import com.suzhongde.tianchen.entity.Album;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.AlbumMapper;
import com.suzhongde.tianchen.mapper.MapperInterface;
import com.suzhongde.tianchen.repository.AlbumRepository;
import com.suzhongde.tianchen.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends TraceableGeneralServiceImpl<Album, AlbumDto> implements AlbumService {

    private AlbumRepository repository;

    private AlbumMapper mapper;


    @Autowired
    public void setRepository(AlbumRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(AlbumMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<Album, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Album, AlbumDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ALBUM_NOT_FOUND;
    }
}
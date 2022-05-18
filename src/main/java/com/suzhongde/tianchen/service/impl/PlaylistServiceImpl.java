package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.PlaylistDto;
import com.suzhongde.tianchen.entity.Playlist;
import com.suzhongde.tianchen.exception.BizException;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.PlaylistMapper;
import com.suzhongde.tianchen.repository.PlaylistRepository;
import com.suzhongde.tianchen.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository repository;

    private PlaylistMapper mapper;

    @Override
    public PlaylistDto get(String id) {
        Optional<Playlist> playlist = repository.findById(id);
        if (!playlist.isPresent()) {
            throw new BizException(ExceptionType.PLAYLIST_NOT_FOUND);
        }
        return mapper.toDto(playlist.get());
    }

    @Autowired
    public void setRepository(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(PlaylistMapper mapper) {
        this.mapper = mapper;
    }
}
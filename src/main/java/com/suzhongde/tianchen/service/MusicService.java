package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.MusicCreateRequest;
import com.suzhongde.tianchen.dto.MusicDto;
import com.suzhongde.tianchen.dto.MusicUpdateRequest;
import com.suzhongde.tianchen.entity.Music;

import java.util.List;

public interface MusicService extends GeneralService<Music, MusicDto> {

    void publish(String id);

    void close(String id);
}
package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.MusicCreateRequest;
import com.suzhongde.tianchen.dto.MusicDto;
import com.suzhongde.tianchen.dto.MusicSearchFilter;
import com.suzhongde.tianchen.dto.MusicUpdateRequest;
import com.suzhongde.tianchen.entity.Music;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MusicService extends GeneralService<Music, MusicDto> {

    Page<MusicDto> search(MusicSearchFilter musicSearchRequest);

    void publish(String id);

    void close(String id);
}
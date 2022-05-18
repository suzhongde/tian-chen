package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.AlbumDto;
import com.suzhongde.tianchen.dto.AlbumSearchFilter;
import com.suzhongde.tianchen.entity.Album;
import org.springframework.data.domain.Page;

public interface AlbumService extends GeneralService<Album, AlbumDto> {
    Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

    AlbumDto recommend(String id, Integer recommendFactor);

    AlbumDto cancelRecommendation(String id);
}
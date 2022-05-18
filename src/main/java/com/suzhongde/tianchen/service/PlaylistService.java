package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.PlaylistDto;
import com.suzhongde.tianchen.dto.PlaylistSearchFilter;
import com.suzhongde.tianchen.entity.Playlist;
import org.springframework.data.domain.Page;

public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
    Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

    PlaylistDto recommend(String id, Integer recommendFactor);

    PlaylistDto cancelRecommendation(String id);

    PlaylistDto makeSpecial(String id);

    PlaylistDto cancelSpecial(String id);
}
package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.ArtistCreateRequest;
import com.suzhongde.tianchen.dto.ArtistDto;
import com.suzhongde.tianchen.dto.ArtistUpdateRequest;

import java.util.List;

public interface ArtistService {
    ArtistDto create(ArtistCreateRequest artistCreateRequest);

    ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest);

    List<ArtistDto> list();
}
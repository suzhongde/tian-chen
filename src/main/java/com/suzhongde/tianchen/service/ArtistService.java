package com.suzhongde.tianchen.service;

import com.suzhongde.tianchen.dto.ArtistCreateRequest;
import com.suzhongde.tianchen.dto.ArtistDto;
import com.suzhongde.tianchen.dto.ArtistSearchFilter;
import com.suzhongde.tianchen.dto.ArtistUpdateRequest;
import com.suzhongde.tianchen.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArtistService extends GeneralService<Artist, ArtistDto> {

    List<ArtistDto> list();

    Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);
}
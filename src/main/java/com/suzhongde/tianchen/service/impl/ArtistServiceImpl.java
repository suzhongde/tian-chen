package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.ArtistCreateRequest;
import com.suzhongde.tianchen.dto.ArtistDto;
import com.suzhongde.tianchen.dto.ArtistUpdateRequest;
import com.suzhongde.tianchen.entity.Artist;
import com.suzhongde.tianchen.enums.ArtistStatus;
import com.suzhongde.tianchen.exception.BizException;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.ArtistMapper;
import com.suzhongde.tianchen.repository.ArtistRepository;
import com.suzhongde.tianchen.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistServiceImpl extends BaseService implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;

    @Override
    public ArtistDto create(ArtistCreateRequest artistCreateRequest) {
        Artist artist = mapper.createEntity(artistCreateRequest);
        artist.setStatus(ArtistStatus.DRAFT);
        artist.setCreatedBy(getCurrentUserEntity());
        artist.setUpdatedBy(getCurrentUserEntity());
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto update(String id, ArtistUpdateRequest artistUpdateRequest) {
        Optional<Artist> artistOptional = repository.findById(id);
        if (!artistOptional.isPresent()) {
            throw new BizException(ExceptionType.ARTIST_NOT_FOUND);
        }
        Artist artist = mapper.updateEntity(artistOptional.get(), artistUpdateRequest);

        return mapper.toDto(repository.save(artist));
    }

    @Override
    public List<ArtistDto> list() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(ArtistRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(ArtistMapper mapper) {
        this.mapper = mapper;
    }
}
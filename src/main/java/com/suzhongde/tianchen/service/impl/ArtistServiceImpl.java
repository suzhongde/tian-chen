package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.ArtistCreateRequest;
import com.suzhongde.tianchen.dto.ArtistDto;
import com.suzhongde.tianchen.dto.ArtistSearchFilter;
import com.suzhongde.tianchen.dto.ArtistUpdateRequest;
import com.suzhongde.tianchen.entity.Artist;
import com.suzhongde.tianchen.enums.ArtistStatus;
import com.suzhongde.tianchen.exception.BizException;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.ArtistMapper;
import com.suzhongde.tianchen.mapper.MapperInterface;
import com.suzhongde.tianchen.repository.ArtistRepository;
import com.suzhongde.tianchen.repository.specs.ArtistSpecification;
import com.suzhongde.tianchen.repository.specs.SearchCriteria;
import com.suzhongde.tianchen.repository.specs.SearchOperation;
import com.suzhongde.tianchen.service.ArtistService;
import com.suzhongde.tianchen.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {

    private ArtistMapper mapper;

    private ArtistRepository repository;


    @Override
    public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
        ArtistSpecification specs = new ArtistSpecification();
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        if (artistSearchFilter.getRecommended() != null) {
            specs.add(new SearchCriteria("recommended", artistSearchFilter.getRecommended(), SearchOperation.EQUAL));
        }
        return repository.findAll(specs, artistSearchFilter.toPageable()).map(mapper::toDto);
    }

    @Override
    public ArtistDto recommend(String id, Integer recommendFactor) {
        Artist artist = getEntity(id);
        artist.setRecommended(true);
        artist.setRecommendFactor(recommendFactor);
        return mapper.toDto(repository.save(artist));
    }

    @Override
    public ArtistDto cancelRecommendation(String id) {
        Artist artist = getEntity(id);
        artist.setRecommended(false);
        artist.setRecommendFactor(0);
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


    @Override
    public JpaRepository<Artist, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Artist, ArtistDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.ARTIST_NOT_FOUND;
    }
}
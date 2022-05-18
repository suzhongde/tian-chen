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
        // Todo: 代码重复需要重构
        specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
        Pageable pageable = PageRequest.of(artistSearchFilter.getPage() - 1, artistSearchFilter.getSize(), sort);
        return repository.findAll(specs, pageable).map(mapper::toDto);
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
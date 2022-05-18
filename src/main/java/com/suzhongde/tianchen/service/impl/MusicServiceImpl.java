package com.suzhongde.tianchen.service.impl;

import com.suzhongde.tianchen.dto.MusicCreateRequest;
import com.suzhongde.tianchen.dto.MusicDto;
import com.suzhongde.tianchen.dto.MusicSearchFilter;
import com.suzhongde.tianchen.dto.MusicUpdateRequest;
import com.suzhongde.tianchen.entity.Music;
import com.suzhongde.tianchen.enums.MusicStatus;
import com.suzhongde.tianchen.exception.BizException;
import com.suzhongde.tianchen.exception.ExceptionType;
import com.suzhongde.tianchen.mapper.MapperInterface;
import com.suzhongde.tianchen.mapper.MusicMapper;
import com.suzhongde.tianchen.repository.MusicRepository;
import com.suzhongde.tianchen.repository.specs.MusicSpecification;
import com.suzhongde.tianchen.repository.specs.SearchCriteria;
import com.suzhongde.tianchen.repository.specs.SearchOperation;
import com.suzhongde.tianchen.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

    private MusicRepository repository;

    private MusicMapper mapper;

    @Override
    public MusicDto create(MusicDto musicDto) {
        return super.create(musicDto);
    }

    @Override
    public Page<MusicDto> search(MusicSearchFilter musicSearchRequest) {
        if (musicSearchRequest == null) {
            musicSearchRequest = new MusicSearchFilter();
        }
        MusicSpecification specs = new MusicSpecification();
        specs.add(new SearchCriteria("name", musicSearchRequest.getName(), SearchOperation.MATCH));
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
        Pageable pageable = PageRequest.of(musicSearchRequest.getPage() - 1, musicSearchRequest.getSize(), sort);
        return repository.findAll(specs, pageable).map(mapper::toDto);
    }

    @Override
    public void publish(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.PUBLISHED);
        repository.save(music);
    }


    @Override
    public void close(String id) {
        Music music = getEntity(id);
        music.setStatus(MusicStatus.CLOSED);
        repository.save(music);
    }


    @Autowired
    public void setRepository(MusicRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(MusicMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<Music, String> getRepository() {
        return repository;
    }

    @Override
    public MapperInterface<Music, MusicDto> getMapper() {
        return mapper;
    }

    @Override
    public ExceptionType getNotFoundExceptionType() {
        return ExceptionType.MUSIC_NOT_FOUND;
    }
}

package com.suzhongde.tianchen.controller;

import com.suzhongde.tianchen.dto.AlbumCreateRequest;
import com.suzhongde.tianchen.dto.AlbumSearchFilter;
import com.suzhongde.tianchen.dto.AlbumUpdateRequest;
import com.suzhongde.tianchen.dto.RecommendRequest;
import com.suzhongde.tianchen.mapper.AlbumMapper;
import com.suzhongde.tianchen.service.AlbumService;
import com.suzhongde.tianchen.vo.AlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumService albumService;

    private AlbumMapper albumMapper;

    @PostMapping
    public AlbumVo create(@Validated @RequestBody AlbumCreateRequest albumCreateRequest) {
        return albumMapper.toVo(albumService.create(albumMapper.toDto(albumCreateRequest)));
    }

    @PostMapping("/{id}")
    public AlbumVo update(@PathVariable String id, @Validated @RequestBody AlbumUpdateRequest albumUpdateRequest) {
        return albumMapper.toVo(albumService.update(id, albumMapper.toDto(albumUpdateRequest)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        albumService.delete(id);
    }

    @GetMapping
    public Page<AlbumVo> search(@Validated AlbumSearchFilter albumSearchFilter) {
        return albumService.search(albumSearchFilter).map(albumMapper::toVo);
    }

    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AlbumVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return albumMapper.toVo(albumService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AlbumVo cancelRecommendation(@PathVariable String id) {
        return albumMapper.toVo(albumService.cancelRecommendation(id));
    }

    @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }
}
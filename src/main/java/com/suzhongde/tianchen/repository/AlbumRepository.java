package com.suzhongde.tianchen.repository;

import com.suzhongde.tianchen.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumRepository extends JpaRepository<Album, String> {
}
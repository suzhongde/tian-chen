package com.suzhongde.tianchen.repository;

import com.suzhongde.tianchen.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
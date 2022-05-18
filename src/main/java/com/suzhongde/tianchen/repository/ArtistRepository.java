package com.suzhongde.tianchen.repository;

import com.suzhongde.tianchen.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, String> {
    Optional<Artist> findById(String id);
}
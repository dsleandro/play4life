package com.dsleandro.play4life.repository;

import com.dsleandro.play4life.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    Page<Game> findAllByGenre(String genre, Pageable pageable);
    Page<Game> findAllByPlatform(String platform, Pageable pageable);
}

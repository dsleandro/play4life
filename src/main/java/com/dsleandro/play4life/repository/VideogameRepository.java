package com.dsleandro.play4life.repository;

import com.dsleandro.play4life.entity.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideogameRepository extends JpaRepository<Videogame,Long> {
    Page<Videogame> findAllByGenre(String genre, Pageable pageable);
    Page<Videogame> findAllByPlatform(String platform, Pageable pageable);

}

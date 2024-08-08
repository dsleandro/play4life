package com.dsleandro.play4life.controller;

import com.dsleandro.play4life.entity.Videogame;
import com.dsleandro.play4life.repository.VideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class VideogameController {
    @Autowired
    VideogameRepository videogameRepository;

    @GetMapping("/all")
    public ResponseEntity<Videogame> getAllPAged(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(videogameRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{genre}/all")
    public ResponseEntity<Videogame> getByGenre(String genre, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(videogameRepository.findAllByGenre(genre, pageable), HttpStatus.OK);
    }

    @GetMapping("/{platform}/all")
    public ResponseEntity<Videogame> getByPlatform(String platform, @PageableDefault(size = 10) Pageable pageable){
        return new ResponseEntity(videogameRepository.findAllByPlatform(platform, pageable), HttpStatus.OK) ;
    }
}

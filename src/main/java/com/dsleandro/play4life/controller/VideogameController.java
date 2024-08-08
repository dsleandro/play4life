package com.dsleandro.play4life.controller;

import com.dsleandro.play4life.entity.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import com.dsleandro.play4life.repository.VideogameRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class VideogameController {

    @Autowired
    VideogameRepository videogameRepository;

    @GetMapping("/all")
    public ResponseEntity<Videogame> getAllPAged(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(videogameRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}/all")
    public ResponseEntity<Videogame> getByGenre(String genre, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(videogameRepository.findAllByGenre(genre, pageable), HttpStatus.OK);
    }

    @GetMapping("/platform/{platform}/all")
    public ResponseEntity<Videogame> getByPlatform(String platform, @PageableDefault(size = 10) Pageable pageable){
        return new ResponseEntity(videogameRepository.findAllByPlatform(platform, pageable), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Videogame> saveVideogame(Videogame videogame){
        return new ResponseEntity(videogameRepository.save(videogame), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videogame> updateVideogame(Long Id, Videogame videogame){
        videogameRepository.findById(Id).orElseThrow(() -> new RuntimeException("Videogame not found"));
        return new ResponseEntity(videogameRepository.save(videogame), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVideogame(Long id){
        videogameRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

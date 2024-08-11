package com.dsleandro.play4life.controller;

import com.dsleandro.play4life.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import com.dsleandro.play4life.repository.GameRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/all")
    public ResponseEntity<Game> getAllPAged(@PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(gameRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}/all")
    public ResponseEntity<Game> getByGenre(@PathVariable("genre") String genre, @PageableDefault(size = 10) Pageable pageable) {
        return new ResponseEntity(gameRepository.findAllByGenre(genre, pageable), HttpStatus.OK);
    }

    @GetMapping("/platform/{platform}/all")
    public ResponseEntity<Game> getByPlatform(@PathVariable("platform") String platform, @PageableDefault(size = 10) Pageable pageable){
        return new ResponseEntity(gameRepository.findAllByPlatform(platform, pageable), HttpStatus.OK) ;
    }

    @PostMapping("/new")
    public ResponseEntity<Game> saveVideogame(@RequestBody Game game){
        return new ResponseEntity(gameRepository.save(game), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateVideogame(@RequestBody Game game){
        gameRepository.findById(game.getId()).orElseThrow(() -> new RuntimeException("Game not found"));
        return new ResponseEntity(gameRepository.save(game), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVideogame(@PathVariable("id") Long id){
        gameRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

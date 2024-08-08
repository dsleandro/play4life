package com.dsleandro.play4life.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Videogame {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String genre;
    private String platform;
}

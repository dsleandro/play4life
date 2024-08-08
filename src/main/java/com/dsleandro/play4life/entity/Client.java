package com.dsleandro.play4life.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String genre;
    private int age;
}

package com.dsleandro.play4life.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long videogameId;
    private String customerId;
    private String date;
    private float amount;
}

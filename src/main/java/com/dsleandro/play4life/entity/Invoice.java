package com.dsleandro.play4life.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "gameId")
    private Long gameId;
    @Column(name = "customerId")
    private String customerId;
    @Column(name = "date")
    private String date;
    @Column(name = "amount")
    private float amount;
}

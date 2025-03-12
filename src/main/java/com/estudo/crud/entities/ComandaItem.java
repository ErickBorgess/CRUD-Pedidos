package com.estudo.crud.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "comanda_item")
public class ComandaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comanda_id")
    @JsonIgnore
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantidade;
    private double precoUnitario;
}

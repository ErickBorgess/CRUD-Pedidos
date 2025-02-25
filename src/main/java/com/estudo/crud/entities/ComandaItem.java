package com.estudo.crud.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comanda_item")
public class ComandaItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComandaItem;
}

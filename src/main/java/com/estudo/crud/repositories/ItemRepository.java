package com.estudo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.crud.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}

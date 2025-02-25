package com.estudo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.crud.entities.ComandaItem;

public interface ComandaItemRepository extends JpaRepository<ComandaItem, Long>{
    
}

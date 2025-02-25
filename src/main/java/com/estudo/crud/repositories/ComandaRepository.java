package com.estudo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.crud.entities.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    
}

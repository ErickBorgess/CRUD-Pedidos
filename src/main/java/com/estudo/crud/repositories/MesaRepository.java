package com.estudo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.crud.entities.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long>{
    
}

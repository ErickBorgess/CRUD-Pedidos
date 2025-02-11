package com.estudo.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.crud.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}

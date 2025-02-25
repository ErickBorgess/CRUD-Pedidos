package com.estudo.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.estudo.crud.entities.Pedido;
import com.estudo.crud.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin("*")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarPedido(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }
}

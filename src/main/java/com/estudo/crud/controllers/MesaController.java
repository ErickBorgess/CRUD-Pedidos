package com.estudo.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.estudo.crud.entities.Mesa;
import com.estudo.crud.services.MesaService;

@RequestMapping("/mesas")
@CrossOrigin("*")
@RestController
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @PostMapping
    public Mesa criarMesa(@RequestBody Mesa mesa) {
        return mesaService.criarMesa(mesa);
    }

    @GetMapping 
    public List<Mesa> listarPedidos() {
        return mesaService.listarMesas();
    }

    @GetMapping("/{id}")
    public Optional<Mesa> buscarMesa(@PathVariable Long id) {
        return mesaService.buscarMesa(id);
    }

    @DeleteMapping("/{id}")
    public void deletarMesa(@PathVariable Long id) {
        mesaService.deletarMesa(id);
    }
}

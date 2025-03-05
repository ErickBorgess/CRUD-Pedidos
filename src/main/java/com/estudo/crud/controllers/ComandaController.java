package com.estudo.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.crud.entities.Comanda;
import com.estudo.crud.services.ComandaService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("/*")
public class ComandaController {
    @Autowired
    private ComandaService comandaService;

    @PostMapping
    public Comanda criarComanda(@RequestBody Comanda comanda) {
        return comandaService.criarComanda(comanda);
    }

    @GetMapping
    public List<Comanda> listarComandas() {
        return comandaService.listarComandas();
    }

    @GetMapping("/{id}")
    public Optional<Comanda> buscarComanda(@PathVariable Long id) {
        return comandaService.buscarComanda(id);
    }

    @PostMapping("/additem")
    public Comanda adicionarItemComanda(Long idComanda, Long idItem, int quantidade) {
        return comandaService.adicionarItem(idComanda, idItem, quantidade);
    }

    @PostMapping("/{id}")
    public void fecharComanda(@PathVariable Long id) {
        comandaService.fecharComanda(id);
    }

    @DeleteMapping("/{id}")
    public void deletarComanda(@PathVariable Long id) {
        comandaService.deletarComanda(id);
    }

}

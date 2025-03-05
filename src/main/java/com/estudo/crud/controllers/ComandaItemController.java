package com.estudo.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.crud.entities.ComandaItem;
import com.estudo.crud.services.ComandaItemService;

@RestController
@RequestMapping("/comanda-itens")
public class ComandaItemController {
    @Autowired
    private ComandaItemService comandaItemService;

    @GetMapping
    public List<ComandaItem> listarComandaItens() {
        return comandaItemService.listarComandaItens();
    }

    @GetMapping("/{id}")
    public Optional<ComandaItem> buscarComandaItem(@PathVariable Long id) {
       return comandaItemService.buscarComandaItem(id);
    }

    @PostMapping
    public ComandaItem salvarComanda(@RequestBody ComandaItem comandaItem) {
        return comandaItemService.salvarComanda(comandaItem);
    }

    @DeleteMapping("/{id}")
    public void deletarComandaItem(@PathVariable Long id) {
        comandaItemService.deletarComandaItem(id);
    }
}

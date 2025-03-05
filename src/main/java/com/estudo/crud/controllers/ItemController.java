package com.estudo.crud.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.crud.entities.Item;
import com.estudo.crud.services.ItemService;

@RestController
@RequestMapping("/estoque")
@CrossOrigin("/*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item criarItem(@RequestBody Item item) {
        return itemService.criarItem(item);
    }

    @PutMapping("/{id}")
    public Item atualizarItem(@PathVariable Long id, @RequestBody Item itemAtualizado) {
        return itemService.atualizarItem(id, itemAtualizado);
    }

    @GetMapping
    public List<Item> listarItens() {
        return itemService.listarItens();
    }

    @GetMapping("/{id}")
    public Optional<Item> buscarItem(@PathVariable Long id) {
        return itemService.buscarItem(id);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable Long id) {
        itemService.deletarItem(id);
    }

}

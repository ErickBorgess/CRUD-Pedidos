package com.estudo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.crud.entities.Item;
import com.estudo.crud.repositories.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    /*public Item criarItem(Item item) {
        return
    }*/

    public void deletarItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    public Optional<Item> buscarItem(Long id) {
        return itemRepository.findById(id);
    }
}

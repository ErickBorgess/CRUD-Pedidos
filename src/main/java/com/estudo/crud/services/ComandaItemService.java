package com.estudo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.crud.entities.ComandaItem;
import com.estudo.crud.repositories.ComandaItemRepository;

@Service
public class ComandaItemService {
    @Autowired
    private ComandaItemRepository comandaItemRepository;

    public List<ComandaItem> listarComandaItens() {
        return comandaItemRepository.findAll();
    }

    public Optional<ComandaItem> buscarComandaItem(Long id) {
        return comandaItemRepository.findById(id);
    }

    public ComandaItem salvarComanda(ComandaItem comandaItem) {
        return comandaItemRepository.save(comandaItem);
    }

    public void deletarComandaItem(Long id) {
        comandaItemRepository.deleteById(id);
    }
}

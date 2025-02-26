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

    public List<ComandaItem> listarComandas() {
        return comandaItemRepository.findAll();
    }

    public Optional<ComandaItem> buscarComanda(Long id) {
        return comandaItemRepository.findById(id);
    }

    public ComandaItem criarComanda(ComandaItem comandaItem) {
        return comandaItemRepository.save(comandaItem);
    }

    public void deletarComanda(Long id) {
        comandaItemRepository.deleteById(id);
    }
}

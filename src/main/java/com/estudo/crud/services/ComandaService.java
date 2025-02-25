package com.estudo.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.crud.entities.Comanda;
import com.estudo.crud.entities.ComandaItem;
import com.estudo.crud.entities.Item;
import com.estudo.crud.repositories.ComandaRepository;
import com.estudo.crud.repositories.ItemRepository;

@Service
public class ComandaService {
    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private ItemRepository itemRepository;

    public Comanda adicionarItem(Long idComanda, Long idItem, int quantidade) {
        Comanda comanda = comandaRepository.findById(idComanda)
            .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));
        Item item = itemRepository.findById(idItem)
            .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        ComandaItem comandaItem = new ComandaItem();
        comandaItem.setComanda(comanda);
        comandaItem.setItem(item);
        comandaItem.setQuantidade(quantidade);
        comandaItem.setPrecoUnitario(quantidade);

        comandaItem.getItem().add(comandaItem);
        return comandaRepository.save(comanda);
    }

    private List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    private Optional<Comanda> buscarComanda(Long id) {
        return comandaRepository.findById(id);
    }

    private Comanda criarComanda(Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    private void deletarComanda(Long id) {
        comandaRepository.deleteById(id);
    }
}

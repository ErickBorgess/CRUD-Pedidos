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

    public Item criarItem(String nomeItem, double preco) {
       Item item = new Item();
       item.setNomeItem(nomeItem);
       item.setPreco(preco);
       return itemRepository.save(item);
    }

    public List<Item> criarItens(List<Item> itens) {
        return itemRepository.saveAll(itens);
    }

    public Item criarItem(Item item) {
        if (item.getPreco() < 0) {
            throw new IllegalArgumentException("O preço do item não pode ser negativo!");
        }
        return itemRepository.save(item);
    }

    public Item atualizarItem(Long id, Item itemAtualizado) {
        return itemRepository.findById(id).map(item -> {
            item.setNomeItem(itemAtualizado.getNomeItem());
            item.setPreco(itemAtualizado.getPreco());
            return itemRepository.save(item);
        }).orElseThrow(() -> new RuntimeException("Item não encontrado!"));
    }

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

package com.estudo.crud.services;

import java.util.ArrayList;
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
        comandaItem.setPrecoUnitario(item.getPreco());

        comandaItem.getItem().add(comandaItem);
        comanda.setValorTotal(comanda.getValorTotal() + (item.getPreco() * quantidade));

        return comandaRepository.save(comanda);
    }

    public List<Comanda> listarComandas() {
        return comandaRepository.findAll();
    }

    public Optional<Comanda> buscarComanda(Long id) {
        return comandaRepository.findById(id);
    }

    public Comanda criarComanda(Comanda comanda) {
        comanda.setValorTotal(0.0);
        comanda.setItens(new ArrayList<>());
        return comandaRepository.save(comanda);
    }

    public void deletarComanda(Long id) {
        comandaRepository.deleteById(id);
    }

    public void fecharComanda(Long id) {
        Comanda comanda = comandaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));
        comanda.setStatus(false);
        double total = comanda.getItens().stream()
            .mapToDouble(item -> item.getPrecoUnitario() * item.getQuantidade())
            .sum();
        comanda.setValorTotal(total);
        comandaRepository.save(comanda);
    }

}

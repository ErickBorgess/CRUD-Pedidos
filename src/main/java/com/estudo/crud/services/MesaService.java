package com.estudo.crud.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.crud.entities.Mesa;
import com.estudo.crud.repositories.MesaRepository;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> listarMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> buscarMesa(Long id) {
        return mesaRepository.findById(id);
    }

    public Mesa criarMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public void deletarMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}

package com.estudo.crud.entities;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "comanda")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComanda; //PK

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComandaItem> itens;
    
    private String descricao;
    private double valorTotal;
    private LocalDateTime dataAbertura = LocalDateTime.now();
    private boolean status = true;

    public List<ComandaItem> getItens() {
        return itens;
    }

}

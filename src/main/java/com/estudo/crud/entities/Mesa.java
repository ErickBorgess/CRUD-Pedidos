package com.estudo.crud.entities;

import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa; //PK

    private String descricaoMesa;

    @OneToMany(mappedBy = "mesa")
    private List<Comanda> comandas;
}

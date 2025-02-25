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

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ComandaItem> itens;

    private LocalDateTime dataAbertura;
    private Boolean status;

}

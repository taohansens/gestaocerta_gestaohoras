package com.gestaocerta.microgestaohoras.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class BancoHoras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pontoEletronicoId;
    private Long empregadoId;
    private LocalDate data;
    private Double saldo;
}

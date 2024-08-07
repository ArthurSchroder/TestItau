package com.desafioItau.entities;

import com.desafioItau.controller.dto.TransacaoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(name = "valor")
    public BigDecimal valor;
    @Column(name = "data_hora")
    public OffsetDateTime dataHora;

    public Transacao(TransacaoDTO transacaoDTO){
        this.valor = transacaoDTO.getValor();
        this.dataHora = transacaoDTO.getDataHora();
    }
}

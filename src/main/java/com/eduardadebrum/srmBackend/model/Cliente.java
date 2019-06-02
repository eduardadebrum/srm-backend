package com.eduardadebrum.srmBackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Classe responsavél pelo mapeamento da tabela cliente para o banco de dados.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @NotBlank(message = "Nome do Cliente é Obrigatório")
    @Column(name = "NOME")
    private String nome;

    @NotNull(message = "Limite de Crédito é Obrigatório")
    @Column(name = "LIMITE_CREDITO")
    private BigDecimal limiteCredito;

    @NotNull(message = "Risco é Obrigatório")
    @Column(name = "RISCO")
    @Convert(converter = RiscoEnumConverter.class)
    private RiscoEnum risco;


}

package com.client.api.account;

import com.client.api.client.Client;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) //se tiene que aplicar sobre un atributo
    private Client clientId;

    private String numeroCuenta;
    private Currency moneda;
    private BigDecimal saldo;
    private Boolean activo;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
}
package com.client.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    private static final int DIAS_UMBRAL = 35;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidoRazonSocial;
    private String documentoCuit;
    private String direccion;
    private String telefono;
    private String email;


    // Nuevos atributos
    private String tipoCliente;     // "PERSONA_FISICA" o "EMPRESA"
    private boolean activo;         // estado del cliente
    private double saldoPendiente;  // deuda acumulada en pesos
    private LocalDate fechaAlta;    // fecha de registro en el sistema

    public boolean esClienteReciente() {
        if (fechaAlta == null) return false;
        return !fechaAlta.isBefore(LocalDate.now().minusDays(DIAS_UMBRAL));
    }

}
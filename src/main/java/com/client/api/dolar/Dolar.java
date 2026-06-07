package com.client.api.dolar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // puedo hacer lo mismo que con el requiredArgsContructor
public class Dolar {

    private String moneda;
    private String casa;
    private String nombre;
    private double compra;
    private double venta;
    private LocalDate fechaActualizacion;

}
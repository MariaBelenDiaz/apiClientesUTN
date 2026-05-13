package com.client.api;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientTest {

    @Test
    void esClienteReciente() {

        // Given
        Client client = new Client();

        // Cliente dado de alta hace menos de 35 días
        client.setFechaAlta(LocalDate.now().minusDays(10));

        // When
        boolean resultado = client.esClienteReciente();

        // Then
        assertTrue(resultado);
    }

    @Test
    void noEsClienteReciente() {

        // Given
        Client client = new Client();

        // Cliente dado de alta hace más de 35 días
        client.setFechaAlta(LocalDate.now().minusDays(50));

        // When
        boolean resultado = client.esClienteReciente();

        // Then
        assertFalse(resultado);
    }

    @Test
    void fechaAltaNull_devuelveFalse() {

        // Given
        Client client = new Client();

        // When
        boolean resultado = client.esClienteReciente();

        // Then
        assertFalse(resultado);
    }
}
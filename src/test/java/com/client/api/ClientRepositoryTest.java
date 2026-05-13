package com.client.api;

import com.client.api.Client;
import com.client.api.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void debeGuardarCliente() {

        //Contexto inicial
        Client clienteAGuardar = new Client();
        clienteAGuardar.setNombre("Juan");
        clienteAGuardar.setDocumentoCuit("12345");
        clienteAGuardar.setActivo(true);

        //Ejecucion de alguna funcionalidad
        Client clienteGuardado = clientRepository.save(clienteAGuardar);

        //Chequeo del correcto funcionamiento
        assertThat(clienteGuardado.getId()).isNotNull();
        assertThat(clienteGuardado.getNombre()).isEqualTo("Juan");
        //assertThat(clienteGuardado.getNombre()).isEqualTo("Juano"); //este falla
    }
}
package com.client.api.client;

import com.client.api.account.Account;
import com.client.api.dolar.Dolar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/agregar")
    public Client addClient(@RequestBody Client addedClient) {
        return clientService.addClient(addedClient);
    }

    @GetMapping
    public List<Client> getClient() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        return clientService.updateClient(id, updatedClient);
    }

    @GetMapping("/cotizacion")
    public Dolar getCotizacion() {
        return clientService.getCotizacion();
    }

    //mio
    @GetMapping("/cotizacion/compra")
    public Double getCotizacionCompra() {
        Dolar dolar = clientService.getCotizacion();

        return dolar.getCompra();
    }

// Ejemplo uso de builder
//    @GetMapping("/cotizacion")
//    public Dolar getCotizacion() {
//        return Dolar.builder()
//                .moneda("1")
//                .casa("2")
//                .nombre("3")
//                .venta(1111)
//                .compra(2222)
//                .fechaActualizacion(LocalDate.of(2026, 5, 27))
//                .build();
//    }


}
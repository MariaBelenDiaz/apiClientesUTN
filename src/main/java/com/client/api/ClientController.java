package com.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/agregar")
    public Client addClient(@RequestBody Client addedClient){
        return clientService.addClient(addedClient);
    }

    @GetMapping
    public List<Client> getClient() {
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable Long id){
        clientService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient){
        return clientService.updateClient(id, updatedClient);
    }

}
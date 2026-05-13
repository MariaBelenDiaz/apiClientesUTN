package com.client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client>  getClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id){
        return clientRepository.getReferenceById(id);
    }


    public Client addClient(Client addedClient){
        return clientRepository.save(addedClient);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client updatedClient){
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existingClient.setNombre(updatedClient.getNombre());
        existingClient.setApellidoRazonSocial(updatedClient.getApellidoRazonSocial());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setTelefono(updatedClient.getTelefono());
        existingClient.setDireccion(updatedClient.getDireccion());
        existingClient.setDocumentoCuit(updatedClient.getDocumentoCuit());

        return clientRepository.save(existingClient);
    }


}
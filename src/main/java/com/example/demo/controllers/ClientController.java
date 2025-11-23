package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    public ClientService clientService;

    @GetMapping
    public List<ClientDTO> findAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findClientById(@PathVariable Long id) {
        Client client = clientService.getByClientId(id);
        return new ClientDTO(client);
    }

    @PostMapping
    public ClientDTO createClient(@Valid @RequestBody ClientDTO body) {
        Client client = clientService.createClient(body);
        return new ClientDTO(client);
    }

    @PatchMapping(value = "/{id}")
    public ClientDTO updateClient(@RequestBody ClientDTO body, @PathVariable Long id) {
        Client client = clientService.updateClient(body, id);
        return new ClientDTO(client);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
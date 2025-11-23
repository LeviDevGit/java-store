package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.ClientDTO;
import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientDTO> findAllClients() {
        List<Client> result = clientRepository.findAll();
        return result.stream().map(ClientDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public Client getByClientId(Long id) {
        Client result = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return result;
    }

    @Transactional
    public Client createClient(ClientDTO body) {
        Client client = clientRepository.save(new Client(body));
        return client;
    }

    @Transactional
    public Client updateClient(ClientDTO body, Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (body.getNome() != null) {
            client.setNome(body.getNome());
        }

        if (body.getEmail() != null) {
            client.setEmail(body.getEmail());
        }

        if (body.getTelefone() != null) {
            client.setTelefone(body.getTelefone());
        }

        return client;
    }

    @Transactional
    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        clientRepository.delete(client);
    }
}
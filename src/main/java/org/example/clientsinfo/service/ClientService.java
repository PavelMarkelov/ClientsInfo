package org.example.clientsinfo.service;

import jakarta.transaction.Transactional;
import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.repos.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDtoResponse> findAllClients() {
        List<ClientDtoResponse> clients = new ArrayList<>();
        clientRepository.findAll().forEach(client ->
                clients.add(new ClientDtoResponse(client)));
        clients.sort(Comparator
                .comparing(ClientDtoResponse::getFistName)
                .thenComparing(ClientDtoResponse::getLastName));
        return clients;
    }
}

package org.example.clientsinfo.service;

import jakarta.transaction.Transactional;
import org.example.clientsinfo.dto.request.ClientDtoRequest;
import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.entities.Client;
import org.example.clientsinfo.repos.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public ClientDtoResponse addClient(ClientDtoRequest request) {
        Client client;
        Optional<Client> clientFromRepos = Optional.ofNullable(clientRepository.findClientByFirstNameAndLastName(request.getFistName(), request.getLastName()));
        if (clientFromRepos.isPresent()) {
            client = clientFromRepos.get();
            if (client.equalsByContacts(request.getPhoneNumbers(), request.getEmailList())) {
                return new ClientDtoResponse(client);
            }
        }
        client = new Client(request);
        return new ClientDtoResponse(clientRepository.save(client));
    }
}

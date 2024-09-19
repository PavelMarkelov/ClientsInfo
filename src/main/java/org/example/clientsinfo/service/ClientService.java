package org.example.clientsinfo.service;

import jakarta.transaction.Transactional;
import org.example.clientsinfo.dto.request.ClientDtoRequest;
import org.example.clientsinfo.dto.request.EmailDtoRequest;
import org.example.clientsinfo.dto.request.PhoneDtoRequest;
import org.example.clientsinfo.dto.response.ClientContactsResponse;
import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.dto.response.ClientEmailListResponse;
import org.example.clientsinfo.dto.response.ClientPhonesResponse;
import org.example.clientsinfo.entities.Client;
import org.example.clientsinfo.entities.Email;
import org.example.clientsinfo.entities.Phone;
import org.example.clientsinfo.repos.ClientRepository;
import org.example.clientsinfo.repos.EmailRepository;
import org.example.clientsinfo.repos.PhoneRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;
    private final PhoneRepository phoneRepository;
    private final EmailRepository emailRepository;

    public ClientService(ClientRepository clientRepository, PhoneRepository phoneRepository, EmailRepository emailRepository) {
        this.clientRepository = clientRepository;
        this.phoneRepository = phoneRepository;
        this.emailRepository = emailRepository;
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

        Client finalClient = client;
        Set<Phone> phones = request.getPhoneNumbers().stream().map(s -> new Phone(finalClient, s)).collect(Collectors.toSet());
        finalClient.setPhoneNumbers(phones);
        Set<Email> emailList = request.getEmailList().stream().map(s -> new Email(finalClient, s)).collect(Collectors.toSet());
        finalClient.setEmailList(emailList);

        return new ClientDtoResponse(clientRepository.save(finalClient));
    }

    public ClientDtoResponse addClientPhone(PhoneDtoRequest request) {
        Phone phone;
        Optional<Phone> phoneFromRepos = Optional.ofNullable(phoneRepository.findByPhone(request.getPhone()));
        if (phoneFromRepos.isPresent()) {
            phone = phoneFromRepos.get();
            return new ClientDtoResponse(phone.getClient());
        } else {
            Client client = clientRepository.findClientById(request.getClientId());
            phone = new Phone(client, request.getPhone());
            return new ClientDtoResponse(phoneRepository.save(phone).getClient());
        }
    }

    public ClientDtoResponse addClientEmail(EmailDtoRequest request) {
        Email email;
        Optional<Email> emailFromRepos = Optional.ofNullable(emailRepository.findByEmail(request.getEmail()));
        if (emailFromRepos.isPresent()) {
            email = emailFromRepos.get();
            return new ClientDtoResponse(email.getClient());
        } else {
            Client client = clientRepository.findClientById(request.getClientId());
            email = new Email(client, request.getEmail());
            return new ClientDtoResponse(emailRepository.save(email).getClient());
        }
    }

    public ClientDtoResponse findClient(long id) {
        Client client;
        Optional<Client> clientFromRepos = Optional.ofNullable(clientRepository.findClientById(id));
        if (clientFromRepos.isPresent()) {
            client = clientFromRepos.get();
            return new ClientDtoResponse(client);
        }
        return new ClientDtoResponse();
    }

    public ClientPhonesResponse findClientPhones(long id) {
        Client client;
        Optional<Client> clientFromRepos = Optional.ofNullable(clientRepository.findClientById(id));
        if (clientFromRepos.isPresent()) {
            client = clientFromRepos.get();
            return new ClientPhonesResponse(id, client.getPhoneNumbersAsStrings());
        }
        return new ClientPhonesResponse();
    }

    public ClientEmailListResponse findClientEmailList(long id) {
        Client client;
        Optional<Client> clientFromRepos = Optional.ofNullable(clientRepository.findClientById(id));
        if (clientFromRepos.isPresent()) {
            client = clientFromRepos.get();
            return new ClientEmailListResponse(id, client.getEmailListAsStrings());
        }
        return new ClientEmailListResponse();
    }

    public ClientContactsResponse findClientContacts(long id) {
        Client client;
        Optional<Client> clientFromRepos = Optional.ofNullable(clientRepository.findClientById(id));
        if (clientFromRepos.isPresent()) {
            client = clientFromRepos.get();
            return new ClientContactsResponse(id, client.getPhoneNumbersAsStrings(), client.getEmailListAsStrings());
        }
        return new ClientContactsResponse();
    }
}

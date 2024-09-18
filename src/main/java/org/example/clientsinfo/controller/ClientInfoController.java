package org.example.clientsinfo.controller;

import org.example.clientsinfo.dto.request.ClientDtoRequest;
import org.example.clientsinfo.dto.request.EmailDtoRequest;
import org.example.clientsinfo.dto.request.PhoneDtoRequest;
import org.example.clientsinfo.dto.response.ClientContactsResponse;
import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.dto.response.ClientEmailListResponse;
import org.example.clientsinfo.dto.response.ClientPhonesResponse;
import org.example.clientsinfo.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientInfoController {

    private final ClientService clientService;

    public ClientInfoController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDtoResponse> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/client")
    public ClientDtoResponse getClient(long id) {
        return clientService.findClient(id);
    }

    @GetMapping("/clientPhones")
    public ClientPhonesResponse getClientPhones(long id) {
        return clientService.findClientPhones(id);
    }

    @GetMapping("/clientEmailList")
    public ClientEmailListResponse getClientEmailList(long id) {
        return clientService.findClientEmailList(id);
    }

    @GetMapping("/clientContacts")
    public ClientContactsResponse getClientContacts(long id) {
        return clientService.findClientContacts(id);
    }

    @PostMapping("/client")
    public ClientDtoResponse addClient(@RequestBody ClientDtoRequest request) {
        return clientService.addClient(request);
    }

    @PostMapping("/clientPhone")
    public ClientDtoResponse addClientPhone(@RequestBody PhoneDtoRequest request) {
        return clientService.addClientPhone(request);
    }

    @PostMapping("/clientEmail")
    public ClientDtoResponse addClientEmail(@RequestBody EmailDtoRequest request) {
        return clientService.addClientEmail(request);
    }
}

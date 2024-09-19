package org.example.clientsinfo.controller;

import org.example.clientsinfo.dto.request.ClientDtoRequest;
import org.example.clientsinfo.dto.request.EmailDtoRequest;
import org.example.clientsinfo.dto.request.PhoneDtoRequest;
import org.example.clientsinfo.dto.response.ClientContactsResponse;
import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.dto.response.ClientEmailListResponse;
import org.example.clientsinfo.dto.response.ClientPhonesResponse;
import org.example.clientsinfo.service.ClientService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/client/{id}")
    public ClientDtoResponse getClient(@PathVariable("id") long id) {
        return clientService.findClient(id);
    }

    @GetMapping("/clientPhones/{id}")
    public ClientPhonesResponse getClientPhones(@PathVariable("id") long id) {
        return clientService.findClientPhones(id);
    }

    @GetMapping("/clientEmailList/{id}")
    public ClientEmailListResponse getClientEmailList(@PathVariable("id") long id) {
        return clientService.findClientEmailList(id);
    }

    @GetMapping("/clientContacts/{id}")
    public ClientContactsResponse getClientContacts(@PathVariable("id") long id) {
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

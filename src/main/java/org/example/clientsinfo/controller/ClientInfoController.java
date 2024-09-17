package org.example.clientsinfo.controller;

import org.example.clientsinfo.dto.response.ClientDtoResponse;
import org.example.clientsinfo.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientInfoController {

    private final ClientService clientService;

    public ClientInfoController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<ClientDtoResponse> getAllCustomer() {
        return clientService.findAllClients();
    }
}

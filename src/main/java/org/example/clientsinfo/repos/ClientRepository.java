package org.example.clientsinfo.repos;

import org.example.clientsinfo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findClientById(Long id);
}

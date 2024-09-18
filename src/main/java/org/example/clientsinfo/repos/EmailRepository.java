package org.example.clientsinfo.repos;

import org.example.clientsinfo.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}

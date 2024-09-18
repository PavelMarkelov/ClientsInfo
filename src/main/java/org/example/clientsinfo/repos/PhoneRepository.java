package org.example.clientsinfo.repos;

import org.example.clientsinfo.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}

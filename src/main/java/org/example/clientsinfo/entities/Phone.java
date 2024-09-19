package org.example.clientsinfo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    private String phone;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Phone() {
    }

    public Phone(Long id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public Phone(String phone) {
        this.phone = phone;
    }

    public Phone(Client client, String phone) {
        this.client = client;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone1 = (Phone) o;
        return Objects.equals(phone, phone1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phone);
    }

    @Override
    public String toString() {
        return String.format("Phone: [id=%s phone=%s]", id, phone);
    }
}

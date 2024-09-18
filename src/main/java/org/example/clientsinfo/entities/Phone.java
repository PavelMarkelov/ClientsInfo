package org.example.clientsinfo.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Id.class)
    @Getter
    @Setter
    private Long id;

    @Setter
    @Getter
    private String phone;

    @Getter
    @Setter
    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(View.Id.class)
    private Client client;

    public Phone() {
    }

    public Phone(Long id, String phone) {
        this.id = id;
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
        Phone phone = (Phone) o;
        return Objects.equals(id, phone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format("Phone: [id=%s phone=%s]", id, phone);
    }
}

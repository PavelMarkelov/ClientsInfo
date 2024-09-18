package org.example.clientsinfo.entities;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.clientsinfo.dto.request.ClientDtoRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.Id.class)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @OneToMany(mappedBy = "phone", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Phone> phoneNumbers = new ArrayList<>();

    @OneToMany(mappedBy = "email", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Email> emailList = new ArrayList<>();

    public Client() {
    }

    public Client(ClientDtoRequest request) {
        firstName = request.getFistName();
        lastName = request.getLastName();
    }

    public List<String> getPhoneNumbersAsStrings() {
        return phoneNumbers.stream().map(Phone::getPhone).sorted().toList();
    }

    public List<String> getEmailListAsStrings() {
        return emailList.stream().map(Email::getEmail).sorted().toList();
    }

    public boolean equalsByContacts(List<String> phoneNumbers, List<String> emailList) {
        Collections.sort(phoneNumbers);
        Collections.sort(emailList);
        return getPhoneNumbersAsStrings().equals(phoneNumbers) && getEmailListAsStrings().equals(emailList);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }
}

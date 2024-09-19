package org.example.clientsinfo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.clientsinfo.dto.request.ClientDtoRequest;

import java.util.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;

    @Getter
    @Setter
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Phone> phoneNumbers = new HashSet<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Email> emailList = new HashSet<>();

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

    public void addPhone(Phone phone) {
        phoneNumbers.add(phone);
    }

    public void addEmail(Email email) {
        emailList.add(email);
    }
}

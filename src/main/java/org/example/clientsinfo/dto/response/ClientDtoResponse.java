package org.example.clientsinfo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.clientsinfo.entities.Client;
import org.example.clientsinfo.entities.Email;
import org.example.clientsinfo.entities.Phone;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDtoResponse {

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String fistName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private List<Phone> phoneNumbers;

    @Getter
    @Setter
    private List<Email> emailList;

    public ClientDtoResponse() {
    }

    public ClientDtoResponse(long id, String fistName, String lastName, List<Phone> phoneNumbers, List<Email> emailList) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.emailList = emailList;
    }

    public ClientDtoResponse(Client client) {
        this.id = client.getId();
        this.fistName = client.getFirstName();
        this.lastName = client.getLastName();
        this.phoneNumbers = client.getPhoneNumbers();
        this.emailList = client.getEmailList();
    }
}

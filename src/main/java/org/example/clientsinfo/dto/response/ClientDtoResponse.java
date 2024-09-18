package org.example.clientsinfo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.example.clientsinfo.entities.Client;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDtoResponse {

    private long id;

    private String fistName;

    private String lastName;

    private List<String> phoneNumbers = new ArrayList<>();

    private List<String> emailList = new ArrayList<>();

    public ClientDtoResponse() {
    }

    public ClientDtoResponse(Client client) {
        this.id = client.getId();
        this.fistName = client.getFirstName();
        this.lastName = client.getLastName();
        this.phoneNumbers = client.getPhoneNumbersAsStrings();
        this.emailList = client.getEmailListAsStrings();
    }
}

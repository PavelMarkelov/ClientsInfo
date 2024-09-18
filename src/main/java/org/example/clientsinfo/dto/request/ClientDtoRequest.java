package org.example.clientsinfo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDtoRequest {

    @Getter
    @Setter
    private String fistName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private List<String> phoneNumbers;

    @Getter
    @Setter
    private List<String> emailList;

    public ClientDtoRequest() {
    }

    public ClientDtoRequest(String fistName, String lastName, List<String> phoneNumbers, List<String> emailList) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.phoneNumbers = phoneNumbers;
        this.emailList = emailList;
    }
}

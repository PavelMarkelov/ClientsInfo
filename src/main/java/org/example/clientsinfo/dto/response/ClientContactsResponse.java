package org.example.clientsinfo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientContactsResponse {

    private long clientId;

    private List<String> phones = new ArrayList<>();

    private List<String> emailList = new ArrayList<>();

    public ClientContactsResponse() {
    }

    public ClientContactsResponse(long clientId, List<String> phones, List<String> emailList) {
        this.clientId = clientId;
        this.phones = phones;
        this.emailList = emailList;
    }
}

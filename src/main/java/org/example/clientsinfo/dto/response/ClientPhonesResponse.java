package org.example.clientsinfo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientPhonesResponse {

    private long clientId;

    private List<String> phones = new ArrayList<>();

    public ClientPhonesResponse() {
    }

    public ClientPhonesResponse(long clientId, List<String> phones) {
        this.clientId = clientId;
        this.phones = phones;
    }
}

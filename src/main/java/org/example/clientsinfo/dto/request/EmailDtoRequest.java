package org.example.clientsinfo.dto.request;

import lombok.Getter;
import lombok.Setter;

public class EmailDtoRequest {

    @Getter
    @Setter
    private long clientId;

    @Getter
    @Setter
    private String email;

    public EmailDtoRequest() {
    }

    public EmailDtoRequest(long clientId, String email) {
        this.clientId = clientId;
        this.email = email;
    }
}

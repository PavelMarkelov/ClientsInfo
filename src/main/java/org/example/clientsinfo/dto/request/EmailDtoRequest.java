package org.example.clientsinfo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDtoRequest {

    private long clientId;
    private String email;

    public EmailDtoRequest() {
    }
}

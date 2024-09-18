package org.example.clientsinfo.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneDtoRequest {

    private long clientId;
    private String phone;

    public PhoneDtoRequest() {
    }
}

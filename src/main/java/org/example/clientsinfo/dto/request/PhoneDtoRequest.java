package org.example.clientsinfo.dto.request;

import lombok.Getter;
import lombok.Setter;

public class PhoneDtoRequest {

    @Getter
    @Setter
    private long clientId;

    @Getter
    @Setter
    private String phone;

    public PhoneDtoRequest(long clientId, String phone) {
        this.clientId = clientId;
        this.phone = phone;
    }

    public PhoneDtoRequest() {
    }
}

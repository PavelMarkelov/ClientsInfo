package org.example.clientsinfo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientEmailListResponse {

    private long clientId;

    private List<String> emailList = new ArrayList<>();

    public ClientEmailListResponse() {
    }

    public ClientEmailListResponse(long clientId, List<String> emailList) {
        this.clientId = clientId;
        this.emailList = emailList;
    }
}

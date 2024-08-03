package com.jugph.loan.decision;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LoanApplicationDecisionService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper;

    public LoanApplicationDecisionService(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    public LoanDecisionResponse getDecision(LoanDecisionRequest loanDecisionRequest) {
        String requestJson = "";
        try {
            requestJson = objectMapper.writeValueAsString(loanDecisionRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return restClient.post()
                .uri("/decision/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestJson)
                .retrieve()
                .body(LoanDecisionResponse.class);
    }

}

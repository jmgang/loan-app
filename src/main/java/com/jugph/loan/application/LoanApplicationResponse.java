package com.jugph.loan.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoanApplicationResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("status") String status
) {
}


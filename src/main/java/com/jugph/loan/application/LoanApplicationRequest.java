package com.jugph.loan.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoanApplicationRequest(
        @JsonProperty("applicant_name") String applicantName,
        @JsonProperty("loan_amount") double loanAmount,
        @JsonProperty("term") int term,
        @JsonProperty("income") double income,
        @JsonProperty("credit_score") int creditScore
) {}

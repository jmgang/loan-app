package com.jugph.loan.decision;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LoanDecisionRequest(@JsonProperty("loan_amount") double loanAmount,
                                  @JsonProperty("credit_score") int creditScore) {
}

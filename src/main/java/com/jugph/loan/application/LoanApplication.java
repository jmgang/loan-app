package com.jugph.loan.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private double loanAmount;

    @Column(nullable = false)
    private int term;

    @Column(nullable = false)
    private double income;

    @Column(nullable = false)
    private int creditScore;

    @Column(nullable = false)
    private String status;

    // Default constructor required by JPA
    public LoanApplication() {
    }

    // Constructor to initialize all fields except id
    public LoanApplication(String applicantName, double loanAmount, int term, double income, int creditScore, String status) {
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.term = term;
        this.income = income;
        this.creditScore = creditScore;
        this.status = status;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "{" +
                    "\"id\":" + id +
                    ", \"applicantName\":\"" + applicantName + "\"" +
                    ", \"loanAmount\":" + loanAmount +
                    ", \"term\":" + term +
                    ", \"income\":" + income +
                    ", \"creditScore\":" + creditScore +
                    ", \"status\":\"" + status + "\"" +
                    "}";
        }
    }
}

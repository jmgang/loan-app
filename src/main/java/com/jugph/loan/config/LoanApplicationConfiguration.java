package com.jugph.loan.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class LoanApplicationConfiguration {

    @Value("${loan.decision.client.base-url}")
    private String baseUrl;

    @Bean
    public RestClient loanApprovalRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .credentialsProvider(DefaultCredentialsProvider.create())
                //.credentialsProvider(ProfileCredentialsProvider.create("admin-general"))
                .build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}

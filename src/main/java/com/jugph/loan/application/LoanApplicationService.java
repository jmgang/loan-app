package com.jugph.loan.application;

import com.jugph.loan.decision.LoanApplicationDecisionService;
import com.jugph.loan.decision.LoanDecisionRequest;
import com.jugph.loan.decision.LoanDecisionResponse;
import com.jugph.loan.publisher.SnsPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoanApplicationService {

    private final LoanApplicationDecisionService loanApplicationDecisionService;

    private final LoanApplicationRepository loanApplicationRepository;

    private final SnsPublisher snsPublisher;

    @Value("${aws.sns.topic-arn}")
    private String topicArn;

    public LoanApplicationService(LoanApplicationDecisionService loanApplicationDecisionService,
                                  LoanApplicationRepository loanApplicationRepository, SnsPublisher snsPublisher) {
        this.loanApplicationDecisionService = loanApplicationDecisionService;
        this.loanApplicationRepository = loanApplicationRepository;
        this.snsPublisher = snsPublisher;
    }
 
    public LoanApplication processApplication(LoanApplication loanApplication) {
        log.info("Processing loan application: {}", loanApplication);

        LoanDecisionResponse loanDecisionResponse = loanApplicationDecisionService.getDecision(
                new LoanDecisionRequest(loanApplication.getLoanAmount(), loanApplication.getCreditScore())
        );

        loanApplication.setStatus(loanDecisionResponse.status());

        LoanApplication savedApplication = loanApplicationRepository.save(loanApplication);

        log.info("Publishing processed loan application: {}", savedApplication);
        snsPublisher.publishTopic(savedApplication.toString(), topicArn);

        return savedApplication;
    }
}

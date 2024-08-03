package com.jugph.loan.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/loans")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoanApplicationResponse process(@RequestBody LoanApplicationRequest request) {
        var  loanApplication = new LoanApplication(
                request.applicantName(), request.loanAmount(), request.term(), request.income(),
                request.creditScore(), null
        );

        var processedApplication = loanApplicationService.processApplication(loanApplication);

        return new LoanApplicationResponse(processedApplication.getId(), processedApplication.getStatus());
    }


}

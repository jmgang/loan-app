package com.jugph.loan.loan_app;

import com.jugph.loan.LoanAppApplication;
import org.springframework.boot.SpringApplication;

public class TestLoanAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(LoanAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

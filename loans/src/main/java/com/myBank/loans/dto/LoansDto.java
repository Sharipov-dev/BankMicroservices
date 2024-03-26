package com.myBank.loans.dto;

import lombok.Data;

@Data
public class LoansDto {

    private String mobileNumber;

    private String loanNumber;

    private String loanType;

    private int totalLoan;

    private int amountPaid;

    private int outstandingAmount;
}

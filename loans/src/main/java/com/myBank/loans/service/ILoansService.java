package com.myBank.loans.service;

import com.myBank.loans.dto.LoansDto;

public interface ILoansService {
    void createLoan(String mobileNumber);

    LoansDto getLoan(String mobileNumber);
}

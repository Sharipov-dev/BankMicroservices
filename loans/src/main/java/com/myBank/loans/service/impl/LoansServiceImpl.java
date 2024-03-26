package com.myBank.loans.service.impl;

import com.myBank.loans.constants.LoansConstants;
import com.myBank.loans.dto.LoansDto;
import com.myBank.loans.entity.Loans;
import com.myBank.loans.exception.LoanAlreadyExistsException;
import com.myBank.loans.repository.LoansRepository;
import com.myBank.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements ILoansService {
    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {
        Optional<Loans> foundLoan = loansRepository.findByMobileNumber(mobileNumber);
        if(foundLoan.isPresent()){
            throw new LoanAlreadyExistsException("Loan with given mobileNumber already exists: " + mobileNumber);
        }
        Loans loans = createNewLoan(mobileNumber);
        loansRepository.save(loans);
    }

    @Override
    public LoansDto getLoan(String mobileNumber) {
        Optional<Loans> foundLoan = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException()
        );
    }

    public Loans createNewLoan(String mobileNumber){
        Long loanNumber = 100000000000L + new Random().nextInt(900000000);
        Loans loans = Loans
                .builder()
                .loanNumber(String.valueOf(loanNumber))
                .loanType(LoansConstants.HOME_LOAN)
                .mobileNumber(mobileNumber)
                .amountPaid(0)
                .outstandingAmount(LoansConstants.NEW_LOAN_LIMIT)
                .totalLoan(LoansConstants.NEW_LOAN_LIMIT)
                .build();
        return loans;
    }
}

package com.myBank.loans.controller;

import com.myBank.loans.constants.LoansConstants;
import com.myBank.loans.dto.LoansDto;
import com.myBank.loans.dto.ResponseDto;
import com.myBank.loans.service.ILoansService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LoansController {

    private ILoansService iLoansService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                  String mobileNumber){

        iLoansService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        LoansConstants.STATUS_201,
                        LoansConstants.MESSAGE_201
                ));
    }

    @GetMapping ("/fetch")
    public ResponseEntity<LoansDto> getLoan(@RequestParam
                                            String mobileNumber){
        iLoansService.getLoan(String mobileNumber);
    }

}

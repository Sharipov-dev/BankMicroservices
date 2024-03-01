package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;


public interface IAccountsService {

    /**
     *
     * @param customerDto - customerDto Object
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}

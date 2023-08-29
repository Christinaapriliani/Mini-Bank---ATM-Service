package com.christina.atm.service;

import com.christina.atm.model.Account;

public interface ATMService {
    Account getAccountInfo(String accountNumber);
    boolean withdraw(String accountNumber, double amount);
    boolean deposit(String accountNumber, double amount);
}

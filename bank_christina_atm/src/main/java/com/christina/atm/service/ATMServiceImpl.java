package com.christina.atm.service;

import com.christina.atm.model.Account;
import org.springframework.stereotype.Service;

@Service
public class ATMServiceImpl implements ATMService {

    private final Map<String, Account> accountData = new HashMap<>();

    @Override
    public Account getAccountInfo(String accountNumber) {
        return accountData.get(accountNumber);
    }

    @Override
    public boolean withdraw(String accountNumber, double amount) {
        Account account = accountData.get(accountNumber);
        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountData.put(accountNumber, account);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(String accountNumber, double amount) {
        Account account = accountData.get(accountNumber);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
            accountData.put(accountNumber, account);
            return true;
        }
        return false;
    }

    private void initializeAccountData() {
        Account account1 = new Account("123456", "Eko", 1000.0);
        Account account2 = new Account("789012", "Rudianto", 1500.0);
        accountData.put(account1.getAccountNumber(), account1);
        accountData.put(account2.getAccountNumber(), account2);
    }

    public ATMServiceImpl() {
        initializeAccountData();
    }
}

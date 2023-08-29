package com.christina.atm.controller;

import com.christina.atm.model.Account;
import com.christina.atm.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class ATMController {

    private final ATMService atmService;

    @Autowired
    public ATMController(ATMService atmService) {
        this.atmService = atmService;
    }

    @GetMapping("/account/{accountNumber}")
    public Account getAccountInfo(@PathVariable String accountNumber) {
        return atmService.getAccountInfo(accountNumber);
    }

    @PostMapping("/withdraw/{accountNumber}")
    public String withdraw(@PathVariable String accountNumber, @RequestParam double amount) {
        if (atmService.withdraw(accountNumber, amount)) {
            return "Withdrawal successful.";
        } else {
            return "Withdrawal failed. Insufficient balance.";
        }
    }

    @PostMapping("/deposit/{accountNumber}")
    public String deposit(@PathVariable String accountNumber, @RequestParam double amount) {
        if (atmService.deposit(accountNumber, amount)) {
            return "Deposit successful.";
        } else {
            return "Deposit failed. Invalid amount.";
        }
    }
}

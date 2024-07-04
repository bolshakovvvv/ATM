package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.ATMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class ATMController {

    @Autowired
    ATMService atmService;

    @PostMapping("/add-new-user")
    public void add(@RequestBody AddUserToDB addUserToDB) {
        atmService.addUser(addUserToDB);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody WithdrawMoneyRequest withdrawMoneyRequest) {
        atmService.withdrawMoney(withdrawMoneyRequest);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody DepositMoneyRequest depositMoneyRequest) {
        atmService.depositMoney(depositMoneyRequest);
    }

    @PostMapping("/send-money")
    public void sendMoney(@RequestBody SendMoneyRequest sendMoneyRequest) {
        atmService.sendMoney(sendMoneyRequest);
    }

    @GetMapping("/get-balance/{id}")
    public ResponseEntity<Integer> getBalance(@PathVariable Integer number) {
        return new ResponseEntity<>(atmService.getBalanceByNumber(number), HttpStatus.OK);
    }

}


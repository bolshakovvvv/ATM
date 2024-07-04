package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ATMService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public void addUser(AddUserToDB addUserToDB){
        var user = addUserToDB.getUser();
        var account = addUserToDB.getAccount();
        user.setAccount(account);
        account.setUser(user);
        userRepository.save(user);
        accountRepository.save(account);
    }

    @Transactional
    public void withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest){
        var account = accountRepository.getAccountByNumber(withdrawMoneyRequest.getNumber());
        setBalanceById(account.getId(), getBalanceByNumber(account.getNumber()) - withdrawMoneyRequest.getAmount());
        accountRepository.save(account);
    }

    @Transactional
    public void depositMoney(DepositMoneyRequest depositMoneyRequest){
        var account = accountRepository.getAccountByNumber(depositMoneyRequest.getNumber());
        setBalanceById(account.getId(), getBalanceByNumber(account.getNumber()) + depositMoneyRequest.getAmount());
        accountRepository.save(account);
    }

    @Transactional
    public void sendMoney(SendMoneyRequest sendMoneyRequest){
        var senderAccount = accountRepository.getAccountByNumber(sendMoneyRequest.getSenderNumber());
        var receiverAccount = accountRepository.getAccountByNumber(sendMoneyRequest.getReceiverNumber());
        setBalanceById(senderAccount.getId(), getBalanceByNumber(senderAccount.getNumber()) - sendMoneyRequest.getAmount());
        setBalanceById(receiverAccount.getId(),getBalanceByNumber(receiverAccount.getNumber()) + sendMoneyRequest.getAmount());
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }

    @Transactional
    public void setBalanceById(Integer Id, Integer amount){
        var user = userRepository.getUserById(Id);
        var account = user.getAccount();
        account.setBalance(amount);
        accountRepository.save(account);
    }

    public Integer getBalanceByNumber(Integer number){
        var account = accountRepository.getAccountByNumber(number);
        return account.getBalance();
    }

}


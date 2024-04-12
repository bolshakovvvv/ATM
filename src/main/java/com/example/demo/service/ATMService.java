package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.AccountRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AccountRepository accountRepository;

    public void addUser(AddUserToDB addUserToDB){
        userRepository.save(addUserToDB.getUser());
        accountRepository.save(addUserToDB.getAccount());
    }

    public void withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest){
        var account = accountRepository.getAccountByNumber(withdrawMoneyRequest.getNumber());
        setBalanceById(account.getId(), getBalanceById(account.getId()) - withdrawMoneyRequest.getAmount());
        accountRepository.save(account);
    }

    public void depositMoney(DepositMoneyRequest depositMoneyRequest){
        var account = accountRepository.getAccountByNumber(depositMoneyRequest.getNumber());
        setBalanceById(account.getId(), getBalanceById(account.getId()) + depositMoneyRequest.getAmount());
        accountRepository.save(account);
    }

    public void sendMoney(SendMoneyRequest sendMoneyRequest){
        var senderAccount = accountRepository.getAccountByNumber(sendMoneyRequest.getSenderNumber());
        var receiverAccount = accountRepository.getAccountByNumber(sendMoneyRequest.getReceiverNumber());
        setBalanceById(senderAccount.getId(), getBalanceById(senderAccount.getId()) - sendMoneyRequest.getAmount());
        setBalanceById(receiverAccount.getId(),getBalanceById(receiverAccount.getId()) + sendMoneyRequest.getAmount());
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }

    public void setBalanceById(Integer Id, Integer amount){
        var user = userRepository.getUserById(Id);
        var account = user.getAccount();
        account.setBalance(amount);
        accountRepository.save(account);
    }

    public Integer getBalanceById(Integer Id){
        var user = userRepository.getUserById(Id);
        var account = user.getAccount();
        return account.getBalance();
    }
}

